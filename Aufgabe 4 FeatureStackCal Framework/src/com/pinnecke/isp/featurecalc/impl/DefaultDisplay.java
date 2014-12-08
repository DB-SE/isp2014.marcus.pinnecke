package com.pinnecke.isp.featurecalc.impl;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.pinnecke.isp.featurecalc.hotspots.IDisplay;

public class DefaultDisplay extends JTextField implements IDisplay {
	
	private boolean eraseOldInput = true;	

	public DefaultDisplay() {
		super.setHorizontalAlignment(SwingConstants.RIGHT);
		super.setText("ABC");
		super.setFont(new Font("Courier New", Font.BOLD, 17));
		super.setEditable(false);
	}

	public JComponent render() {
		return this;
	}

	public void onInput(short singleNum) {
		if (eraseOldInput) {
			this.setText("");
			eraseOldInput = false;
		}
		this.setText(this.getText() + singleNum);
	}

	public void onInputComplete(float number) {
		this.setText(String.valueOf(number));
		this.eraseOldInput = true;
	}

	public void onInputComma() {
		this.setText(this.getText() + ".");
	}

	public void onClearCommand() {
		this.setText("0.0");
		eraseOldInput = true;
	}

	public void onFlipSignCommand() {
		String text = this.getText();
		this.setText(text.startsWith("-")? text.substring(1) : "-" + text);
	}

	public void onOperation(char operationSymbol) {
		// TODO Auto-generated method stub
		
	}

	public void onErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	public String getPlugInName() {
		return "Default Display";
	}

	

}
