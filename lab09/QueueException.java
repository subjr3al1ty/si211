//make a new exception class to throw a new type of exception (QueueException)
public class QueueException extends RuntimeException {
  public QueueException(String msg) {
    super(msg);
  }
}

