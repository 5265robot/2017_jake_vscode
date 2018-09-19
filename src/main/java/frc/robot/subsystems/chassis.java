/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.driveCommandSteer;

/**
 * Add your docs here.
 */
public class chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final static SpeedController speedController0 = RobotMap.chassisSpeedController0; // Front Left
  private final static SpeedController speedController1 = RobotMap.chassisSpeedController1; // Front Right
  private final static SpeedController speedController2 = RobotMap.chassisSpeedController2; // Rear Right
  private final static SpeedController speedController3 = RobotMap.chassisSpeedController3; // Rear Left
  public final static SpeedController brushless = RobotMap.brushless;
  
  // main driving program, using simple addition to get the robot moving in the appropriate direction
   
  // driving the individual wheels. If a certain motor begins to not supply sufficient umph, we can modify it here
  public static void driveFrontLeft(double speed) {
    speedController0.set(speed);
  }

  public static void driveFrontRight(double speed) {
    speedController1.set(speed);
  }

  public static void driveRearRight(double speed) {
    speedController2.set(speed);
  }

  public static void driveRearLeft(double speed) {
    speedController3.set(speed);
  }

  public static void brushless(double speed) {
    brushless.set(speed);
  }
  
  public static void driveChassisSteering(double x_speed, double y_speed) {
    double FL, FR, RL, RR;
    //	double maxXYT;
    
    if(x_speed < -0.1 || x_speed > 0.1){
      FL =  -x_speed;
      FR =  x_speed;
      RL = -x_speed;
      RR = x_speed;
    }
    else{
      FL = y_speed;
      FR = y_speed;
      RL = y_speed;
      RR = y_speed;
    }

    driveFrontLeft(FL);
    driveFrontRight(FR);
    driveRearLeft(RL);
    driveRearRight(RR);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // calls the command to get the joystick position for driving
    setDefaultCommand(new driveCommandSteer());
  }
}
