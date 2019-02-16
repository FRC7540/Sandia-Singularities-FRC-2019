/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_VictorSPX clawMotor = new WPI_VictorSPX(RobotMap.clawMotor);
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    limitSwitch1 = new DigitalInput(RobotMap.clawOpen);
    limitSwitch2 = new DigitalInput(RobotMap.clawClosed);
  }

  public void openClaw() {
    // Move motors open
    clawMotor.set(ControlMode.PercentOutput, 1);
  }

  public void closeClaw() {
    // Move motors closed
    clawMotor.set(ControlMode.PercentOutput, -1);
  }

  public void stopClaw() {
    clawMotor.set(ControlMode.PercentOutput, 0);
  }

  public boolean limitSwitch1Check() {
    return limitSwitch1.get();
  }

  public boolean limitSwitch2Check() {
    return limitSwitch2.get();
  }
}
