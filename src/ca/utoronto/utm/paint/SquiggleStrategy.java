package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * A special strategy to use squiggle to draw lines.
 * When mouse is pressed, set the start point for a line.
 * When mouse is dragged, set the end point for the line and draw it.
 * When the line is drawn, set the end point as the start point of next line. 
 */

public class SquiggleStrategy implements Strategy{
	
	private PaintPanel pp;

	public SquiggleStrategy(PaintPanel pp) {
		this.pp = pp;
	}
	
	
	@Override
	public void dragging(MouseEvent e) {
		Line l = (Line)pp.getCurrent();
		Point end = new Point(e.getX(),e.getY());
		l.setEnd(end);
		l.setThickness(pp.getView().getSlider().getSlider().getValue());
		l.setShapecolor(pp.getShapecolor());
		pp.getModel().addShape(l);
		pp.setCurrent(new Line(end));
	}

	@Override
	public void releasing(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressing(MouseEvent e) {
		Point start = new Point(e.getX(),e.getY());
		Line l = new Line(start);
		pp.setCurrent(l);
		
	}


	@Override
	public void moving(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void clicking(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
