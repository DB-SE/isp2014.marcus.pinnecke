package com.pinnecke.isp.featurecalc.impl;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpCount implements IStackOperation {

	public String getPlugInName() {
		return "Count Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return -1;
	}

	public char getSymbol() {
		return '#';
	}

	public float[] performOperation(float[] head) {
		float[] result = new float[head.length + 1];
		System.arraycopy(head, 0, result, 0, head.length);
		result[head.length] = head.length;
		return result;
	}

	public String getOperationName() {
		return "Count";
	}

}
