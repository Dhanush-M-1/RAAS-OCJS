import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Main {

  private void solve(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();

    FenwickTree bit = new FenwickTree(M + 2);

    int[] l = new int[N];
    int[] r = new int[N];
    ArrayList<Integer>[] buckets = new ArrayList[M + 1];
    for (int i = 1; i <= M; i++) {
      buckets[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      l[i] = in.nextInt();
      r[i] = in.nextInt();
      int w = r[i] - l[i] + 1;
      buckets[w].add(i);
    }

    int gone = 0;
    for (int d = 1; d <= M; d++) {
      for (int i : buckets[d]) {
        gone++;
        bit.add(l[i], 1);
        bit.add(r[i] + 1, -1);
      }

      int ans = N - gone;
      for (int m = d; m <= M; m += d) {
        ans += bit.sum(m + 1);
      }
      out.println(ans);
    }
  }

  public class FenwickTree {

    int N;
    long[] data;

    FenwickTree(int N) {
      this.N = N + 1;
      data = new long[N + 1];
    }

    void add(int k, long val) {
      for (int x = k; x < N; x |= x + 1) {
        data[x] += val;
      }
    }

    // [0, k)
    long sum(int k) {
      if (k >= N) {
        k = N - 1;
      }
      long ret = 0;
      for (int x = k - 1; x >= 0; x = (x & (x + 1)) - 1) {
        ret += data[x];
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new Main().solve(in, out);
    in.close();
    out.close();
  }
}
