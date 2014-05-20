package GUIAssignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class MyMouseListener extends JComponent implements MouseListener {
	private StatusPanel statusPane;
	private InteractivePanel interactivePane;	

	public MyMouseListener(StatusPanel s,InteractivePanel i)
	{
		statusPane = s;
		interactivePane = i;
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
		statusPane.setCoordinates(-1,-1);
	}

	public void mouseClicked(MouseEvent e)
	{
		 if (SwingUtilities.isRightMouseButton(e)) {
         	if (e.isPopupTrigger())
 	            doPop(e);
         }
	}

	public void mousePressed(MouseEvent e)
	{
		 if (SwingUtilities.isRightMouseButton(e)) {
         	if (e.isPopupTrigger())
 	            doPop(e);
         }
	}

	public void mouseReleased(MouseEvent e)
	{

	}

    private void doPop(MouseEvent e){
        PopUpMenu menu = new PopUpMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
