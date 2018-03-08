package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class Lift {
	private Spark motorA;
	private Spark motorB;
	private Encoder m_encoder;
	private int m_revolutions;
	
	public Lift(int motorPortA, int motorPortB/**, int encoderPortA, int encoderPortB**/) {
		motorA = new Spark(motorPortA);
		motorB = new Spark(motorPortB);
		//m_encoder = new Encoder(encoderPortA, encoderPortB);
		
		m_revolutions = 5;
	}
	
	public void update(Gamepad gamePad) {
		double up = gamePad.trigger.getRightVal();
		double down = -gamePad.trigger.getLeftVal();
		double speed = (up + down);
		
	
		
		motorA.set(speed);
		motorB.set(speed);

		/**int currentRevolutions = m_encoder.getRaw();
		
		if (m_revolutions == 5 ||
			speed == 0) {
			m_revolutions = currentRevolutions;
		
			int difference = currentRevolutions - m_revolutions;
			if (difference > 10) {
				m_motor.set(.15);
			} else if (difference < -10) {
				m_motor.set(-.15);
			}
		}
		else {
			
			m_revolutions = currentRevolutions;			
		}**/
	}
/***
	private Spark lift_motor;
	private Encoder encoder;
	private int m_revolutions;
	
	public Lift(int motorPort, int encoderPortA, int encoderPortB) {
		lift_motor = new Spark(motorPort);
		encoder = new Encoder(encoderPortA, encoderPortB);
	}
	
	public void update(Gamepad gamePad) {
		double up = gamePad.trigger.getRightVal();
		double down = -gamePad.trigger.getLeftVal();
		double distance = up + down;
		double speed = 0 + distance;
		
		lift_motor.set(speed);
		
		double currentPos = encoder.getRaw();
		
		if (speed == 0) {
			lift_motor.set(currentPos);
		}
		
		if (m_revolutions == 100000000 ||
			y == 0) {
			m_revolutions = currentRevolutions;
		
			int difference = currentRevolutions - m_revolutions;
			if (difference > 10) {
				m_motor.set(.15);
			} else if (difference < -10) {
				m_motor.set(-.15);
			}
		}
		else {
			
			m_revolutions = currentRevolutions;	
		}
	} ***/
}
