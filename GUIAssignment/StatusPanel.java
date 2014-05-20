package GUIAssignment;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel
{
  private JLabel posText    = new JLabel("position:");
  private JLabel XCoord     = new JLabel("0", JLabel.RIGHT);
  private JLabel YCoord     = new JLabel("0", JLabel.RIGHT);

  private int clickCount = 0;

  public StatusPanel()   {
    this.setLayout(new GridLayout(1,3));
    this.add(posText);
    this.add(XCoord);
    this.add(YCoord);
   }

   public void setCoordinates(int x, int y){
    XCoord.setText(""+x);
    YCoord.setText(""+y);
   }
}
