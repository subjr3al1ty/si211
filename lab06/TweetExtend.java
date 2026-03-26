//extender class :)

import si211.*;
import java.util.*;

public class TweetExtend extends TweetQueue {
  public void dumpFunc() {
    TweetQueue.Iter rawr = iterator();
    while(rawr.hasNext()) {
      System.out.println(rawr.next().toString());
    }
  }

  public TweetExtend filternorm(String s) {

    // create empty new queue
    TweetExtend moo = new TweetExtend();

    // loop through "this" queue and add to moo if it matches
    TweetQueue.Iter woof = iterator();
    int counter = 0;
    while(woof.hasNext()) {
      Tweet t = woof.next();
      if(t.getText().indexOf(s) != -1) {
	moo.enqueue(t);
        counter++;
      }
    }
    
    System.out.println(counter + " tweets");
    return moo;
  }

  public TweetExtend filterspe(String s) {
    TweetExtend moo = new TweetExtend();

    TweetQueue.Iter woof = iterator();
    int counter = 0;
    while(woof.hasNext()) {
      Tweet t = woof.next();
      if(t.getText().indexOf(s) == -1) {
        moo.enqueue(t);
        counter++;
      }
    }
    System.out.println(counter + " tweets");
    return moo;
  }

}
