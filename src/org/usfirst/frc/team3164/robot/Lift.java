package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class Lift {
	private Spark m_motor;
	private Encoder m_encoder;
	private int m_revolutions;
	
	public Lift(int motorPort, int encoderPortA, int encoderPortB) {
		m_motor = new Spark(motorPort);
		m_encoder = new Encoder(encoderPortA, encoderPortB);
		
		m_revolutions = 100000000;
	}
	
	public void update(Gamepad gamePad) {
		double y = gamePad.sticks.RIGHT_Y.getRaw();
		
		m_motor.set(y);
		int currentRevolutions = m_encoder.getRaw(); //explain specificslly this part to maria pls : )
		
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
	}
}
