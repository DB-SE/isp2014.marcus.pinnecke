package com.pinnecke.isp.featurecalc.impl;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.pinnecke.isp.featurecalc.hotspots.IStackObserver;
import com.pinnecke.isp.featurecalc.hotspots.IToolWindow;

public class StackToolWindow extends JFrame implements IToolWindow,
		IStackObserver {
	
	private Stack<String> stackClone = new Stack<String>();
	private JTextArea textField = new JTextArea();

	public StackToolWindow() {
		super("Stack");
		super.setType(Type.UTILITY);
		super.setResizable(false);
		textField.setPreferredSize(new Dimension(60, 400));
		textField.setEditable(false);
		textField.setBackground(SystemColor.window);
		textField.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(textField);
		this.pack();
		printStack();
	}
	
	private void printStack() {
		String text = "⊥";
		for(int i = 0; i < stackClone.size(); i++)
			text = stackClone.get(i) + "\n" + text;
		textField.setText(text);
	}
	
	public void onPush(String f) {
		stackClone.push(f);
		printStack();
	}

	public void onPop(String f) {
		stackClone.pop();
		printStack();
	}

	public JFrame getWindow() {
		return this;
	}
	
	public String getPlugInName() {
		return "Stack tool window";
	}

}
