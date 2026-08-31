import java.io.*;
import java.util.*;

public class Program {
  static BufferedReader in = null;
  static PrintWriter out = null;
  static StringTokenizer st = new StringTokenizer("");

  public static void main(String[] args) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      solve();
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String readString() {
    while (!st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(in.readLine());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }


  public static int readInt() {
    return Integer.parseInt(readString());
  }

  public static long readLong() {
    return Long.parseLong(readString());
  }

  public static double readDouble() {
    return Double.parseDouble(readString());
  }


  static final long MAX = 3L * Integer.MAX_VALUE;

  private static void solve() throws IOException {
    int n = readInt();
    int k = readInt();
    long p = readInt();
    long[] a = new long[n];
    long[] b = new long[k];
    for (int i = 0; i < n; i++) {
      a[i] = readInt();
    }
    Arrays.sort(a);
    for (int i = 0; i < k; i++) {
      b[i] = readInt();
    }
    Arrays.sort(b);

    boolean[] used = new boolean[k];

    long left = 0;
    long right = MAX;

    long ans = 0;
    while (left <= right) {
      long mid = (left + right) / 2;
      Arrays.fill(used, false);
      boolean ok = true;
      for (int i = 0; i < n; i++) {
        if (!ok) break;
        boolean found = false;
        for (int j = 0; j < k; j++) {
          if (used[j]) continue;
          long dist = Math.abs(a[i] - b[j]) + Math.abs(b[j] - p);
          if (dist <= mid) {
            used[j] = true;
            found = true;
            break;
          }
        }
        if (!found) ok = false;
      }
      if (ok) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    out.print(ans);

  }

}

















