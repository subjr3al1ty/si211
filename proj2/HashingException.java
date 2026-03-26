public class HashingException extends Exception {
  public HashingException(String message) {
    super(message);
  }
}

class InvalidKeyException extends HashingException {
  public InvalidKeyException(char c) {
    super("error " + c + " not allowed in key");
  }
}

class UnknownAlgorithmException extends HashingException {
  public UnknownAlgorithmException(String alg) {
    super("Unkown algorithm '" + alg + "'");
  }
}
