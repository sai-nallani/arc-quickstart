package org.firstinspires.ftc.teamcode.teleops;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.commands.teleOps.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.teleOps.MotorCommand;
import org.firstinspires.ftc.teamcode.subsystems.motor.MotorSubSystem;
import org.firstinspires.ftc.teamcode.subsystems.teleops.DriveSubSystem;

@TeleOp(name = "main")
public class MainTeleOps extends CommandOpMode {
    private Motor fL, fR, bL, bR, m;
    private GamepadEx gpad1;
    private DriveSubSystem driveS;
    private MotorSubSystem motorSubSystem;
    private MotorCommand motorCommand;
    private final double DRIVE_MULT = 1.0;
    private final double SLOW_MULT = 1.0;
    @Override
    public void initialize() {
        fL = new Motor(hardwareMap, "FrontLeft");
        fR = new Motor(hardwareMap, "FrontRight");
        bL = new Motor(hardwareMap, "BackRight");
        bR = new Motor(hardwareMap, "BackLeft");
        gpad1 = new GamepadEx(gamepad1);
        m = new Motor(hardwareMap, "m");
        fL.motor.setDirection(DcMotor.Direction.REVERSE);
        fR.motor.setDirection(DcMotor.Direction.FORWARD);
        bL.motor.setDirection(DcMotor.Direction.REVERSE);
        bR.motor.setDirection(DcMotor.Direction.FORWARD);

        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveS = new DriveSubSystem(fL, fR, bL, bR);
        motorSubSystem = new MotorSubSystem(m, 0.5);
        motorCommand = new MotorCommand(motorSubSystem);
        gpad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new DriveCommand(driveS, gpad1::getLeftX, gpad1::getLeftY, gpad1::getRightX, SLOW_MULT));
        //gpad1.getGamepadButton(GamepadKeys.Button.A).toggleWhenPressed(new MotorCommand(motor));
        gpad1.getGamepadButton(GamepadKeys.Button.A).toggleWhenPressed(motorCommand);

    }
}