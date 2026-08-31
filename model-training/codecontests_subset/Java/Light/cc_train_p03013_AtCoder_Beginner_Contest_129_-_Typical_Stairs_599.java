import java.util.Scanner;

public class Main {
  private static final int mod = 1_000_000_007;
  private static void solve(int n, int m, int[] a) {
    int brokenIndex = 0;
    int[] steps = new int[n + 1];
    steps[0] = 1;
    if (brokenIndex < m && a[brokenIndex] == 1) {
      brokenIndex++;
    } else {
      steps[1] = 1;
    }
    for (int i = 2; i <= n; i++) {
      if (brokenIndex < m && a[brokenIndex] == i) {
        steps[i] = 0;
        brokenIndex++;
      } else {
        steps[i] = steps[i - 1] + steps[i - 2];
        if (steps[i] >= mod) steps[i] -= mod;
      }
    }
    System.out.println(steps[n]);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] nums = sc.nextLine().split(" ");
    int n = Integer.parseInt(nums[0]);
    int m = Integer.parseInt(nums[1]);
    int[] a = new int[m];
    for (int i = 0; i < m; i++) a[i] = Integer.parseInt(sc.nextLine());
    sc.close();
    solve(n, m, a);
  }
}