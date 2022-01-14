/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// import org.graalvm.compiler.asm.sparc.SPARCAssembler.Br;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveSpinners extends SubsystemBase {

  /** These are the variables for the SwerveSpinners subsytem. */
  public static final double MM_TO_IN = 0.0393701;
  public static final double WHEEL_TO_WHEEL_DIAMETER_INCHES = 320 * MM_TO_IN;
  public static final double WHEEL_DIAMETER_INCHES = 4;
  // It may be more logical to use no SPEED MULTIPLIER and rather just depend on the controller input(investigate)
  public static final double ROTTRANSCUT = 0;
  public static final double SPEED_MULTIPLIER = 1/(Math.sqrt(2))-ROTTRANSCUT;
  public static final double ROTATION_COEFFICIENT = 0.5;
  private WPI_TalonFX bRMotor, bLMotor, fRMotor, fLMotor;
  private SpeedControllerGroup bR, bL, fR, fL;
  public static boolean swerveSwitch; // tank drive go brrrrrrr
  
  //This is the constructor for this subsytem.
  public SwerveSpinners() {
    swerveSwitch = false;

    bRMotor = new WPI_TalonFX(MOTOR_PORT_4);
    bLMotor = new WPI_TalonFX(MOTOR_PORT_3);
    fRMotor = new WPI_TalonFX(MOTOR_PORT_1);
    fLMotor = new WPI_TalonFX(MOTOR_PORT_2);

    fLMotor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 25, 20, 1.0));
    fLMotor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 25, 20, 1.0));

    fRMotor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 25, 20, 1.0));
    fRMotor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 25, 20, 1.0));

    bRMotor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 25, 20, 1.0));
    bRMotor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 25, 20, 1.0));
    
    bLMotor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 25, 20, 1.0));
    bLMotor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 25, 20, 1.0));


    bR = new SpeedControllerGroup(bRMotor);
    bL = new SpeedControllerGroup(bLMotor);
    fR = new SpeedControllerGroup(fRMotor);
    fL = new SpeedControllerGroup(fLMotor);
  }

  public boolean getSwitch() {return swerveSwitch;}

  public void toggleSwitch(){
    if(swerveSwitch==true) swerveSwitch = false;
    else swerveSwitch = true;
  }

  //This function is the default command for the swervedrive motor spinners.
  public void spinMotors(double horizontal, double vertical, double rotationHorizontal, double angle){
    //This -1 is due to how the vertical axis works on the controller. 
    vertical *= -1;

    if(swerveSwitch == false){
      double r = (Math.pow(Math.sqrt(horizontal*horizontal + vertical*vertical),1)*SPEED_MULTIPLIER);

      //Here the initial speeds are set to the value r - calculated above -
      double backRightSpeed = 0;
      double backLeftSpeed = 0;
      double frontRightSpeed = 0;
      double frontLeftSpeed = 0;
      boolean isRotating = Math.abs(rotationHorizontal)>=CONTROLLER_SENSITIVITY;
      boolean isTranslating = (Math.sqrt((Math.pow(vertical, 2) + Math.pow(horizontal, 2))) >= CONTROLLER_SENSITIVITY);

      if (!isRotating&&isTranslating){
        frontRightSpeed = r;
        backLeftSpeed = r;
        backRightSpeed = r;
        frontLeftSpeed = r;
      }

      else if(isRotating && !isTranslating){
        backRightSpeed = -rotationHorizontal*ROTATION_COEFFICIENT;
        frontRightSpeed = -rotationHorizontal*ROTATION_COEFFICIENT;
        backLeftSpeed = -rotationHorizontal*ROTATION_COEFFICIENT;
        frontLeftSpeed = -rotationHorizontal*ROTATION_COEFFICIENT;
      }

      else if (isRotating && isTranslating){
        frontRightSpeed = r;
        backLeftSpeed = r;
        backRightSpeed = r;
        frontLeftSpeed = r;
      }

      bR.set(backRightSpeed);
      bL.set(backLeftSpeed);
      fR.set(frontRightSpeed);
      fL.set(frontLeftSpeed);
    }

    else{
      double y;
      double x;
      if(Math.abs(vertical) < 0.02) y = 0;
      if(Math.abs(rotationHorizontal) < 0.02) x = 0;        
      y = Math.abs(vertical) * SPEED_MULTIPLIER;
      x = Math.abs(rotationHorizontal) * SPEED_MULTIPLIER; 
      bR.set(-(y-x));
      bL.set(y+x);
      fR.set(-(y-x));
      fL.set(y+x);
    }
  }

  public void autoTranslational(double x, double y, double totalDistance){
    double initialPosition = bRMotor.getSelectedSensorPosition();
    while((Math.PI*WHEEL_DIAMETER_INCHES*360*(bRMotor.getSelectedSensorPosition()-initialPosition)/2048)<totalDistance){
      spinMotors(x, -y, 0, 0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}