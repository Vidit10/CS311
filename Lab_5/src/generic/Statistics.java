package generic;

import java.io.PrintWriter;

public class Statistics {

    // TODO add your statistics here
    static int numberOfInstructions;
    static int numberOfCycles;
    private static int freezednumberOfInstructions;
    static float CPI;
    static float IPC;
    //int freezednumberOfInstructions;

    public static void printStatistics(String statFile) {
        try {
            PrintWriter writer = new PrintWriter(statFile);

            writer.println("Number of instructions executed = " + numberOfInstructions);
            writer.println("Number of cycles taken = " + numberOfCycles);
            writer.println("CPI = " + CPI);
            writer.println("IPC = " + IPC);

            // TODO add code here to print statistics in the output file

            writer.close();
        } catch (Exception e) {
            Misc.printErrorAndExit(e.getMessage());
        }
    }

    public static int getNumberOfInstructions() {
        return Statistics.numberOfInstructions;
    }

    // TODO write functions to update statistics
    public static void setNumberOfInstructions(int numberOfInstructions) {
        Statistics.numberOfInstructions = numberOfInstructions;
    }

    public static int getNumberOfCycles() {
        return Statistics.numberOfCycles;
    }

    public static void setNumberOfCycles(int numberOfCycles) {
        Statistics.numberOfCycles = numberOfCycles;
    }

    public static int getFreezednumberOfInstructions() {
        return freezednumberOfInstructions;
    }

    public static void setFreezednumberOfInstructions(int freezednumberOfInstructions) {
        Statistics.freezednumberOfInstructions = freezednumberOfInstructions;
    }
    public void setCPI() {
        Statistics.CPI = (float) numberOfCycles / (float) numberOfInstructions;
    }

    public void setIPC() {
        Statistics.IPC = (float) numberOfInstructions / (float) numberOfCycles;
    }
}