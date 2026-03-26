// Encryptor providing the clear algorithm, which is to
// not change the plaintext at all.
public class Clear implements Encryptor {
  private final int minchar = 42;
  private final int maxchar = 122;

  public String getAlgName() { return "clear"; }
  public void   init(char[] key) {
    for(int i = 0; i < key.length; i++) {
      char c = key[i];
      validate(c, "key");
    }
  }
  public String encrypt(String plain) { 
    for(int i = 0; i < plain.length(); i++) {
      char c = plain.charAt(i);
      validate(c, "plaintext");
    }
    return plain;
  }
  public String decrypt(String cipher){ 
    for(int i = 0; i < cipher.length(); i++) {
      char c = cipher.charAt(i);
      validate(c, "ciphertext");
    }
    return cipher; 
  }

  private void validate(char c, String context) {
    if(c < minchar || c > maxchar) {
      throw new InvalidCharacterException(c, context);
    }
  }
}
