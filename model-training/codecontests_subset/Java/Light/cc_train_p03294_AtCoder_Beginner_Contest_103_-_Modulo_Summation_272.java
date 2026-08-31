import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      int n = scanner.nextInt();
      int ans = 0;
      for (int i = 0; i < n; i++) {
        int a = scanner.nextInt();
        ans += --a;
      }
      System.out.println(ans);
    } finally {
      scanner.close();
    }
  }
}