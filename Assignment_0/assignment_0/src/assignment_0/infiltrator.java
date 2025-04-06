package assignment_0;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class infiltrator {
	private int x;
	private int y;
	private boolean caught;
	private boolean succeeded;
	private final int borderWidth;
	private final int borderLength;

	public infiltrator(int borderWidth, int borderLength) {
	Random rand = new Random();
	this.x = 0;
	this.y = rand.nextInt(borderWidth);
	this.borderWidth = borderWidth;
	this.borderLength = borderLength;
	this.caught = false;
	this.succeeded = false;
	}

	public void move(boolean[][] sensorStates) {
	if (clock.getCurrentTime() % 10 == 0) {
	    Random rand = new Random();
	    if (rand.nextDouble() <= 0.5) {
		// Store current position
		int newX = x;
		int newY = y;
		
		// Choose random direction
		int direction = rand.nextInt(8);
		switch (direction) {
		    case 0: newX--; newY--; break;
		    case 1: newX--; break;
		    case 2: newX--; newY++; break;
		    case 3: newY--; break;
		    case 4: newY++; break;
		    case 5: newX++; newY--; break;
		    case 6: newX++; break;
		    case 7: newX++; newY++; break;
		}
		
		// Check if move is valid and sensors are OFF
		if (isValidMove(newX, newY) && 
		    !sensorStates[y][x] && !sensorStates[newY][newX]) {
		    x = newX;
		    y = newY;
		    
		    // Check if infiltrator has reached the other side
		    if (x == borderLength - 1) {
		        succeeded = true;
		    }
		} else if (sensorStates[y][x] || 
		          (isValidMove(newX, newY) && sensorStates[newY][newX])) {
		    caught = true;
		}
	    }
	}
	}

	private boolean isValidMove(int newX, int newY) {
	return newX >= 0 && newX < borderLength && 
	       newY >= 0 && newY < borderWidth;
	}

	public boolean isCaught() {
	return caught;
	}

	public boolean hasSucceeded() {
	return succeeded;
	}

	public int getX() { return x; }
	public int getY() { return y; }
}

