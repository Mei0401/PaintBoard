package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 *  PaintPanel is a panel where we draw our patterns. It is basically an observer, when a model add any
 * patterns, the PaintPanel will recieve signal and update method will be executed. The update method will
 * use all shapes in model to to paint things.
 * 
 *  When a button on ShapechooserPanel is clicked, the mode will switch to corresponding strategy. This
 * idea is based on Strategy Method Design Pattern
 *
 */
class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private Strategy mode; // using strategy pattern here
	private Shape current; // this is the current pattern we are going to draw, when it finished set null
	private Shape before;
	private Color shapecolor;
	private boolean isFill;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setShapecolor(Color.black);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.isFill = false;
		
		this.mode= new SquiggleStrategy(this); 
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		

		
		// Draw Shapes
		ArrayList<Shape> shapes = this.model.getShapes();
		ArrayList<Shape> feedback = this.model.getFeedBack();
		for(Shape shape: shapes){
			shape.draw(g2d);
		}
		
		for (Shape shape: feedback) {
			shape.draw(g2d);
		}
		
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(Strategy mode){
		this.mode=mode;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		mode.moving(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mode.dragging(e);
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		mode.clicking(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mode.pressing(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mode.releasing(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	public PaintModel getModel() {
		return model;
	}

	public void setModel(PaintModel model) {
		this.model = model;
	}

	public Shape getCurrent() {
		return current;
	}

	public void setCurrent(Shape current) {
		this.current = current;
	}

	public Strategy getMode() {
		return mode;
	}

	public Shape getBefore() {
		return before;
	}

	public void setBefore(Shape before) {
		this.before = before;
	}
	
	public View getView() {
		// TODO Auto-generated method stub
		return view;
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
	
	
	
	
}
