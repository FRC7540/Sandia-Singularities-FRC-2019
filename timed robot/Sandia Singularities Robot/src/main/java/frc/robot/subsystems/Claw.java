/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  private static final WPI_VictorSPX clawMotor = new WPI_VictorSPX(RobotMap.ClawMotor);
  public static final boolean switchClosedValue = false;
  DigitalInput limitSwitchOpen;
  DigitalInput limitSwitchClosed;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    //Open
    limitSwitchOpen = new DigitalInput(3);
    //Closed
    limitSwitchClosed = new DigitalInput(4);
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void openClaw() {
    clawMotor.set(ControlMode.PercentOutput,1);
    // Move motors open

  }

  public void closeClaw() {
    clawMotor.set(ControlMode.PercentOutput,-1);
    // Move motors closed
  }

  public boolean isClawMaxOpen() {
    boolean switchPosition = limitSwitchOpen.get();
    if (switchPosition == false) {
      return true;
    }
    else {
      return false;
    }
    // Checks if claw has hit the limit switch (open)
  }

  public boolean isClawClosed() {
    boolean switchPosition = limitSwitchClosed.get();
    if (switchPosition == false) {
      return true;
    }
    else {
      return false;
    }
    // Checks if claw has hit limit switch (closed)
  }

  public void stopClaw() {
    clawMotor.set(ControlMode.PercentOutput,0);
    clawMotor.stopMotor();
  }

}
