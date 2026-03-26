public class InvalidCharacterException extends EncryptionException {
  public InvalidCharacterException(char c, String context) {
    super("error " + c + " not allowed in " + context);
  }
}
