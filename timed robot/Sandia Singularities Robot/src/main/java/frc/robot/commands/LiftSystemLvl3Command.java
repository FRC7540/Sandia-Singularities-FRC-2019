/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftSystemLvl3Command extends Command {
  private static final double level3 = 20;

  public LiftSystemLvl3Command() {
    requires(Robot.liftSubsystem);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.liftSubsystem.setCurrentPosition(level3);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.liftSubsystem.moveTowardsPosition();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double position1 = Robot.liftSubsystem.getCurrentPosition();
    if (level3 < position1+0.1 && level3 > position1-0.1)
      return true;
    else
      return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.liftSubsystem.liftStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
