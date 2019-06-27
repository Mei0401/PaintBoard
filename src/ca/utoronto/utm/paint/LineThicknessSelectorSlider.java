package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class LineThicknessSelectorSlider  extends JPanel{
	private View view; // So we can talk to our parent or other components of the view
	private int min; // Minimum of thickness 
	private int max;// Maximum of thickness
	private Slider Slider;
	// Construct a slider to select line thickness
	public LineThicknessSelectorSlider(View view, int min, int max) {
		super(true);
		JLabel sliderLabel = new JLabel("Line thickness");
		this.view = view;
        this.min = min;
        this.max = max;
	    this.setLayout(new BorderLayout());
	    Slider = new Slider(JSlider.HORIZONTAL,min, max, 3);
	    Slider.setPaintTicks(true);
	    Slider.setPaintLabels(true);
	    Slider.setPreferredSize(new Dimension(120,40));;

	    Slider.setLabelTable(Slider.createStandardLabels(1));
	    Slider.setPaintLabels(true);
	    this.add(Slider,BorderLayout.NORTH);
	    this.add(sliderLabel,BorderLayout.CENTER);
	  }
	
	public Slider getSlider() {
		return Slider;
	  }
	
	/**
	 * Override this class in order to override the setValue method for hooking this with 
	 * PaintModel.
	 *
	 */
	class Slider extends JSlider{
		
		public Slider(int horizontal, int min, int max, int i) {
			super(horizontal, min,max, i);
		}
		
		/**
		 * When the value is changed, change the thickness on down panel.
		 * And then ask the PaintPanel to change.
		 */
		@Override
		public void setValue(int n) {
			super.setValue(n);
			view.getDownpanel().getThicknessStatus().setThickness(n);
			view.getModel().setThickness(n);
		}
	}
	
}


