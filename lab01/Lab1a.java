public class Lab1a {
  public static void main(String[] args) {
    int[] x = new int[10];
    int k = 0;
    for(int i = 0; i < 10; i++)
    {
      x[k] = k*k;
      System.out.println(i + " squared is " + x[i]);
      k++;
    }
  }
}
