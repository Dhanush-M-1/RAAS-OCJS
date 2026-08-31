import java.util.*;
import java.io.*;

public class P1107D {

  private static String[] hex = {
    "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
      "1110", "1111"
  };

  private static void solve() {
    int n = nextInt();

    Set<Integer> factors = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        factors.add(i);
      }
    }

    char[][] g = new char[n][n];

    for (int i = 0; i < n; i++) {
      char[] x = next().toCharArray();
      int l = 0;
      for (int j = 0; j < x.length; j++) {
        int index = x[j] - '0';
        if (x[j] >= 'A' && x[j] <= 'F') {
          index = x[j] - 'A' + 10;
        }

        char[] tmp = hex[index].toCharArray();
        for (int k = 0; k < 4; k++) {
          g[i][l++] = tmp[k];
        }
      }
    }

    int[][] rs = new int[n][n];
    for (int i = 0; i < n; i++) {
      rs[i][0] = g[i][0] - '0';
      for (int j = 1; j < n; j++) {
        rs[i][j] = rs[i][j - 1] + (g[i][j] - '0');
      }
    }

    Map<Integer, Boolean> b1 = new HashMap<>();
    Map<Integer, Boolean> b2 = new HashMap<>();

    int ans = 1;
    for (Integer f : factors) {
      boolean good = true;
      for (int i = 0; i < n && good; i++) {
        for (int j = 0; j + f - 1 < n && good; j += f) {
          int diff = rs[i][j + f - 1] - (j == 0 ? 0 : rs[i][j - 1]);
          if (diff != 0 && diff != f) {
            good = false;
          }
        }
      }

      b1.put(f, good);
    }

    for (int i = 0; i < n; i++) {
      rs[0][i] = g[0][i] - '0';
      for (int j = 1; j < n; j++) {
        rs[j][i] = rs[j - 1][i] + (g[j][i] - '0');
      }
    }

    for (Integer f : factors) {
      boolean good = true;
      for (int i = 0; i < n && good; i++) {
        for (int j = 0; j + f - 1 < n && good; j += f) {
          int diff = rs[j + f - 1][i] - (j == 0 ? 0 : rs[j - 1][i]);
          if (diff != 0 && diff != f) {
            good = false;
          }
        }
      }
      b2.put(f, good);
    }

    for (Integer f : factors) {
      if (b1.get(f) && b2.get(f)) {
        ans = Math.max(ans, f);
      }
    }

    System.out.println(ans);

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