package ca.utoronto.utm.paint;

import java.awt.Color;

public class ColorSwitcher {
	

	public static void switchMode(String mode , PaintPanel pp) {
		// tell the ColorPanel about what color to set
		pp.getView().getDownpanel().setColorStatus(mode);
		// tell PaintModel a color was changed, ask it to update
		pp.getView().getModel().setColor(mode);
		
		if(mode == "red") {
			pp.setShapecolor(Color.red); 
		} else if(mode == "blue") {
			pp.setShapecolor(Color.blue); 
		} else if (mode == "yellow") {
			pp.setShapecolor(Color.yellow); 
		} else if (mode == "green") {
			pp.setShapecolor(Color.green); 
		} else if (mode == "orange") {
			pp.setShapecolor(Color.orange); 
		} else if (mode == "black") {
			pp.setShapecolor(Color.black);
		}

	}
}
