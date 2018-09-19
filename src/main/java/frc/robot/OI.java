/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

import frc.robot.subsystems.stagValues;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick steering;
  public JoystickButton brush;
  public JoystickButton armPos;
  public JoystickButton armPosH;
  public JoystickButton solTest;
  public JoystickButton liftup;
  public JoystickButton liftdown;
  public JoystickButton tog;

  public OI() {
    // construct the joystick
    steering = new Joystick(0);
     
    // construct each button and what happens when it is used
    // click01 = new JoystickButton(steering, 1);
      //click01.whileHeld(new dothis01());
    tog = new JoystickButton(steering, 2);
        tog.whenPressed(new arm());

    solTest = new JoystickButton(steering,1);
        solTest.whenPressed(new SolTest());

    liftup = new JoystickButton(steering, 5);
        liftup.whileHeld(new Lift(true));

    liftdown = new JoystickButton(steering, 6);
        liftdown.whileHeld(new Lift(false));

    armPos = new JoystickButton(steering, 3);
        armPos.whenPressed(new armPos(stagValues.startPos));

    armPosH = new JoystickButton(steering, 4);
        armPosH.whenPressed(new armPos(stagValues.maxH));
  }
          
  // these methods return raw data from the joystick
  // we should probably comment out the radian vector methods, as we aren't using them
  public Joystick getsteering() {
      return steering;
  }

  public double getForward() {
      return steering.getRawAxis(1); //look up what the actual axis number is
  }

  public double getSideways() {
      return steering.getRawAxis(4); //look up what the actual axis number is
  }   
  
  public double getThrottle() {
      return steering.getThrottle()-.99;
  }
}
