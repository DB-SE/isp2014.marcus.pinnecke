package com.pinnecke.isp.featurecalc;

import java.awt.EventQueue;

import com.pinnecke.isp.featurecalc.gui.ApplicationFrame;
import com.pinnecke.isp.featurecalc.gui.Frame;
import com.pinnecke.isp.featurecalc.hotspots.IActionRecorder;
import com.pinnecke.isp.featurecalc.hotspots.IHotspot;
import com.pinnecke.isp.featurecalc.hotspots.IToolWindow;
import com.pinnecke.isp.featurecalc.impl.LogToolWindow;
import com.pinnecke.isp.featurecalc.impl.StackOpCount;
import com.pinnecke.isp.featurecalc.impl.StackOpDivide;
import com.pinnecke.isp.featurecalc.impl.StackOpFold;
import com.pinnecke.isp.featurecalc.impl.StackOpMinus;
import com.pinnecke.isp.featurecalc.impl.StackOpModulo;
import com.pinnecke.isp.featurecalc.impl.StackOpMultiply;
import com.pinnecke.isp.featurecalc.impl.StackOpPlus;
import com.pinnecke.isp.featurecalc.impl.StackOpPop;
import com.pinnecke.isp.featurecalc.impl.StackOpRandomFill;
import com.pinnecke.isp.featurecalc.impl.StackOpReverse;
import com.pinnecke.isp.featurecalc.impl.StackToolWindow;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame frame = new ApplicationFrame();
										
//					int configuration = 1;
//					int configuration = 2;
//					int configuration = 3;
//					int configuration = 4;
					int configuration = 5;
					
					if (configuration == 1) {
						frame.registerPlugIn(new LogToolWindow());
						frame.registerPlugIn(new StackOpPlus());
						frame.registerPlugIn(new StackOpMinus());
					} else if (configuration == 2) {
						frame.registerPlugIn(new StackToolWindow());
						frame.registerPlugIn(new StackOpPop());
						frame.registerPlugIn(new StackOpCount());
					} else if (configuration == 3) {
						frame.registerPlugIn(new StackToolWindow());
						frame.registerPlugIn(new StackOpPop());
						frame.registerPlugIn(new StackOpPlus());
						frame.registerPlugIn(new StackOpMinus());
					} else if (configuration == 4) {
						frame.registerPlugIn(new StackOpPlus());
						frame.registerPlugIn(new StackOpMinus());
						frame.registerPlugIn(new StackOpMultiply());
						frame.registerPlugIn(new StackOpDivide());
						frame.registerPlugIn(new StackOpModulo());
					} else if (configuration == 5) {
						frame.registerPlugIn(new LogToolWindow());
						frame.registerPlugIn(new StackToolWindow());
						frame.registerPlugIn(new StackOpPop());
						frame.registerPlugIn(new StackOpReverse());
						frame.registerPlugIn(new StackOpRandomFill());
						frame.registerPlugIn(new StackOpFold());
						frame.registerPlugIn(new StackOpPlus());
						frame.registerPlugIn(new StackOpMinus());
						frame.registerPlugIn(new StackOpMultiply());
						frame.registerPlugIn(new StackOpDivide());
						frame.registerPlugIn(new StackOpModulo());
						frame.registerPlugIn(new StackOpCount());
					}
	
					frame.loadPlugIns();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
