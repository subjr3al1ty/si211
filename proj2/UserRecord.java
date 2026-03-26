public class UserRecord {
  private String username;
  private String hashalg;
  private String hash;

  public UserRecord(String u, String h, String hash) {
    this.username = u;
    this.hashalg = h;
    this.hash = hash;
  }

  public String getUsername() {
    return this.username;
  }

  public String getHashAlg() {
    return this.hashalg;
  }

  public String getHash() {
    return this.hash;
  }
}
