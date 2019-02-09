/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static final DoubleSolenoid clawPneumatics = new DoubleSolenoid(RobotMap.clawPneumatics[0], RobotMap.clawPneumatics[1]);
  public static final Compressor clawCompressor = new Compressor(RobotMap.clawCompressor);
  public static final XboxController logitech2 = new XboxController(RobotMap.controller2);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void OpenClaw() {
    clawPneumatics.set(Value.kForward);  
  }

  public void CloseClaw() {
    clawPneumatics.set(Value.kReverse);
  }
}
