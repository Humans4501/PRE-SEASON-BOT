package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;

import org.usfirst.frc.team4501.robot.commands.DriveManual;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon talon1, talon2;
	RobotDrive drive;
	DoubleSolenoid sol1;
	Encoder enc2, enc3;
	
	double driveEnc1;
	double driveEnc2;
	double x;
	
	
	public Drivetrain() {
		talon1 = new Talon(RobotMap.Motors.MOTOR1);
		talon2 = new Talon(RobotMap.Motors.MOTOR2);
		
		drive = new RobotDrive(talon1, talon2);
		
		sol1 = new DoubleSolenoid(RobotMap.Solenoids.HIGHGEAR, RobotMap.Solenoids.LOWGEAR);
		
		enc2 = new Encoder(RobotMap.Sensors.ENCODER2_A, RobotMap.Sensors.ENCODER2_B);
		enc3 = new Encoder(RobotMap.Sensors.ENCODER3_A, RobotMap.Sensors.ENCODER3_B);

	
		
	}
	

	
	public void drivemanual(double move, double turn) {
		drive.arcadeDrive(move, turn);
	}
	
	public void driveauto(double speedx, double speedy) {
		drive.tankDrive(speedx, speedy);
		drive.setSafetyEnabled(false);
	}
	
	public void shiftHigh() {
		sol1.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shiftLow() {
		sol1.set(DoubleSolenoid.Value.kReverse);
	}
	
	public double encDist1() {
		driveEnc1 =enc2.getDistance();
	
		return driveEnc1;
	}
	
	public double encDist2() {
		driveEnc2 =enc3.getDistance();
		
		return driveEnc2;
	}



    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveManual());
    }
}

