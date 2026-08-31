import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;
import static java.lang.Integer.signum;

@SuppressWarnings("unchecked")
public class P1107D {

  int [][] dp;

  int get(int i, int j) {
    return (((i > 0) && (j > 0)) ? dp[i - 1][j - 1] : 0);
  }

  int get(int i, int j, int x) {
    i *= x;
    j *= x;
    return (get(i + x, j + x) - get(i + x, j) - get(i, j + x) + get(i, j));
  }

  public void run() throws Exception {
    int n = nextInt(), x;
    dp = new int [n][n];
    
    for (int i = 0; i < n; i++) {
      char [] s = next().toCharArray();
      for (int j = 0; j < n;) {
        int v = (s[j >> 2] <= '9') ? (s[j >> 2] - '0') : (s[j >> 2] - 'A' + 10);
        dp[i][j++] = signum(v & 0b1000);
        dp[i][j++] = signum(v & 0b0100);
        dp[i][j++] = signum(v & 0b0010);
        dp[i][j++] = signum(v & 0b0001);
      }
    }

    for (int i = 0; i < n; i++) { for (int j = 1; j < n; dp[i][j] += dp[i][j - 1], j++); }

    for (int i = 1; i < n; i++) { for (int j = 0; j < n; dp[i][j] += dp[i - 1][j], j++); }
    
next_x:
    for (x = n; x > 1; x--) {
      if ((n % x) == 0) {
        int c = n / x, xx = x * x;

        for (int i = 0; i < c; i++) {
          for (int j = 0; j < c; j++) {
            int s = get(i, j, x);

            if ((s != 0) && (s != xx)) {
              continue next_x;
            }
          }
        }

        break;
      }
    }

    println(x);
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P1107D().run();
    br.close();
    pw.close();
    System.err.println("\n[Time : " + (System.currentTimeMillis() - startTime) + " ms]");
  }

  static long startTime = System.currentTimeMillis();
  static BufferedReader br;
  static PrintWriter pw;
  StringTokenizer stok;

  String nextToken() throws IOException {
    while (stok == null || !stok.hasMoreTokens()) {
      String s = br.readLine();
      if (s == null) { return null; }
      stok = new StringTokenizer(s);
    }
    return stok.nextToken();
  }

  void print(byte b) { print("" + b); }
  void print(int i) { print("" + i); }
  void print(long l) { print("" + l); }
  void print(double d) { print("" + d); }
  void print(char c) { print("" + c); }
  void print(Object o) {
    if (o instanceof int[]) { print(Arrays.toString((int [])o));
    } else if (o instanceof long[]) { print(Arrays.toString((long [])o));
    } else if (o instanceof char[]) { print(Arrays.toString((char [])o));
    } else if (o instanceof byte[]) { print(Arrays.toString((byte [])o));
    } else if (o instanceof short[]) { print(Arrays.toString((short [])o));
    } else if (o instanceof boolean[]) { print(Arrays.toString((boolean [])o));
    } else if (o instanceof float[]) { print(Arrays.toString((float [])o));
    } else if (o instanceof double[]) { print(Arrays.toString((double [])o));
    } else if (o instanceof Object[]) { print(Arrays.toString((Object [])o));
    } else { print("" + o); }
  }
  void print(String s) { pw.print(s); }
  void println() { println(""); }
  void println(byte b) { println("" + b); }
  void println(int i) { println("" + i); }
  void println(long l) { println("" + l); }
  void println(double d) { println("" + d); }
  void println(char c) { println("" + c); }
  void println(Object o) { print(o); println(); }
  void println(String s) { pw.println(s); }
  int nextInt() throws IOException { return Integer.parseInt(nextToken()); }
  long nextLong() throws IOException { return Long.parseLong(nextToken()); }
  double nextDouble() throws IOException { return Double.parseDouble(nextToken()); }
  char nextChar() throws IOException { return (char) (br.read()); }
  String next() throws IOException { return nextToken(); }
  String nextLine() throws IOException { return br.readLine(); }
  int [] readInt(int size) throws IOException {
    int [] array = new int [size];
    for (int i = 0; i < size; i++) { array[i] = nextInt(); }
    return array;
  }
  long [] readLong(int size) throws IOException {
    long [] array = new long [size];
    for (int i = 0; i < size; i++) { array[i] = nextLong(); }
    return array;
  }
  double [] readDouble(int size) throws IOException {
    double [] array = new double [size];
    for (int i = 0; i < size; i++) { array[i] = nextDouble(); }
    return array;
  }
  String [] readLines(int size) throws IOException {
    String [] array = new String [size];
    for (int i = 0; i < size; i++) { array[i] = nextLine(); }
    return array;
  }

  int gcd(int a, int b) {
    if (a == 0) return Math.abs(b); if (b == 0) return Math.abs(a);
    a = Math.abs(a); b = Math.abs(b);
    int az = Integer.numberOfTrailingZeros(a), bz = Integer.numberOfTrailingZeros(b);
    a >>>= az; b >>>= bz;
    while (a != b) {
      if (a > b) { a -= b; a >>>= Integer.numberOfTrailingZeros(a); }
            else { b -= a; b >>>= Integer.numberOfTrailingZeros(b); }
    }
    return (a << Math.min(az, bz));
  }

  long gcd(long a, long b) {
    if (a == 0) return Math.abs(b); if (b == 0) return Math.abs(a);
    a = Math.abs(a); b = Math.abs(b);
    int az = Long.numberOfTrailingZeros(a), bz = Long.numberOfTrailingZeros(b);
    a >>>= az; b >>>= bz;
    while (a != b) {
      if (a > b) { a -= b; a >>>= Long.numberOfTrailingZeros(a); }
            else { b -= a; b >>>= Long.numberOfTrailingZeros(b); }
    }
    return (a << Math.min(az, bz));
  }

  void shuffle(int [] a) {
    Random r = new Random();
    for (int i = a.length - 1; i >= 0; i--) {
      int j = r.nextInt(a.length);
      int t = a[i]; a[i] = a[j]; a[j] = t;
    }
  }

  void shuffle(long [] a) {
    Random r = new Random();
    for (int i = a.length - 1; i >= 0; i--) {
      int j = r.nextInt(a.length);
      long t = a[i]; a[i] = a[j]; a[j] = t;
    }
  }

  void shuffle(Object [] a) {
    Random r = new Random();
    for (int i = a.length - 1; i >= 0; i--) {
      int j = r.nextInt(a.length);
      Object t = a[i]; a[i] = a[j]; a[j] = t;
    }
  }

  void flush() {
    pw.flush();
  }

  void pause() {
    flush();
    System.console().readLine();
  }
}