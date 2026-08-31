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
//    int T = nextInt();
    int T = 1;
    for (int i = 0; i < T; i++) {
      helper();
    }
  }

  int n;
  long[] arr;
  void helper() {
    n = nextInt();
    arr = nextLongArr(n);

    double low = -2 * MOD;
    double high = 2 * MOD;
    for (int i = 0; i < 150; i++) {
      double mid1 = (2 * low + high) / 3;
      double mid2 = (low + 2 * high) / 3;
      double v1 = findVal(mid1);
      double v2 = findVal(mid2);
      if (v1 < v2) {
        high = mid2;
      } else {
        low = mid1;
      }
    }
    outln(findVal((low + high) / 2));
  }

  double findVal(double mid) {
    double[] newArr = new double[n];
    for (int i = 0; i < n; i++) {
      newArr[i] = arr[i] - mid;
    }
    return Math.max(findMax(newArr), findMin(newArr));
  }

  double findMax(double[] arr) {
    int n = arr.length;
    double res = Double.MIN_VALUE;
    double sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      res = Math.max(res, sum);
      sum = Math.max(0, sum);
    }
    return res;
  }

  double findMin(double[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      arr[i] = -arr[i];
    }
    double res = findMax(arr);
    for (int i = 0; i < n; i++) {
      arr[i] = -arr[i];
    }
    return res;
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
    outln(String.format("%.9f%n", val));
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
