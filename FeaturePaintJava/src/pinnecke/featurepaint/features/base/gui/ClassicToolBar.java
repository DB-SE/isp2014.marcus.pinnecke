package pinnecke.featurepaint.features.base.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ClassicToolBar extends JToolBar {

	public ClassicToolBar() {

		JButton newButton = new JButton("Neu");
		JButton openButton = new JButton("Öffnen");
		JButton saveButton = new JButton("Speichern");
		JButton printButton = new JButton("Drucken");

		newButton.setEnabled(false);
		openButton.setEnabled(false);
		saveButton.setEnabled(false);
		printButton.setEnabled(false);

		super.add(printButton);
		super.add(openButton);
		super.add(openButton);
		super.add(printButton);
	}

}
