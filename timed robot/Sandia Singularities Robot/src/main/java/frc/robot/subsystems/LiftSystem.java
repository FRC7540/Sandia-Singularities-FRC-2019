/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice; 

/**
 * Add your docs here.
 * This makes the claw go up and down... woah...
 */
public class LiftSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_TalonSRX liftmotor = new WPI_TalonSRX(RobotMap.liftMotor);
  private static final double level1 = RobotMap.lvl1;
  private static final double level2 = RobotMap.lvl2;
  private static final double level3 = RobotMap.lvl3;
  private static final double level4 = RobotMap.lvl4;
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    limitSwitch1 = new DigitalInput(RobotMap.liftBottom);
    limitSwitch2 = new DigitalInput(RobotMap.liftTop);
  }

  public void liftInit() {
    liftmotor.configFactoryDefault();
    liftmotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
  }

  public void liftStop() {
    // Stops motor when finished
    liftmotor.set(ControlMode.PercentOutput, 0);
  }

  public void moveTowardsPosition1() {
    liftmotor.set(ControlMode.Position, level1);
  }

  public void moveTowardsPosition2() {
    liftmotor.set(ControlMode.Position, level2);
  }

  public void moveTowardsPosition3() {
    liftmotor.set(ControlMode.Position, level3);
  }

  public void moveTowardsPosition4() {
    liftmotor.set(ControlMode.Position, level4);
  }

  public boolean limitSwitch1Check() {
    return limitSwitch1.get();
  }

  public boolean limitSwitch2Check() {
    return limitSwitch2.get();
  }
}
