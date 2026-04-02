public class Calc {
  private double loanAmt;
  private double interest;
  private double monthlyPayment;
  private int months;
  private double totalCost;

  public Calc(double amount, double rate, double payment) {
    this.loanAmt = amount;
    this.interest = rate;
    this.monthlyPayment = payment;
    calculate();
  }

  private void calculate() {
    double currentBalance = loanAmt;
    double totalPaid = 0;
    int monthCount = 0;

    while(currentBalance > 0) {
      monthCount++;
      double rate = currentBalance * interest / 1200.0;
      currentBalance += rate;

      currentBalance -= monthlyPayment;
      totalPaid += monthlyPayment;

      if(currentBalance <= 0) {
        double overpay = Math.abs(currentBalance);
        this.totalCost = totalPaid - overpay - loanAmt;
        this.months = monthCount;
      }
    }
  }

  public int getMonths() {
    return months;
  }

  public double getTotalCost() {
    return Math.round(totalCost * 100.0) / 100.0;
  }

  public static void main(String[] args) {
    if(args.length != 3) {
      System.out.println("usage: java Calc <amount> <rate> <payment>");
      return;
    }

    double amt = Double.parseDouble(args[0]);
    double rate = Double.parseDouble(args[1]);
    double pay = Double.parseDouble(args[2]);

    Calc calcs = new Calc(amt, rate, pay);
    System.out.println("months = " + calcs.getMonths() + "   cost = " + calcs.getTotalCost());
  }
}
