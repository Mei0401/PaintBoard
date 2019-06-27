package ca.utoronto.utm.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorchoosePanel extends JPanel implements ActionListener {
	
	private View view;

	public ColorchoosePanel(View view) {	
		this.view=view;
		
		
		
		JButton button1 = new JButton();
		button1.setText("red");
		button1.setForeground(new Color(255,255,255,0));
		button1.setBackground(Color.red);
		this.add(button1);
		button1.setPreferredSize(new Dimension(25,25));
		button1.addActionListener(this);
		
		JButton button2 = new JButton("blue");
		button2.setBackground(Color.blue);
		button2.setForeground(new Color(255,255,255,0));;
		this.add(button2);
		button2.setPreferredSize(new Dimension(25,25));
		button2.addActionListener(this);
		
		JButton button3 = new JButton("yellow");
		button3.setBackground(Color.yellow);
		button3.setForeground(new Color(255,255,255,0));;
		this.add(button3);
		button3.setPreferredSize(new Dimension(25,25));
		button3.addActionListener(this);
		
		JButton button4 = new JButton("green");
		button4.setBackground(Color.green);
		button4.setForeground(new Color(255,255,255,0));;
		this.add(button4);
		button4.setPreferredSize(new Dimension(25,25));
		button4.addActionListener(this);
		
		JButton button5 = new JButton("orange");
		button5.setBackground(Color.orange);
		button5.setForeground(new Color(255,255,255,0));;
		this.add(button5);
		button5.setPreferredSize(new Dimension(25,25));
		button5.addActionListener(this);
		
		JButton button6  = new JButton("black");
		button6.setBackground(Color.black);
		button6.setForeground(new Color(255,255,255,0));;
		this.add(button6);
		button6.setPreferredSize(new Dimension(25,25));
		button6.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ColorSwitcher.switchMode(e.getActionCommand(), view.getPaintPanel());
		
		
	}

}
