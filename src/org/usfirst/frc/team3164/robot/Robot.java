/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;
/**import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team3164.robot.Lift;**/
import org.usfirst.frc.team3164.robot.Intake;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	//private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Spark frontLeft;
	private Spark frontRight;
	private Spark backLeft;
	private Spark backRight;
	private MecanumDrive mecDrive;
	private Gamepad j_gamepad;
	private Gamepad p_gamepad;
	//private Timer timer;
	//private boolean hasStarted;
	//private Lift lift;
	//private Intake intake;
	private Autonomous auto;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	@Override
	public void robotInit() {	
		frontLeft = new Spark(2);
		frontRight = new Spark(3);
		backLeft = new Spark(1);
		backRight = new Spark(0);
		mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		j_gamepad = new Gamepad(0);
		p_gamepad = new Gamepad(1);
		j_gamepad.sticks.setDeadzones();
		p_gamepad.sticks.setDeadzones();
		//p_gamepad = new Gamepad(1);
		//lift = new Lift(4, 7);/**, encoder encoder**/
		//intake = new Intake(6, 5);
//		CameraServer.getInstance().startAutomaticCapture("cam0", 0);
//		CameraServer.getInstance().startAutomaticCapture("cam1", 1);
//		CameraServer.getInstance().startAutomaticCapture("cam2", 2);
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
		auto = new Autonomous(mecDrive);
		/**timer = new Timer();
		hasStarted = false;**/
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */

	@Override
	public void autonomousPeriodic() {
		auto.autoPath();
		/**if (!hasStarted) {
			hasStarted = true;
			timer.start();
		}
		if (timer.get() < .8) {
			mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
		}**/
	}


	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		//lift.update(p_gamepad);
		
		double speedBoost = j_gamepad.trigger.getRightVal() + 1;
		double speedDecrease = j_gamepad.trigger.getLeftVal() +1;

		double xSpeed = -j_gamepad.sticks.RIGHT_Y.getRaw()  * 0.5 * speedBoost / speedDecrease;
		double ySpeed = -j_gamepad.sticks.RIGHT_X.getRaw() * 0.5 * speedBoost / speedDecrease;
		double zSpeed = -j_gamepad.sticks.LEFT_X.getRaw()  * 0.5 * speedBoost / speedDecrease;
		
		mecDrive.driveCartesian(ySpeed, xSpeed, zSpeed, 0, 0);
		//intake.powerIntake(p_gamepad);


		SmartDashboard.putNumber("joyStick", j_gamepad.sticks.RIGHT_X.getRaw());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
