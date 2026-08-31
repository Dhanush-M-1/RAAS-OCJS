import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;

public class P551B {

  Map<Character, Integer> a = new HashMap<Character, Integer>('z' - 'a' + 1);
  Map<Character, Integer> b = new HashMap<Character, Integer>('z' - 'a' + 1);
  Map<Character, Integer> c = new HashMap<Character, Integer>('z' - 'a' + 1);

  void countChars(String s, Map<Character, Integer> m) {
    for (char cc : s.toCharArray()) {
      Integer cnt = m.get(cc);
      cnt = (cnt == null) ? 1 : (cnt + 1);
      m.put(cc, cnt);
    }
  }

  int BinA() {
    int res = Integer.MAX_VALUE;

    for (Map.Entry<Character, Integer> me : b.entrySet()) {
      if (a.containsKey(me.getKey())) {
        res = Math.min(res, a.get(me.getKey()) / me.getValue());
      } else {
        return 0;
      }
    }

    return res;
  }

  int CinAwithoutB(int bCount) {
    int res = Integer.MAX_VALUE;

    for (Map.Entry<Character, Integer> me : c.entrySet()) {
      if (a.containsKey(me.getKey())) {
        res = Math.min(res, (a.get(me.getKey()) - (b.containsKey(me.getKey()) ? b.get(me.getKey()) * bCount : 0)) / me.getValue());
      } else {
        return 0;
      }
    }

    return res;
  }

  void clearA(Map<Character, Integer> map, int cnt) {
    for (Map.Entry<Character, Integer> me : map.entrySet()) {
      int newCnt = a.containsKey(me.getKey()) ? (a.get(me.getKey()) - me.getValue() * cnt) : 0;

      if (newCnt != 0) {
        a.put(me.getKey(), newCnt);
      } else {
        a.remove(me.getKey());
      }
    }
  }

  @SuppressWarnings("unchecked")                                   
  public void run() throws Exception {
    String A = next();
    String B = next();
    String C = next();
    int bCount = 0, cCount = 0;

    countChars(A, a);
    countChars(B, b);
    countChars(C, c);

    int bMax = BinA();
    
    for (int bc = 0; bc <= bMax; bc++) {
      int cc = CinAwithoutB(bc);
      if ((bc + cc) > (bCount + cCount)) {
        bCount = bc;
        cCount = cc;
      }
    }

    for (int i = 0; i < bCount; i++) { print(B); }
    for (int i = 0; i < cCount; i++) { print(C); }
    clearA(b, bCount);
    clearA(c, cCount);

    for (Map.Entry<Character, Integer> me : a.entrySet()) {
      for (int i = 0; i < me.getValue(); i++) {
        print(me.getKey());
      }
    }
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P551B().run();
    br.close();
    pw.close();
  }

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
}