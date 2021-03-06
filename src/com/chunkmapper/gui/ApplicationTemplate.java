package com.chunkmapper.gui;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.StereoOptionSceneController;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.ViewInputAttributes;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.event.RenderingExceptionListener;
import gov.nasa.worldwind.event.SelectEvent;
import gov.nasa.worldwind.event.SelectListener;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.placename.PlaceNameLayer;
import gov.nasa.worldwind.util.StatisticsPanel;
import gov.nasa.worldwind.util.StatusBar;
import gov.nasa.worldwind.util.WWUtil;
import gov.nasa.worldwindx.examples.layermanager.LayerPanel;
import gov.nasa.worldwindx.examples.util.HighlightController;
import gov.nasa.worldwindx.examples.util.ToolTipController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.chunkmapper.admin.FeedbackManager;
import com.chunkmapper.admin.GlobalSettings;
import com.chunkmapper.admin.MyLogger;
import com.chunkmapper.admin.PreferenceManager;
import com.chunkmapper.gui.dialog.FeedbackDialog;
import com.chunkmapper.gui.layer.ViewControlsLayer;
import com.chunkmapper.gui.layer.ViewControlsSelectListener;
import com.chunkmapper.security.MySecurityManager;

/**
 * Provides a base application framework for simple WorldWind examples. Examine other examples in this package to see
 * how it's used.
 *
 * @version $Id: ApplicationTemplate.java 1171 2013-02-11 21:45:02Z dcollins $
 */
public class ApplicationTemplate
{
	public static class AppPanel extends JPanel
	{
		protected WorldWindow wwd;
		protected StatusBar statusBar;
		protected ToolTipController toolTipController;
		protected HighlightController highlightController;

		public AppPanel(Dimension canvasSize, boolean includeStatusBar)
		{
			super(new BorderLayout());

			this.wwd = this.createWorldWindow();

			((Component) this.wwd).setPreferredSize(canvasSize);

			// Create the default model as described in the current worldwind properties.
			Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
			this.wwd.setModel(m);


			this.add((Component) this.wwd, BorderLayout.CENTER);
			if (includeStatusBar)
			{
				this.statusBar = new StatusBar();
				this.add(statusBar, BorderLayout.PAGE_END);
				this.statusBar.setEventSource(wwd);
			}

			// Add controllers to manage highlighting and tool tips.
			this.toolTipController = new ToolTipController(this.getWwd(), AVKey.DISPLAY_NAME, null);
			this.highlightController = new HighlightController(this.getWwd(), SelectEvent.ROLLOVER);

			//remove go to on click
			ViewInputAttributes attrs = wwd.getView().getViewInputHandler().getAttributes();         
			attrs.getActionMap(ViewInputAttributes.DEVICE_MOUSE)
			.getActionAttributes(ViewInputAttributes.VIEW_MOVE_TO)
			.setMouseActionListener(null);
		}

		protected WorldWindow createWorldWindow()
		{
			return new WorldWindowGLCanvas();
		}

		public WorldWindow getWwd()
		{
			return wwd;
		}

		public StatusBar getStatusBar()
		{
			return statusBar;
		}
	}

	protected static class AppFrame extends JFrame
	{
		protected GlobalSettings globalSettings = new GlobalSettings();
		private Dimension canvasSize = new Dimension(800, 600);

		protected AppPanel wwjPanel;
		protected LayerPanel layerPanel;
		protected StatisticsPanel statsPanel;
		private boolean simpleGuiShown;

		public AppFrame()
		{
			this.initialize(true, true, false);
		}

		public AppFrame(Dimension size)
		{
			this.canvasSize = size;
			this.initialize(true, true, false);
		}

		public AppFrame(boolean includeStatusBar, boolean includeLayerPanel, boolean includeStatsPanel)
		{
			this.initialize(includeStatusBar, includeLayerPanel, includeStatsPanel);
		}

		protected void initialize(boolean includeStatusBar, boolean includeLayerPanel, boolean includeStatsPanel)
		{
			System.out.println("hi");
			// Create the WorldWindow.
			this.wwjPanel = this.createAppPanel(this.canvasSize, includeStatusBar);
			this.wwjPanel.setPreferredSize(canvasSize);

			// Put the pieces together.
			this.getContentPane().add(wwjPanel, BorderLayout.CENTER);
			if (includeLayerPanel)
			{
				this.layerPanel = new LayerPanel(this.wwjPanel.getWwd(), null);
				this.getContentPane().add(this.layerPanel, BorderLayout.WEST);
			}

			if (includeStatsPanel || System.getProperty("gov.nasa.worldwind.showStatistics") != null)
			{
				this.statsPanel = new StatisticsPanel(this.wwjPanel.getWwd(), new Dimension(250, canvasSize.height));
				this.getContentPane().add(this.statsPanel, BorderLayout.EAST);
			}

			// Create and install the view controls layer and register a controller for it with the World Window.
			ViewControlsLayer viewControlsLayer = new ViewControlsLayer();
			insertBeforeCompass(getWwd(), viewControlsLayer);
			this.getWwd().addSelectListener(new ViewControlsSelectListener(this.getWwd(), viewControlsLayer, this, globalSettings));
			//now add a CursorCorrector
			
			// Register a rendering exception listener that's notified when exceptions occur during rendering.
			this.wwjPanel.getWwd().addRenderingExceptionListener(new RenderingExceptionListener()
			{
				public void exceptionThrown(Throwable t)
				{
					MyLogger.LOGGER.severe("Rendering Exception Thrown");
					MyLogger.LOGGER.severe(MyLogger.printException(t));
					if (!simpleGuiShown) {
						simpleGuiShown = true;	
						dispose();
						com.chunkmapper.gui.simple.SimplifiedGUI.open();
					}
				}
			});

			// Search the layer list for layers that are also select listeners and register them with the World
			// Window. This enables interactive layers to be included without specific knowledge of them here.
			for (Layer layer : this.wwjPanel.getWwd().getModel().getLayers())
			{
				if (layer instanceof SelectListener)
				{
					this.getWwd().addSelectListener((SelectListener) layer);
				}
			}

			this.pack();

			// Center the application on the screen.
			WWUtil.alignComponent(null, this, AVKey.CENTER);
			this.setResizable(true);
		}

		protected AppPanel createAppPanel(Dimension canvasSize, boolean includeStatusBar)
		{
			return new AppPanel(canvasSize, includeStatusBar);
		}

		public Dimension getCanvasSize()
		{
			return canvasSize;
		}

		public AppPanel getWwjPanel()
		{
			return wwjPanel;
		}

		public WorldWindow getWwd()
		{
			return this.wwjPanel.getWwd();
		}

		public StatusBar getStatusBar()
		{
			return this.wwjPanel.getStatusBar();
		}

		public LayerPanel getLayerPanel()
		{
			return layerPanel;
		}

		public StatisticsPanel getStatsPanel()
		{
			return statsPanel;
		}

		public void setToolTipController(ToolTipController controller)
		{
			if (this.wwjPanel.toolTipController != null)
				this.wwjPanel.toolTipController.dispose();

			this.wwjPanel.toolTipController = controller;
		}

		public void setHighlightController(HighlightController controller)
		{
			if (this.wwjPanel.highlightController != null)
				this.wwjPanel.highlightController.dispose();

			this.wwjPanel.highlightController = controller;
		}
	}

	public static void insertBeforeCompass(WorldWindow wwd, Layer layer)
	{
		// Insert the layer into the layer list just before the compass.
		int compassPosition = 0;
		LayerList layers = wwd.getModel().getLayers();
		for (Layer l : layers)
		{
			if (l instanceof CompassLayer)
				compassPosition = layers.indexOf(l);
		}
		layers.add(compassPosition, layer);
	}

	public static void insertBeforePlacenames(WorldWindow wwd, Layer layer)
	{
		// Insert the layer into the layer list just before the placenames.
		int compassPosition = 0;
		LayerList layers = wwd.getModel().getLayers();
		for (Layer l : layers)
		{
			if (l instanceof PlaceNameLayer)
				compassPosition = layers.indexOf(l);
		}
		layers.add(compassPosition, layer);
	}

	public static void insertAfterPlacenames(WorldWindow wwd, Layer layer)
	{
		// Insert the layer into the layer list just after the placenames.
		int compassPosition = 0;
		LayerList layers = wwd.getModel().getLayers();
		for (Layer l : layers)
		{
			if (l instanceof PlaceNameLayer)
				compassPosition = layers.indexOf(l);
		}
		layers.add(compassPosition + 1, layer);
	}

	public static void insertBeforeLayerName(WorldWindow wwd, Layer layer, String targetName)
	{
		// Insert the layer into the layer list just before the target layer.
		int targetPosition = 0;
		LayerList layers = wwd.getModel().getLayers();
		for (Layer l : layers)
		{
			if (l.getName().indexOf(targetName) != -1)
			{
				targetPosition = layers.indexOf(l);
				break;
			}
		}
		layers.add(targetPosition, layer);
	}

	static
	{
		System.setProperty("java.net.useSystemProxies", "true");
		if (Configuration.isMacOS())
		{
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "World Wind Application");
			System.setProperty("com.apple.mrj.application.growbox.intrudes", "false");
			System.setProperty("apple.awt.brushMetalLook", "true");
		}
		else if (Configuration.isWindowsOS())
		{
			System.setProperty("sun.awt.noerasebackground", "true"); // prevents flashing during window resizing
		}
	}

	public static AppFrame start(String appName, Class appFrameClass)
	{
		if (Configuration.isMacOS() && appName != null)
		{
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", appName);
		}

		try
		{
			final AppFrame frame = new Main.AppFrame();
			//			final AppFrame frame = (AppFrame) appFrameClass.newInstance();
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					//manageFeedback();
				}
			});
			frame.setTitle(appName);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			java.awt.EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					System.out.println("running");
					frame.setVisible(true);
				}
			});

			return frame;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void manageFeedback() {
		boolean purchased = MySecurityManager.isOfflineValid();
		if (purchased && !PreferenceManager.getIgnoreFeedback()) {
			(new FeedbackDialog()).setVisible(true);
//		} else if (!purchased && !PreferenceManager.getNoPurchaseShown()) {
//			NoPurchaseDialog d = new NoPurchaseDialog();
//			d.setVisible(true);
//			if (!d.submitted && PreferenceManager.getAllowUsageReports()) {
//				FeedbackManager.submitFeedback(null);
//			}
		} else if (PreferenceManager.getAllowUsageReports()) {
			FeedbackManager.submitFeedback(null);
		}
	}

	//    public static void main(String[] args)
	//    {
	//        // Call the static start method like this from the main method of your derived class.
	//        // Substitute your application's name for the first argument.
	//        ApplicationTemplate.start("World Wind Application", AppFrame.class);
	//    }
}
