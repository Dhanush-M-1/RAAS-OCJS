import java.util.*;
import java.io.*;

/**
 * created at 10/22/17 10:23 PM
 */

public class P670B {

  private static void solve() {
    int n = nextInt();
    int k = nextInt();

    int start = 1, end = n;

    int mid = -1;
    while (start <= end) {
      mid = (start + end) / 2;

      long sum = sum(mid);
      long prev = sum(mid - 1);

      if(prev < k && k <= sum) {
        break;
      }

      if(sum < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    int cnt = (int) (k - sum(mid - 1));
    for (int i = 0; i < cnt - 1; i++) {
      nextInt();
    }
    System.out.println(nextInt());

  }

  private static long sum(int n) {
    if(n <= 0) return 0;
    return ((long)n * (n + 1)) / 2;
  }

  private static void run() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    solve();

    out.close();
  }

  private static StringTokenizer st;
  private static BufferedReader br;
  private static PrintWriter out;

  private static String next() {
    while (st == null || !st.hasMoreElements()) {
      String s;
      try {
        s = br.readLine();
      } catch (IOException e) {
        return null;
      }
      st = new StringTokenizer(s);
    }
    return st.nextToken();
  }

  private static int nextInt() {
    return Integer.parseInt(next());
  }

  private static long nextLong() {
    return Long.parseLong(next());
  }

  public static void main(String[] args) {
    run();
  }
}