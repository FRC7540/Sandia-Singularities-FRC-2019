/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.LiftSystemLvl1Command;
import frc.robot.commands.LiftSystemLvl2Command;
import frc.robot.commands.LiftSystemLvl3Command;
import frc.robot.commands.LiftSystemLvl4Command;
import frc.robot.commands.OpenClawCommand;
import frc.robot.commands.CloseClawCommand;

/**
 * Add your docs here.
 */
public class IO {

    public IO () {
        driverButtonA.whenPressed(new LiftSystemLvl1Command());
        driverButtonB.whenPressed(new LiftSystemLvl2Command());
		driverButtonX.whenPressed(new LiftSystemLvl3Command());
		driverButtonY.whenPressed(new LiftSystemLvl4Command());
		driverButtonLeftBumper.whenPressed(new OpenClawCommand());
		driverButtonRightBumper.whenPressed(new CloseClawCommand());
    }

    private static final int LEFT_HORIZ_AXIS = 0;
	private static final int LEFT_VERT_AXIS = 1;
	private static final int RIGHT_HORIZ_AXIS = 4;
	private static final int RIGHT_VERT_AXIS = 5;
	private static final int LEFT_Z_AXIS = 3;
	private static final int RIGHT_Z_AXIS = 2;

	private static final double STICK_DEADZONE = 0.3;
	private static final double STICK_MAX = 0.97;

	// driver controller setup
	private Joystick driverController = new Joystick(0);
	private Button driverButtonA = new JoystickButton(driverController, 1);
	private Button driverButtonB = new JoystickButton(driverController, 2);
	private Button driverButtonX = new JoystickButton(driverController, 3);
	private Button driverButtonY = new JoystickButton(driverController, 4);
	private Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
	private Button driverButtonRightBumper = new JoystickButton(driverController, 6);
	private Button driverButtonBack = new JoystickButton(driverController, 7);
	private Button driverButtonStart = new JoystickButton(driverController, 8);
	private Button driverButtonLeftAxisPress = new JoystickButton(driverController, 9);
    private Button driverButtonRightAxisPress = new JoystickButton(driverController, 10);
}
