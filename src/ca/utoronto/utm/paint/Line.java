package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Add line class , it is a shape. A line has 2 points, a start point and end point. 
 */

public class Line implements Shape{
	
	private Point start;
	private Point end;
	private int thickness;
	private Color shapecolor;
	/**
	 * Construct the line given the start point.
	 */
	public Line(Point start) {
		this.start = start;
		this.thickness = 0;
	}
	
	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public Color getShapecolor() {
		return shapecolor;
	}

	public void setShapecolor(Color shapecolor) {
		this.shapecolor = shapecolor;
	}
	/**
	 * Return the start point.
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * When pressing the mouse, create a circle that only has start
	 */
	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	/**
	 * When start point and end point confirmed, draw a line between them.
	 */
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(shapecolor);
		g2d.setStroke(new BasicStroke(thickness));
		g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		
	}

}
