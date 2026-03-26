//Part 1 of SI211 Project 1
//Code developed by Aspen Harres (282604)

import java.io.*;
import java.util.*;

public class Proj01 {
  public static void main(String[] args) {
    //read the filename from the command line
    //then set up the array to set up for the 11 sections
    String fname = args[0];
    Section[] section = new Section[11];

    try(Scanner filesc = new Scanner(new FileReader(fname))) {
    //read in all the information in the file
      for(int i = 0; i < 11; i++) {
        String name = filesc.next();
        String sec = filesc.next();
        String days = filesc.next();
        String location = filesc.next();
        //set up new sections
        section[i] = new Section(name, sec, days, location);
      }
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    //make the users able to use commands
    Scanner users = new Scanner(System.in);
    String cmd;
    while(true) {
      System.out.print("> ");
      if(!users.hasNext()) break;

      //read in the command
      cmd = users.next();
      if(cmd.equals("quit")) {
        break;
      } else if (cmd.equals("sections")) {
        String sname = users.next();
        //search the array for the matching string
        for(int i = 0; i < 11; i++) {
          if(section[i].getName().equals(sname)) {
            System.out.println(section[i].toString());
          }
        }
      } else {
        System.out.println("Unknown command: " + cmd);
      }
    }
  }
}
