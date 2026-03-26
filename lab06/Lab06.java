/*******************************************
 * Aspen Harres
 * Jonathan Marshall
 ******************************************/

import si211.*;
import java.util.*;
import java.io.*;

public class Lab06
{
  public static void main(String[] args) {
    if(args.length == 0) {
      System.out.println("useage: java Lab06 <filename>");
      return;
    }

    String fname = args[0];

    //read in and count num of tweets
    TweetExtend meow = new TweetExtend();
    int counter = 0;

    try(Scanner filesc = new Scanner(new FileReader(fname))) {
      while(filesc.hasNext()) {
        Tweet tw = Tweet.read(filesc);
        if(tw != null) {
          meow.enqueue(tw);
          counter++;
        }
      }
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    System.out.println(counter + " tweets");

    //command line :)
    Scanner users = new Scanner(System.in);
    String cmd;
    TweetExtend quack = new TweetExtend();
    quack = meow;
    while(true) {
      System.out.print("> ");
      if(!users.hasNext()) break;

      cmd = users.next();
      if(cmd.equals("quit")) {
        break;
      } else if(cmd.equals("dump")) {
        meow.dumpFunc();
      } else if(cmd.equals("filter")) {
        //keeps everything that has the keyword
        String ask = users.next();
        quack = meow.filternorm(ask);
        meow = quack;
      } else if(cmd.equals("filter!")) {
        //keeps everything that doesn't have the keyword
        String ask = users.next();
        quack = meow.filterspe(ask);
        meow = quack;
      } else if(cmd.equals("reset")) {

      }else {
        System.out.println("Unknown command: " + cmd);
      }
    }
  }
}
