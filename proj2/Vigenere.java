import java.io.*;
import java.util.*;

//Code developed by Aspen Harres (282604)
//Project 2 pt 1

public class Vigenere implements Encryptor {
  private char[] key;
  private final int minchar = 42;
  private final int maxchar = 122;
  private final int totrange = 81;

  public String getAlgName() {
    return "vigenere";
  }

  public void init(char[] keyIn) {
    this.key = new char[keyIn.length];
    for(int i = 0; i < keyIn.length; i++) {
      validate(keyIn[i], "key");
      this.key[i] = keyIn[i];
    }
  }

  public String encrypt(String plain) {
    String result = "";
    int n = key.length;
    for(int i = 0; i < plain.length(); i++) {
      char pc = plain.charAt(i);
      validate(pc, "plaintext");

      char sc = key[i % n];
      int k = (int)sc - minchar;
      int p = (int)pc - minchar;
      int c = (p + k) % totrange;

      result += (char)(c + minchar);
    }
    return result;
  }

  public String decrypt(String cipher) {
    String result = "";
    int n = key.length;
    for(int i = 0; i < cipher.length(); i++) {
      char cc = cipher.charAt(i);
      validate(cc, "ciphertext");

      char sc = key[i % n];

      int k = (int)sc - minchar;
      int c = (int)cc - minchar;
      int p = (c + (totrange - k)) % totrange;

      result += (char)(p + minchar);
    }
    return result;
  }

  private void validate(char c, String context) {
    if(c < minchar || c > maxchar || c == '$') {
      throw new InvalidCharacterException(c, context);
    }
  }
}
