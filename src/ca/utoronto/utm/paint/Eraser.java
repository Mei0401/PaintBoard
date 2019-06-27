package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Add Eraser class, it is a shape. An eraser is used to clean the graph drawn by the previous move.
 */

public class Eraser implements Shape{
	
	private Point start;
	private Point end;
	private int thickness;
	private Color shapecolor;
	public Color getShapecolor() {
		return shapecolor;
	}

	public void setShapecolor(Color shapecolor) {
		this.shapecolor = shapecolor;
	}

	/**
	 * Construct the Eraser.
	 */
	public Eraser(Point start) {
		this.start = start;
		this.thickness = 0;
	}
	
	/**
	 * 
	 * @return int Return the thickness.
	 */
	public int getThickness() {
		return thickness;
	}
	
	/**
	 * 
	 * @param int Set the thickness
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	/**
	 * Return the start point.
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * set the start point.
	 */
	
	public void setStart(Point start) {
		this.start = start;
	}

	/**
	 * Return the end point
	 */
	public Point getEnd() {
		return end;
	}
	
	/**
	 * Set the end point point.
	 */
	public void setEnd(Point end) {
		this.end = end;
	}

	/**
	 * When start point and end point confirmed, use eraser to clean the graph from the interval based on the start 
	 * coordiates and end coordiates.
	 */
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		g2d.setStroke(new BasicStroke(thickness * 2));
		
	}

}