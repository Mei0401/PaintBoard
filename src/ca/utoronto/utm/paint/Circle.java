package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *  The Circle class is a shape. It has 3 point and a int radius. 
 *  Under Circle mode, when mouse clicked, a start point will be set. 
 *  When dragging, end point and center and radius will be set.
 *  When user dragging the mouse, PaintPanel will try to call draw method
 */
public class Circle implements Shape {
	// start is where we click the mouse
	private Point start;
	// end is where we drag the mouse
	private Point end;
	// radius of the circle
	private int radius;
	// the point that drawoval function used to draw a circle
	private Point drawpoint;
	private int thickness;
	private Color shapecolor;
	private boolean isFill;

	public Circle(Point start){
		this.start = start;
		this.radius = 0;
		this.thickness = 0;
		this.isFill = false;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point centre) {
		this.start = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public Point getDrawpoint() {
		return drawpoint;
	}

	public void setDrawpoint(Point drawpoint) {
		this.drawpoint = drawpoint;
	}

	public Color getShapecolor() {
		return shapecolor;
	}

	public void setShapecolor(Color shapecolor) {
		this.shapecolor = shapecolor;
	}
	

	public boolean isFill() {
		return isFill;
	}

	public void setFill(boolean isFill) {
		this.isFill = isFill;
	}

	/**
	 * This method will be call in the PaintPanel
	 * when called, using center and diameter to draw a circle
	 */
	@Override
	public void draw(Graphics2D g2d) {
		if(isFill) {
			g2d.fillOval(drawpoint.getX(), drawpoint.getY(),radius*2,radius*2);
			g2d.setStroke(new BasicStroke(thickness));
			g2d.setColor(shapecolor);
		}else {
	g2d.drawOval(drawpoint.getX(), drawpoint.getY(),radius*2,radius*2);
	g2d.setStroke(new BasicStroke(thickness));
	g2d.setColor(shapecolor);
	
		}
		
	}

}
