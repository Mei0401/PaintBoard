package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * A special strategy to create circle.
 * When mouse is pressed, start drawing a circle. 
 * 
 * When mouse is dragged, try to create the circle and add it to the PaintModel
 *
 */
public class CircleStrategy implements Strategy{
	
	private PaintPanel pp;

	public CircleStrategy(PaintPanel pp) {
		this.pp = pp;
	}

	/**
	 * When mouse is dragging, add a circle into PaintModel's shape list
	 */
	@Override
	public void dragging(MouseEvent e) {
		// get the circle we created before 
		Circle c = (Circle) pp.getCurrent();
		// tell circle the coordinates of mouse now
		Point end = new Point(e.getX(),e.getY());
		c.setEnd(end);
		// calculate the radius using Pythagorean theorem
		int radius_x =  Math.abs(c.getEnd().getX()-c.getStart().getX());
		int radius_y =  Math.abs(c.getEnd().getY()-c.getStart().getY());
		int true_radius = (int)Math.sqrt(radius_x*radius_x + radius_y*radius_y);
		c.setRadius(true_radius);
		// a special function for drawoval function to draw a circle
		// the drawpoint is on the topleft of the center, the distance between center and
		// drawpoint is the radius
		Point drawpoint = new Point(c.getStart().getX()-true_radius,c.getStart().getY()-true_radius);
		c.setDrawpoint(drawpoint);
		c.setThickness(pp.getView().getSlider().getSlider().getValue());
		c.setShapecolor(pp.getShapecolor());
		if(pp.isFill()) {
			c.setFill(true);
		}
		pp.getModel().addFeedBack(c);
	}

	/**
	 * When pressing the mouse, create a circle that only has start
	 */
	@Override
	public void pressing(MouseEvent e) {
		// set the current coordinate to start, which is also the center of the circle
		Point start = new Point(e.getX(), e.getY());
		pp.setCurrent(new Circle(start));
	}

	@Override
	public void releasing(MouseEvent e) {
		// do nothing, everything is finished when dragging
		Circle c = (Circle) pp.getCurrent();
		pp.getModel().addShape(c);
		pp.getModel().emptyFeedBack();
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
