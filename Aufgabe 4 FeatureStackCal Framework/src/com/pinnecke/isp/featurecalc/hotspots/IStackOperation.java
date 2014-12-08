package com.pinnecke.isp.featurecalc.hotspots;

public interface IStackOperation extends IHotspot {

	/**
	 * Or -1 if the entire stack is needed
	 * @return
	 */
	public int getRequiredHeadSize();
	public char getSymbol();
	
	/**
	 * The last index of <b>head</b> is the top (the freshest element) of the stack, the index 0 is the oldest element 
	 * @param head
	 * @return
	 */
	public float[] performOperation(float[] head);
	public String getOperationName();
}
