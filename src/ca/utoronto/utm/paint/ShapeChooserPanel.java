package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * ShapeChooserPanel is a JPanel that have all tools button.
 * It has a list buttons that stores all buttons on the panel.
 * When a button is clicked, using modeSwitcher class to switch the mode of PaintPanel.
 * The idea of modeSwitcher class is base on Factory Method Design Pattern. 
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private ArrayList<JButton> buttons;
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		this.buttons = new ArrayList();
		
		String[] buttonLabels = { "FillCircle","FillRectangle","FillSquare","Circle", "Rectangle", "Square", "Squiggle", "Polyline","Eraser" };
		this.setLayout(new GridLayout(1, buttonLabels.length));
		for (String label : buttonLabels) {
			ImageIcon i = new ImageIcon("icon/" + label +".png");
			JButton button = new JButton();
			button.setPreferredSize(new Dimension(40,40));
			button.setIcon(i);
			button.setActionCommand(label);
			this.add(button);
			buttons.add(button);
			button.addActionListener(this);
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// re-enable all buttons
		for(JButton all_b:buttons) {
			all_b.setEnabled(true);
		}
		JButton button = (JButton) e.getSource();
		button.setEnabled(false);
		// factory pattern to switch mode
		ModeSwitcher.switchMode(e.getActionCommand(), view.getPaintPanel());
		
		
	}

	
}

