package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;

/**
 * The modeSwitcher is only used to switch mode for the actionPerformed in ShapeChooserPanel.
 *	Given a string of the mode, switch the mode in PaintPanel.
 */
public class ModeSwitcher {
	
	public static void switchMode(String mode , PaintPanel pp) {
		// this code is used to tell polyline finish drawing
		pp.setBefore(null);
		// tell the StatusPanel the mode is changed
		pp.getView().getDownpanel().setModeStatus(mode);
		// ask the PaintModel to update
		pp.getView().getModel().setMode(mode);
		
		if(mode == "Circle") {
			pp.setMode(new CircleStrategy(pp));
			pp.setFill(false);
		} else if(mode == "Rectangle") {
			pp.setMode(new RectangleStrategy(pp)); 
			pp.setFill(false);
		} else if (mode == "Square") {
			pp.setMode(new SquareStrategy(pp));
			pp.setFill(false);
		} else if (mode == "Squiggle") {
			pp.setMode(new SquiggleStrategy(pp));
		} else if (mode == "Eraser") {
			pp.setMode(new EraserStrategy(pp));
		} else if(mode == "Polyline") {
			pp.setMode(new PolylineStrategy(pp)); 
		}
		if(mode == "FillCircle") {
			pp.setMode(new CircleStrategy(pp)); 
			pp.setFill(true);
		}else if(mode == "FillRectangle") {
			pp.setMode(new RectangleStrategy(pp)); 
			pp.setFill(true);
		}else if(mode == "FillSquare") {
			pp.setMode(new SquareStrategy(pp));
			pp.setFill(true);
		}
		
	}
}
