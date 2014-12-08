package com.pinnecke.isp.featurecalc.hotspots;

import javax.swing.JComponent;

public interface IDisplay extends IHotspot {
	
	public JComponent render();
	
	public void onInput(short singleNum);
	
	public void onInputComplete(float number);
	
	public void onInputComma();
	
	public void onClearCommand();
	
	public void onFlipSignCommand();
	
	public void onOperation(char operationSymbol);
	
	public void onErrorMessage(String message);

}
