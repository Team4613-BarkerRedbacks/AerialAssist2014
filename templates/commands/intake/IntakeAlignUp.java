/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.intake;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class IntakeAlignUp extends CommandBase {
    
    public IntakeAlignUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intakeArm.raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return intakeArm.pot.getVoltage() < RobotMap.intakeStandardPosition;
    }

    // Called once after isFinished returns true
    protected void end() {
        new IntakeLower().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
