package org.firstinspires.ftc.teamcode.commands.teleOps;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.motor.MotorSubSystem;

public class MotorCommand extends CommandBase {
    private MotorSubSystem m;

    public MotorCommand(MotorSubSystem w123) {
        m = w123;
        addRequirements(m);
    }
    @Override
    public void initialize() {

        m.start();
    }
    @Override
    public void end(boolean interrupted){

        m.stop();
    }
}
