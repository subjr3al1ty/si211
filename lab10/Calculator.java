import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
  private JTextField amount;
  private JComboBox<Double> interestRate;
  private JTextField payment;
  private JTextField monthsResult;
  private JTextField costResult;
  private final Double[] rates = {3.50, 3.75, 4.00, 4.25, 4.50, 4.75,
  5.00, 5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 7.00, 7.25, 7.50, 26.00};
  
  public Calculator() {
    super("loan calculator");

    Color customColor = new Color(0x5c2326);

    

    amount = new JTextField("100.00");
    interestRate = new JComboBox<>(rates);
    payment = new JTextField("200.00");
    monthsResult = new JTextField(8);
    monthsResult.setEditable(false);
    costResult = new JTextField(8);
    costResult.setEditable(false);
    JButton calcButton = new JButton("calculate");
    

    JPanel pan = new JPanel(new FlowLayout());
    pan.add(new JLabel("loan amount "));
    pan.add(amount);
    pan.add(new JLabel("interest rate "));
    pan.add(interestRate);
    pan.add(new JLabel("monthly payment "));
    pan.add(payment);
    
    JPanel gr = new JPanel(new FlowLayout());
    JPanel br = new JPanel(new FlowLayout());
    JPanel meow = new JPanel(new FlowLayout());
    br.add(new JLabel("months to payoff "));
    br.add(monthsResult);
    gr.add(new JLabel("cost "));
    gr.add(costResult);
    meow.add(calcButton);
    
    this.setLayout(new BorderLayout());
    this.add(pan, BorderLayout.NORTH);
    this.add(gr, BorderLayout.SOUTH);
    this.add(br, BorderLayout.CENTER);
    this.add(meow, BorderLayout.EAST);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    calcButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double amt = Double.parseDouble(amount.getText());
        double rate = (Double)interestRate.getSelectedItem();
        double pay = Double.parseDouble(payment.getText());

        Calc calculation = new Calc(amt, rate, pay);

        monthsResult.setText(String.valueOf(calculation.getMonths()));
        costResult.setText("$" + String.format("%.2f",
        calculation.getTotalCost()));
      }
    });

    this.pack();
    this.setSize(700, 150);
  }

  public static void main(String[] args) {
    new Calculator().setVisible(true);
  }
}



