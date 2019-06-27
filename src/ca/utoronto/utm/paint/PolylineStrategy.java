package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * A special strategy to use polyline to draw lines.
 * When mouse is clicked, set the start point for a line.
 * When mouse is clicked another time, set the end point for the line and draw it.
 * When the line is drawn, set the end point as the start point of next line. 
 */

public class PolylineStrategy implements Strategy{
	private PaintPanel pp;

	public PolylineStrategy(PaintPanel pp) {
		this.pp = pp;
	}

	@Override
	public void dragging(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releasing(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressing(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moving(MouseEvent e) {
	
	}

	@Override
	public void clicking(MouseEvent e) {
		if(pp.getBefore() != null) { // this is click at other time
			Line before = (Line)pp.getBefore();
			Point start =  before.getEnd();
			Point end = new Point(e.getX(),e.getY());
			Line current = new Line(start);
			current.setEnd(end);
			pp.getModel().addShape(current);
			pp.setBefore(current);
		}else { // this is clicking at first time
			Point start = new Point(e.getX(),e.getY());
			Line current = new Line(start);
			current.setEnd(start);
			pp.getModel().addShape(current);
			pp.setBefore(current);
		}
		
	}

}
