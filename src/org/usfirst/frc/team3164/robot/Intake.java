package org.usfirst.frc.team3164.robot;

import org.usfirst.frc.team3164.robot.Gamepad.LeftRightDir;
import org.usfirst.frc.team3164.robot.Gamepad.UpDownDir;

import edu.wpi.first.wpilibj.Spark;

public class Intake {
	private Spark rightMotor;
	private Spark leftMotor;
	private UpDownDir y_direction; //left joystick direction
	private double speed;
	private boolean isCCW;
	private UpDownDir up;
	private UpDownDir down;
	
	public Intake(int r_motorPort, int l_motorPort) {
		rightMotor = new Spark (r_motorPort);
		leftMotor = new Spark (l_motorPort);
		isCCW = false;
		up = UpDownDir.UP;
		down = UpDownDir.DOWN;
	}
	
	public void powerIntake(Gamepad gamepad) {
		y_direction = gamepad.sticks.LEFT_Y.getDirection();
		speed = gamepad.sticks.LEFT_Y.getIntensity();
		rightMotor.set(speed);
		leftMotor.set(speed);
		
		if (y_direction == up) { 
			leftMotor.setInverted(isCCW);
			rightMotor.setInverted(!isCCW);
		} if (y_direction == down) {
			leftMotor.setInverted(!isCCW);
			rightMotor.setInverted(isCCW);
		} 
	
	}
}
