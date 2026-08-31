import java.util.*;
import java.io.*;

public class CFC {
  BufferedReader br;
  PrintWriter out;
  StringTokenizer st;
  boolean eof;
  private static final long MOD = 1000L * 1000L * 1000L + 7;
  private static final int[] dx = {0, -1, 0, 1};
  private static final int[] dy = {1, 0, -1, 0};
  private static final String yes = "Yes";
  private static final String no = "No";

  long[][] dp;
  void solve() {
    int LIMIT = 200 * 1000 + 100;
    dp = new long[10][LIMIT];
    for (int i = 0; i < 10; i++) {
      long[] start = new long[10];
      start[i]++;
      for (int j = 0; j < LIMIT; j++) {
        for (int k = 0; k < 10; k++) {
          dp[i][j] += start[k];
          dp[i][j] %= MOD;
        }

        long[] nxt = new long[10];
        for (int k = 0; k < 10; k++) {
          if (k != 9) {
            nxt[k + 1] += start[k];
          } else {
            nxt[0] += start[k];
            nxt[1] += start[k];
          }
        }
        for (int k = 0; k < 10; k++) {
          nxt[k] = nxt[k] % MOD;
        }
        start = nxt;
      }
    }

    int T = nextInt();
//    int T = 200 * 1000;
    for (int i = 0; i < T; i++) {
      helper();
    }
  }

  void helper() {
    String[] str = nextString().split(" ");
    int m = Integer.parseInt(str[1]);
    long res = 0;
    for (int i = 0; i < str[0].length(); i++) {
      res += dp[str[0].charAt(i) - '0'][m];
    }
    outln(res % MOD);
  }

  void shuffle(long[] a) {
    int n = a.length;
    for(int i = 0; i < n; i++) {
      int r = i + (int) (Math.random() * (n - i));
      long tmp = a[i];
      a[i] = a[r];
      a[r] = tmp;
    }
  }
  long gcd(long a, long b) {
    while(a != 0 && b != 0) {
      long c = b;
      b = a % b;
      a = c;
    }
    return a + b;
  }
  private void outln(Object o) {
    out.println(o);
  }
  private void out(Object o) {
    out.print(o);
  }
  private void formatPrint(double val) {
    outln(String.format("%.9f%n", val));
  }
  public CFC() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.close();
  }
  public static void main(String[] args) {
    new CFC();
  }

  public long[] nextLongArr(int n) {
    long[] res = new long[n];
    for(int i = 0; i < n; i++)
      res[i] = nextLong();
    return res;
  }
  public int[] nextIntArr(int n) {
    int[] res = new int[n];
    for(int i = 0; i < n; i++)
      res[i] = nextInt();
    return res;
  }
  public String nextToken() {
    while (st == null || !st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (Exception e) {
        eof = true;
        return null;
      }
    }
    return st.nextToken();
  }
  public String nextString() {
    try {
      return br.readLine();
    } catch (IOException e) {
      eof = true;
      return null;
    }
  }
  public int nextInt() {
    return Integer.parseInt(nextToken());
  }
  public long nextLong() {
    return Long.parseLong(nextToken());
  }
  public double nextDouble() {
    return Double.parseDouble(nextToken());
  }
}
