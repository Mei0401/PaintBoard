package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * A special strategy to use eraser to clean graph/lines drawn.
 * When mouse is pressed, set the start point for a eraser.
 * When mouse is dragged, clean the points drawn between the start and end point.. 
 */

public class EraserStrategy implements Strategy{
	
	private PaintPanel pp;
	/**
	 * Construct the EraserStrategy
	 */
	public EraserStrategy(PaintPanel pp) {
		this.pp = pp;
	}
	
	/**
	 * When dragging the mouse, clean the points using the eraser along the coordinates.
	 */
	@Override
	public void dragging(MouseEvent e) {
		Eraser e1 = (Eraser)pp.getCurrent();
		Point end = new Point(e.getX(),e.getY());
		e1.setEnd(end);
		e1.setThickness(pp.getView().getSlider().getSlider().getValue());
		e1.setShapecolor(pp.getShapecolor());
		pp.getModel().addShape(e1);
		pp.setCurrent(new Eraser(end));
		
	}

	@Override
	/**
	 * Do nothing.
	 */
	public void releasing(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * When pressing the mouse, clean the start point.
	 */
	@Override
	public void pressing(MouseEvent e) {
		Point start = new Point(e.getX(),e.getY());
		Eraser e1 = new Eraser(start);
		pp.setCurrent(e1);
		
	}

	/**
	 * Do nothing
	 */
	@Override
	public void moving(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Do nothong
	 */

	@Override
	public void clicking(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
