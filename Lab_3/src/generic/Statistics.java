package generic;

import java.io.PrintWriter;

public class Statistics {
	
	// TODO add your statistics here
	static int numberOfInstructions;
	static int numberOfCycles;
	static float instructionsPerCycle;
	static float cyclePerInstructions;
	

	public static void printStatistics(String statFile)
	{
		try
		{
			PrintWriter writer = new PrintWriter(statFile);
			
			writer.println("Number of instructions executed = " + numberOfInstructions);
			writer.println("Number of cycles taken = " + numberOfCycles);
			writer.println("IPC = " + instructionsPerCycle);
			writer.println("CPI = " + cyclePerInstructions);
			writer.close();
		}
		catch(Exception e)
		{
			Misc.printErrorAndExit(e.getMessage());
		}
	}
	 
	// TODO write functions to update statistics
	public static void setNumberOfInstructions(int numberOfInstructions) {
		Statistics.numberOfInstructions = numberOfInstructions;
	}

	public static void setNumberOfCycles(int numberOfCycles) {
		Statistics.numberOfCycles = numberOfCycles;
	}

	public static int getNumberOfInstructions() {
		return numberOfInstructions;
	}

	public static int getNumberOfCycles() {
		return numberOfCycles;
	}

	public static void setIPC(int numinst, int numcycles) {
		instructionsPerCycle = (float)numinst / (float)numcycles;
	}

	public static void setCPI(int numinst, int numcycles) {
		cyclePerInstructions = (float)numcycles / (float)numinst;
	}

	public static float getIPC() {
		return instructionsPerCycle;
	}

	public static float getCPI() {
		return cyclePerInstructions;
	}
}