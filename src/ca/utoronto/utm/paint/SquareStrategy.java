package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;

/**
 * A special strategy to use square to draw lines.
 * When mouse is pressed, set the start point for a line.
 * When mouse is dragged, set the end point for the line and draw it.
 * When the line is drawn, set the end point as the start point of next line. 
 */

public class SquareStrategy implements Strategy{
	private PaintPanel pp;

	
	/**
	 * Construct the square strategy.
	 */
	public SquareStrategy(PaintPanel pp) {
		this.pp = pp;
	}
	
	/**
	 * When dragging mouse, draw the square based on the coordinates.
	 */
	public void dragging(MouseEvent e) {
		// TODO Auto-generated method stub
		Square s = (Square) pp.getCurrent();
		Point end = new Point(e.getX(),e.getY());
		s.setEnd(end);
		int length_x =  Math.abs(s.getEnd().getX()-s.getStart().getX());
		int length_y =  Math.abs(s.getEnd().getY()-s.getStart().getY());
		int true_length = (int)Math.sqrt(length_x*length_x + length_y*length_y); 
		s.setLength(true_length);
		Point drawpoint = new Point(s.getStart().getX()-true_length, s.getStart().getY()-true_length);
		s.setDrawpoint(drawpoint);
		s.setThickness(pp.getView().getSlider().getSlider().getValue());
		s.setShapecolor(pp.getShapecolor());
		if(pp.isFill()) {
			s.setFill(true);
			
		}
		pp.getModel().addFeedBack(s);
		
	}
	
	@Override
	/**
	 * When pressing the mounse, set the starter point.
	 */
	public void pressing(MouseEvent e) {
		// TODO Auto-generated method stub
		Point start = new Point(e.getX(), e.getY()); // this will give me the coordinate for starting point.
		pp.setCurrent(new Square(start)); 
		
	}

	@Override
	/**
	 * Do nothing.
	 */
	public void releasing(MouseEvent e) {
		// TODO Auto-generated method stub
		Square s = (Square) pp.getCurrent();
		pp.getModel().addShape(s);
		pp.getModel().emptyFeedBack();
		
	}

	@Override
	/**
	 * Do nothing 
	 */
	public void moving(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Do nothing.
	 */
	public void clicking(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}