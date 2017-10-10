import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class VoltronHardwareConfig
{
	public DcMotor driveMotorL = null;
	public DcMotor driveMotorR = null;
	HardwareMap hwMap = null;
	private ElapsedTime period  = new ElapsedTime();

	public void init(HardwareMap ahwMap)
	{
		hwMap = ahwMap;
		driveMotorL = hardwareMap.dcMotor.get("nullL");
		driveMotorR = hardwareMap.dcMotor.get("nullR");
		driveMotorL.setDirection(DcMotor.Direction.REVERSE);
		driveMotorR.setDirection(DcMotor.Direction.FORWARD);
		driveMotorL.setPower(0);
		driveMotorR.setPower(0);
		driveMotorL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
		driveMotorR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
	}
	   /***
   	 *
     	* waitForTick implements a periodic delay. However, this acts like a metronome with 	a regular
    	 * periodic tick.  This is used to compensate for varying processing times for each 	cycle.
    	 * The function looks at the elapsed cycle time, and sleeps for the remaining time 	interval.
     	*
     	* @param periodMs  Length of wait cycle in mSec.
   	*/
   	public void waitForTick(long periodMs) {
        		long  remaining = periodMs - (long)period.milliseconds();
       		 // sleep for the remaining portion of the regular cycle period.
        		if (remaining > 0)
        		{
            			try
            			{
                			Thread.sleep(remaining);
            			}
            			catch (InterruptedException e)
            			{
                			Thread.currentThread().interrupt();
            			}
       	 	}

        		// Reset the cycle clock for the next pass.
        		period.reset();
    	}
}
