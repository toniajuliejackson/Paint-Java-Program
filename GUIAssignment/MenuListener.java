package GUIAssignment;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;


public class MenuListener extends JComponent implements ActionListener {

	private InteractiveFrame menuFrame;
	InteractivePanel IAPanel = new InteractivePanel();

	public MenuListener(InteractiveFrame mf) {
		menuFrame = mf;
	}

	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		if(actionCommand.equals("New Sketch")){
			IAPanel.newSketch();
		}
		else if(actionCommand.equals("Open Sketch")){
			File fileName = IAPanel.getFileName();
			IAPanel.loadFile(fileName);
			IAPanel.openFile(fileName);
			IAPanel.closeFile();
		}
		else if(actionCommand.equals("Save Sketch")){
			BufferedImage image = new BufferedImage(IAPanel.getWidth(), IAPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = image.createGraphics(); 

			IAPanel.paint(graphics2D);
			try{
				ImageIO.write(image, "png", new File("filename.png"));
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		else if(actionCommand.equals("Quit")){
			System.exit(0);
		}
		else{
			System.out.println("ERROR: unknown action command.");
		}
	}
}




