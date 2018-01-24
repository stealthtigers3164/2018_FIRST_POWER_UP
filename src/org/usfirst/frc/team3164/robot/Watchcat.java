package org.usfirst.frc.team3164.robot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Watchcat {
	public static boolean isRobotDead = false;
	private static MotorRegistry mReg;
	
	public static void init() {
		mReg = new MotorRegistry();
		//wdTrd.start();
	}
	
	public static class MotorRegistry {
		private Map<UUID, BasicMotor> motors = new HashMap<UUID, BasicMotor>();
		
		public void addMotor(BasicMotor m) {
			if(!isHere(m)) {
				motors.put(UUID.randomUUID(), m);
			}
		}
		
		private boolean isHere(BasicMotor m) {
			for(BasicMotor mo : motors.values()) {
				if(m.getLoc() == mo.getLoc()) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void killRobot() {
		if(isRobotDead)
			return;
		isRobotDead = true;
		for(BasicMotor m : mReg.motors.values()) {
			m.setDead(true);
		}
	}
	
	public static void reviveRobot() {
		if(!isRobotDead)
			return;
		isRobotDead = false;
		for(BasicMotor m : mReg.motors.values()) {
			m.setDead(false);
		}
	}
	
	public static void feed() {
		reviveRobot();
	}
	
	public static void registerMotor(BasicMotor m) {
		mReg.addMotor(m);
	}
}
