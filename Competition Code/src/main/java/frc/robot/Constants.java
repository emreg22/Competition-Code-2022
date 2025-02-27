/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants {

    // === PORTS === //

    // SwerveDrive MOTOR Ports
  
    public static final int MOTOR_PORT_1 = 1;
    public static final int MOTOR_PORT_2 = 3;
    public static final int MOTOR_PORT_3 = 5;
    public static final int MOTOR_PORT_4 = 7; 
    public static final int ROTATOR_PORT_1 = 2;
    public static final int ROTATOR_PORT_2 = 4;
    public static final int ROTATOR_PORT_3 = 6;
    public static final int ROTATOR_PORT_4 = 8;

    // Intake Ports
    public static final int INTAKE_MOTOR_PORT = 10;
    public static final int INTAKE_PISTON_PORT_1 = 10;
    public static final int INTAKE_PISTON_PORT_2 = 11;

    //Climber Ports
    public static final int TELESCOPE_PORT_1 = 1;
    public static final int TELESCOPE_PORT_2 = 1;
    public static final int SECONDARY_PORT_1 = 1;
    public static final int SECONDARY_PORT_2 = 1;

    // Catapult Ports
    public static final int SHOOTER_MOTOR_PORT_1 = 1;
    public static final int SHOOTER_PISTON_PORT_1 = 3;
    public static final int SHOOTER_PISTON_PORT_2 = 4;

    //Piston test ports
    public static final int TPISTON_PORT_1 = 4;
    public static final int TPISTON_PORT_2 = 5;
    // Gyro Port
    
    public static final int GYRO_PORT = 9;

    // Camera & Sensor Ports

    // === CONTROLLER === //

    // Controller Constants
    public static final int DRIVER_CONTROLLER = 0;
    public static final int OPERATOR_CONTROLLER = 1;

    // == BUTTON CONSTANTS == //

        //Swerve
    public static final int TRANSLATIONAL_HORIZONTAL_AXIS = 0;
    public static final int TRANSLATIONAL_VERTICAL_AXIS = 1;
    public static final int ROTATIONAL_HORIZONTAL_AXIS = 4;
    public static final int DRIVESWITCHBUTTON = 9;

        //Intake
    public static final int INTAKE_BUTTON = 3;
    public static final int OUTTAKE_BUTTON = 4;
    public static final int RAISE_INTAKE_BUTTON = 8;
    public static final int LOWER_INTAKE_BUTTON = 10;

        //Catapult
    public static final int LOWERCATAPULT_BUTTON = 6;
    public static final int RELEASECATAPULT_BUTTON = 7;

        //Climber
    public static final int EXTEND_TELESCOPING_BUTTON = 0;
    public static final int RETRACT_TELESCOPING_BUTTON = 0;
    public static final int EXTEND_SECONDARY_BUTTON = 0;
    public static final int RETRACT_SECONDARY_BUTTON = 0;
    // === EXTRAS === //

    // Swervedrive Constants
    public static final double CONTROLLER_SENSITIVITY = 0.1;
    public static final double GEAR_RATIO = 12.8;
    public static final double GEAR_RATIO_SPINNER = 6.86;
    public static final double UNITS_PER_ROTATION = 2048;
       
    //Speed constants
    public static final double INTAKE_SPEED = 0.5;
    public static final double SHOOTER_PISTON_SPEED = 0.5;
    public static final double CATAPULT_SPEED = 0.4;
    public static final double TELESCOPING_SPEED = 0.5;
    public static final double SECONDARY_SPEED = 0.5;

    //Swervedrive PID Stuff
    public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs = 30;
    public static final Gains kGains = new Gains(0.2, 0.0, 0.0, 0.0, 0, 0.0); //coamnds 
    public static final Gains jGains = new Gains(0.1,0.0,0.0,0.0,0, 0.0); // spinners
    public static final double ERROR_TOLERANCE = 300;
    public static final double ROTATOR_ERROR_TOLERANCE = 300;

    //Controller Buttons
    public static final int BUTTON_X = 1;
    public static final int BUTTON_A = 2;
    public static final int BUTTON_B = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int LEFT_TRIGGER = 7;
    public static final int RIGHT_TRIGGER = 8;
    public static final int BACK_BUTTON = 9;
    public static final int START_BUTTON = 10;
}