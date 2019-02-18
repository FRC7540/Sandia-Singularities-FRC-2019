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

    //LiftSystem
    public static final int liftMotor = 1;
    public static final double liftMotorSpeed = .1;
    public static final double lvl1 = -7038.0;
    public static final double lvl2 = 1441.0;
    public static final double lvl3 = 3000.0;
    public static final double lvl4 = 4365.0;

    //LimitSwitches
    public static final int liftTop = 1;
    public static final int liftBottom = 0;
    public static final int clawOpen = 3;
    public static final int clawClosed = 4;
    public static final int pivotUp = 5;
    public static final int pivotDown = 6;
}