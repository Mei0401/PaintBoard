package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;



/**
 * A special strategy to create Rectangle.
 * When mouse is pressed, construct a rectangle. 
 * 
 * When mouse is dragged, try to create the rectangle and add it to the PaintModel
 *
 */

public class RectangleStrategy implements Strategy{
	private PaintPanel pp;
	

	/**
	 * Construct the rectangle strategy.
	 *
	 */
	public RectangleStrategy(PaintPanel pp) {
		this.pp = pp;
	}
	
	/**
	 * When mouse is dragging, add a circle into PaintModel's shape list
	 */
	
	public void dragging(MouseEvent e) {
		// TODO Auto-generated method stub
		Rectangle r = (Rectangle) pp.getCurrent();
		Point end = new Point(e.getX(),e.getY());
		r.setEnd(end);
		r.width =  Math.abs(r.getEnd().getX() - r.getStart().getX());
		r.length =  Math.abs(r.getEnd().getY() - r.getStart().getY());
		Point drawpoint = new Point(r.width,r.length);
		r.setDrawpoint(drawpoint);
		r.setThickness(pp.getView().getSlider().getSlider().getValue());
		r.setShapecolor(pp.getShapecolor());
		if(pp.isFill()) {
			r.setFill(true);
			
		}
		pp.getModel().addFeedBack(r);
		
		
	}

	/**
	 * Do nothing
	 */
	@Override
	public void releasing(MouseEvent e) {
		// TODO Auto-generated method stub
		Rectangle r = (Rectangle) pp.getCurrent();
		pp.getModel().addShape(r);
		pp.getModel().emptyFeedBack();
		
	}
	
	/**
	 * When pressing the mouse, create a circle that only has start
	 */
	@Override
	public void pressing(MouseEvent e) {
		// TODO Auto-generated method stub
		Point start = new Point(e.getX(), e.getY()); // this will give me the coordinate for starting point.
		pp.setCurrent(new Rectangle(start)); 
		
	}


	/**
	 * Do nothing
	 */
	@Override
	public void moving(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Do nothing
	 */
	@Override
	public void clicking(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}