/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.RobotMap;
import frc.robot.commands.ThirdeyeCommand;

public class Thirdeye extends Subsystem {
  Ultrasonic thirdeye = new Ultrasonic(1,1);

   @Override
   public void initDefaultCommand() {
     // Set the default command for a subsystem here.
     // setDefaultCommand(new MySpecialCommand());
     setDefaultCommand(new ThirdeyeCommand());
   }

   public void robotInit() {
     thirdeye.setAutomaticMode(true);
   }

   public void thirdeyeValue() {

   }

   public void thirdeyeConversion() {
     
   }
 }