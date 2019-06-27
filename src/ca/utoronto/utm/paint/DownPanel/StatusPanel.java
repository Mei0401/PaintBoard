package ca.utoronto.utm.paint.DownPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is used to provide current mode information
 *
 */
public class StatusPanel extends JPanel {
	
	private JLabel status;

	public StatusPanel() {
		status = new JLabel();
		this.add(status);
	}

	public JLabel getStatus() {
		return status;
	}
	
	/**
	 * When received a string about current mode,
	 * set it to the JLabel mode
	 */
	public void setStatus(String curr) {
		status.setText("Current Mode is: "+curr);
	}
	
}
