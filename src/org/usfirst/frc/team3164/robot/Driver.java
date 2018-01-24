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
		double y = pad.sticks.LEFT_Y.getRaw();
		double x = pad.sticks.LEFT_X.getRaw();
		
		if (y != 0 && 
			x == 0) {
			m_frontLeft.setPower(y);
			m_frontRight.setPower(y);
			m_backLeft.setPower(y);
			m_backRight.setPower(y);
		} else if (x != 0 &&
				y == 0) {
			m_frontLeft.setPower(-x);
			m_frontRight.setPower(x);

			m_backLeft.setPower(x);
			m_backRight.setPower(-x);
		} else {
			m_frontLeft.setPower(-x);
			m_backLeft.setPower(x / 2);

			m_frontRight.setPower(x / 2);
			m_backRight.setPower(-x);			
		}
	}
}
