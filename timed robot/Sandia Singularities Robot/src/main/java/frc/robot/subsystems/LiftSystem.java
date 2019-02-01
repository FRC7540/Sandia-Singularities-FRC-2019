/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PWM;

/**
 * Add your docs here.
 * This makes the claw go up and down... woah...
 */
public class LiftSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final PWMTalonSRX motor5 = new PWMTalonSRX(4);
  private static final PWMTalonSRX motor6 = new PWMTalonSRX(5);
  private static final XboxController logitech2 = new XboxController(1);
  // SpeedControllerGroup liftmotors = new SpeedControllerGroup(motor6, motor7);
  PWM liftmotor = new PWM(1);
  double currentLvl = 0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void liftControl() {
    // creates and uses analog stick for manual elevator positioning
    double analogLY = logitech2.getY(Hand.kLeft);
    liftmotor.setSpeed(analogLY);

    // creates A,B,X, and Y buttons to use for preset elevator positions
    boolean buttonA = logitech2.getAButton();
    boolean buttonB = logitech2.getBButton();
    boolean buttonX = logitech2.getXButton();
    boolean buttonY = logitech2.getYButton();
  }

  public double calcDiff(double curr, double des) {
    double diff = des - curr;
    return diff;
  }

  public double desiredPos(int buttonInput) {
    if (buttonInput == 0)
       return (double)0.0;
    else if (buttonInput == 1)
      return (double)10.0;
    else if (buttonInput == 2)
      return (double)20.0;
    else if (buttonInput == 3)
      return (double)30.0;
  }

  public double getCurrentLvl() {
    return currentLvl;
  }

  public void updateCurrentLvl(double diff) {
    double temp = currentLvl + diff;
    currentLvl = temp;
  }

  public void setLevel(double diff) {
    //Convert rotations to distance and tell that to motor
  }
}
