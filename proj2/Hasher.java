public interface Hasher {
  public String getAlgName();
  public String hash(char[] input) throws Exception;
}
