// *************************
// MotorTest.java           09/15/22
//
// Demonstrates
package org.firstinspires.ftc.teamcode.tests;

import java.util.concurrent.TimeUnit;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "UdayaLikesNewborns")
public class MotorTest extends CommandOpMode {
    private Motor m;

    @Override
    public void initialize() {
        m = new Motor(hardwareMap, "motor");
        schedule(
                new WaitUntilCommand(this::isStarted)
                        .andThen(new InstantCommand(() -> m.set(-1)))
                        .andThen(new WaitCommand(1000))
                        .andThen(new InstantCommand(() -> m.set(-0.5)))
                        .andThen(new WaitCommand(1000))
                        .andThen(new InstantCommand(() -> m.set(0)))
                        .andThen(new WaitCommand(1000))
                        .andThen(new InstantCommand(() -> m.set(0.5)))
                        .andThen(new WaitCommand(1000))
                        .andThen(new InstantCommand(() -> m.set(1)))
                        .andThen(new WaitCommand(1000))
                        .andThen(new InstantCommand(() -> m.set(0))));

    }
}