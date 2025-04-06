package assignment_0;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class sensor {
	private boolean[][] sensorStates;
	private final int width;
	private final int length;
	private final double probability;

	public sensor(int width, int length, double probability) {
	this.width = width;
	this.length = length;
	this.probability = probability;
	this.sensorStates = new boolean[width][length];
	updateSensors();
	}

	public void updateSensors() {
	if (clock.getCurrentTime() % 10 == 0) {  // Update every 10 seconds
	    Random rand = new Random();
	    for (int i = 0; i < width; i++) {
		for (int j = 0; j < length; j++) {
		    sensorStates[i][j] = rand.nextDouble() <= probability;
		}
	    }
	}
	}

	public boolean[][] getSensorStates() {
	return sensorStates;
	}
}

