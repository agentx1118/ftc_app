package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Sample Tank Drive", group = "Pushbot")
public class TankTest extends LinearOpMode
{
    VoltronHardwareConfig robot = new VoltronHardwareConfig();
  
    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);
        while(opModeIsActive())
        {
            double lPower = gamepad1.left_stick_y;
            double rPower = gamepad1.right_stick_y;
            robot.driveMotorL.setPower(lPower);
            robot.driveMotorR.setPower(rPower);
      
            //adds telemetry data to phone display
            telemetry.addData("Left_Drive", "%2f", lPower);
            telemetry.addData("Right_Drive", "%2f", rPower);
            telemetry.update();
            robot.waitForTick(40);
        }
    }
}
