package assignment_0;

public class SimulationAnalysis {
    private static final int BORDER_LENGTH = 1000;
    private static final int MAX_TIME = 100000; // Maximum simulation time to prevent infinite loops
    
    public static class SimulationResult {
        public final double probability;
        public final int width;
        public final int time;
        public final boolean succeeded;
        
        public SimulationResult(double p, int w, int t, boolean s) {
            probability = p;
            width = w;
            time = t;
            succeeded = s;
        }
        
        @Override
        public String toString() {
            return String.format("%.2f,%d,%d,%b", probability, width, time, succeeded);
        }
    }
    
    public static SimulationResult runSimulation(double probability, int width) {
        clock.reset();
        sensor sensors = new sensor(width, BORDER_LENGTH, probability);
        infiltrator Infiltrator = new infiltrator(width, BORDER_LENGTH);
        
        while (!Infiltrator.isCaught() && !Infiltrator.hasSucceeded() && clock.getCurrentTime() < MAX_TIME) {
            sensors.updateSensors();
            Infiltrator.move(sensors.getSensorStates());
            clock.increment();
        }
        
        return new SimulationResult(
            probability,
            width,
            clock.getCurrentTime(),
            Infiltrator.hasSucceeded()
        );
    }
    
    public static void main(String[] args) {
        // Create output file header
        System.out.println("probability,width,time,succeeded");
        
        // Test different combinations of p and W
        double[] probabilities = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
        int[] widths = {2, 4, 6, 8, 10, 12, 14, 16};
        
        // Run multiple trials for each combination
        int trials = 10;
        for (double p : probabilities) {
            for (int w : widths) {
                for (int trial = 0; trial < trials; trial++) {
                    SimulationResult result = runSimulation(p, w);
                    System.out.println(result.toString());
                }
            }
        }
    }
}
