package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Shape is what we draw on the PaintPanel. All drawn shape will be store in a list in PaintModel.
 * It has a method draw, which means that when a shape is created, it should be able to draw itself.
 *
 */
public interface Shape {

	public void draw(Graphics2D g2d);

}
