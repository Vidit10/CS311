package assignment_0;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class clock {
	private static int currentTime = 0;

	public static int getCurrentTime() {
		return currentTime;
	}

	public static void increment() {
		currentTime++;
	}

	public static void reset() {
		currentTime = 0;
	}
}

