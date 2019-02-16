/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClawManualCommand;

/**
 * Add your docs here.
 */
public class ClawManual extends Subsystem {
  // Put methods for controlling this subsystem 
  // here. Call these from Commands.
  public static final XboxController logitech2 = new XboxController(RobotMap.controller2);
  public static final WPI_VictorSPX clawMotor = new WPI_VictorSPX(RobotMap.clawMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ClawManualCommand());
  }

  public void manualMovement() {
    double analogYL = logitech2.getY(Hand.kLeft);
    clawMotor.set(ControlMode.PercentOutput, analogYL);
  }
}
