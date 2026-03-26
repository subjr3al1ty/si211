import java.io.*;
import java.util.*;

//Code developed by Aspen Harres (282604)
//Proj 2 pt. 1

public class Caesar implements Encryptor {
  private int shift;
  
  private final int minchar = 42;
  private final int maxchar = 122;
  private final int totrange = maxchar - minchar + 1;

  public String getAlgName() {
    return "caesar";
  }

  //this gives class Caesar the shift key amount so we don't have to keep
  //reloading it every time we call a function
  public void init(char[] key) {
    int sum = 0;
    for(int i = 0; i < key.length; i++) {
      validate(key[i], "key");
      sum += (int)key[i] - 42;
    }
    //sets shift as result
    this.shift = (18 + sum) % 81;

    if(this.shift < 0)
      this.shift += 81;
  }

  //encryption for plaintext
  public String encrypt(String plain) {
    String result = "";
    for(int i = 0; i < plain.length(); i++) {
      char c = plain.charAt(i);
      //make sure that there's no invalid chars
      validate(c, "plaintext");
      //use our cool new function to shift characters :)
      int p = (int) c - 42;
      int d = (p + shift) % 81;
      result += (char)(d + 42);
    }
    return result;
  }

  //decryption for ciphertext
  public String decrypt(String cipher) {
    String result = "";
    for(int i = 0; i < cipher.length(); i++) {
      char cc = cipher.charAt(i);
      validate(cc, "ciphertext");
      //cool new function again
      int c = (int)cc - 42;
      int p = (c + (81 - shift)) % 81;
      result += (char)(p + 42);
    }
    return result;
  }

  private void validate(char c, String context) {
    if(c < minchar || c > maxchar || c == '$') {
      //meow
      throw new InvalidCharacterException(c, context);
    }
  }
}
