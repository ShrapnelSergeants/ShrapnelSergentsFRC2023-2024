// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */

 /*
  navX for gyro/imu
  Front wheels TalonSRX
  Back wheels VictorSPX 

  CAN address
  front left 20
  back left 21
  front right 22
  back right 23


  */


public class Robot extends TimedRobot {
  //private final TalonSRX m_leftFrontMotor = new TalonSRX(20);
  //private final TalonSRX m_rightFrontMotor = new TalonSRX(22);
  private final WPI_TalonSRX m_leftFrontMotor = new WPI_TalonSRX(20);
  private final WPI_TalonSRX m_rightFrontMotor = new WPI_TalonSRX(22);
  private final VictorSPX m_leftBackMotor = new VictorSPX(21);
  private final VictorSPX m_rightBackMotor = new VictorSPX(23);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftFrontMotor, m_rightFrontMotor);
  //private final Joystick m_stick = new Joystick(0);
  private final XboxController m_stick = new XboxController(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightFrontMotor.setInverted(true);
    m_rightBackMotor.setInverted(true);

    m_leftBackMotor.follow(m_leftFrontMotor);
    m_rightBackMotor.follow(m_rightFrontMotor);
    
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    //m_robotDrive.arcadeDrive(-m_stick.getY(), -m_stick.getX());
    m_robotDrive.arcadeDrive(-m_stick.getLeftY(),-m_stick.getRightX());
  }
}
