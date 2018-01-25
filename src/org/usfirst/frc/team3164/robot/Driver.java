package org.usfirst.frc.team3164.robot;

public class Driver {
	private SparkMotor m_frontLeft;
	private SparkMotor m_frontRight;
	private SparkMotor m_backLeft;
	private SparkMotor m_backRight;
	
	public Driver() {
		m_frontLeft = new SparkMotor(2);
		m_frontRight = new SparkMotor(3);
		m_backLeft = new SparkMotor(1);
		m_backRight = new SparkMotor(0);
		
	}

	public void update(Gamepad pad) {
		double left_y = pad.sticks.LEFT_Y.getRaw();
		double left_x = pad.sticks.LEFT_X.getRaw();
		double right_y = pad.sticks.RIGHT_Y.getRaw();
		double right_x = pad.sticks.RIGHT_X.getRaw();

		if (right_y != 0 && 
			right_x == 0) {
			m_frontRight.setPower(right_y);
			m_backRight.setPower(right_y);
		}else if (right_x != 0 &&
				right_x == 0) {
			m_frontRight.setPower(right_x);
			m_backRight.setPower(-right_x);			
		} else {
			m_frontRight.setPower(right_x / 2);
			m_backRight.setPower(-right_x);			
		}
		
		if (left_y != 0 && 
			left_x == 0) {
			m_frontLeft.setPower(left_y);
			m_backLeft.setPower(left_y);
		} else if (left_x != 0 &&
				left_y == 0) {
			m_frontLeft.setPower(-left_x);
			m_backLeft.setPower(left_x);
		} else {
			m_frontLeft.setPower(-left_x);
			m_backLeft.setPower(left_x / 2);
		}
	}
}
