package ca.utoronto.utm.paint;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 *  The Square is a shape. It has 2 point and corresponding length and width. 
 *  Under Square mode, when mouse clicked, a start point will be set. 
 *  When dragging, end point and center and radius will be set.
 *  When user dragging the mouse, PaintPanel will try to call draw method
 */

public class Square implements Shape{
	protected Point start;
	protected Point end;
	protected int length;

	protected Point drawpoint;
	private int thickness;
	private Color shapecolor;
	private boolean isFill;
	
	public Color getShapecolor() {
		return shapecolor;
	}


	public void setShapecolor(Color shapecolor) {
		this.shapecolor = shapecolor;
	}


	/**
	 *  Construt the square.
	 */
	public Square(Point start){
		this.start = start;
		this.thickness = 0;
	}
	
	
	/**
	 * 
	 * @return int the thickness.
	 */
	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	
	/**
	 *  Return the start point.
	 */
	public Point getStart() {
		return start;
	}
	
	
	/**
	 *  Set the start point.
	 */
	public void setStart(Point start) {
		this.start = start;
	}
	
	/**
	 *  Return the end point.
	 */
	public Point getEnd() {
		return end;
	}

	/**
	 *  Set the end point.
	 */
	public void setEnd(Point end) {
		this.end = end;
	}
	
	/**
	 *  Return the length.
	 */
	public int getLength() {
		return length;
	}
	
	
	/**
	 *  Set the length.
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 *  Return the drawpoint.
	 */
	public Point getDrawpoint() {
		return drawpoint;
	}
	
	/**
	 *  Set the drawpoint point.
	 */
	public void setDrawpoint(Point drawpoint) {
		this.drawpoint = drawpoint;
	}
	public boolean isFill() {
		return isFill;
	}

	public void setFill(boolean isFill) {
		this.isFill = isFill;
	}
	
	/**
	 *  Draw the square.
	 */
	public void draw(Graphics2D g2d){
		if(isFill) {
		g2d.fillRect(drawpoint.getX(), drawpoint.getY(), length*2, length*2);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(shapecolor);
		}else {
			g2d.drawRect(drawpoint.getX(), drawpoint.getY(), length*2, length*2);
			g2d.setStroke(new BasicStroke(thickness));
			g2d.setColor(shapecolor);
			}
		}



	

}
