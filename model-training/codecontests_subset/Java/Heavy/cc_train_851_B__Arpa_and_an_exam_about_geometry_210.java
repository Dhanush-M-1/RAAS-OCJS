import java.io.*;
import java.util.*;

public class J implements Runnable {

  private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

  private BufferedReader in;
  private PrintWriter out;
  private StringTokenizer tok = new StringTokenizer("");

  private void init() throws FileNotFoundException {
    Locale.setDefault(Locale.US);
    String fileName = "";
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

  }

  String readString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (Exception e) {
        return null;
      }
    }
    return tok.nextToken();
  }

  int readInt() {
    return Integer.parseInt(readString());
  }

  long readLong() {
    return Long.parseLong(readString());
  }

  double readDouble() {
    return Double.parseDouble(readString());
  }

  int[] readIntArray(int size) {
    int[] a = new int[size];
    for (int i = 0; i < size; i++) {
      a[i] = readInt();
    }
    return a;
  }

  public static void main(String[] args) {
    //new Thread(null, new _Solution(), "", 128 * (1L << 20)).start();
    new J().run();
  }

  long timeBegin, timeEnd;

  void time() {
    timeEnd = System.currentTimeMillis();
    // System.err.println("Time = " + (timeEnd - timeBegin));
  }

  @Override
  public void run() {
    try {
      timeBegin = System.currentTimeMillis();
      init();
      solve();
      out.close();
      time();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  private int aiverson(boolean good) {
    return good ? 1 : 0;
  }

  boolean isDigit(char x) {
    return x == '0' || x == '1';
  }


  private void solve() throws IOException {
    long ax = readInt();
    long ay = readInt();
    long bx = readInt();
    long by = readInt();
    long cx = readInt();
    long cy = readInt();
    if (tr_area_2(ax, ay, bx, by, cx, cy) != 0 && dist2(ax, ay, bx, by) == dist2(bx, by, cx, cy)){
      out.print("Yes");
    } else {
      out.print("No");
    }

  }

  static long tr_area_2(long x1, long y1, long x2, long y2, long x3, long y3) {
    return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
  }

  static long dist2(long x1, long y1, long x2, long y2) {
    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
  }


}
