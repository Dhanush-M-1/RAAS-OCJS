import java.util.Scanner;

public class Main {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    
    while (in.hasNext()) {
      int N = in.nextInt();
      int f = 0;

      for (int i = 0; i < N; ++i) {
        f += in.nextInt() - 1;
      }

      System.out.println(f);
    }
  }
}