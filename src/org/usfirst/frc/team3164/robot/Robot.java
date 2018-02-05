/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private Spark frontLeft;
	private Spark frontRight;
	private Spark backLeft;
	private Spark backRight;
	private MecanumDrive mecDrive;
	private Gamepad padGame;
	
	private Timer timer;
	private double startTime;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		frontLeft = new Spark(2);
		frontRight = new Spark(1);
		backLeft = new Spark(3);
		backRight = new Spark(0);
		mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		padGame = new Gamepad(0);
		padGame.sticks.setDeadzones();
		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
		CameraServer.getInstance().startAutomaticCapture("cam1", 1);
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		timer = new Timer();
		hasStarted = false;
	}
	
	private boolean hasStarted;
	/**
	 * This function is called periodically during autonomous.
	 */

	@Override
	public void autonomousPeriodic() {		
		if (!hasStarted) {
			hasStarted = true;
			timer.start();
		}
		
		if (timer.get() < 5) {
			mecDrive.driveCartesian(0, .3, 0, 0, 0);
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
//		double xSpeed = -padGame.sticks.RIGHT_X.getRaw() * .5;
//		double ySpeed = -padGame.sticks.RIGHT_Y.getRaw() * .5;
//		double zSpeed = -padGame.sticks.LEFT_X.getRaw() * .5;
//		
//		double speedBoost = padGame.trigger.getRightVal() * .5;
//		double speedDecrease = padGame.trigger.getLeftVal() * .5;
//		
//		mecDrive.driveCartesian(ySpeed, xSpeed, zSpeed, speedBoost, speedDecrease);
		
		
		double speedBoost = padGame.trigger.getRightVal() + 1;
		double speedDecrease = padGame.trigger.getLeftVal() +1;

		double xSpeed = -padGame.sticks.RIGHT_X.getRaw() * .5 *speedBoost / speedDecrease;
		double ySpeed = -padGame.sticks.RIGHT_Y.getRaw() * .5 *speedBoost / speedDecrease;
		double zSpeed = -padGame.sticks.LEFT_X.getRaw() * .5 *speedBoost / speedDecrease;
		
	mecDrive.driveCartesian(ySpeed, xSpeed, zSpeed, 0, 0);

		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
