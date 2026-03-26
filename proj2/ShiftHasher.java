public class ShiftHasher implements Hasher {
    private String name;
    private Encryptor encryptor;

    public ShiftHasher(String name, Encryptor enc) {
      this.name = name;
      this.encryptor = enc;
    }

    public String getAlgName() {
      return name;
    }

    public String hash(char[] input) throws Exception {
      String x = "GO_NAVY_2018^mid";
      encryptor.init(input);
      for(int i = 0; i < 16; i++) {
        char[] xChars = x.toCharArray();
        int k = ((int) xChars[i]) % 16;
        char[] shifted = new char[16];
        for(int j = 0; j < 16; j++) {
          shifted[j] = xChars[(j + k) % 16];
        }
        x = encryptor.encrypt(new String(shifted));
      }
      return x;
    }
}
