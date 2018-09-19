/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AllianceAutonomous extends Command {
  String pos;
  Command autoMiddle;

  public AllianceAutonomous(String place) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chassis);
    pos = place;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (pos== "center"){
      autoMiddle = new autoAlliance("center");
    }
    else if (pos== "right"){
      autoMiddle = new autoAlliance("right");

    }
    else if (pos== "left"){
      autoMiddle = new autoAlliance("left");
      
    }
    else if (pos== "leftNoScale"){
      autoMiddle = new autoAlliance("leftNoScale");
      
    }
    else if (pos== "rightNoScale"){
      autoMiddle = new autoAlliance("rightNoScale");
      
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    autoMiddle.start();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
