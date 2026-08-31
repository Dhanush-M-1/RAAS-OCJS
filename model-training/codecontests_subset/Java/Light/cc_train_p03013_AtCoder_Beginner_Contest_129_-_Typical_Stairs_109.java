import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    final int mod = 1000000007;

    int[] steps = new int[n + 1];

    for (int i = 0; i < m; ++i)
      steps[sc.nextInt()] = -1;

    steps[n] = 1;
    steps[n - 1] = (steps[n - 1] == -1) ? -1 : 1;

    for (int i = n - 2; i >= 0; --i) {
      if (steps[i] == -1)
        continue;
      steps[i] = (steps[i + 1] == -1) ? steps[i] : steps[i] % mod + steps[i + 1] % mod;
      steps[i] = (steps[i + 2] == -1) ? steps[i] : steps[i] % mod + steps[i + 2] % mod;
    }

    System.out.println(steps[0] % mod);
  }
}