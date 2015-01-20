/*
 * Subtract and branch if less than or equal to zero
 */

public class Subleq implements Instruction {
	
	private int aAddress;
	private int bAddress;
	private int cGotoLabel;
	
	public Subleq(int aAddress, int bAddress, int cGotoLabel) {
		this.aAddress = aAddress;
		this.bAddress = bAddress;
		this.cGotoLabel = cGotoLabel;
	}

	public Subleq(int aAddress, int bAddress) {
		this (aAddress, bAddress, -1);
	}

	/**
	 * Mem[b] = Mem[b] - Mem[a]
	 * if (Mem[b] ≤ 0) goto c
	 */
	public void execute(OiscVM context) {
		
		context.setMemAt(this.bAddress, context.getMemAt(this.bAddress, 0) - context.getMemAt(this.aAddress, 0));
		if (context.getMemAt(this.bAddress,0) == 0 && this.cGotoLabel >= 0)
			context.programCounter = this.cGotoLabel;
		

	}

	public String print() {
		return "SUBLEQ " + aAddress + ", " + bAddress + (cGotoLabel >= 0?  ", " + cGotoLabel : "");
	}

}
