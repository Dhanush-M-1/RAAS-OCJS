import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
public class P691D {

  public void run() throws Exception {
    int n = nextInt(), m = nextInt();

    int [] p = new int [n];
    Set<Integer> [] ms = new TreeSet [n];
    for (int i = 0; i < n; i++) {
      p[i] = nextInt();
      ms[i] = new TreeSet();
    }

    while ((m--) > 0) {
      int a = nextInt() - 1, b = nextInt() - 1;
      ms[a].add(b);
      ms[b].add(a);
    }

    int sn = 0;
    int [] s = new int [n];
    Arrays.fill(s, -1);
    Deque<Integer> q = new ArrayDeque();
    for (int i = 0; i < n; i++) {
      if (s[i] == -1) {
        q.push(i);
        s[i] = sn;

        while (q.size() > 0) {
          int li = q.pop();
          
          for (int j : ms[li]) {
            if (s[j] == -1) {
              q.push(j);
              s[j] = sn;
            }
          }
        }

        sn++;
      }
    }
    ms = null;

    List<Integer> [] ns = new ArrayList [sn];
    for (int i = 0; i < sn; i++) {
      ns[i] = new ArrayList();
    }
    for (int i = 0; i < n; i++) {
      ns[s[i]].add(p[i]);
    }
    for (int i = 0; i < sn; i++) {
      ns[i].sort(null);
    }
    
    for (int ss : s) {
      print(ns[ss].get(ns[ss].size() - 1) + " ");
      ns[ss].remove(ns[ss].size() - 1);
    }
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P691D().run();
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
}