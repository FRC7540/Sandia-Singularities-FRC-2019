/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftSystemManualCommand;

/**
 * Add your docs here.
 */
public class LiftSystemManual extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final XboxController logitech1 = new XboxController(RobotMap.controller1);
  private static final WPI_TalonSRX liftmotor = new WPI_TalonSRX(RobotMap.liftMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftSystemManualCommand());
  }

  public void manualPosition() {
    double analogRY = logitech1.getY(Hand.kRight);
    double motorSlowDown = analogRY * .1;
    liftmotor.set(ControlMode.PercentOutput, motorSlowDown);
  }

  public void stopManual() {
    boolean leftBumper = logitech1.getBumper(Hand.kLeft);
    if (leftBumper == true)
      liftmotor.stopMotor();
  }
}
