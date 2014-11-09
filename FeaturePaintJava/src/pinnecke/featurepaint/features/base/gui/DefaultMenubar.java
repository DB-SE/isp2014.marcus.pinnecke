package pinnecke.featurepaint.features.base.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pinnecke.featurepaint.features.base.core.StringTable;

public class DefaultMenubar extends JMenuBar {
	
	public DefaultMenubar() {
		JMenu file = new JMenu(StringTable.MENU_FILE);
		JMenuItem itemNew = new JMenuItem(StringTable.MENU_NEW);
		JMenuItem itemOpen = new JMenuItem(StringTable.MENU_OPEN);
		JMenuItem itemSave = new JMenuItem(StringTable.MENU_SAVE);
		file.add(itemNew);
		file.add(itemOpen);
		file.add(itemSave);
		
		JMenu edit = new JMenu(StringTable.MENU_EDIT);
		edit.setEnabled(false);
		
		JMenu image = new JMenu(StringTable.MENU_IMAGE);
		image.setEnabled(false);
		
		JMenu layer = new JMenu(StringTable.MENU_LAYER);
		layer.setEnabled(false);
		
		JMenu effects = new JMenu(StringTable.MENU_EFFECTS);
		effects.setEnabled(false);
		
		JMenu help = new JMenu(StringTable.MENU_HELP);
		help.setEnabled(false);
		
		this.add(file);
		this.add(edit);
		this.add(image);
		this.add(layer);
		this.add(effects);
		this.add(help);
	}

}
