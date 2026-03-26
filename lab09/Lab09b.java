import java.util.*;
import java.io.*;

public class Lab09b {
  public static void main(String[] args)
  {
    Scanner sc = null;
    boolean verbose = false;
    boolean fromFile = false;

    for(int i = 0; i < args.length; i++) {
      if(args[i].equals("-v"))
        verbose = true;
      else {
        try {
          sc = new Scanner(new FileReader(args[i]));
          fromFile = true;
        } catch (IOException e) {
          System.out.println("File '" + args[i] + "' could not be opened; switching input to standard in.");
        }
      }
    }

    if(sc == null)
      sc = new Scanner(System.in);

    ModQueue Q = new ModQueue();
    
    do {
      if(!fromFile)
        System.out.print("> ");
      String s;
      try {
          s = sc.next();
      }
      catch(NoSuchElementException e) {
        break;
      }

      if (s.equals("quit")) 
	break;
      else if (s.equals("clearto"))
      {
        try {
          String x = sc.next();
          try {
            Q.dequeue(x);
          }
          catch (QueueException e) {
            if(verbose)
              System.out.println("String '" + x + "' not found!");
          }
        }
        catch (NoSuchElementException e) {
          System.out.println("Unexpected end of input.");
          return;
        }
      }

      else if (s.equals("add"))
      {
	try {
          Q.enqueue(sc.next());
        } catch (NoSuchElementException e) {
          System.out.println("Unexpected end of input.");
          return;
        }
      }
      else if (s.equals("dump"))
      {
        try {
	  System.out.println(Q.dump());
        } catch (QueueException e) {
        }
      }
      else {
        if(verbose)
          System.out.println("Unknown command '" + s + "'.");
        else if(!verbose)
          continue;
      }
    }while(true);
  }
     
}
