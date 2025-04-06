package assignment_0;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class simulation {
	private static final int BORDER_WIDTH = 4;
	private static final int BORDER_LENGTH = 1000;
	private static final double SENSOR_PROBABILITY = 0.5;

	public static void main(String[] args) {
	clock.reset();
	sensor sensors = new sensor(BORDER_WIDTH, BORDER_LENGTH, SENSOR_PROBABILITY);
	infiltrator Infiltrator = new infiltrator(BORDER_WIDTH, BORDER_LENGTH);

	while (!Infiltrator.isCaught() && !Infiltrator.hasSucceeded()) {
	    sensors.updateSensors();
	    Infiltrator.move(sensors.getSensorStates());
	    
	    if (clock.getCurrentTime() % 10 == 0) {
		System.out.printf("Time: %d, infiltrator position: (%d, %d)\n",
		    clock.getCurrentTime(), Infiltrator.getX(), Infiltrator.getY());
	    }
	    
	    clock.increment();
	    
	    // Added this optional delay, so that the simulation is observable to human eye :D
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	if (Infiltrator.isCaught()) {
	    System.out.println("Infiltrator was caught!");
	} else {
	    System.out.println("Infiltrator succeeded in crossing the border!");
	}
	System.out.println("Simulation ended at time: " + clock.getCurrentTime());
	}
}

