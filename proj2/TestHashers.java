import java.util.*;

public class TestHashers {
  public static void main(String[] args) throws Throwable {
    ArrayList<Hasher> hashers = new ArrayList<>();

    hashers.add(new Padcut());
    hashers.add(new ShiftHasher("shift+caesar", new Caesar()));
    hashers.add(new ShiftHasher("shift+vigenere", new Vigenere()));

    System.out.print("algorithm: ");
    String alg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();

    Hasher selected = null;
    for(int i = 0; i < hashers.size(); i++) {
      if(hashers.get(i).getAlgName().equals(alg)) {
        selected = hashers.get(i);
        break;
      }
    }

    if(selected == null) {
      throw new UnknownAlgorithmException(alg);
    }

    System.out.println("password read : " + new String(password));
    String result = selected.hash(password);
    System.out.println("hash computed : " + result);
  }
}
