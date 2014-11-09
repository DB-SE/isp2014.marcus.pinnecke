package pinnecke.featurepaint.features.base.core;

import pinnecke.featurepaint.features.base.gui.MainWindow;

public class Launcher {
	
	public static void main(String[] args) {
		
		if (args == null || args.length == 0) {
			System.out.println("Usage");
			System.out.println("\t<name> ([imageviewer|mxpaint|mxpaint2k]|[FLAGS])");
			System.out.println("\n\n\tSelect variant imageviewer, mxpaint (old school) or mxpaint2k (fancy modern) or build your own where flags is a list of following options");
			System.out.println("\t\t\tMENUBAR\tDisplays a menubar");
			System.out.println("\t\t\tRIBBONBAR\tDisplays a ribbon bar");
			System.out.println("\t\t\tTOOLBAR\tDisplays a toolbar");
			System.out.println("\t\t\tSTATUSBAR\tDisplays a statusbar");
			System.out.println("\t\t\tTOOLSWINDOW\tDisplays a toolswindow");
			System.out.println("\t\t\tPEN\tEnables editing the image with a pen tool");
			System.out.println("\n\nPlease note:");
			System.out.println("\n\t- Some kind of menubar is mandatory");
			System.out.println("\n\t- Eighter choose ribbons or classic menubar (with optional toolbar) but not both");
			System.out.println("\n\t- When selecting tools window a least one tool must be selected as well.");
			System.exit(0);
		} else {			
		
		final int config = parseConfiguration(args); 	// or final int config = Configuration.FEATURE_NORMAL_MENUBAR | Configuration.FEATURE_STATUSBAR | Configuration.FEATURE_TOOLSWINDOW;
	
		
		try {
			Configuration.checkConfigurationAndSaveIt(config);
			new MainWindow(config);
		} catch (IllegalStateException e) {
			System.out.println("Invalid variant: " + e.getMessage());
		}
		}
		
	}

	private static int parseConfiguration(String[] args) {
		if (args[0].equalsIgnoreCase("imageviewer"))
			return Configuration.FEATURE_NORMAL_MENUBAR;
		else if (args[0].equalsIgnoreCase("mxpaint")) 
			return Configuration.FEATURE_NORMAL_MENUBAR | Configuration.FEATURE_STATUSBAR | Configuration.FEATURE_CLASSIC_TOOLBAR | Configuration.FEATURE_TOOLSWINDOW | Configuration.FEATURE_EDITING_PEN_TOOL;
		else if (args[0].equalsIgnoreCase("mxpaint2k")) 
			return Configuration.FEATURE_STATUSBAR | Configuration.FEATURE_RIBBON_BAR | Configuration.FEATURE_TOOLSWINDOW | Configuration.FEATURE_EDITING_PEN_TOOL;
		else {
			int config = 0;
			for (int i = 0; i < args.length; i++) {
				final String a = args[i];
				if (a.equalsIgnoreCase("MENUBAR"))
					config |= Configuration.FEATURE_NORMAL_MENUBAR;
				else if (a.equalsIgnoreCase("RIBBONBAR"))
					config |= Configuration.FEATURE_RIBBON_BAR;
				else if (a.equalsIgnoreCase("TOOLBAR"))
					config |= Configuration.FEATURE_CLASSIC_TOOLBAR;
				else if (a.equalsIgnoreCase("STATUSBAR"))
					config |= Configuration.FEATURE_STATUSBAR;
				else if (a.equalsIgnoreCase("TOOLSWINDOW"))
					config |= Configuration.FEATURE_TOOLSWINDOW;	
				else if (a.equalsIgnoreCase("PEN"))
					config |= Configuration.FEATURE_EDITING_PEN_TOOL;	
			}
			return config;
		}
	}

}
