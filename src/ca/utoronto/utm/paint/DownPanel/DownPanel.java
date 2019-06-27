package ca.utoronto.utm.paint.DownPanel;

import java.awt.Component;

import javax.swing.JPanel;

import ca.utoronto.utm.paint.View;

/**
 * This class is a large JPanel that contains all status information
 * which are shown on the bottom of the program.
 * 
 * All information are implement using JPanels. User will be able to
 * see the information on modeStatus and colorStatus.
 */
public class DownPanel extends JPanel {
	
	private View view;
	private StatusPanel modeStatus;
	private ColorPanel colorStatus;
	private ThicknessPanel thicknessStatus;
	public DownPanel(View view) {
		this.view = view;
		// Initializing the statusPanel
		this.modeStatus = new StatusPanel();
		this.add(modeStatus);
		this.modeStatus.setStatus("Squiggle");
		// Initializing the ColorPanel
		this.colorStatus = new ColorPanel();
		this.add(colorStatus);
		this.colorStatus.setColor("black");
		// Initializing the ThicknessPanel
		this.thicknessStatus = new ThicknessPanel();
		this.add(thicknessStatus);
		this.thicknessStatus.setThickness(3);
	}
	public StatusPanel getModeStatus() {
		return modeStatus;
	}
	public void setModeStatus(String modeStatus) {
		this.modeStatus.setStatus(modeStatus); 
	}
	public ColorPanel getColorStatus() {
		return colorStatus;
	}
	public void setColorStatus(String colorStatus) {
		this.colorStatus.setColor(colorStatus);
	}
	public ThicknessPanel getThicknessStatus() {
		return thicknessStatus;
	}
	public void setThicknessStatus(int thicknessStatus) {
		this.thicknessStatus.setThickness(thicknessStatus);;
	}
	
	

}
