/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.stagValues;
import frc.robot.RobotMap;

public class armPos extends Command {
  public double pos;
	double power = stagValues.armPower;
 	boolean bet = true;
 	public double pot;
 	public double fudge = 0.002;
	
  public armPos(double posi) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    pos = posi;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putString("on", "off");		
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    pot = RobotMap.analPot.get();
    bet = ((pot > pos + fudge) || (pot < pos - fudge));
    if(bet) {
    	if(RobotMap.analPot.get() > pos) {
    		RobotMap.chubby.set(-power);
    	}
      else {
    		RobotMap.chubby.set(power);
    	}	
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    pot = RobotMap.analPot.get();
    bet = ((pot > pos + fudge) || (pot < pos - fudge));
    if(!bet) {
      RobotMap.chubby.set(0);
      return true;
    }
    else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
       end();
  }
}
