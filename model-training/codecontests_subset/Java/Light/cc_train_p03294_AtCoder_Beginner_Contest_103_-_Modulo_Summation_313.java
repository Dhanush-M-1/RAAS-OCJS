import java.util.Scanner;

public class Main {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    new Main().solve();
  }


  private void solve() {
    int N = sc.nextInt();
    int ans = 0;
    for (int i = 0; i < N; i++) {
      ans += sc.nextInt() - 1;
    }

    System.out.println(ans);
  }
}