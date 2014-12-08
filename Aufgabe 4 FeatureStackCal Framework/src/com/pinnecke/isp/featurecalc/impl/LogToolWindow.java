package com.pinnecke.isp.featurecalc.impl;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pinnecke.isp.featurecalc.hotspots.IActionRecorder;
import com.pinnecke.isp.featurecalc.hotspots.IToolWindow;

public class LogToolWindow extends JFrame implements IActionRecorder, IToolWindow {
	
	JTextArea textField = new JTextArea();
	
	public LogToolWindow() {
		super("Log");
		super.setType(Type.UTILITY);
		textField.setPreferredSize(new Dimension(300, 600));
		textField.setEditable(false);
		this.add(textField);
		this.pack();
	}

	public JFrame getWindow() {
		return this;
	}

	public void onAction(String action) {
		textField.setText(textField.getText() + "\n" + action);
	}
	
	public String getPlugInName() {
		return "Log tool window";
	}

}
