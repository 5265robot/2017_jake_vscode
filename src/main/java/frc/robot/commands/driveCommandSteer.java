/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.chassis;
import frc.robot.subsystems.stagValues;

public class driveCommandSteer extends Command {
  /**
   * Add your docs here.
   */
  public driveCommandSteer() {
      // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.chassis);
      }
  
      // Called just before this Command runs the first time
      protected void initialize() {
      }
  
      // Called repeatedly when this Command is scheduled to run
      protected void execute() {
  
      // variables for the raw data from the joystick
      double x, y, minMotion, throttle;
      
      // load the variables from the joystick
      x = Robot.m_oi.getForward();
      y = Robot.m_oi.getSideways();
      
      throttle = Robot.m_oi.getThrottle();
      
      minMotion = stagValues.minimumMotionJoystick;
     
      // Incorporating throttle 
      throttle = ((-throttle + 1)/2);
      
      // x modification
      if (Math.abs(x) <= minMotion) { // x can be both positive and negative
          x = 0;
      }
        
      else {
        //x = Math.pow(x, pwr) * Math.abs(x)/x; // sqr of value gets better control at low speed
        x = x * throttle;
      }
    
    
      // y modification
      if (Math.abs(y) <= minMotion) { // y can be both positive and negative
        y = 0;
      }
      
      else {
        //y = Math.pow(y, pwr) * Math.abs(y)/y; // sqr of value gets better control at low speed
        y = y * throttle;
      }
      
      // steer using those variables
      chassis.driveChassisSteering(x, y);
      
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
