// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.RobotMap;

// /**
//  * Add your docs here.
//  */
// public class ArmDrop extends Subsystem {
//   // Put methods for controlling this subsystem
//   // here. Call these from Commands.
//   public static final WPI_VictorSPX armMotor = new WPI_VictorSPX(RobotMap.armMotor);

//   @Override
//   public void initDefaultCommand() {
//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//   }

//   public void runMotor() {
//     armMotor.set(ControlMode.PercentOutput, 0.5);
//   }

//   public void stopMotor() {
//     armMotor.set(ControlMode.PercentOutput, 0);
//   }
// }
