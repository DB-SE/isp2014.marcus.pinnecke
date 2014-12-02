package pinnecke.featurepaint.features.base.gui;

import java.awt.Dimension;

import javax.swing.JLabel;

public class Statusbar extends JLabel {

    public Statusbar() {
        super.setPreferredSize(new Dimension(300, 20));
        resetHint();
    }

    public void setHint(String hint) {
        setText(" " + hint);        
    }

	public void resetHint() {
		setHint ("Bereit");
	}        
} 