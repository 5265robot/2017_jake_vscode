/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.stagValues;
import frc.robot.RobotMap;

public class arm extends Command {
  boolean pos;
	private double power = stagValues.armPower;
	private double upLimit = stagValues.upperLimit;
	private double lowLimit = stagValues.lowerLimit;
  boolean stuck;
  
  public arm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    pos = (RobotMap.analPot.get() > lowLimit);
    stuck = (RobotMap.analPot.get()  < lowLimit && RobotMap.analPot.get() > upLimit ); 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(stuck) {
      RobotMap.chubby.set(-power);
    }
    else if(pos) {
      RobotMap.chubby.set(-power);
    }
    else {
      RobotMap.chubby.set(power);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(pos || stuck) {
      if(RobotMap.analPot.get() < upLimit) {
        RobotMap.chubby.set(0);
        return true;
      }
    }else {
      if(RobotMap.analPot.get() > lowLimit) {
        RobotMap.chubby.set(0);
        return true;
      }
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
