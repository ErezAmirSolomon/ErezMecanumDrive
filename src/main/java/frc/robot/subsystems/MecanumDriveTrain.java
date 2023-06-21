// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VictorSPPorts;
import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class MecanumDriveTrain extends SubsystemBase {
  private VictorSP m_frontRightMotorController;
  private VictorSP m_rearRightMotorController;
  private VictorSP m_frontLeftMotorController;
  private VictorSP m_rearLeftMotorController;

  private Joystick m_stick;

  private MecanumDrive m_robotDrive;


  /** Creates a new MecanumDrive. */
  public MecanumDriveTrain() {
    m_frontRightMotorController = new VictorSP(VictorSPPorts.kFrontRightMotorControllerPort);
    m_rearRightMotorController = new VictorSP(VictorSPPorts.kRearRightMotorContollerPort);
    m_frontLeftMotorController = new VictorSP(VictorSPPorts.kFrontLeftMotorControllerPort);
    m_rearLeftMotorController = new VictorSP(VictorSPPorts.kRearLeftMotorControllerPort);


    m_frontRightMotorController.setInverted(true);
    m_rearRightMotorController.setInverted(true);

    m_robotDrive = new MecanumDrive(m_frontLeftMotorController, m_rearLeftMotorController, m_frontRightMotorController, m_rearRightMotorController);

    m_stick = new Joystick(OperatorConstants.kDriverControllerPort);

  }
  public void Move(double xspeed, double yspeed, double rotspeed) {
    m_robotDrive.driveCartesian(-m_stick.getY(), -m_stick.getX(), -m_stick.getZ());
  }
}
