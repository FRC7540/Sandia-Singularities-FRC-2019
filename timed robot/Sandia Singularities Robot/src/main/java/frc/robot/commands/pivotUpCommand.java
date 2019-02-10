/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class pivotUpCommand extends Command {
  public static final boolean limitSwitchClosed = false;
  public static final XboxController logitech1 = new XboxController(RobotMap.controller2);

  public pivotUpCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pivotSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //this runs infinitely and only needs to run once
    System.out.println("starting motor");
    Robot.pivotSubsystem.pivotUp();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean closedSwitch = Robot.pivotSubsystem.limitSwitchCheck();
    if (limitSwitchClosed == closedSwitch) {
      System.out.println("detected limit switch");
      return true;
    }
    else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Stopping motor");
    Robot.pivotSubsystem.pivotStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
