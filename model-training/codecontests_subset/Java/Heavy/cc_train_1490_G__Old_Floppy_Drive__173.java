import java.util.*;
import java.io.*;
public class G {
  private static PrintWriter out;
  private static class FS {
    StringTokenizer st;
    BufferedReader br;
    public FS() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {st = new StringTokenizer(br.readLine());}
        catch (IOException e) {e.printStackTrace();}
      }
      return st.nextToken();
    }
    public String nextLine() {
      String s = null;
      try {s = br.readLine();}
      catch (IOException e) {e.printStackTrace();}
      return s;
    }
    public int nextInt() {return Integer.parseInt(next());}
    public long nextLong() {return Long.parseLong(next());}
    public double nextDouble() {return Double.parseDouble(next());}
  }
  private static int bs(long[] a, int x, int hi) {
    int lo = 0, m = 0;
    while (lo <= hi) {
      m = lo + ((hi - lo) >> 1);
      if (a[m] >= x) hi = m - 1;
      else lo = m + 1;
    }
    return hi+1;
  }
  public static void main(String[] args) {
    FS sc = new FS();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(), m = sc.nextInt(), sz = 0;
      long[] a = new long[n];
      long sum = 0;
      int[] id = new int[n];
      for (int i = 0; i < n; ++i) {
        sum += sc.nextInt();
        if (sz == 0 || a[sz-1] < sum) {a[sz] = sum; id[sz++] = i;}
      }
      for (int i = 0; i < m; ++i) {
        int x = sc.nextInt();
        if (a[sz-1] < x && sum <= 0) {out.print(-1 + " "); continue;}
        long needTimes = 0;
        if (a[sz-1] < x) needTimes = (x - a[sz-1] + sum - 1) / sum;
        x -= needTimes * sum;
        out.print((needTimes * n + id[bs(a, x, sz - 1)]) + " ");
      }
      out.println();
    }
    out.close();
  }
}
