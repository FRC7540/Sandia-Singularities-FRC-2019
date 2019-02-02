/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Add your docs here.
 */
public class Pivot extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final XboxController logitech2 = new XboxController(1);
    private static final PWMTalonSRX motor7 = new PWMTalonSRX(6);

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void pivotControl() {
    boolean bumperL = logitech2.getBumper(Hand.kLeft);
    boolean bumperR = logitech2.getBumper(Hand.kRight);
  }
}