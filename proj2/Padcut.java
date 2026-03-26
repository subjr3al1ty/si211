public class Padcut implements Hasher {
  public String getAlgName() {
    return "padcut";
  }

  public String hash(char[] input) throws Exception {
    for(int i = 0; i < input.length; i++) {
      if(input[i] == '$' || input[i] == '!') {
        throw new InvalidKeyException(input[i]);
      }
    }

    char[] result = new char[16];
    for(int i = 0; i < 16; i++) {
      if(i < input.length) {
        result[i] = input[i];
      } else {
        result[i] = 'x';
      }
    }
    return new String(result);
  }
}
