package com.pinnecke.isp.featurecalc.impl;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpReverse implements IStackOperation {

	
	public String getPlugInName() {
		return "Reverse Stack Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return -1;
	}

	public char getSymbol() {
		return '↔';
	}

	public float[] performOperation(float[] head) {
		float[] result = new float[head.length];
		for (int i = 0; i < head.length; i++)
			result[head.length - i - 1] = head[i];
		return result;
	}

	public String getOperationName() {
		return "Reverse";
	}

}
