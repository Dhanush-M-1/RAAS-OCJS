import java.util.*;
import java.io.*;

public class CFF {
  BufferedReader br;
  PrintWriter out;
  StringTokenizer st;
  boolean eof;
  private static final long MOD = 1000L * 1000L * 1000L + 7;
  private static final int[] dx = {0, -1, 0, 1};
  private static final int[] dy = {1, 0, -1, 0};
  private static final String yes = "Yes";
  private static final String no = "No";

  void solve() {
//    int T = nextInt();
    int T = 1;
    for (int i = 0; i < T; i++) {
        helper();
    }
  }

  void helper() {
    int n = nextInt();
    int m = nextInt();
    WeightedUF uf = new WeightedUF(m);
    List<Integer> needed = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int k = nextInt();
      if (k == 1) {
        int p = nextInt() - 1;
        if (!uf.isBroken(p)) {
          needed.add(i + 1);
          uf.setBroken(p);
        }
      } else {
        int p1 = nextInt() - 1;
        int p2 = nextInt() - 1;
        boolean b1 = uf.isBroken(p1);
        boolean b2 = uf.isBroken(p2);
        if (!b1) {
          if (b2) {
            needed.add(i + 1);
            uf.setBroken(p1);
          } else {
            if (!uf.isConnected(p1, p2)) {
              needed.add(i + 1);
              uf.union(p1, p2);
            }
          }
        } else {
          if (!b2) {
            needed.add(i + 1);
            uf.setBroken(p2);
          }
        }
      }
    }

    long res = 1;
    for (int i = 0; i < needed.size(); i++) {
      res = res * 2 % MOD;
    }
    outln(res + " " + needed.size());
    for (int v : needed) {
      out(v + " ");
    }
    outln("");
  }

  public class WeightedUF {
    int[] id;
    int count;
    int[] sz;
    boolean[] isBroken;
    public WeightedUF(int n) {
      count = n;
      id = new int[n];
      for(int i = 0; i < n; i++) {
        id[i] = i;
      }
      sz = new int[n];
      Arrays.fill(sz, 1);
      isBroken = new boolean[n];
    }

    public boolean isBroken(int p) {
      return isBroken[find(p)];
    }

    public void setBroken(int p) {
      isBroken[find(p)] = true;
    }

    public boolean isConnected(int p, int q) {
      return find(p) == find(q);
    }
    public int find(int p) {
      while(p != id[p]) {
        p = id[p];
      }
      return p;
    }

    public boolean union(int p, int q) {
      int i = find(p);
      int j = find(q);
      if(i == j) {
        return false;
      }
      if(sz[i] < sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
      }
      else {
        id[j] = i;
        sz[i] += sz[j];
      }
      count--;
      return true;
    }
  }

  void shuffle(long[] a) {
    int n = a.length;
    for(int i = 0; i < n; i++) {
        int r = i + (int) (Math.random() * (n - i));
        long tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
    }
  }
  long gcd(long a, long b) {
    while(a != 0 && b != 0) {
        long c = b;
        b = a % b;
        a = c;
    }
    return a + b;
  }
  private void outln(Object o) {
      out.println(o);
  }
  private void out(Object o) {
      out.print(o);
  }
  private void formatPrint(double val) {
      outln(String.format("%.9f%n", val));
  }
  public CFF() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.close();
  }
  public static void main(String[] args) {
      new CFF();
  }

  public long[] nextLongArr(int n) {
    long[] res = new long[n];
    for(int i = 0; i < n; i++)
        res[i] = nextLong();
    return res;
  }
  public int[] nextIntArr(int n) {
    int[] res = new int[n];
    for(int i = 0; i < n; i++)
        res[i] = nextInt();
    return res;
  }
  public String nextToken() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
            eof = true;
            return null;
        }
    }
    return st.nextToken();
  }
  public String nextString() {
    try {
        return br.readLine();
    } catch (IOException e) {
        eof = true;
        return null;
    }
  }
  public int nextInt() {
      return Integer.parseInt(nextToken());
  }
  public long nextLong() {
      return Long.parseLong(nextToken());
  }
  public double nextDouble() {
      return Double.parseDouble(nextToken());
  }
}
