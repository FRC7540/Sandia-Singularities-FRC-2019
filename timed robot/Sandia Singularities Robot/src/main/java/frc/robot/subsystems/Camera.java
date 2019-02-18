/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * Add your docs here.
 * This handles all the camera stuff... I think...
 */
public class Camera extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void addCamera() {
    CameraServer camera1 = CameraServer.getInstance();
    CameraServer camera2 = CameraServer.getInstance();
    camera1.startAutomaticCapture("cam1", 0);
    camera2.startAutomaticCapture("cam2", 1);
  }
}
