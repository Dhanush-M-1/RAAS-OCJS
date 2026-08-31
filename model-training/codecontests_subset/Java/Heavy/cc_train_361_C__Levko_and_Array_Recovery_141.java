import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
public class P360A {

  int [] a;

  int max(int l, int r) {
    int m = a[l];
    for (int i = l + 1; i <= r; m = Math.max(m, a[i]), i++);
    return m;
  }

  void inc(int l, int r, int d) {
    for (int i = l; i <= r; a[i] += d, i++);
  }

  public void run() throws Exception {
    int n = nextInt(), m = nextInt();
    int [][] ops = new int [m][4];
    for (int i = 0; i < m; i++) {
      ops[i][0] = nextInt();
      ops[i][1] = nextInt() - 1;
      ops[i][2] = nextInt() - 1;
      ops[i][3] = nextInt();
    }
    a = new int [n];
    Arrays.fill(a, 1_000_000_000);

    for (int o = m - 1; o >= 0; o--) {
      if (ops[o][0] == 1) {
        inc(ops[o][1], ops[o][2], -ops[o][3]);
      } else {
        for (int i = ops[o][1]; i <= ops[o][2]; a[i] = Math.min(a[i], ops[o][3]), i++);
      }
    }

    int [] aa = Arrays.copyOf(a, a.length);

    for (int [] o : ops) {
      if (o[0] == 1) {
        inc(o[1], o[2], o[3]);
      } else {
        if (max(o[1], o[2]) != o[3]) {
          println("NO");
          return;
        }
      }
    }

    println("YES");
    for (int ca : aa) {
      ca = Math.min(ca, +1_000_000_000);
      ca = Math.max(ca, -1_000_000_000);
      print(ca + " ");
    }
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P360A().run();
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
    return ((b > 0) ? gcd(b, a % b) : a);
  }
  long gcd(long a, long b) {
    return ((b > 0) ? gcd(b, a % b) : a);
  }
}