package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.movearm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon mot1, mot2;
	RobotDrive drive;
	
	
	AnalogPotentiometer pot;
    Encoder enc1;
    DigitalInput limitSwitch;
    
	 double potRate;
	 double armEnc;
	
	public Arm() {
		mot1 = new Talon(RobotMap.Motors.MOTOR3);
		mot2 = new Talon(RobotMap.Motors.MOTOR4);
		
		pot = new AnalogPotentiometer(RobotMap.Sensors.POTENTIOMETERA, RobotMap.Sensors.POTENTIOMETERB, RobotMap.Sensors.POTENTIOMETERC);
		
		enc1 = new Encoder(RobotMap.Sensors.ENCODER1_A, RobotMap.Sensors.ENCODER1_B);
		
		limitSwitch = new DigitalInput(RobotMap.Sensors.LIMITSWITCH);
		
	}
	
	public void moveArm(double x, double y) {
		mot1.set(x);
		mot2.set(y);
	}
	
	public  boolean isSwitchSet() {
		limitSwitch.get();
		return true;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new movearm());
    }
    
    public double potRate() {
    	potRate = pot.get();
    	
    	 return potRate;
    }
    
    public double encRate1() {
    	armEnc = enc1.getRate();
    	
    	return armEnc;    	
    }
}

