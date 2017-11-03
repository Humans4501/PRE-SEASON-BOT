package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon mot1, mot2;
	RobotDrive drive;
	public Arm() {
		mot1 = new Talon(RobotMap.Motors.MOTOR3);
		mot2 = new Talon(RobotMap.Motors.MOTOR4);
	}
	
	public void moveArm(double x, double y) {
		mot1.set(x);
		mot2.set(y);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

