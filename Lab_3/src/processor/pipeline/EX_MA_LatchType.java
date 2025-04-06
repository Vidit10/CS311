package processor.pipeline;

import generic.Instruction;

public class EX_MA_LatchType {

	boolean MA_enable;
	Instruction instruction;
	int aluResult;

	// Constructor
	public EX_MA_LatchType() {
		MA_enable = false;
		aluResult = 0;
	}

	public EX_MA_LatchType(boolean mA_enable) {
		MA_enable = mA_enable;
	}

	public EX_MA_LatchType(boolean mA_enable, int aLuResult) // for load
	{
		MA_enable = mA_enable;
		this.aluResult = aLuResult;
	}

	public EX_MA_LatchType(boolean mA_enable, int aLuResult, Instruction instructions) // for store
	{
		MA_enable = mA_enable;
		this.aluResult = aLuResult;
		this.instruction = instructions;
	}

	// enable
	public boolean isMA_enable() {
		return MA_enable;
	}

	public void setMA_enable(boolean mA_enable) {
		MA_enable = mA_enable;
	}

	// aluResult
	public int getaluResult() {
		return aluResult;
	}

	public void setaluResult(int aLuResult) {
		aluResult = aLuResult;
	}

	// instruction
	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instructions) {
		instruction = instructions;
	}
}