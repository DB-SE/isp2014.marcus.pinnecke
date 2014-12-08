package com.pinnecke.isp.featurecalc.impl;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpPop implements IStackOperation {

	public String getPlugInName() {
		return "Pop Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return 1;
	}

	public char getSymbol() {
		return '∧';
	}

	public float[] performOperation(float[] head) {
		float[] result = new float[head.length - 1];
		System.arraycopy(head, 0, result, 0, head.length - 1);
		return result;
	}

	public String getOperationName() {
		return "Pop";
	}

}
