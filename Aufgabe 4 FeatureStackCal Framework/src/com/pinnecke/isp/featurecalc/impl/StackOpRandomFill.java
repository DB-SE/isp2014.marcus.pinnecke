package com.pinnecke.isp.featurecalc.impl;

import java.util.Random;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpRandomFill implements IStackOperation {

	public String getPlugInName() {
		return "Random Fill Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return 0;
	}

	public char getSymbol() {
		return '•';
	}

	public float[] performOperation(float[] head) {
		Random r = new Random();
		float[] result = new float[r.nextInt(100)];
		for (int i = 0; i < result.length; i++)
			result[i] = r.nextFloat() * r.nextInt(100);
		return result;
	}

	public String getOperationName() {
		return "Random Fill";
	}

}
