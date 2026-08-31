
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Random;

public class P691D {
  InputStream is;
  PrintWriter out;
  String INPUT = "9 6\n" +
    "1 2 3 4 5 6 7 8 9\n" +
    "1 4\n" +
    "4 7\n" +
    "2 5\n" +
    "5 8\n" +
    "3 6\n" +
    "6 9\n";

  private static class DJSet {
    int[] id;
    Random rnd = new Random();

    DJSet(int n) {
      id = new int[n];
      for (int i = 0; i < n; i++) {
        id[i] = i;
      }
    }

    void union(int x, int y) {
      x = find(x);
      y = find(y);
      if (x == y)
        return;
      if (rnd.nextBoolean()) {
        id[x] = id[y];
      } else {
        id[y] = id[x];
      }
    }

    private int find(int x) {
      return id[x] == x ? x : (id[x] = find(id[x]));
    }
  }
  
  void solve() {
    int n = ni();
    int m = ni();
    int[] a = new int[n];
    DJSet ds = new DJSet(n);
    for (int i = 0; i < n; i++) {
      a[i] = ni();
    }
    for (int i = 0; i < m; i++) {
      ds.union(ni() - 1, ni() - 1);
    }
    PriorityQueue<Integer>[] 
      q = new PriorityQueue[n];
    for (int i = 0; i < n; i++) {
      int p = ds.find(i);
      if (q[p] == null) {
        q[p] = new PriorityQueue<Integer>();
      }
      q[p].add(-a[i]);
    }
    for (int i = 0; i < n; i++) {
      int p = ds.find(i);
      out.print(-q[p].poll() + " ");
    }
  }

  private void shuffle(int[] numbers) {
    Random rnd = new Random();
    int n = numbers.length;
    for (int i = 0; i < n; i++) {
      int index = rnd.nextInt(n - i);
      int tmp = numbers[i];
      numbers[i] = numbers[index];
      numbers[index] = tmp;
    }
  }

  public static void main(String[] args) throws Exception {
    new P691D().run();
  }
  
  void run() throws Exception {
    is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
    out = new PrintWriter(System.out);
  
    long s = System.currentTimeMillis();
    solve();
    out.flush();
    tr(System.currentTimeMillis() - s + "ms");
  }
  
  private byte[] inbuf = new byte[1024];
  private int lenbuf = 0, ptrbuf = 0;
  
  private int readByte() {
    if (lenbuf == -1)
      throw new InputMismatchException();
    if (ptrbuf >= lenbuf) {
      ptrbuf = 0;
      try {
        lenbuf = is.read(inbuf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (lenbuf <= 0)
        return -1;
    }
    return inbuf[ptrbuf++];
  }
  
  private boolean isSpaceChar(int c) {
    return !(c >= 33 && c <= 126);
  }
  
  private int skip() {
    int b;
    while ((b = readByte()) != -1 && isSpaceChar(b))
      ;
    return b;
  }
  
  private double nd() {
    return Double.parseDouble(ns());
  }
  
  private char nc() {
    return (char) skip();
  }
  
  private String ns() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
      sb.appendCodePoint(b);
      b = readByte();
    }
    return sb.toString();
  }
  
  private char[] ns(int n) {
    char[] buf = new char[n];
    int b = skip(), p = 0;
    while (p < n && !(isSpaceChar(b))) {
      buf[p++] = (char) b;
      b = readByte();
    }
    return n == p ? buf : Arrays.copyOf(buf, p);
  }
  
  private char[][] nm(int n, int m) {
    char[][] map = new char[n][];
    for (int i = 0; i < n; i++)
      map[i] = ns(m);
    return map;
  }
  
  private int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = ni();
    return a;
  }
  
  private int ni() {
    int num = 0, b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
      ;
    if (b == '-') {
      minus = true;
      b = readByte();
    }
  
    while (true) {
      if (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
      } else {
        return minus ? -num : num;
      }
      b = readByte();
    }
  }
  
  private long nl() {
    long num = 0;
    int b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
      ;
    if (b == '-') {
      minus = true;
      b = readByte();
    }
  
    while (true) {
      if (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
      } else {
        return minus ? -num : num;
      }
      b = readByte();
    }
  }
  
  private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
  
  private void tr(Object... o) {
    if (!oj)
      System.out.println(Arrays.deepToString(o));
  }
}
