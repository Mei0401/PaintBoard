package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * 
 * Strategy is a class that represent an algorithm of how PaintPanel to create a shape object.
 * Based on different mouse events, the algorithm implement different method.
 *
 */

public interface Strategy {
	
	public void dragging(MouseEvent e);
	public void releasing(MouseEvent e);
	public void pressing(MouseEvent e);
	public void moving(MouseEvent e);
	public void clicking(MouseEvent e);
	
}
