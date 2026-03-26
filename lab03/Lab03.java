import java.util.*;

public class Lab03 {
  public static void main(String[] args) {
    String command = "";
    Scanner sc = new Scanner(System.in);
    command = sc.next();
    Point initial = Point.read(sc);
    Box B = new Box(initial);

    command = sc.next();
    while(!command.equals("done"))
    {
      if(command.equals("add"))
      {
        Point a = Point.read(sc);
        B.growBy(a);      
      }
      else if(command.equals("map"))
      {
        Point assist = Point.read(sc);
        Point mappt = B.mapIntoUnitSquare(assist);
        if(mappt == null)
        {
          System.out.println("error");
        }
        else 
        {
          System.out.println(mappt);
        }
      }
      else if(command.equals("box"))
      {
        String boxString = B.toString();
        System.out.println(boxString);
      }
      else
      {
        System.out.println("Error! Unknown command \"" + command + "\"!");
      }
      command = sc.next();
    }
  
    if(command.equals("done"))
      return;
  }
}
