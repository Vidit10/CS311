package processor.pipeline;

public class EX_IF_LatchType {

	boolean IS_enable;
	int PC;
	
	public EX_IF_LatchType()
	{
		IS_enable = false;
	}

	public boolean getIF_Enable() {
		return IS_enable;
	}

	public void setIF_Enable(boolean iS_enable, int newPC) {
		IS_enable = iS_enable;
		PC = newPC;
	}

	public void setIF_Enable(boolean iS_enable) {
		IS_enable = iS_enable;
	}

	public int getPC() {
		return PC;
	}

}