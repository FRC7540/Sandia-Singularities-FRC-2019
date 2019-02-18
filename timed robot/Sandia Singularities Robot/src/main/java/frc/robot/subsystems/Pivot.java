/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class Pivot extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final WPI_VictorSPX pivotMotor = new WPI_VictorSPX(RobotMap.pivotMotor);
    DigitalInput limitSwitch1;
    DigitalInput limitSwitch2;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    limitSwitch1 = new DigitalInput(RobotMap.pivotUp);
    limitSwitch2 = new DigitalInput(RobotMap.pivotDown);
  }

  public void pivotDown() {
    pivotMotor.set(ControlMode.PercentOutput, 0.2);
  }

  public void pivotUp() {
    pivotMotor.set(ControlMode.PercentOutput, -0.2);
  }

  public void pivotStop() {
    pivotMotor.set(ControlMode.PercentOutput, 0);
  }

  public boolean limitSwitch1Check() {
    return limitSwitch1.get();
  }

  public boolean limitSwitch2Check() {
    return limitSwitch2.get();
  }
}