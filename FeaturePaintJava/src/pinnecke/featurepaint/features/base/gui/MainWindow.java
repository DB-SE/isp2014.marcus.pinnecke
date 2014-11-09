package pinnecke.featurepaint.features.base.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import pinnecke.featurepaint.features.base.core.Configuration;
import pinnecke.featurepaint.features.base.core.StringTable;

public class MainWindow extends JFrame {

	private FeaturePaintCanvas featurePaintCanvas;
	private Statusbar statusbar;

	public MainWindow(final int featurePaintFlags) {
		// Mandatory features
		setupWindow();
		setupCanvas();

		setupMenubar(featurePaintFlags);
		setupStatusBar(featurePaintFlags);
		setupToolsWindow(featurePaintFlags);

		setupFinishTouches();
	}

	private void setupFinishTouches() {
		super.pack();
		super.setVisible(true);
	}

	private void setupWindow() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle(StringTable.MAIN_TITLE);

	}

	private void setupToolsWindow(int featurePaintFlags) {
		if (Configuration.isActivated(Configuration.FEATURE_TOOLSWINDOW)) {
			add(new ToolsWindow(statusbar), BorderLayout.WEST);
		}
	}

	private void setupStatusBar(int featurePaintFlags) {
		if (Configuration.isActivated(Configuration.FEATURE_STATUSBAR)) {
			statusbar = new Statusbar();
			add(statusbar, BorderLayout.SOUTH);
		}
	}

	private void setupMenubar(int featurePaintFlags) {
		if (Configuration.isActivated(Configuration.FEATURE_RIBBON_BAR))
			add(new RibbonBar(), BorderLayout.NORTH);
		else {
			setJMenuBar(new DefaultMenubar());

			if (Configuration
					.isActivated(Configuration.FEATURE_CLASSIC_TOOLBAR)) {
				add(new ClassicToolBar(), BorderLayout.NORTH);
			}
		}
	}

	private void setupCanvas() {
		featurePaintCanvas = new FeaturePaintCanvas();
		JPanel workspacePanel = new JPanel();
		workspacePanel.setBackground(SystemColor.controlShadow);
		workspacePanel.setPreferredSize(featurePaintCanvas.getImageDimension());
		workspacePanel.add(featurePaintCanvas);
		JScrollPane scrollFrame = new JScrollPane(workspacePanel);
		workspacePanel.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension(800, 300));
		this.add(scrollFrame);
	}

}
