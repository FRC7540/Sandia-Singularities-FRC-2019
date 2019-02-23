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
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;
import frc.robot.commands.LiftSystemManualCommand;

/**
 * Add your docs here.
 */
public class LiftSystemManual extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final XboxController logitech2 = new XboxController(RobotMap.controller2);
  private static final WPI_TalonSRX liftmotor = new WPI_TalonSRX(RobotMap.liftMotor);
  public static final boolean limitSwitchClosed = false;
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftSystemManualCommand());
    limitSwitch1 = new DigitalInput(RobotMap.liftBottom);
    limitSwitch2 = new DigitalInput(RobotMap.liftTop);
  }

  public void manualPosition() {
    double analogRY = logitech2.getY(Hand.kRight);
    double motorSlowDown = analogRY;
    //System.out.println(analogRY);
    //liftmotor.set(ControlMode.PercentOutput, motorSlowDown);
    if (motorSlowDown < 0) {
      if (limitSwitch1.get() == limitSwitchClosed)
        liftmotor.stopMotor();
      else 
        liftmotor.set(ControlMode.PercentOutput, motorSlowDown);
      }
    
      if (motorSlowDown > 0) {
        if (limitSwitch2.get() == limitSwitchClosed)
          liftmotor.stopMotor();
        else 
          liftmotor.set(ControlMode.PercentOutput, motorSlowDown);
      }

  }

  // public void stopManualTop() {
  //   boolean closedSwitch2 = limitSwitch2.get();
  //   if (limitSwitchClosed == closedSwitch2)
  //     liftmotor.stopMotor();
  // }

  // public void stopManualBottom() {
  //   boolean closedSwitch1 = limitSwitch1.get();
  //   if (limitSwitchClosed == closedSwitch1)
  //     liftmotor.stopMotor();
  // }
}
