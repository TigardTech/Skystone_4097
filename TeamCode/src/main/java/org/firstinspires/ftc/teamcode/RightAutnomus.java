package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="UpAutonomus", group="Autonomous")
public class RightAutnomus extends LinearOpMode {
    DcMotor FleftDrive, BleftDrive, FrightDrive, BrightDrive;
    ColorSensor sensorColor;
    ModernRoboticsI2cRangeSensor rangeSensor;

    //Functions:
    void mySleep(long interval, String msg) {
        ElapsedTime myTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        while(myTimer.milliseconds() < interval && opModeIsActive()) {
            telemetry.addData("Elapsed Time (msec)", "%.00f", myTimer.milliseconds());
            telemetry.addData("mySleep", msg);
            telemetry.update();
            this.sleep(250);
        }
    }
    void Forward(double speed) {
        FleftDrive.setPower(speed);
        FrightDrive.setPower(-speed);
        BleftDrive.setPower(speed);
        BrightDrive.setPower(-speed);
    }


    void Stop() {
        FleftDrive.setPower(0);
        FrightDrive.setPower(0);
        BleftDrive.setPower(0);
        BrightDrive.setPower(0);
    }


    void StrafeLeft(double speed, long time) {
        FleftDrive.setPower(-speed);
        FrightDrive.setPower(-speed);
        BleftDrive.setPower(speed);
        BrightDrive.setPower(speed);
        sleep(time);
    }

    void StrafeRight(double speed, long time) {
        FleftDrive.setPower(speed);
        FrightDrive.setPower(speed);
        BleftDrive.setPower(-speed);
        BrightDrive.setPower(-speed);
        sleep(time);

    }

    void TurnLeft(long time, double speed) {
        FleftDrive.setPower(-speed);
        FrightDrive.setPower(-speed);
        BleftDrive.setPower(-speed);
        BrightDrive.setPower(-speed);
        sleep(time);
    }

    void TurnRight(long time, double speed) {
        FleftDrive.setPower(speed);
        FrightDrive.setPower(speed);
        BleftDrive.setPower(speed);
        BrightDrive.setPower(speed);
        sleep(time);
    }


    void ForwardTime(double speed, long time) {
        FleftDrive.setPower(-speed);
        FrightDrive.setPower(speed);
        BleftDrive.setPower(-speed);
        BrightDrive.setPower(speed);
        sleep(time);
    }

    void BackTime(double speed, int time) {
        FleftDrive.setPower(-speed);
        FrightDrive.setPower(speed);
        BleftDrive.setPower(-speed);
        BrightDrive.setPower(speed);
        sleep(time);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        //Sensors:
        //sensorColor = hardwareMap.get(ColorSensor.class, "ColorSensor");
        //rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sensor_range");

        //Drive:
        FleftDrive = hardwareMap.dcMotor.get("FL");
        FrightDrive = hardwareMap.dcMotor.get("FR");
        BleftDrive = hardwareMap.dcMotor.get("RL");
        BrightDrive = hardwareMap.dcMotor.get("RR");

        waitForStart();
        while (opModeIsActive()) {

            //ForwardTime(1, 100);
            //TurnRight(500, 1);
            Forward(0.3);
           mySleep(500, "Workss");
           Stop();

            //Color Sensor Part:
            /*if (sensorColor.red() > sensorColor.blue()) {
                stop();
            }*/

        }


    }
}
