import java.io.*;
import java.util.*;

public class Vault {
  public static void main(String[] args) {
    if(args.length != 1) {
      System.out.println("usage: java Vault [-au] <filename>");
      return;
    }

    String filename = args[0];
    List<UserRecord> users = new ArrayList<>();

    try {
      Scanner sc = new Scanner(new File(filename));
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] parts = parseLine(line);
        if(parts == null || !parts[0].equals("user")) {
          System.out.println("Error! File '" + filename + "' improperly formatted.");
          sc.close();
          return;
        }
        users.add(new UserRecord(parts[1], parts[2], parts[3]));
      }
      sc.close();

    } catch(FileNotFoundException e) {
      System.out.println("Error! File '" + filename + "' could not be opened.");
      return;
    } catch(Exception e) {
      System.out.println("Error! File '" + filename + "' improperly formatted.");
      return;
    }

    Console console = System.console();
    if(console == null) {
      System.out.println("Error! No console available.");
      return;
    }

    String username = console.readLine("username: ");
    System.out.print("password: ");
    char[] pwChars = console.readPassword();
    String password = new String(pwChars);

    UserRecord found = null;
    for(int i = 0; i < users.size(); i++) {
      UserRecord u = users.get(i);
      if(u.getUsername().equals(username)) {
        found = u;
        break;
      }
    }

    if(found == null || !validAscii(password)) {
      System.out.println("Access denied!");
      return;
    }

    String computedHash;

    try {
      computedHash = hashPassword(password, found.getHashAlg());
    } catch(UnsupportedOperationException e) {
      System.out.println("Error! Hash algorithm '" + found.getHashAlg() + "' not supported.");
      return;
    } catch(Exception e) {
      System.out.println("Exception thrown!");
      return;
    }

    if(!computedHash.equals(found.getHash())) {
      System.out.println("Access denied!");
      return;
    }

    System.out.println("Access granted!");

    while(true) {
      String cmd = console.readLine("> ");
      if(cmd.equals("quit")) {
        return;
      }
    }
  }

  private static String[] parseLine(String line) {
    String[] parts = new String[4];
    int partIndex = 0;

    int i = 0;
    int n = line.length();

    while(i < n && partIndex < 4) {
      while(i < n && line.charAt(i) == ' ') {
        i++;
      }
      if(i >= n) {
        break;
      }
      int start = i;
      while(i < n && line.charAt(i) != ' ') {
        i++;
      }

      parts[partIndex] = line.substring(start, i);
      partIndex++;
    }

    if(partIndex != 4) {
      return null;
    }

    return parts;
  }

  private static boolean validAscii(String s) {
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c < 42) 
        return false;
      
      if(c > 122) 
        return false;
    }
    return true;
  }

  //manage exception
  private static String hashPassword(String password, String algorithm) throws Exception {
    Hasher hasher;

    if(algorithm.equals("padcut")) {
      hasher = new Padcut();
    } else if(algorithm.equals("shift+caesar")) {
      hasher = new ShiftHasher("shift+caesar", new Caesar());
    } else if(algorithm.equals("shift+vigenere")) {
      hasher = new ShiftHasher("shift+vigenere", new Vigenere());
    } else {
      throw new UnsupportedOperationException();
    }

    return hasher.hash(password.toCharArray());
  }
}
