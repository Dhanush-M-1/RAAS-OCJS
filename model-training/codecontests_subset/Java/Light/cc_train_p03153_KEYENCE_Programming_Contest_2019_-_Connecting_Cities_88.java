
import java.util.Arrays;

public class Main {
  private static void solve() {
    int n = ni();
    long d = ni();

    long[][] b = new long[n][2];
    for (int i = 0; i < n; i++) {
      b[i][0] = i;
      b[i][1] = ni();
    }
    Arrays.sort(b, (o1, o2) -> Long.signum(o1[1] - o2[1]));

    SegmentTreeRMQPos stl = new SegmentTreeRMQPos(n);
    SegmentTreeRMQPos str = new SegmentTreeRMQPos(n);


    int[] from = new int[n * 2];
    int[] to = new int[n * 2];
    long[] w = new long[n * 2];
    int ptr = 0;
    for (long[] v : b) {
      int i = (int) v[0];
      long l = stl.minx(0, i);
      int lp = stl.minpos;
      long r = str.minx(i + 1, n);
      int rp = str.minpos;

      if (l < Long.MAX_VALUE / 2) {
        from[ptr] = i;
        to[ptr] = lp;
        w[ptr] = l + i * d + v[1];
        ptr++;
      }
      if (r < Long.MAX_VALUE / 2) {
        from[ptr] = i;
        to[ptr] = rp;
        w[ptr] = r - i * d + v[1];
        ptr++;
      }

      stl.update(i, v[1] - i * d);
      str.update(i, v[1] + i * d);
    }

    System.out.println(kruskal(from, to, w, n));
  }

  public static long kruskal(int[] one, int[] other, long[] w, int n) {
    DisjointSet ds = new DisjointSet(n);
    int p = one.length;
    Integer[] ord = new Integer[p];
    for (int i = 0; i < p; i++)
      ord[i] = i;
    Arrays.sort(ord, (o1, o2) -> Long.compare(w[o1], w[o2]));

    long d = 0;
    for (int i = 0; i < ord.length; i++) {
      int cur = (int) ord[i];
      if (!ds.equiv(one[cur], other[cur])) {
        ds.union(one[cur], other[cur]);
        d += w[cur];
      }
    }
    return d;

  }

  static class SegmentTreeRMQPos {
    public int M, H, N;
    public long[] st;
    public int[] pos;

    public SegmentTreeRMQPos(int n) {
      N = n;
      M = Integer.highestOneBit(Math.max(N - 1, 1)) << 2;
      H = M >>> 1;
      st = new long[M];
      pos = new int[M];
      for (int i = 0; i < N; i++)
        pos[H + i] = i;
      Arrays.fill(st, 0, M, Long.MAX_VALUE);
      for (int i = H - 1; i >= 1; i--)
        propagate(i);
    }


    public void update(int pos, long x) {
      st[H + pos] = x;
      for (int i = (H + pos) >>> 1; i >= 1; i >>>= 1)
        propagate(i);
    }

    private void propagate(int i) {
      if (st[2 * i] <= st[2 * i + 1]) {
        st[i] = st[2 * i];
        pos[i] = pos[2 * i];
      } else {
        st[i] = st[2 * i + 1];
        pos[i] = pos[2 * i + 1];
      }
    }

    public int minpos;
    public long minval;

    public long minx(int l, int r) {
      minval = Long.MAX_VALUE;
      minpos = -1;
      if (l >= r)
        return minval;
      while (l != 0) {
        int f = l & -l;
        if (l + f > r)
          break;
        long v = st[(H + l) / f];
        if (v < minval) {
          minval = v;
          minpos = pos[(H + l) / f];
        }
        l += f;
      }

      while (l < r) {
        int f = r & -r;
        long v = st[(H + r) / f - 1];
        if (v < minval) {
          minval = v;
          minpos = pos[(H + r) / f - 1];
        }
        r -= f;
      }
      return minval;
    }
  }



  public static class DisjointSet {
    public int[] upper;

    public DisjointSet(int n) {
      upper = new int[n];
      Arrays.fill(upper, -1);
    }

    public int root(int x) {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
      return root(x) == root(y);
    }

    public boolean union(int x, int y) {
      x = root(x);
      y = root(y);
      if (x != y) {
        if (upper[y] < upper[x]) {
          int d = x;
          x = y;
          y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
      }
      return x == y;
    }

    public int[][] toBucket() {
      int n = upper.length;
      int[][] ret = new int[n][];
      int[] rp = new int[n];
      for (int i = 0; i < n; i++) {
        if (upper[i] < 0)
          ret[i] = new int[-upper[i]];
      }
      for (int i = 0; i < n; i++) {
        int r = root(i);
        ret[r][rp[r]++] = i;
      }
      return ret;
    }
  }

  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() {
        long start = System.currentTimeMillis();
        String debug = args.length > 0 ? args[0] : null;
        if (debug != null) {
          try {
            is = java.nio.file.Files.newInputStream(java.nio.file.Paths.get(debug));
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
        reader = new java.io.BufferedReader(new java.io.InputStreamReader(is), 32768);
        solve();
        out.flush();
        tr((System.currentTimeMillis() - start) + "ms");
      }
    }, "", 64000000).start();
  }

  private static java.io.InputStream is = System.in;
  private static java.io.PrintWriter out = new java.io.PrintWriter(System.out);
  private static java.util.StringTokenizer tokenizer = null;
  private static java.io.BufferedReader reader;

  public static String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new java.util.StringTokenizer(reader.readLine());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  private static double nd() {
    return Double.parseDouble(next());
  }

  private static long nl() {
    return Long.parseLong(next());
  }

  private static int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = ni();
    return a;
  }

  private static char[] ns() {
    return next().toCharArray();
  }

  private static long[] nal(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = nl();
    return a;
  }

  private static int[][] ntable(int n, int m) {
    int[][] table = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[i][j] = ni();
      }
    }
    return table;
  }

  private static int[][] nlist(int n, int m) {
    int[][] table = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[j][i] = ni();
      }
    }
    return table;
  }

  private static int ni() {
    return Integer.parseInt(next());
  }

  private static void tr(Object... o) {
    if (is != System.in)
      System.out.println(java.util.Arrays.deepToString(o));
  }
}
