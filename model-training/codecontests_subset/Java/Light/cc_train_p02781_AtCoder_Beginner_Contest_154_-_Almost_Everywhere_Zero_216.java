
public class Main {

  private static void solve() {
    char[] n = ns();
    int k = ni();
    System.out.println(solve(n, k));

    // for (int n = 1; n < 1000; n++) {
    // for (int k = 1; k <= 3; k++) {
    // long ret1 = solve(("" + n).toCharArray(), k);
    // long ret2 = solve2(n, k);
    //
    // if (ret1 != ret2) {
    // System.out.println(n + " " + k + " " + ret1 + " " + ret2);
    // // return;
    // }
    // }
    // }
  }

  private static long solve2(int n, int k) {
    long ret = 0;
    for (int i = 1; i <= n; i++) {
      char[] s = ("" + i).toCharArray();
      int nz = 0;
      for (char c : s) {
        if (c != '0') {
          nz++;
        }
      }
      if (nz == k) {
        ret++;
      }
    }
    return ret;
  }

  private static long solve(char[] n, int k) {
    int m = n.length;
    int zc = 0;
    for (int i = 0; i < m; i++) {
      n[i] -= '0';
      if (n[i] == 0) {
        zc++;
      }
    }
    // if (zc == m - 1 && )

    long[][][] dp = new long[m + 1][k + 1][2];
    dp[0][0][0] = 1;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= k; j++) {
        if (j < k) {
          for (int d = 1; d <= 9; d++) {
            dp[i + 1][j + 1][1] += dp[i][j][1];

            if (d == n[i]) {
              dp[i + 1][j + 1][0] += dp[i][j][0];
            } else if (d < n[i]) {
              dp[i + 1][j + 1][1] += dp[i][j][0];
            }
          }
        }

        // digit 0
        dp[i + 1][j][1] += dp[i][j][1];

        if (0 == n[i]) {
          dp[i + 1][j][0] += dp[i][j][0];
        } else if (0 < n[i]) {
          dp[i + 1][j][1] += dp[i][j][0];
        }
      }
    }
    return (dp[m][k][0] + dp[m][k][1]);
  }

  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() {
        long start = System.currentTimeMillis();
        String debug = args.length > 0 ? args[0] : null;
        if (debug != null) {
          try {
            is = java.nio.file.Files.newInputStream(java.nio.file.Paths.get(debug));
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
        reader = new java.io.BufferedReader(new java.io.InputStreamReader(is), 32768);
        solve();
        out.flush();
        tr((System.currentTimeMillis() - start) + "ms");
      }
    }, "", 64000000).start();
  }

  private static java.io.InputStream is = System.in;
  private static java.io.PrintWriter out = new java.io.PrintWriter(System.out);
  private static java.util.StringTokenizer tokenizer = null;
  private static java.io.BufferedReader reader;

  public static String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new java.util.StringTokenizer(reader.readLine());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  private static double nd() {
    return Double.parseDouble(next());
  }

  private static long nl() {
    return Long.parseLong(next());
  }

  private static int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = ni();
    return a;
  }

  private static char[] ns() {
    return next().toCharArray();
  }

  private static long[] nal(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nl();
    return a;
  }

  private static int[][] ntable(int n, int m) {
    int[][] table = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[i][j] = ni();
      }
    }
    return table;
  }

  private static int[][] nlist(int n, int m) {
    int[][] table = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[j][i] = ni();
      }
    }
    return table;
  }

  private static int ni() {
    return Integer.parseInt(next());
  }

  private static void tr(Object... o) {
    if (is != System.in)
      System.out.println(java.util.Arrays.deepToString(o));
  }
}

