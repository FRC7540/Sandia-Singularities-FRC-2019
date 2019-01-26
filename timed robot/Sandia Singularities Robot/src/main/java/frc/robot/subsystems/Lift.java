package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PWM;


public class Lift extends TimedRobot {
    private static final PWMTalonSRX motor5 = new PWMTalonSRX(4);
    private static final PWMTalonSRX motor6 = new PWMTalonSRX(5);
    private static final XboxController logitech2 = new XboxController(1);
    //SpeedControllerGroup liftmotors = new SpeedControllerGroup(motor6, motor7);
    PWM liftmotor = new PWM(1);
    

    public void teleopPeriodic() {
        double analogLY=logitech2.getY(Hand.kLeft);
        liftmotor.setSpeed(analogLY);
    }
}