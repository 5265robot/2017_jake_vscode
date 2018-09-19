/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static SpeedController chassisSpeedController0; // Front Left
  public static SpeedController chassisSpeedController1; // Front Right
  public static SpeedController chassisSpeedController2; // Rear Right
  public static SpeedController chassisSpeedController3; // Rear Left
  public static SpeedController shooterMotor; 
  public static SpeedController chubby;
  public static AnalogPotentiometer analPot;
  public static PowerDistributionPanel chassisPowerDistributionPanel1;
  public static SpeedController brushless;
  public static Servo servme;
  public static DoubleSolenoid airDoubleSolenoid1; 
  public static DigitalInput upper;
  public static DigitalInput lower;
  
  public static void init() {
      // declare our Victors, in a clockwise direction across the front and then the back,
      // as if you were sitting in the center of the robot
      // 0 intake 1
      // x xxxxxx x
      // x xxxxxx x
      // 3 xgearx 2
      chassisSpeedController0 = new Victor(0); // Front Left
      //LiveWindow.addActuator("chassis", "Speed Controller 0", (Victor) chassisSpeedController0);
      
      chassisSpeedController1 = new Victor(1); // Front Right
      //LiveWindow.addActuator("chassis", "Speed Controller 1", (Victor) chassisSpeedController1);
      
      chassisSpeedController2 = new Victor(2); // Rear Right
      //LiveWindow.addActuator("chassis", "Speed Controller 2", (Victor) chassisSpeedController2);
      
      chassisSpeedController3 = new Victor(3); // Rear Left
      // LiveWindow.addActuator("chassis", "Speed Controller 3", (Victor) chassisSpeedController3);
      
      brushless = new Victor(4);
      //LiveWindow.addActuator("brush", "brush motor", (Victor) brushless);
      
      chubby = new Victor(5);
      //LiveWindow.addSensor("chassis", "analpot", (AnalogPotentiometer) analPot);
      
      try {
          upper = new DigitalInput(1);
      }catch(Exception e) {
      
      }try {
          lower = new DigitalInput(0);
      }catch(Exception e) {
      
      }try { 
          analPot = new AnalogPotentiometer(3);
      }catch(Exception e) {
      
      }try {
          airDoubleSolenoid1 = new DoubleSolenoid(0,1);
      }catch(Exception e) {
          
      }

  }
}
