/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void openClaw() {
    // Move motors open

  }

  public void closeClaw() {
    // Move motors closed
  }

  public boolean isClawOpen() {
    return true;
    // Checks if claw has hit the limit switch (open)
  }

  public boolean isClawClosed() {
    return true;
    // Checks if claw has hit limit switch (closed)
  }

  public void stopClaw() {

  }

}
