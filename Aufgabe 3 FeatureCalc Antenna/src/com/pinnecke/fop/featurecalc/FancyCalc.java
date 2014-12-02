package com.pinnecke.fop.featurecalc;

import java.awt.EventQueue;
import java.util.Stack;

public class FancyCalc {

	public static interface Operation {
		public float perform(float left, float right);

		public String toString();
	}

	private Stack<Object> history = new Stack<Object>();

	public void push(float value) {
		if (!history.isEmpty() && !(history.peek() instanceof Operation)) {
			history.push((float)history.pop() * 10 + value);
		} else history.push(value);
	}

	public void push(Operation operation) {
		history.push(operation);
	}

	public void perform() {
		float a = (float) history.pop();
		Operation o = (Operation) history.pop();
		float b = (float) history.pop();
		float result = o.perform(a, b);
		history.push(a);
		history.push(o);
		history.push(b);
		history.push("=");
		history.push(result);
	}

	public String getCurrent() {
		if (!history.isEmpty()) {
			String result = "";
			for (int i = 0; i < history.size(); i++)
				result += history.get(i) + " ";
			return result;
		} else
			return "0";
	}

	public int size() {
		return history.size();
	}

	public void clear() {
		history.clear();
	}

	public boolean lastIsOperation() {
		return history.isEmpty() ? false : history.peek() instanceof Operation;
	}

}
