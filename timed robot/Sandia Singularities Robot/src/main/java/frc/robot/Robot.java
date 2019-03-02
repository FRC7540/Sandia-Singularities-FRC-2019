/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import com.ctre.phoenix.motorcontrol.*;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.LiftSystem;
import frc.robot.subsystems.LiftSystemManual;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.clawManual;
import frc.robot.subsystems.ArmDrop;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

/**
 * By popular demand this robot will be named "Tiny Bot Tim" -Software Big
 * Chungus will also be considered Please help this robot find its purpose, it
 * doesn't want to spend its life passing butter
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private static final WPI_TalonSRX liftmotor = new WPI_TalonSRX(RobotMap.liftMotor);
  private static final WPI_VictorSPX pivotmotor = new WPI_VictorSPX(RobotMap.pivotMotor);
  private static final XboxController logitech1 = new XboxController(RobotMap.controller1);
  private static final XboxController logitech2 = new XboxController(RobotMap.controller2);

  public static final Drive driveSubsystem = new Drive();
  public static final LiftSystem liftSubsystem = new LiftSystem();
  public static final Pivot pivotSubsystem = new Pivot();
  public static final LiftSystemManual liftSystemManualSubsystem = new LiftSystemManual();
  public static final clawManual clawManualSubsystem = new clawManual();
  public static final ArmDrop armDropSubsystem = new ArmDrop();
  public static final OI controllerBinding = new OI();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code
   */
  @Override
  public void robotInit() {
    Scheduler.getInstance().run();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    CameraServer camera1 = CameraServer.getInstance();
    CameraServer camera2 = CameraServer.getInstance();
    camera1.startAutomaticCapture("cam1", 0);
    camera2.startAutomaticCapture("cam2", 1);
    encoderInit();
  }

  public static WPI_TalonSRX getTalon() {
    return liftmotor;
  }

  public void encoderInit() {
    /* Config the sensor used for Primary PID and sensor direction */
    liftmotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx,
        Constants.kTimeoutMs);

    /* Ensure sensor is positive when output is positive */
    liftmotor.setSensorPhase(Constants.kSensorPhase);

    /**
     * Set based on what direction you want forward/positive to be. This does not
     * affect sensor phase.
     */
    //liftmotor.setInverted(Constants.kMotorInvert);

    /* Config the peak and nominal outputs, 12V means full */
    liftmotor.configNominalOutputForward(0, Constants.kTimeoutMs);
    liftmotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
    liftmotor.configPeakOutputForward(.2, Constants.kTimeoutMs);
    liftmotor.configPeakOutputReverse(-.2, Constants.kTimeoutMs);

    /**
     * Config the allowable closed-loop error, Closed-Loop output will be neutral
     * within this range. See Table in Section 17.2.1 for native units per rotation.
     */
    liftmotor.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

    /* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
    liftmotor.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);
    liftmotor.config_kP(Constants.kPIDLoopIdx, Constants.kGains.kP, Constants.kTimeoutMs);
    liftmotor.config_kI(Constants.kPIDLoopIdx, Constants.kGains.kI, Constants.kTimeoutMs);
    liftmotor.config_kD(Constants.kPIDLoopIdx, Constants.kGains.kD, Constants.kTimeoutMs);

    /**
     * Grab the 360 degree position of the MagEncoder's absolute position, and
     * intitally set the relative sensor to match.
     */
    int absolutePosition = liftmotor.getSensorCollection().getPulseWidthPosition();

    /* Mask out overflows, keep bottom 12 bits */
    absolutePosition &= 0xFFF;
    if (Constants.kSensorPhase) {
      absolutePosition *= -1;
    }
    if (Constants.kMotorInvert) {
      absolutePosition *= -1;
    }

    /* Set the quadrature (relative) sensor to match absolute */
    liftmotor.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    // switch (m_autoSelected) {
    // case kCustomAuto:
    //   // Put custom auto code here
    //   break;
    // case kDefaultAuto:
    // default:
    //   // Put default auto code here
    //   break;
    //}
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // adds manual control for liftmotor for testing
    liftmotor.configFactoryDefault();
    liftmotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    double analogYR = logitech1.getY(Hand.kRight);
    double slowMotor = analogYR * .1;
    liftmotor.set(ControlMode.PercentOutput, slowMotor);

    //manual control for pivot
    double analogYR2 = logitech2.getY(Hand.kRight);
    double slowMotor2 = analogYR2 *.1;
    pivotmotor.set(ControlMode.PercentOutput, slowMotor2);

    // prints values of the encoder
    double encoderValues = liftmotor.getSelectedSensorPosition();
    System.out.println("printingEncoderValues");
    System.out.println(encoderValues);
  }
}
