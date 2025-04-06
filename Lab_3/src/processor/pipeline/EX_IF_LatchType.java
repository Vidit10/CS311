package processor.pipeline;

public class EX_IF_LatchType {

	boolean IsBranch_enable;
	int PC;

	// Constructor
	public EX_IF_LatchType() {
		IsBranch_enable = false;
		PC = 0;	// default value
	}

	public EX_IF_LatchType(boolean isBranch_enable) {
		IsBranch_enable = isBranch_enable;
	}

	public EX_IF_LatchType(boolean isBranch_enable, int pC) {
		IsBranch_enable = isBranch_enable;
		PC = pC;
	}

	// Enable
	public boolean getIsBranch_enable() {
		return IsBranch_enable;
	}

	public void setIsBranch_enable(boolean isBranch_enable) {
		this.IsBranch_enable = isBranch_enable;
	}

	public void setIsBranch_enable(boolean isBranch_enable, int pC) {
		IsBranch_enable = isBranch_enable;
		this.PC = pC;
	}

	public int getPC() {
		return PC;
	}

	public void setPC(int pC) {
		PC = pC;
	}
}