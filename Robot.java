// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //create and name a digtal input
  DigitalInput ballSensor = new DigitalInput(1);
  //Ball Counter Variables
  int currentBallCount ;
  int previousBallCount;

//name joystick
private Joystick Stick;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  @Override
  public void robotInit() {
    currentBallCount=0;
    previousBallCount=0;
    Stick = new Joystick(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    
    
  }

  @Override
  public void teleopPeriodic() {
    
    if(ballSensor.get() && (currentBallCount == previousBallCount)){
      currentBallCount++;
          }
    if(ballSensor.get()==false){
      previousBallCount=currentBallCount;
    }
    boolean isPressed = Stick.getRawButton(1);
    if(isPressed==true){
      currentBallCount=0;
      previousBallCount=0;
    } 
          SmartDashboard.putNumber("Current Ball Count", currentBallCount);
          SmartDashboard.putNumber("Previous Ball Count", previousBallCount);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
