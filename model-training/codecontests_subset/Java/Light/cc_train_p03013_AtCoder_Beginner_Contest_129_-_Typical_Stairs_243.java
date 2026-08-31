import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    new Main().run();
  }

  private Scanner sc = new Scanner(System.in);

  int N;
  int M;
  long[] memo;
  boolean[] broken;

  private long dfs(int pos) {
    if (pos > N) {
      return 0L;
    }
    if (broken[pos]) {
      return 0L;
    }
    if (pos == N) {
      return 1L;
    }
    if (memo[pos] != -1) {
      return memo[pos];
    }

    long res = dfs(pos + 1) + dfs(pos + 2);

    return memo[pos] = res % 1000000007L;
  }

  private void run() {
    N = Integer.parseInt(sc.next());
    M = Integer.parseInt(sc.next());
    broken = new boolean[N + 5];
    for (int i = 0; i < M; i++) {
      int tmp = Integer.parseInt(sc.next());
      broken[tmp] = true;
    }

    memo = new long[N + 5];
    for (int i = 0; i < N + 5; i++) {
      memo[i] = -1;
    }

    long ans = dfs(0);
    System.out.println(ans);

  }
}
