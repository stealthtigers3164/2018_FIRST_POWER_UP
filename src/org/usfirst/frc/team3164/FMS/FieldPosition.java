package org.usfirst.frc.team3164.FMS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class FieldPosition {

	private DriverStation station;
	private Alliance allianceColor;
	private String s_switchPos;
	
	public FieldPosition(){
	}
	
	/**call function in autoInit to ensure game data is accurate**/
	public char getSwitchPos(){ 
		s_switchPos = DriverStation.getInstance().getGameSpecificMessage();
		char switchPos = this.s_switchPos.charAt(0);
//if switch position is an invalid entry (neither 'L' nor 'R'), return an error
		if (switchPos != 'L' && switchPos != 'R') {
			char error = '!';
			DriverStation.reportError("Invalid switch position", true);
			return error;
		}
		return switchPos;
	}
	
	
	/**call function in autoInit to ensure game data is accurate**/
	public String getAlliance(){ 
		allianceColor = Alliance.Blue;/**station.getAlliance();**/
//if alliance color or robot location are unknown/invalid, return an error
		if (allianceColor == Alliance.Invalid) {
			String error = "Invalid position";
			DriverStation.reportError("invalid alliance", true);
			return error;
		}
		String allianceColor = String.valueOf(this.allianceColor);
		return allianceColor;
	}
	
/**	public void testPosGetter(){
		System.out.println(getRobotPos());
	}*/

}
