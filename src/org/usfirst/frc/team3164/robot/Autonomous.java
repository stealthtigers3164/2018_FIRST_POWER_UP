
package org.usfirst.frc.team3164.robot;

import org.usfirst.frc.team3164.FMS.FieldPosition;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous {
	private FieldPosition fieldPos;
	private Timer timer;
	private boolean hasStarted;
	private MecanumDrive mecDrive;
	
	public Autonomous(MecanumDrive mecDrive) {
		fieldPos = new FieldPosition();
		timer = new Timer();
		hasStarted = false;
		this.mecDrive = mecDrive;
	 }
	
	public void autoPath() {
		if (!hasStarted) {
			hasStarted = true;
			timer.start();
		}
			switch(fieldPos.getSwitchPos()) {
			case 'L':
				switch(fieldPos.getAlliance()) {
				case "Red":
					if (timer.get() < 0.66) {
						mecDrive.driveCartesian(0, -0.5 , 0, 0, 0);
					}
					if (timer.get() > 0.66 && timer.get() < 1.28) {
						mecDrive.driveCartesian(0.5, 0, 0, 0, 0);
					}
					if (timer.get() > 1.28 && timer.get() < 2.24)
						mecDrive.driveCartesian(0, -0.5, 0, 0, 0);
					break;
				case "Blue":
					if (timer.get() < 0.66) {
						mecDrive.driveCartesian(0, -0.5 , 0, 0, 0);
					}
					if (timer.get() > 0.66 && timer.get() < 1.28) {
						mecDrive.driveCartesian(0.5, 0, 0, 0, 0);
					}
					if (timer.get() > 1.28 && timer.get() < 2.24)
						mecDrive.driveCartesian(0, -0.5, 0, 0, 0);
					break;
				case "Invalid position":
					if (timer.get() < .8) {
						mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
					}
					break;
					}
				break;
			case 'R':
				switch(fieldPos.getAlliance()) {
				case "Red":
					if (timer.get() < 0.66) {
						mecDrive.driveCartesian(0, -0.5 , 0, 0, 0);
					}
					if (timer.get() > 0.66 && timer.get() < 1.28) {
						mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
					}
					if (timer.get() > 1.28 && timer.get() < 2.24)
						mecDrive.driveCartesian(0, -0.5, 0, 0, 0);
					break;
				case "Blue":
					if (timer.get() < 0.66) {
						mecDrive.driveCartesian(0, -0.5 , 0, 0, 0);
					}
					if (timer.get() > 0.66 && timer.get() < 1.28) {
						mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
					}
					if (timer.get() > 1.28 && timer.get() < 2.24)
						mecDrive.driveCartesian(0, -0.5, 0, 0, 0);
					break;
				case "Invalid position":
					if (timer.get() < .8) {
						mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
					}
					break;
					} 
				break;
			case '!':
				if (timer.get() < .8) {
					mecDrive.driveCartesian(-0.5, 0, 0, 0, 0);
				}
				break;
			} 
		}
	}
