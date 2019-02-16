/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

//adding motors and the ultrasonic sensor
public class Thirdeye extends Subsystem {
  Ultrasonic thirdeye = new Ultrasonic(1,1);
  private static final XboxController logitech1 = new XboxController(RobotMap.controller1);
  private static final PWMVictorSPX motor1 = new PWMVictorSPX(RobotMap.leftMotors[0]);
  private static final PWMVictorSPX motor2 = new PWMVictorSPX(RobotMap.leftMotors[1]);
  private static final PWMVictorSPX motor3 = new PWMVictorSPX(RobotMap.rightMotors[0]);
  private static final PWMVictorSPX motor4 = new PWMVictorSPX(RobotMap.rightMotors[1]);
  SpeedControllerGroup leftmotors = new SpeedControllerGroup(motor1, motor2);
  SpeedControllerGroup rightmotors = new SpeedControllerGroup(motor3, motor4);
  DifferentialDrive maindrive = new DifferentialDrive(leftmotors, rightmotors);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void robotInit() {
    thirdeye.setAutomaticMode(true);
  }

  public void ultrasonicSample() {
    double range = thirdeye.getRangeInches();
    double analogLY = logitech1.getY(Hand.kLeft);
    double analogLX = logitech1.getX(Hand.kLeft);
    double middleOp = 1 / range;
    double brakes;
    if (range <= 5)
      middleOp = analogLY - middleOp;
      brakes = middleOp + .1;
      double forwardDrive = brakes;
    maindrive.arcadeDrive(forwardDrive, analogLX);
  }

  public void driveSystem() {
    double analogLY = logitech1.getY(Hand.kLeft);
    double analogLX = logitech1.getX(Hand.kLeft);
    double forwardDrive = analogLY * -1;
    maindrive.arcadeDrive(forwardDrive, analogLX);
  }
}