import java.util.*;

public class Box {
  private double minX;
  private double maxX;
  private double minY;
  private double maxY;

  public Box(Point p)
  {
    this.minX = p.getX();
    this.maxX = p.getX();
    this.minY = p.getY();
    this.maxY = p.getY();
  }

  public Box(Point a, Point b)
  {
   this.minX = Math.min(a.x, b.x);
   this.maxX = Math.max(a.x, b.x);
   this.minY = Math.min(a.y, b.y);
   this.maxY = Math.max(a.y, b.y);
  }

  public String toString()
  {
    String nowString = minX + " < x < " + maxX + ", " + minY + " < y < " + maxY;
    return nowString;
  }

  public void growBy(Point p)
  {
    if(p.x < minX || p.x > maxX || p.y < minY || p.y > maxY)
    {
      this.minX = Math.min(minX, p.x);
      this.maxX = Math.max(maxX, p.x);
      this.minY = Math.min(minY, p.y);
      this.maxY = Math.max(maxY, p.y);
    }
  }

  public Point mapIntoUnitSquare(Point p)
  {
    if(p.x < minX || p.x > maxX || p.y < minY || p.y > maxY)
      return null;
    double ux = (p.x - minX) / (maxX - minX);
    double uy = (p.y - minY) / (maxY - minY);
    return new Point(ux, uy);
  }

  public static void main(String[] args)
  {
    Point p = new Point(0,0);
    Point meow = new Point (2,2);
    Box B = new Box(p, meow);
    String s = B.toString();
    System.out.println(s);
    Point woof = new Point(1,1.5);
    Point moo = B.mapIntoUnitSquare(woof);
    System.out.println(moo);

    Point croak = new Point(-1,-2);
    B.growBy(croak);
    System.out.println(B.toString());
  }
}
