package org.firstinspires.ftc.teamcode.commands.teleOps;

import com.arcrobotics.ftclib.command.CommandBase;
import java.util.Scanner;
import org.firstinspires.ftc.teamcode.subsystems.teleops.DriveSubSystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private final DriveSubSystem mecDrive;
    private final DoubleSupplier m_strafe, m_forward, m_turn;
    private double multiplier;

    public DriveCommand(DriveSubSystem subsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn, double mult) {
        mecDrive = subsystem;
        m_strafe = strafe;
        m_forward = forward;
        m_turn = turn;
        multiplier = mult;

        addRequirements(subsystem);
    }

    public DriveCommand(DriveSubSystem subsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn) {
        mecDrive = subsystem;
        m_strafe = strafe;
        m_forward = forward;
        m_turn = turn;
        multiplier = 1.0;
        addRequirements(subsystem);
    }
    @Override
    public void execute() {
        mecDrive.drive(m_strafe.getAsDouble() * 0.9 * multiplier,
                m_forward.getAsDouble() * 0.9 * multiplier,
                m_turn.getAsDouble() * 0.88 * multiplier);

    }
}
