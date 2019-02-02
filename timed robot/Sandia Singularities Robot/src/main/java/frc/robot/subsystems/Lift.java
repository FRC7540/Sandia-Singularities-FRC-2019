import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive;


public class Lift extends TimedRobot {
    private static final PWMTalonSRX motor6 = new PWMTalonSRX(7);
    private static final XboxController logitech = new XboxController(0);
    MotorDrive liftmotor = new MotorDrive(motor6);
    

    public void teleopPeriodic() {
        double analogLY=logitech.getY(Hand.kLeft);
        double buttonX=logitech.buttonpressX(0);
        double liftstatus=sensor.getLift(0);
        double liftgoto = 20;
        liftmotor.runMotor(analogLY);


        
    }
}