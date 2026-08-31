import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] as = new int[n + 1];
    int[] bs = new int[n + 1];
    int[] cs = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      as[i] = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      bs[i] = sc.nextInt();
    }

    for (int i = 1; i < n; i++) {
      cs[i] = sc.nextInt();
    }

    int sum = 0;
    int x = 0;

    for (int i = 1; i <= n; i++) {
      sum += bs[as[i]];
      if (i > 1 & as[i] - as[i - 1] == 1) {
        sum += cs[as[i - 1]];
      }
    }

    System.out.println(sum);
  }
}
