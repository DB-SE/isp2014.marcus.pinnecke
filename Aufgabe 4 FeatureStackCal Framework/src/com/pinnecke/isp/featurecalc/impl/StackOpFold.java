package com.pinnecke.isp.featurecalc.impl;

import javax.swing.JOptionPane;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class StackOpFold implements IStackOperation {

	public String getPlugInName() {
		return "Fold Stack Operation Plug-In";
	}

	public int getRequiredHeadSize() {
		return -1;
	}

	public char getSymbol() {
		return '⊻';
	}

	public float[] performOperation(float[] head) {
		int choice = JOptionPane.showOptionDialog(null,
				"Do you want to fold with addition or subtraction?",
				"Choose a function to apply", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new Object[] {
						"Use addition", "Use substraction" }, "Use addition");

		float[] result = new float[1];
		result[0] = 0;
		for (int i = 0; i < head.length; i++)
			result[0] = choice == 0 ? (result[0] += head[i])
					: (result[0] -= head[i]);
		return result;
	}

	public String getOperationName() {
		return "Fold";
	}

}
