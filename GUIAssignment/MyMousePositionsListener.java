package GUIAssignment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMousePositionsListener implements MouseMotionListener
{
  private StatusPanel SP;

  public MyMousePositionsListener(StatusPanel s)
  {
    SP = s;
  }

  public void mouseMoved(MouseEvent evt)
   {
   SP.setCoordinates(evt.getX(),evt.getY());
   }

  public void mouseDragged(MouseEvent evt)
   {
     // implemented with emtpy body
   }
}
