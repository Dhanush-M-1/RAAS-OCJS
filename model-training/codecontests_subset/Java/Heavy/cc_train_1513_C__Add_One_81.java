import java.io.*;
import java.util.*;


public class A {
  static final int INF = (int) 1e9 + 9;
  static final int MAXN = (int) 2e5 + 5;
  static final int MAXLOG = (int) (Math.log(MAXN) / Math.log(2) + 1e-10) + 1;
  static final int MOD = 1_000_000_007;

  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static Reader in = new Reader();

  static int n, m, t, q;

  static Integer ans[][] = new Integer[10][MAXN];

  public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
    Scanner in = new Scanner(System.in);
    // Scanner in = new Scanner(new File("lineup.in"));
    // PrintWriter pw = new PrintWriter("lineup.out");
    PrintWriter pw = new PrintWriter(System.out);

    t = in.nextInt();
    
    // for(int i = 0; i < 10; ++i)
    //   for(int j = 0; j < MAXN - 1; ++j)
    //     ans[i][j] = _solve(i, j);
    
    for(int j = 0; j < MAXN - 1; ++j)
      for(int i = 0; i < 10; ++i) {
        if(j == 0) ans[i][j] = 1;
        else if(i == 9)
          ans[i][j] = (ans[0][j - 1] + ans[1][j - 1]) % MOD;
        else ans[i][j] = ans[i + 1][j - 1];
      }
        

    while(t-- > 0) {
      int n = in.nextInt();
      m = in.nextInt();

      long res = 0;
      for(;n > 0; n /= 10)
        res = (res + ans[n % 10][m]) % MOD;

      pw.println(res);
    }

    pw.close();
    in.close();
  }

  static int _solve(int d, int m) {
    if(m < 0) return 1;
    if(ans[d][m] != null) return ans[d][m];
    if(m == 0) return ans[d][m] = 1;

    if(d == 9)
      return ans[d][m] = (_solve(0, m - 1) + _solve(1, m - 1)) % MOD;
    return ans[d][m] = _solve(d + 1, m - 1);
  }

  static class Pair<U, V> implements Comparable<Pair<U, V>> {
    U first;
    V second;

    public Pair(U first, V second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null)
        return false;
      Pair<U, V> o = (Pair<U, V>) obj;
      return this.first.equals(o.first) && this.second.equals(o.second);
    }

    @Override
    public int compareTo(Pair<U, V> p) {
      int firstC = ((Comparable) first).compareTo((Comparable) p.first);
      if (firstC == 0)
        return ((Comparable) second).compareTo((Comparable) p.second);
      return firstC;
    }
  }

  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[64]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public String next() throws IOException {
      byte[] buf = new byte[64]; // string length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == ' ' || c == '\t' || c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg)
        return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();

      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }
  }
}