package org.usfirst.frc.team4501.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static class Motors {	
	//drive is MOTOR1
	public static final int MOTOR1 = 0;
	//drive is MOTOR2
	public static final int MOTOR2 = 1;
	//arm is MOTOR3
	public static final int MOTOR3 = 2;
	//arm is MOTOR4
	public static final int MOTOR4 = 3;
	public static final int MOTOR5 = 4;
	public static final int MOTOR6 = 5;
	}
	
	public static class Solenoids {
		public static final int HIGHGEAR = 1;
		public static final int LOWGEAR = 2;
	}
	
	public static class Sensors{
		public static final int ENCODER1_A = 1;
		public static final int ENCODER1_B = 2;
		public static final int ENCODER2_A = 8;
		public static final int ENCODER2_B = 9;
		public static final int ENCODER3_A = 6;
		public static final int ENCODER3_B = 7;
		
		public static final int POTENTIOMETERA = 0;
		public static final int POTENTIOMETERB = 270;
		public static final int POTENTIOMETERC = 0;
		
		public static final int LIMITSWITCH = 1;
		
	}
	
	
}
