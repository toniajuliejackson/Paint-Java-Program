package GUIAssignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*public class BackgroundColourDialog extends JDialog
{
  private JPanel mainPanel           = new JPanel();
  private JTextField magTF = new JTextField();
  private JRadioButton magButton     = new JRadioButton("Mag");
  private JTextField redTF = new JTextField();
  private JRadioButton redButton     = new JRadioButton("Red");
  private JTextField yellowTF = new JTextField();
  private JRadioButton yellowButton     = new JRadioButton("Yellow");
  private JTextField blueTF = new JTextField();
  private JRadioButton blueButton     = new JRadioButton("Blue");
  private JButton okButton       = new JButton("OK");
  private JButton cancelButton       = new JButton("Cancel");
  private ButtonGroup group = new ButtonGroup();

  public void SBackgroundColourDialog(Frame frame)
  {
    super(frame,"Background Colour dialog",true);

    this.getContentPane().setLayout(new BorderLayout());
    this.setLocation(300,300);
    this.getContentPane().add(mainPanel,BorderLayout.CENTER);

    mainPanel.setLayout(new GridLayout(4,2,10,0));
    mainPanel.add(magTF);
    mainPanel.add(magButton);
    mainPanel.add(redTF);
    mainPanel.add(redButton);
    mainPanel.add(yellowTF);
    mainPanel.add(yellowButton);
    mainPanel.add(blueTF);
    mainPanel.add(blueButton);


    SearchListener SLis = new SearchListener();
    searchButton.addActionListener(SLis);
    cancelButton.addActionListener(SLis);

    this.pack();
  }

// Internal class
  class SearchListener implements ActionListener
  {
   // No constructor defined, default constructor is used

   public void actionPerformed(ActionEvent evt)
     {
       String command = evt.getActionCommand();
       if(command.equals("Cancel"))
       {
        dataTransfer.setAll(searchText,caseSensitive,false);
        //Note that  setVisible  is a method of class SearchDialog,
        //not of the internal class SearchListener!
        setVisible(false);
       }
       else if (command.equals("OK"))
       {
        dataTransfer.setAll(searchText,caseSensitive,true);
        setVisible(false);
       }
     }
  }// internal class
}*/

