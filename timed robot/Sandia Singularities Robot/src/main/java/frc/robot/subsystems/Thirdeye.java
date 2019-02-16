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

   public void ultrasonicSample() {
     //double range = thirdeye.getRangeInches();
     //double opOne = 1 / range;
     //double brakes;
     //double opTwo;

     //opTwo = analogLY - opOne;
     //brakes = opTwo + .1;
    
     //if (range <= 5)
       //brakes = opTwo + .1;
       //double forwardDrive = brakes;
     //maindrive.arcadeDrive(forwardDrive, analogLX);
   }

   public void ultrasonicSmaple(){
     double range = thirdeye.getRangeInches();
     double invert = 0;

     //Converting range to usable
     if (range == 5)
       invert = 1;

     if (range == 4)
       invert = 2;

     if (range == 3)
       invert = 3;
      
     if (range == 2)
       invert = 4;

     if (range == 1)
       invert = 5;

     if (range == 0)
       invert = 6;

     //doing the actual speed conversion
     //speed = analogLY / invert;
   }
 }