package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import ca.utoronto.utm.paint.DownPanel.DownPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private UpPanel uppanel;
	private LineThicknessSelectorSlider Slider;

	private ColorchoosePanel colorchoosePanel;

	private DownPanel downpanel;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.uppanel = new UpPanel(this);
		c.add(this.uppanel, BorderLayout.NORTH);
		uppanel.setBorder(new EtchedBorder(new Color(0xAAAAAA),new Color(0x666666)));
		
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		uppanel.add(shapeChooserPanel);
	    this.Slider = new LineThicknessSelectorSlider(this,1,5);
	    Slider.setBorder(new EtchedBorder(new Color(0xAAAAAA),new Color(0x666666)));
	    uppanel.add(Slider);
	    
		this.model = model;
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.colorchoosePanel =  new ColorchoosePanel(this);
		uppanel.add(colorchoosePanel);
		colorchoosePanel.setBorder(new EtchedBorder(new Color(0xAAAAAA),new Color(0x666666)));

		// adding a downpanel at the bottom of the program
		this.downpanel = new DownPanel(this);
		c.add(this.downpanel, BorderLayout.SOUTH);
		
		
		
		
		this.pack();
		// this.setSize(200,200);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}
	
    public LineThicknessSelectorSlider getLineThicknessSelectorPanel() {
    		return Slider;
    }
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			this.model.createNewFile();
		} else if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Undo")) {
			this.model.removeShape();
		}
	}
	
	public PaintModel getModel() {
		return model;
	}

	public void setModel(PaintModel model) {
		this.model = model;
	}

	public void setPaintPanel(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}

	public void setShapeChooserPanel(ShapeChooserPanel shapeChooserPanel) {
		this.shapeChooserPanel = shapeChooserPanel;
	}

	public LineThicknessSelectorSlider getSlider() {
		return Slider;
	}

	public DownPanel getDownpanel() {
		return downpanel;
	}

	public void setDownpanel(DownPanel downpanel) {
		this.downpanel = downpanel;
	}
	
	
}
