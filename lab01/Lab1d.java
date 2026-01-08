import java.util.*;

public class Lab1d {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Guess a number between 0 and 10: ");
    Random rand = new Random(System.currentTimeMillis());
    int k = 10;
    int correctGuess = rand.nextInt(k);
    
    int guessCount = 1;
    String[] snarkyMessage = {"Good job... ", "Wow that was bad ", "Are you trying? ", "Uh... ", "Well this is awkward. ", "It can't be that hard. " , "LOCK IN. ", "Now I just feel bad... ", "This is sad to watch. ", "Never play this again. "};
    
    int guess = in.nextInt();
    while(guess != correctGuess)
    {
      System.out.print(snarkyMessage[guessCount - 1] + "Guess again: ");
      guessCount++;
      guess = in.nextInt();
    }
    if(guess == correctGuess)
    {
      System.out.print("Right after " + guessCount + " guesses!\n");
    }
  }
}
