package GUIAssignment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopUpMenu extends JPopupMenu {
	JMenuItem redItem;
	JMenuItem blueItem;
	JMenuItem magItem;
	JMenuItem blackItem;
	JMenuItem greenItem;
	JMenuItem yellowItem;
	public PopUpMenu(){
		magItem = new JMenuItem("Magenta");
		add(magItem);
		blackItem = new JMenuItem("Black");
		add(blackItem);
		redItem = new JMenuItem("Red");
		add(redItem);
		greenItem = new JMenuItem("Green");
		add(greenItem);
		blueItem = new JMenuItem("Blue");
		add(blueItem);
		yellowItem = new JMenuItem("Yellow");
		add(yellowItem);
		
		yellowItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(1);
			}
		});
		
		redItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(2);
			}
		});
		
		blueItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(3);
			}
		});
		
		greenItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(4);
			}
		});
		
		blackItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(5);
			}
		});
		
		magItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				InteractiveFrame.IAPanel.setColor(6);
			}
		});
		
		
	}
}
