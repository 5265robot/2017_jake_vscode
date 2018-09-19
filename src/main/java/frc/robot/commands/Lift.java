/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.stagValues;

public class Lift extends Command {
  public boolean dir;
	public double power;

  public Lift(boolean direction) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chassis);
    dir = direction;
    power = stagValues.Liftpower;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (RobotMap.analPot.get() < stagValues.potCheck || stagValues.tog == false) {
      if(dir) {
        RobotMap.brushless.set(power);
      }
      else {
        RobotMap.brushless.set(-power);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(RobotMap.analPot.get() < stagValues.potCheck || stagValues.tog == false) {
      if (dir) {
        return !RobotMap.upper.get();
      }
      else {
        return !RobotMap.lower.get();
      }
    }
    else {
      return true;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.brushless.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.brushless.set(0.0);
  }
}
