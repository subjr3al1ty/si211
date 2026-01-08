import java.util.*;

public class Lab1c {
    public static int factorial(int k) {
    int tot = 1;
    for(int i = k; i > 0; i--)
    {
      tot *= i;
    }
    return tot;
  }
  public static int numerator(int n, int k) {
    int m = n;
    int tot = 1;
    while(m >= (n - k + 1))
    {
      tot *= m;
      m--;
    }
    return tot;
  }
  public static void main(String[] args) {
    String name = "";
    for(int i = 0; i < args.length - 3; i++)
    {
      name += args[i] + " ";
    }
    name += args[args.length - 3];
    

    int n = Integer.parseInt(args[args.length - 2]);
    int k = Integer.parseInt(args[args.length - 1]);
    System.out.println("The two ints were " + n + " and " + k);
    
    //denominator
    int denom = factorial(k);

    //numerator
    int num = numerator(n, k);


    System.out.println("numerator = " + num);
    System.out.println("denominator = " + denom);
    
    //calculate odds
    int odds = num / denom;
    double calc = 1.0 / (double)odds;
    System.out.println("odds = 1 in " + odds + " = " + calc);
    System.out.println("Goodbye " + name + ".");
  }
}
