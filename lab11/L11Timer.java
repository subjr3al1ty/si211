import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11Timer extends JPanel {
  private JLabel display;
  private JTextField input;
  private JButton startButton;
  private boolean isRunning = false;

  public L11Timer() {
    display = new JLabel("DONE");
    display.setPreferredSize(new Dimension(100, 50));
    input = new JTextField("10", 5);
    startButton = new JButton("start");
    Color colorful = new Color(155, 83, 80);
    startButton.setBackground(colorful);

    this.add(display);
    this.add(input);
    this.add(startButton);

    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        startCountdown();
      }
    });
  }

  private void startCountdown() {
    if(isRunning)
      return;

    String text = input.getText();
    final int seconds;

    try {
      seconds = Integer.parseInt(text);
      if(seconds < 0) throw new NumberFormatException();
    } catch(NumberFormatException e) {
      display.setText("ERROR");
      return;
    }
    Thread timerThread = new Thread(new Runnable() {
      public void run() {
        isRunning = true;
        for(int i = seconds; i > 0; i--) {
          display.setText(Integer.toString(i));
          try {
            Thread.sleep(1000);
          }catch(InterruptedException e) {
            return;
          }
        }
        display.setText("DONE");
        isRunning = false;
      }
    });
    timerThread.start();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Lab 11 - Timer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    Color custom = new Color(161,150,149);
    frame.getContentPane().setBackground(custom);

    L11Timer myTimer = new L11Timer();
    frame.add(myTimer);

    frame.pack();
    frame.setVisible(true);
  }
}


