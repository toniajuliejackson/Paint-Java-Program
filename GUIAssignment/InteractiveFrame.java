package GUIAssignment;

import SimpleFrame.SimpleFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InteractiveFrame extends SimpleFrame {
	protected static final String IteractivePanel = null;
	static InteractivePanel IAPanel = new InteractivePanel();
	StatusPanel      StPanel = new StatusPanel();
	Panel      PtPanel = new Panel();
	public ObjectOutputStream output;
	public ObjectInputStream input;
	
	Icon iconB = new ImageIcon("blue.gif");
	Icon iconM = new ImageIcon("magenta.gif");
	Icon iconR = new ImageIcon("red.gif");
	Icon iconBl = new ImageIcon("black.gif");
	Icon iconG = new ImageIcon("green.gif");
	Icon iconY = new ImageIcon("yellow.gif");
	
	Icon erase       = new ImageIcon(getClass().getResource("eraser.png"));
	Icon rect   	 = new ImageIcon(getClass().getResource("rectangle.png"));
	Icon oval        = new ImageIcon(getClass().getResource("oval.png"));
	Icon line        = new ImageIcon(getClass().getResource("line-tool.png"));
	JMenu file;
	JMenuItem quit;
	JMenuItem newSketch;
	JMenuItem openSketch;
	JMenuItem saveSketch;

	public InteractiveFrame() {
		this.setTitle("Paint Program Assignment");
		// Create a menu bar and add it to the frame
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		
		file   = new JMenu("File");
		menubar.add(file);
		newSketch = new JMenuItem("New Sketch");
		openSketch = new JMenuItem("Open Sketch");
		saveSketch = new JMenuItem("Save Sketch");
		quit = new JMenuItem("Quit");

		file.add(newSketch);
		file.add(openSketch);
		file.add(saveSketch);
		file.addSeparator();
		file.add(quit); 

		// Create a listener and add it to the menu items
		MenuListener menuList = new MenuListener(this);

		newSketch.addActionListener(menuList);
		openSketch.addActionListener(menuList);
		saveSketch.addActionListener(menuList);
		quit.addActionListener(menuList);

		this.setLayout(new BorderLayout());

		MyMousePositionsListener MPosAdpt = new MyMousePositionsListener(StPanel);
		IAPanel.addMouseMotionListener(MPosAdpt);

		final MyMouseListener MAdpt = new MyMouseListener(StPanel,IAPanel);
		IAPanel.addMouseListener(MAdpt);

		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());

		content.add(IAPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(90, 68));
		panel.setMinimumSize(new Dimension(90, 68));
		panel.setMaximumSize(new Dimension(90, 68));

		JButton circleButton = new JButton(oval);
		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAPanel.setShape(InteractivePanel.CIRCLE);
			}});

		JButton lineButton = new JButton(line);
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAPanel.setShape(InteractivePanel.LINE);
			}});

		JButton rectangleButton = new JButton(rect);
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAPanel.setShape(InteractivePanel.RECTANGLE);
			}});

		JButton eraseButton = new JButton(erase);
		eraseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setShape(InteractivePanel.ERASE);
			}
		});

		JButton yellowButton = new JButton(iconY);
		yellowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.YELLOW);
			}

		});

		JButton redButton = new JButton(iconR);
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.RED);
			}

		});

		JButton blackButton = new JButton(iconBl);
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.BLACK);
			}
		});

		JButton magentaButton = new JButton(iconM);
		magentaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.MAGENTA);
			}
		});

		JButton blueButton = new JButton(iconB);
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.BLUE);
			}
		});

		JButton greenButton = new JButton(iconG);
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IAPanel.setColor(InteractivePanel.GREEN);
			}
		});

		blackButton.setPreferredSize(new Dimension(16,16));
		magentaButton.setPreferredSize(new Dimension(16,16));
		redButton.setPreferredSize(new Dimension(16,16));
		blueButton.setPreferredSize(new Dimension(16,16));
		greenButton.setPreferredSize(new Dimension(16,16));
		yellowButton.setPreferredSize(new Dimension(16,16));

		circleButton.setPreferredSize(new Dimension(80,50));
		rectangleButton.setPreferredSize(new Dimension(80,50));
		lineButton.setPreferredSize(new Dimension(80,50));
		eraseButton.setPreferredSize(new Dimension(80,50));

		panel.add(greenButton);
		panel.add(blueButton);
		panel.add(magentaButton);
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(yellowButton);

		panel.add(circleButton);
		panel.add(rectangleButton);
		panel.add(lineButton);
		panel.add(eraseButton);

		content.add(panel, BorderLayout.WEST);
		this.getContentPane().add(StPanel,BorderLayout.SOUTH);
		this.getContentPane().add(new JScrollPane(IAPanel),  BorderLayout.CENTER);

		pack();

		this.setVisible(true);
	}
}





