package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;

import org.usfirst.frc.team4501.robot.commands.DriveManual;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon talon1, talon2;
	RobotDrive drive;
	DoubleSolenoid sol1;
	Encoder enc2, enc3;
	PIDController drivePID;
	
	double driveEnc1;
	double driveEnc2;
	double encRate1;
	double encRate2;

	public Drivetrain() {
		
		//PID Stuff
		super("DriveTrain", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(1.0);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("DriveTrain", "PIDSubsystem Controller", getPIDController());
		
		//Drivetrain Stuff
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
	
	public double encRate1() {
		encRate1 = enc2.getRate();
		
		return encRate1;
	}
	
	public double encRate2() {
		encRate2 = enc3.getRate();
		
		return encRate2;
	}
	
	public double encDistAll() {
		enc2.getDistance();
		enc3.getDistance();
		
		return encDistAll();
	}
	
	public void encReset() {
		enc2.reset();
		enc3.reset();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveManual());
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return encDistAll();
		
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		 talon1.pidWrite(output);
		 talon2.pidWrite(output);
	}
}

