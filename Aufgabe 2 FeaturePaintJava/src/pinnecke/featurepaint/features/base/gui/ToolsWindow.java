package pinnecke.featurepaint.features.base.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import pinnecke.featurepaint.features.base.core.Configuration;

public class ToolsWindow extends JToolBar {
	
	public ToolsWindow (Statusbar statusbar) {
		super(JToolBar.VERTICAL);
		
		// icons taken from http://visionwidget.com/
		
	    JButton pen = new JButton(new ImageIcon(this.getClass().getResource("/pen.png")));
	    HintableButton circle = new HintableButton(statusbar, new ImageIcon(this.getClass().getResource("/circle.png")), "Fancy drawing with pen tool.");
	    HintableButton rect = new HintableButton(statusbar, new ImageIcon(this.getClass().getResource("/rect.png")), "Draws rectangles in different sizes.");
	    HintableButton rubber = new HintableButton(statusbar, new ImageIcon(this.getClass().getResource("/rubber.png")), "Removes everything it touches.");
	    HintableButton text = new HintableButton(statusbar, new ImageIcon(this.getClass().getResource("/text.png")), "Write nice text.");
	    
	    circle.setEnabled(false);
	    rect.setEnabled(false);
	    rubber.setEnabled(false);
	    text.setEnabled(false);

	    if (Configuration.isActivated(Configuration.FEATURE_EDITING_PEN_TOOL)) {
	    	super.add(pen);
	    }
	    
	    super.add(circle);
	    super.add(rect);
	    super.add(rubber);
	    super.add(text);
	    

	}

}
