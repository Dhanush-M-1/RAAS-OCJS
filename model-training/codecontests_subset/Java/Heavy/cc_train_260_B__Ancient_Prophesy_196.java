import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class P260B {

  private final int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

  private boolean isMinus(char c) {
    return (c == '-');
  }

  private boolean isGood(String s) {
    if (isDigit(s.charAt(0)) && isDigit(s.charAt(1)) && isMinus(s.charAt(2)) &&
        isDigit(s.charAt(3)) && isDigit(s.charAt(4)) && isMinus(s.charAt(5)) &&
        isDigit(s.charAt(6)) && isDigit(s.charAt(7)) &&
        isDigit(s.charAt(8)) && isDigit(s.charAt(9))) {
      int d = Integer.valueOf(s.substring(0, 2));
      int m = Integer.valueOf(s.substring(3, 5));
      int y = Integer.valueOf(s.substring(6, 10));

      return ((y > 2012) && (y <= 2015) && (m > 0) && (m < 13) && (d > 0) && (d <= days[m - 1]));
    }

    return false;
  }

  @SuppressWarnings("unchecked")
  public void run() throws Exception {
    String s = next();
    TreeMap<String, Integer> dc = new TreeMap();

    for (int i = 0; i <= s.length() - 10; i++) {
      String ss = s.substring(i, i + 10);
      if (isGood(ss)) {
        Integer c = dc.get(ss);
        dc.put(ss, c == null ? 1 : c + 1);
      }
    }

    int c = 0;
    String d = "";

    for (Iterator<Map.Entry<String, Integer>> i = dc.entrySet().iterator(); i.hasNext(); ) {
      Map.Entry<String, Integer> e = i.next();
      if (e.getValue() > c) {
        c = e.getValue();
        d = e.getKey();
      }
    }

    println(d);
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P260B().run();
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
    } else { println("" + o); }
  }
  void print(String s) { pw.print(s); }
  void println() { println(""); }
  void println(byte b) { println("" + b); }
  void println(int i) { println("" + i); }
  void println(long l) { println("" + l); }
  void println(double d) { println("" + d); }
  void println(char c) { println("" + c); }
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