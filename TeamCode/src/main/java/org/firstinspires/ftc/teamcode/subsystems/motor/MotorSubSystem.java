package org.firstinspires.ftc.teamcode.subsystems.motor;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class MotorSubSystem extends SubsystemBase {
    private Motor i;
    private double speed;
    public MotorSubSystem(Motor q, double d) {
        speed = d;
        i = q;
    }
    public void start() {
        i.set(speed);
    }
    public void stop() {
        i.set(0);
    }
}
