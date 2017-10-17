package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;

import org.usfirst.frc.team4501.robot.commands.DriveManual;

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
	
	public Drivetrain() {
		talon1= new Talon(RobotMap.MOTOR1);
		talon2= new Talon(RobotMap.MOTOR2);
		drive = new RobotDrive(talon1, talon2);
	}
	

	
	public void drivemanual(double move, double turn) {
		drive.arcadeDrive(move, turn);
	}
	
	public void driveauto(double speedx, double speedy) {
		drive.tankDrive(speedx, speedy);
		drive.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveManual());
    }
}

