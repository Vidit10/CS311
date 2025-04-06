package generic;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import processor.Clock;
import processor.Processor;

public class Simulator {
		
	static Processor processor;
	static boolean simulationComplete;
	
	public static void setupSimulation(String assemblyProgramFile, Processor p)
	{
		Simulator.processor = p;
		loadProgram(assemblyProgramFile);
		
		simulationComplete = false;
	}
	
	static void loadProgram(String assemblyProgramFile)
	{
		/*
		 * TOD0
		 * 1. load the program into memory according to the program layout described
		 *    in the ISA specification
		 * 2. set PC to the address of the first instruction in the main
		 * 3. set the following registers:
		 *     x0 = 0
		 *     x1 = 65535
		 *     x2 = 65535
		 */

		InputStream programInputStream=null;
		try{
			programInputStream= new FileInputStream(assemblyProgramFile);
			DataInputStream dataInputStream = new DataInputStream(programInputStream);
			int next=0;
			if(dataInputStream.available()>0){
				next = dataInputStream.readInt();
				processor.getRegisterFile().setProgramCounter(next);
			} 
			for(int address=0;dataInputStream.available()>0;address++){
				next=dataInputStream.readInt();
				processor.getMainMemory().setWord(address, next);
			}
			processor.getRegisterFile().setValue(0, 0);
			processor.getRegisterFile().setValue(1,65535);
			processor.getRegisterFile().setValue(2, 65535);

			dataInputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	
	public static void simulate()
	{
		int instructionCount = 0;
		int cycleCount = 0;
		while(simulationComplete == false)
		{
			processor.getIFUnit().performIF();
			Clock.incrementClock();
			processor.getOFUnit().performOF();
			Clock.incrementClock();
			processor.getEXUnit().performEX();
			Clock.incrementClock();
			processor.getMAUnit().performMA();
			Clock.incrementClock();
			processor.getRWUnit().performRW();
			Clock.incrementClock();
			instructionCount++;
			cycleCount++;
		}
		
		// TOD0
		Statistics.setNumberOfInstructions(instructionCount);
		Statistics.setNumberOfCycles(cycleCount);
		Statistics.setCPI(instructionCount, cycleCount);
		Statistics.setIPC(instructionCount, cycleCount);
	}
	
	public static void setSimulationComplete(boolean value)
	{
		simulationComplete = value;
	}
}