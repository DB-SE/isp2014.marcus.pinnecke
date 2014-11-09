package pinnecke.featurepaint.features.base.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RibbonBar extends JPanel{
	
	public RibbonBar() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent panel1 = new JLabel("Ribbonbar Tab 1");
		panel1.setPreferredSize(new Dimension(800, 50));
		
		tabbedPane.addTab("File", panel1);

		JComponent panel2 = new JLabel("Ribbonbar Tab 2");
		tabbedPane.addTab("Drawing", panel2);
		
		add(tabbedPane, BorderLayout.NORTH);
	}

}
