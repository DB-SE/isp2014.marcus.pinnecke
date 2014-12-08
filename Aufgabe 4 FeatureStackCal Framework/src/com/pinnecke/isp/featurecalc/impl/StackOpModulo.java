package com.pinnecke.isp.featurecalc.impl;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpModulo implements IStackOperation {

	public String getPlugInName() {
		return "Modulo Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return 2;
	}

	public char getSymbol() {
		return '%';
	}

	public float[] performOperation(float[] head) {
		return new float[] { head[1] % head[0]};
	}

	public String getOperationName() {
		return "Modulo";
	}

}
