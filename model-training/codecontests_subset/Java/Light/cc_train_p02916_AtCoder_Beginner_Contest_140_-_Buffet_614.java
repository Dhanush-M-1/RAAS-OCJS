import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] b = new boolean[n];
    int ans = 0;
    int pre = 0;

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      if (pre == (a - 1)) {
        b[pre] = true;
      }
      pre = a;
    }

    for (int i = 0; i < n; i++) {
      ans += sc.nextInt();
    }

    for (int i = 1; i < n; i++) {
      int c = sc.nextInt();
      if (b[i]) {
        ans += c;
      }
    }

    System.out.println(ans);

  }
}