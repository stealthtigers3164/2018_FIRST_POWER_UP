/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	private Driver m_driver;
	private Gamepad m_gamePad;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		m_driver = new Driver();
		m_gamePad = new Gamepad(0);
		Watchcat.init();
	}
	
	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
	}

	public void teleopPeriodic() {
//<<<<<<< Updated upstream
//		double stickDataX = pad.sticks.RIGHT_X.getRaw();
//		double stickDataY = pad.sticks.RIGHT_Y.getRaw();
//		
//		if (stickDataX != 0 &&
//			stickDataY == 0) {
//			frontLeft.set(stickDataX);
//			backLeft.set(-stickDataX);
//			
//			frontRight.set(-stickDataX);
//			backRight.set(stickDataX);
//		} else if (stickDataX == 0 &&
//				   stickDataY != 0) {
//			frontLeft.set(stickDataY);
//			backLeft.set(stickDataY);
//			frontRight.set(stickDataY);
//			backRight.set(stickDataY);			
//		} else {
//			frontLeft.set(stickDataX);
//			backLeft.set(-stickDataX);
//			
//			frontRight.set(-stickDataX);
//			backRight.set(stickDataX);
//		}
		m_driver.update(m_gamePad);
	}

	public void testPeriodic() {
	}
}
