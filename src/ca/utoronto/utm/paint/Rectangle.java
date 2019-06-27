package ca.utoronto.utm.paint;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *  The Rectangle class is a shape. It has 2 points and corresponding length and width. 
 *  Under Rectangle mode, when mouse clicked, a start point will be set. 
 *  When dragging, end point and end point will be set.
 *  When user dragging the mouse, PaintPanel will try to call the draw method.
 */


public class Rectangle implements Shape{
	protected Point start;
	protected Point end;
	protected int length;
	protected int width;
	protected Point drawpoint;
	private int thickness;
	private Color shapecolor;
	private boolean isFill;
	
	/**
	 *  Construct the Rectangle given the start point and the thickness level.
	 */
	public Rectangle(Point start){
		this.start = start;
		this.thickness = 0;
	}
	
	/**
	 * Return the thickness.
	 */
	public int getThickness() {
		return thickness;
	}
	
	public Color getShapecolor() {
		return shapecolor;
	}

	public void setShapecolor(Color shapecolor) {
		this.shapecolor = shapecolor;
	}
	
	/**
	 *  Set the thickness.
	 */
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
	 *  Set the start point
	 */
	public void setStart(Point start) {
		this.start = start;
	}

	
	/**
	 *  Return the end point
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
	 *  Return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 *  Set the length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	
	/**
	 *  Return the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 *  Set the width.
	 */
	public void setWidth(int width) {
		this.width = width;
	}	
	
	/**
	 *  Return the drawpoint
	 */
	public Point getDrawpoint() {
		return drawpoint;
	}

	/**
	 *  Set the end point
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
	 * draw is used to draw the rectangle and show the thickness of line for the rectangle.
	 */
	public void draw(Graphics2D g2d){		
		int x = Math.min(end.getX(),start.getX());
		int y = Math.min(end.getY(),start.getY());
		if(isFill) {
		g2d.fillRect(x, y, width, length);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(shapecolor);
		
			
		}else {
	
		g2d.drawRect(x, y, width, length);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(shapecolor);
		}
	}

}
