package com.pinnecke.isp.featurecalc.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.pinnecke.isp.featurecalc.hotspots.IStackOperation;

public class OptionButton extends JButton {

	private JPopupMenu popup;
	private JMenuItem pushCmd;
	private Frame parent;
	
	private void buildPushActionMenu(final Frame parent) {
	
		popup = new JPopupMenu();
		popup.setFont(popup.getFont().deriveFont(Font.BOLD));
		pushCmd = new JMenuItem(new AbstractAction("∨\t\tPush") {
			public void actionPerformed(ActionEvent e) {
				parent.actionInputIsDone();
				parent.btnPlusMinus.setEnabled(false);
				parent.updateTop();
				parent.display.onInputComplete(0.0f);
			}
		});
		popup.add(pushCmd);
		popup.addSeparator();

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public OptionButton(final Frame parent, final String label) {
		super(label);
		this.parent = parent;
		buildPushActionMenu(parent);
	}
	
	public void setPushButtonEnabled(boolean b) {
		pushCmd.setEnabled(b);
	}
	
	private PlugInService plugInService;

	public void loadPlugIns(final PlugInService plugInService) {
		this.plugInService = plugInService;
		
		List<Object> pluginList = plugInService.getPlugIns(IStackOperation.class);
		if (pluginList == null || pluginList.isEmpty()) {
			JMenuItem noPlugInInfo = new JMenuItem(
					"No further operations available");
			noPlugInInfo.setEnabled(false);
			popup.add(noPlugInInfo);
		} else {
			for (int i = 0; i < pluginList.size(); i++) {
				final IStackOperation op = (IStackOperation) pluginList.get(i);
				JMenuItem command = new JMenuItem(new AbstractAction(op.getSymbol() + "\t\t" + op.getOperationName()) {
					public void actionPerformed(ActionEvent e) {
						plugInService.performStackOperation(op);
					}
				});
				command.setEnabled(op.getRequiredHeadSize() == 0 ? true : (op.getRequiredHeadSize() == -1 && maximumStackSize == 0 ? false : op.getRequiredHeadSize() <= maximumStackSize));
				popup.add(command);
			}
		}
	}
	
	private int maximumStackSize = Integer.MIN_VALUE;

	public void stackSizeChanged(int i) {
		this.maximumStackSize = i;
		remove(popup);
		buildPushActionMenu(parent);
		loadPlugIns(this.plugInService);
	}

}
