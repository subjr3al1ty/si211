import java.util.*;

public class NRRandom extends Random {
  private int last;

  public NRRandom(long seed) {
    super(seed);
    last = -1;
  }

  public int nextInt(int num) {
    int curr = 0;
    
    do {
      curr = super.nextInt(num);
    } while(curr == last);    

    last = curr;
    return curr;
  }
}
