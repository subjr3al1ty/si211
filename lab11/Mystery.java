import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener
{
  private JLabel label;
  private boolean isRunning = false;

  public Mystery(JLabel label) { this.label = label; }
  
  public void actionPerformed(ActionEvent e)
  {
    if(isRunning)
      return;

    Thread t = new Thread(new Runnable() {
      public void run() {
        isRunning = true;
        CChange.changeColor(label);
        isRunning = false;
      }
    });
    t.start();
  }
}

