import java.util.*;
import java.io.*;

public class CFA {
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
    int T = nextInt();
//    int T = 1;
    for (int i = 0; i < T; i++) {
      helper();
    }
  }

  void helper() {
    int n = nextInt();
    int m = nextInt();
    long[] arr = nextLongArr(n);
    long[] pref = new long[1 + n];
    long prefMax = 0;
    long[] prefArr = new long[1 + n];
    for (int i = 1; i <= n; i++) {
      pref[i] = pref[i - 1] + arr[i - 1];
      prefMax = Math.max(prefMax, pref[i]);
      prefArr[i] = prefMax;
    }
    long[] query = nextLongArr(m);
    long delta = pref[n];
    for (long q : query) {
      if (prefMax < q && delta <= 0) {
        out(-1 + " ");
        continue;
      }
      long cnt = 0;
      if (q > prefMax) {
        cnt = (q - prefMax) / delta;
        if ((q - prefMax) % delta != 0) {
          cnt++;
        }
      }
      int low = 0;
      int high = n;
      while (low < high) {
        int mid = (low + high) / 2;
        long diff = prefArr[mid] + cnt * delta - q;
        if (diff < 0) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }
      long res = cnt * n + low - 1;
      out(res + " ");
    }
    outln("");
  }

  void shuffle(int[] a) {
    int n = a.length;
    for(int i = 0; i < n; i++) {
      int r = i + (int) (Math.random() * (n - i));
      int tmp = a[i];
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
  int gcd(int a, int b) {
    while(a != 0 && b != 0) {
      int c = b;
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
    outln(String.format("%.9f", val));
  }
  public CFA() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.close();
  }
  public static void main(String[] args) {
    new CFA();
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