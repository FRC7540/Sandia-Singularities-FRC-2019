package frc.robot;

public class RobotMap {
    
    // Drive
    public static final int[] leftMotors = {0, 1};
    public static final int[] rightMotors = {2, 3};

    //Controllers
    public static final int controller1 = 0;
    public static final int controller2 = 1;

    //pivot
    public static final int pivotMotor = 2;
    
    //Claw
    public static final int clawMotor = 3;

    //Arm Drop
    public static final int armMotor = 4;

    //LiftSystem
    public static final int liftMotor = 1;
    public static final double liftMotorSpeed = .1;
    public static final double lvl1 = 3;
    public static final double lvl2 = 2;
    public static final double lvl3 = 1;
    public static final double lvl4 = 0;

    //LimitSwitches
    public static final int liftBottom = 0;
    public static final int liftTop = 1;
}