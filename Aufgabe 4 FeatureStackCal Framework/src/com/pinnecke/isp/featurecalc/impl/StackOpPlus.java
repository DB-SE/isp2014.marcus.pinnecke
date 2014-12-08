package com.pinnecke.isp.featurecalc.impl;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpPlus implements IStackOperation {

	public String getPlugInName() {
		return "Plus Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return 2;
	}

	public char getSymbol() {
		return '+';
	}

	public float[] performOperation(float[] head) {
		return new float[] { head[0] + head[1]};
	}

	public String getOperationName() {
		return "Plus";
	}

}
