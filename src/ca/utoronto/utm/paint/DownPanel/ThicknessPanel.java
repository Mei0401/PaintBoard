package ca.utoronto.utm.paint.DownPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to provide current thickness information
 *
 */
public class ThicknessPanel extends JPanel {
	
	private JLabel thickness;

	public ThicknessPanel() {
		thickness = new JLabel();
		this.add(thickness);
	}

	public JLabel getThickness() {
		return thickness;
	}
	
	/**
	 * When received a string about current mode,
	 * set it to the JLabel mode
	 */
	public void setThickness(int curr) {
		thickness.setText("Current Thickness is: "+curr);
	}
	
}
