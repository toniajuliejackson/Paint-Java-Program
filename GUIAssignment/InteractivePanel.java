package GUIAssignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class InteractivePanel extends JPanel implements MouseListener, 
MouseMotionListener {
	public ObjectOutputStream output;
	public ObjectInputStream input;
	private BufferedImage image = null;
	Graphics2D graphics2D;
	public Color backgroundColor;

	//--- Variables to store the current figure info
	private int _shape = NONE;
	private int currentX = 0;
	private int currentY = 0; 
	private int oldX = 0; 
	private int oldY = 0;

	private int _color = STANDARD;
	public static final int STANDARD = 0;
	public static final int YELLOW = 1;
	public static final int RED = 2;
	public static final int BLUE = 3;
	public static final int GREEN = 4;
	public static final int BLACK = 5;
	public static final int MAGENTA = 6;

	public static final int NONE      = 0;
	public static final int LINE      = 1;
	public static final int RECTANGLE = 2;
	public static final int CIRCLE    = 3;
	public static final int ERASE     = 4;

	public InteractivePanel(){
		this.setBackground(Color.LIGHT_GRAY);
		backgroundColor = Color.white;

		setBackground(backgroundColor);
		setPreferredSize(new Dimension(1024, 768));

		addMouseListener(this);

		this.addMouseListener(this); 
		this.addMouseMotionListener(this);
		setDoubleBuffered(false);
	}

	public void setShape(int shape) {
		_shape = shape;
	}

	public void setColor(int color) {
		_color = color;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D graphics2D = (Graphics2D)g;
		if(image == null){
			image = (BufferedImage) this.createImage(getSize().width, getSize().height);
			graphics2D = image.createGraphics();
			graphics2D.setPaint(Color.white);
			graphics2D.fillRect(0, 0, getSize().width, getSize().height);
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		graphics2D.drawImage(image, null, 0, 0);  // draw previous shapes

		drawCurrentColor(graphics2D);
		drawCurrentShape(graphics2D);
	}
	private void drawCurrentColor(final Graphics2D graphics2D) {
		switch (_color) {
		case STANDARD  :
			break;

		case YELLOW:
			graphics2D.setColor(Color.yellow);
			break;

		case RED:
			graphics2D.setColor(Color.red);
			break;

		case BLUE:
			graphics2D.setColor(Color.blue);
			break;

		case BLACK:
			graphics2D.setColor(Color.black);
			break;

		case GREEN:
			graphics2D.setColor(Color.green);
			break;

		case MAGENTA:
			graphics2D.setColor(Color.magenta);
			break;
		}
	}

	private void drawCurrentShape(final Graphics2D graphics2D) {
		switch (_shape) {
		case NONE  :
			if(graphics2D != null)
				drawCurrentColor(graphics2D);
			graphics2D.fillOval(oldX, oldY,
					currentX - oldX, 
					currentY - oldY);
			break;

		case CIRCLE:
			drawCurrentColor(graphics2D);
			if(graphics2D != null)
				graphics2D.fillOval(oldX, oldY,
						currentX - oldX, 
						currentY - oldY);
			break;

		case LINE:
			if(graphics2D != null)
				drawCurrentColor(graphics2D);
			graphics2D.drawLine(oldX, oldY, currentX, currentY);
			break;

		case RECTANGLE:
			if(graphics2D != null)
				drawCurrentColor(graphics2D);
			graphics2D.fillRect(oldX, oldY,
					currentX - oldX, 
					currentY - oldY);
			break;

		case ERASE:
			if(graphics2D != null) {
				addMouseMotionListener(new MouseMotionAdapter(){
					public void mouseDragged(MouseEvent e){
						currentX = e.getX();
						currentY = e.getY();
						if(graphics2D != null) {
							graphics2D.setColor(Color.white);
							graphics2D.fillOval(currentX, currentY, 15, 15);
						}
						repaint();
						oldX = currentX;
						oldY = currentY;
					}
				});
			}
			break;

		default:
			graphics2D.drawString("This never happens", 10, 20);
			break;
		}
	}

	public void erase(){
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDown(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
				if(graphics2D != null) {
					graphics2D.setColor(Color.white);
					graphics2D.fillOval(currentX, currentY, 15, 15);
				}
				repaint();
				oldX = currentX;
				oldY = currentY;
			}
		});
	}
	public void newSketch(){
		image = (BufferedImage) this.createImage(getSize().width, getSize().height);
		graphics2D = image.createGraphics();
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		clear();
	}
	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}

	public void saveFile() {
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = image.createGraphics(); 

		this.paint(graphics2D);
		try{
			ImageIO.write(image,"png", new File("screenshot.png"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public File getFileName() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File("/Users/toniajackson/Desktop"));

		int result = fileChooser.showOpenDialog(this);

		File fileName = fileChooser.getSelectedFile();

		return fileName;
	}

	public void loadFile(File fileName)
	{
		try
		{
			input = new ObjectInputStream(new FileInputStream(fileName));
		}
		catch(IOException ioException)
		{
			System.err.println("Error loading file: "+fileName);
			return;
		}
	}
	public void openFile(File fileName)
	{
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(IOException ioException)
		{
			System.err.println("Error loading file: "+fileName);
			return;
		}
	}

	public void closeFile()
	{
		try
		{
			if (output != null)
				output.close();
		}
		catch (IOException exception)
		{
			System.err.println("Error closing file");
			System.exit(1);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		currentX = e.getX();
		currentY = e.getY();

		//graphics2D.drawLine(oldX, oldY, currentX, currentY);*/
		this.repaint();
		/*oldX = currentX;
		oldY = currentY;*/
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		oldX = e.getX();
		oldY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentX = e.getX(); // save ending coordinates
		currentY = e.getY();

		//--- Draw the current shape onto the buffered image.
		Graphics2D grafarea = image.createGraphics();
		drawCurrentShape(grafarea);

		this.repaint();
	}
}
