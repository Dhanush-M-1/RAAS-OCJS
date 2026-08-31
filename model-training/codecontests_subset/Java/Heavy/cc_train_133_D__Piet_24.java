import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
public class P133D {

  final static int W = 0, H = 1, X = 2, Y = 3;
  final static int [][] WHXY = {{1, 0, 0, 0}, {1, 1, 0, -1}, {1, 1, -1, 0}, {0, 1, 0, 0},
                                {0, 1, -1, -1}, {0, 0, -1, 0}, {0, 0, 0, -1}, {1, 0, -1, -1}};

  //---------------------------------------------------------------------

  class Block {
    int c, x, y, w, h;
    boolean processed;
    // directions : ru, rd, lu, ld, ul, ur, dl, dr
    Block [] nb = new Block [4 * 2];

    public Block(int c, int x, int y, int w, int h) {
      this.c = c - '0';
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
    }

    public void findNB(Block [][] b) {
      if (processed) {
        return;
      }

      processed = true;

      for (int i = 0; i < 8; i++) {
        int xx = x + WHXY[i][W] * w + WHXY[i][X];
        int yy = y + WHXY[i][H] * h + WHXY[i][Y];

        if ((xx >= 0) && (xx < b[0].length) && (yy >= 0) && (yy < b.length)) {
          nb[i] = b[yy][xx];
        }
      }
    }

    public Block getNB(int dpcp) {
      return nb[dpcp];
    }

    @Override
    public String toString() {
      return Integer.toString(c);
    }
  }

  //---------------------------------------------------------------------

  class BP {
    Block bp;
    int dpcp;

    public BP(Block bp) {
      this.bp = bp;
    }

    public void nextStep() {
      //TODO
      Block nb = bp.getNB(dpcp);
      
      if (nb != null) {
        bp = nb;  
      } else {
        dpcp = (dpcp + 1) &0b111;
      }
    }
  
    @Override
    public String toString() {
      return bp.toString();
    }
  }

  //---------------------------------------------------------------------

  public void run() throws Exception {
    int m = nextInt(), n = nextInt();

    String [] f = readLines(m);
    Block [][] b = new Block [m][f[0].length()];
    
    for (int y = 0; y < m; y++) {
      for (int x = 0; x < f[0].length(); x++) {
        if ((b[y][x] == null) && (f[y].charAt(x) != '0')) {
          int w, h;
          for (w = 1; ((w + x) < f[0].length()) && (f[y].charAt(x + w) == f[y].charAt(x)); w++);
          for (h = 1; ((h + y) < m) && (f[y + h].charAt(x) == f[y].charAt(x)); h++);
          
          b[y][x] = new Block(f[y].charAt(x), x, y, w, h);

          for (int i = y; i < (y + h); i++) {
            for (int j = x; j < (x + w); j++) {
              b[i][j] = b[y][x];
            }
          }
        }
      }
    }
    f = null;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < b[0].length; j++) {
        if (b[i][j] != null) {
          b[i][j].findNB(b);
        }
      }
    }
    
    BP bp = new BP(b[0][0]);
    b = null;

    while ((n--) > 0) {
      bp.nextStep();
    }
  
    println(bp);
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P133D().run();
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