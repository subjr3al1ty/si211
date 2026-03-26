import java.util.*;

public class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public static Point read(Scanner sc)
  {
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    return new Point(x,y);
  }
  public String toString()
  {
    String nowString = x + " " + y;
    return nowString;
  }
  public double getX()
  {
    return x;
  }
  public double getY()
  {
    return y;
  }
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    Point a = new Point(3,5);
    System.out.println(a.toString());
    System.out.println("Enter a point lolz: ");
    Point meow = read(sc);
    System.out.println(meow.toString());

  }
}
