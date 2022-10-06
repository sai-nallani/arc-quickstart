package org.firstinspires.ftc.teamcode.subsystems.teleops;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubSystem extends SubsystemBase {
    private MecanumDrive mecanumDrive;
    private Motor _fL, _fR, _bL, _bR;

    public DriveSubSystem(Motor fL, Motor bL, Motor fR, Motor bR) {
        _fL = fL;
        _fR = bL;
        _bL = fR;
        _bR = bR;
        mecanumDrive = new MecanumDrive(_fL, _fR, _bL, _bR);


    }
    public void drive(double sS, double fS, double tS) {
        mecanumDrive.driveRobotCentric(-sS, -fS, -tS, true);
    }
}
