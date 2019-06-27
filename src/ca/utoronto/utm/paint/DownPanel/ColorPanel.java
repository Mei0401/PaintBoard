package ca.utoronto.utm.paint.DownPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to provide current color information
 *
 */
public class ColorPanel extends JPanel {
	
	private JLabel color;

	public ColorPanel() {
		color = new JLabel();
		this.add(color);
	}

	public JLabel getColor() {
		return color;
	}
	
	/**
	 * When received a string about current color,
	 * set it to the JLabel color
	 */
	public void setColor(String curr) {
		color.setText("Current color is: "+curr);
	}
	
}
