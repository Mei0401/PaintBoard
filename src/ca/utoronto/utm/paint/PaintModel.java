package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

/**
 * PaintModel is all about what is going on with PaintPanel
 * When it should store all shapes that has being drawn by user.
 * It is a observer, when user's mouse doing something, the PaintModel will try to add
 * a corresponding shape and setchanged.
 *
 */
		
public class PaintModel extends Observable {
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	private ArrayList<Shape> feedBack = new ArrayList<Shape>();
	private ArrayList<Shape> removed = new ArrayList<Shape>();
	private Shape removedItem;
	
	public void addFeedBack(Shape c) {
		this.feedBack.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void emptyFeedBack() {
		feedBack = new ArrayList<Shape>();
	}
	
	
	public ArrayList<Shape> getFeedBack() {
		return feedBack;
	}

	private String mode;
	private int thickness;
	private String color;
	
	public void removeShape() {
		if (this.shapes.size() == 0) {
			
		} else {
			removedItem = this.shapes.get(this.shapes.size() - 1);
			this.removed.add(removedItem);
			this.shapes.remove(removedItem);
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	public void addShape(Shape c){
		this.shapes.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void createNewFile(){
		shapes = new ArrayList<Shape>();
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public String getMode() {
		return mode;
	}
	
	/**
	 * When a mode is changed, ask PaintPanel to update
	 * @param mode is the name of mode changed
	 */
	public void setMode(String mode) {
		this.mode = mode;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	 * When a color is changed, ask PaintPanel to update
	 * @param color is the name of color changed
	 */
	public void setColor(String color) {
		this.color = color;
		this.setChanged();
		this.notifyObservers();
	}
	
	
}
