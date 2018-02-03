package org.usfirst.frc.team3164.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Spark frontLeft;
	private Spark frontRight;
	private Spark backLeft;
	private Spark backRight;
	private MecanumDrive mecDrive;
	private Gamepad padGame;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		frontLeft = new Spark(2);
		frontRight = new Spark(1);
		backLeft = new Spark(3);
		backRight = new Spark(0);
		mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
		padGame = new Gamepad(0);
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
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */

	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double xSpeed = -padGame.sticks.RIGHT_X.getRaw() * .5;
		double ySpeed = -padGame.sticks.RIGHT_Y.getRaw() * .5;
		double zSpeed = -padGame.sticks.LEFT_X.getRaw() * .5;
		
		double speedBoost = padGame.trigger.getRightVal() * .5;
		double speedDecrease = padGame.trigger.getLeftVal() * .5;
		
		int xSign = (xSpeed > 0) ? 1 : -1;
		int ySign = (ySpeed > 0) ? 1 : -1;
		int zSign = (zSpeed > 0) ? 1 : -1;
		
		xSpeed += speedBoost * xSign;
		xSpeed -= speedDecrease * xSign;
		ySpeed += speedBoost * ySign;
		ySpeed -= speedDecrease * ySign;
		zSpeed += speedBoost * zSign;
		zSpeed -= speedDecrease * zSign;
		
		mecDrive.driveCartesian(ySpeed, xSpeed, zSpeed);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
