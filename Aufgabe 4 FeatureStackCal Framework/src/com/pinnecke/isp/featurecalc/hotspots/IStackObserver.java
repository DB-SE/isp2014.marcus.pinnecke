package com.pinnecke.isp.featurecalc.hotspots;

public interface IStackObserver {
	
	public void onPush(String f);
	public void onPop(String f);

}
