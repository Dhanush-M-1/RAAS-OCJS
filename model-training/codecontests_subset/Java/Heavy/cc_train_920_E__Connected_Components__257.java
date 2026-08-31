import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
public class P920E {

  public void run() throws Exception {
    int n = nextInt(), m = nextInt();
    TreeSet<Integer> fvs = new TreeSet();
    HashSet<Integer> bvs [] = new HashSet [n];
    for (int i = 0; i < n; fvs.add(i), bvs[i] = new HashSet(), i++);
    while ((m--) > 0) {
      int u = nextInt() - 1, v = nextInt() - 1;
      bvs[u].add(v);
      bvs[v].add(u);
    }

    List<Integer> ans = new ArrayList();
    Deque<Integer> vd = new ArrayDeque();
    
    while (!fvs.isEmpty()) {
      int u = fvs.pollFirst(), k = 0;
      vd.add(u);

      while (vd.size() != 0) {
        u = vd.pollFirst();
        k++;

        for (Iterator<Integer> it = fvs.iterator(); it.hasNext();) {
          int v = it.next();
          if (u == v) { continue; }

          if (!bvs[u].contains(v)) {
            vd.add(v);
            it.remove();
          }
        }
      }

      ans.add(k);
    }

    ans.sort(Comparator.reverseOrder());

    println(ans.size());
    for (int i = ans.size() - 1; i >= 0; print(ans.get(i) + " "), i--);
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P920E().run();
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
}