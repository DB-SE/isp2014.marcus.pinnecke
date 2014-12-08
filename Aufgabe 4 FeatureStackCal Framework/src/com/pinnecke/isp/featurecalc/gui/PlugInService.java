package com.pinnecke.isp.featurecalc.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.pinnecke.isp.featurecalc.hotspots.IActionRecorder;
import com.pinnecke.isp.featurecalc.hotspots.IHotspot;
import com.pinnecke.isp.featurecalc.hotspots.IStackObserver;
import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;
import com.pinnecke.isp.featurecalc.hotspots.IToolWindow;

public class PlugInService {

	private Map<Class<?>, List<Object>> plugIns = new HashMap<Class<?>, List<Object>>();

	public void register(final Class<?> clazz, final Object o) {
		if (!plugIns.containsKey(clazz))
			plugIns.put(clazz, new ArrayList<Object>());
		plugIns.get(clazz).add(o);
	}

	public List<Object> getPlugIns(final Class<?> clazz) {
		return plugIns.containsKey(clazz) ? plugIns.get(clazz) : new ArrayList<Object>();
	}

	public static final int STACK_MODE_PUSH = 0;
	public static final int STACK_MODE_POP = 1;
	private Frame context;
	
	public PlugInService(Frame context) {
		this.context = context;
	}

	public void notifyStackObserver(int mode, String value) {
		for (Iterator<Object> it = getPlugIns(IStackObserver.class).iterator(); it
				.hasNext();) {
			Object o = it.next();
			try {
				IStackObserver so = (IStackObserver) o;
				if (mode == STACK_MODE_PUSH)
					so.onPush(value);
				else
					so.onPop(value);
			} catch (Throwable t) {
				showMessageBox(t.toString(), o);
			}
		}
	}

	private void showMessageBox(String message, Object o) {
		IHotspot hotspotImpl = (IHotspot) o;
		JOptionPane
				.showMessageDialog(
						null,
						"There are two news. The bad one is an error occurred while \n"
						+ "callig a plug-in method. The good one is sit back and relax. \n"
						+ "Nothing can happen, because this application is incredibly \n"
						+ "safe.\n\n\nMessage: "
								+ message
								+ "\n\nCaused by: \""
								+ hotspotImpl.getPlugInName() + "\".",
						"Failed to handle request.", JOptionPane.ERROR_MESSAGE);
	}

	public void propageToActionRecorders(String message) {
		for (Iterator<Object> it = getPlugIns(IActionRecorder.class).iterator(); it
				.hasNext();) {
			Object o = it.next();
			try {
				((IActionRecorder) o).onAction(message);
			} catch (Throwable t) {
				showMessageBox(t.getMessage(), o);
			}
		}
	}

	public void openToolWindows() {
		for (Iterator<Object> it = getPlugIns(IToolWindow.class).iterator(); it
				.hasNext();) {
			Object o = it.next();
			try {
				((IToolWindow) o).getWindow().setVisible(true);
			} catch (Throwable t) {
				showMessageBox(t.getMessage(), o);
			}
		}
	}

	public void performStackOperation(IStackOperation op) {
		int size = op.getRequiredHeadSize();
		int popcount = size == -1 ? context.stack.size() : size;
		float[] head = new float[popcount];
		for(int i = 1; i <= popcount; i++) {
			head[popcount - i] = context.stack.pop();
			notifyStackObserver(PlugInService.STACK_MODE_POP, String.valueOf(head[popcount - i]));
		}
		try {
			float[] result = op.performOperation(head);
			for (int i = 0; i < result.length; i++) {
				context.stack.push(result[i]);
				notifyStackObserver(PlugInService.STACK_MODE_PUSH, String.valueOf(result[i]));
			}
			String top = (context.stack.isEmpty() && result.length == 0)? "⊥" : String.valueOf(context.stack.peek()); 
			context.updateTop(top);
		} catch (Throwable t) {
			for (int i = 0; i < head.length; i++) {
				context.stack.push(head[i]);
				notifyStackObserver(PlugInService.STACK_MODE_PUSH, String.valueOf(head[i]));
			}
			showMessageBox(t.getMessage() + " (the stack content is unchanged)", op);
		}
	}

}
