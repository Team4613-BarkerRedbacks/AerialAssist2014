/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.drive;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class TimedMove extends CommandBase {
    
    double speed;
    CommandBase command;
    
    public TimedMove(double time, double sp, CommandBase com) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driver);
        setTimeout(time);
        speed = sp;
        command = com;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double rotation = 0;
                
        driver.driveFront.arcadeDrive(rotation, speed);
        driver.driveRear.arcadeDrive(rotation, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut(); 
    }

    // Called once after isFinished returns true
    protected void end() {
        if(command != null)
        {
            command.start();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
