package pinnecke.featurepaint.features.base.core;

public class Configuration {
	
	public static final int FEATURE_NORMAL_MENUBAR 		= 1;
	public static final int FEATURE_RIBBON_BAR 		= 2;
	public static final int FEATURE_CLASSIC_TOOLBAR	= 4;

	public static final int FEATURE_STATUSBAR		= 8;
	
	public static final int FEATURE_TOOLSWINDOW		= 16;
	
	public static final int FEATURE_EDITING_PEN_TOOL = 32;
	
	public static int configuration = 0;	// this is not good style!
	
	public static void checkConfigurationAndSaveIt(final int config) throws IllegalStateException {
		if (!isActivated(config, FEATURE_NORMAL_MENUBAR) && !isActivated(config, FEATURE_CLASSIC_TOOLBAR) && !isActivated(config, FEATURE_RIBBON_BAR))
			throw new IllegalStateException("Constrain MenuBar is mandatory!");
		if (isActivated(config, FEATURE_RIBBON_BAR) && (isActivated(config, FEATURE_NORMAL_MENUBAR) || (isActivated(config, FEATURE_CLASSIC_TOOLBAR))))
			throw new IllegalStateException("Constrain RibbinBar -> NOT(NormalMenubar OR Toolbar) is violated!");
		if ((isActivated(config, FEATURE_TOOLSWINDOW) && !isActivated(config, FEATURE_EDITING_PEN_TOOL)))
			throw new IllegalStateException("Constrain ToolsWindow -> PenTool is violated!");
		configuration = config;
	}
	
	public static boolean isActivated(final int config, final int feature) {
		return (config & feature) == feature;
	}
	
	public static boolean isActivated(final int feature) {
		return isActivated(configuration, feature);
	}

}
