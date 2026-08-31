import java.util.*;
import java.io.*;

public class Practice {
  BufferedReader br;
  PrintWriter out;
  StringTokenizer st;
  boolean eof;
  private static final long MOD = 1000L * 1000L * 1000L + 7;
  private static final int[] dx = {0, -1, 0, 1};
  private static final int[] dy = {1, 0, -1, 0};
  private static final String yes = "Yes";
  private static final String no = "No";

  void solve() {
    int T = 1;
//    int T = nextInt();
    for (int i = 0; i < T; i++) {
      helper();
    }
  }

  void helper() {
    int n = nextInt();
    int[] soda = nextIntArr(n);
    int[] volume = nextIntArr(n);
    int[] volumeCopy = Arrays.copyOf(volume, n);

    int sumSoda = 0;
    for (int v : soda) {
      sumSoda += v;
    }
    Arrays.sort(volume);
    int cnt = 0;
    int acc = 0;
    for (int i = 0; i < n; i++) {
      acc += volume[n - 1 - i];
      cnt++;
      if (acc >= sumSoda) {
        break;
      }
    }

    int LIMIT = 100 * 100 + 10;
    // First i bottles, picked j bottle and sum of volume is k -> maximum soda.
    int[][] dp = new int[cnt + 1][LIMIT];
    for (int i = 0; i <= cnt; i++) {
      Arrays.fill(dp[i], -1);
    }
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      int[][] nxt = new int[cnt + 1][LIMIT];
      for (int j = 0; j <= cnt; j++) {
        Arrays.fill(nxt[j], -1);
      }

      for (int j = 0; j <= cnt; j++) {
        for (int k = 0; k < LIMIT; k++) {
          if (dp[j][k] == -1) {
            continue;
          }
          // Pick bottle i.
          if (j + 1 <= cnt && k + volumeCopy[i] < LIMIT) {
            nxt[j + 1][k + volumeCopy[i]] = Math.max(nxt[j + 1][k + volumeCopy[i]], dp[j][k] + soda[i]);
          }

          // Do not pick bottle i.
          nxt[j][k] = Math.max(nxt[j][k], dp[j][k]);
        }
      }
      dp = nxt;
    }

    int res = Integer.MAX_VALUE;
    for (int i = sumSoda; i < LIMIT; i++) {
      if (dp[cnt][i] != -1) {
        res = Math.min(res, sumSoda - dp[cnt][i]);
      }
    }

    outln(cnt + " " + res);
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
  public Practice() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.close();
  }
  public static void main(String[] args) {
    new Practice();
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