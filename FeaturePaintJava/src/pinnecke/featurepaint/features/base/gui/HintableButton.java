package pinnecke.featurepaint.features.base.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HintableButton extends JButton {
	
	public HintableButton(final Statusbar statusbar, ImageIcon icon, final String hint) {
		super(icon);
		addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				statusbar.resetHint();
			}
			
			public void mouseEntered(MouseEvent e) {
				statusbar.setHint(hint);
			}
			
		});
	}

}
