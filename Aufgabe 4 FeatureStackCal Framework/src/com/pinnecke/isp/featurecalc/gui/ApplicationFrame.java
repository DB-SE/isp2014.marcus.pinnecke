package com.pinnecke.isp.featurecalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;

public class ApplicationFrame extends Frame {
	
	public static final int MODE_DECIMAL = 0;
	public static final int MODE_FRACTAL = 1;
	
	private int mode = MODE_DECIMAL;
	private short currentSign = 1;
	private int currentInputDecimal = 0;
	private float currentInputFrac = 0f;
	

	protected void actionPlusMinus() {
		currentSign *= -1;
		super.display.onFlipSignCommand();
	}

	protected void actionComma() {
		if (mode == MODE_DECIMAL) {
			mode = MODE_FRACTAL;
			super.display.onInputComma();
			super.btnComma.setEnabled(false);
		}
	}
	
	private void numInput(short num) {
		if (mode == MODE_DECIMAL) {
			currentInputDecimal = (currentInputDecimal * 10) + num;
			btnComma.setEnabled(true);
		} else {
			currentInputFrac = (currentInputFrac / 10) + num / 10f;
		}
		super.display.onInput((short) num);	
	}

	protected void actionNum0() {
		numInput((short) 0);		
	}

	protected void actionNum3() {
		numInput((short) 3);
	}

	protected void actionNum2() {
		numInput((short) 2);
	}

	protected void actionNum1() {
		numInput((short) 1);
	}

	protected void actionNum6() {
		numInput((short) 6);
	}

	protected void actionNum5() {
		numInput((short) 5);
	}

	protected void actionNum4() {
		numInput((short) 4);
	}

	protected void actionNum9() {
		numInput((short) 9);
	}

	protected void actionNum8() {
		numInput((short) 8);
	}

	protected void actionNum7() {
		numInput((short) 7);	
	}
	
	private void reset() {
		this.mode = MODE_DECIMAL;
		this.currentSign = 1;
		this.currentInputDecimal = 0;
		this.currentInputFrac = 0f;
		super.btnComma.setEnabled(false);
	}

	protected void actionClear() {
		super.display.onClearCommand();
		reset();
	}

	protected void actionInputIsDone() {
		final float finalValue = currentSign * (currentInputDecimal + currentInputFrac);
		super.display.onInputComplete(finalValue);
		this.stack.push(finalValue);
		plugInService.notifyStackObserver(PlugInService.STACK_MODE_PUSH, String.valueOf(finalValue));
		reset();
	}

}
