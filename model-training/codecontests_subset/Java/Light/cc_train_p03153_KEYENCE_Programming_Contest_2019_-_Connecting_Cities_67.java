import java.util.Arrays;

class DisjointSet {
  public int[] upper; // minus:num_element(root) plus:root(normal)
  
  public DisjointSet(int n)
  {
      upper = new int[n];
      Arrays.fill(upper, -1);
  }
  
  public int root(int x)
  {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
  }
  
  public boolean equiv(int x, int y)
  {
      return root(x) == root(y);
  }
  
  public boolean union(int x, int y)
  {
      x = root(x);
      y = root(y);
      if(x != y) {
          if(upper[y] < upper[x]) {
              int d = x; x = y; y = d;
          }
          upper[x] += upper[y];
          upper[y] = x;
      }
      return x == y;
  }
}

class SegmentTreeRMQLPos {
  public int M, H, N;
  public long[] st;
  public int[] pos;
  
  public SegmentTreeRMQLPos(int n)
  {
      N = n;
      M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
      H = M>>>1;
      st = new long[M];
      pos = new int[M];
      for(int i = 0;i < N;i++)pos[H+i] = i;
      Arrays.fill(st, 0, M, Long.MAX_VALUE);
      for(int i = H-1;i >= 1;i--)propagate(i);
  }
  
  public SegmentTreeRMQLPos(long[] a)
  {
      N = a.length;
      M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
      H = M>>>1;
      st = new long[M];
      pos = new int[M];
      for(int i = 0;i < N;i++){
          st[H+i] = a[i];
          pos[H+i] = i;
      }
      Arrays.fill(st, H+N, M, Long.MAX_VALUE);
      for(int i = H-1;i >= 1;i--)propagate(i);
  }
  
  public void update(int pos, long x)
  {
      st[H+pos] = x;
      for(int i = (H+pos)>>>1;i >= 1;i >>>= 1)propagate(i);
  }
  
  private void propagate(int i)
  {
      if(st[2*i] <= st[2*i+1]){
          st[i] = st[2*i];
          pos[i] = pos[2*i];
      }else{
          st[i] = st[2*i+1];
          pos[i] = pos[2*i+1];
      }
  }
  
  public int minpos;
  public long minval;
  
  public long minx(int l, int r){
      minval = Long.MAX_VALUE;
      minpos = -1;
      if(l >= r)return minval;
      while(l != 0){
          int f = l&-l;
          if(l+f > r)break;
          long v = st[(H+l)/f];
          if(v < minval){
              minval = v;
              minpos = pos[(H+l)/f];
          }
          l += f;
      }
      
      while(l < r){
          int f = r&-r;
          long v = st[(H+r)/f-1];
          if(v < minval){
              minval = v;
              minpos = pos[(H+r)/f-1];
          }
          r -= f;
      }
      return minval;
  }
  
  public long min(int l, int r){ 
      minpos = -1;
      minval = Long.MAX_VALUE;
      min(l, r, 0, H, 1);
      return minval;
  }
  
  private void min(int l, int r, int cl, int cr, int cur)
  {
      if(l <= cl && cr <= r){
          if(st[cur] < minval){
              minval = st[cur];
              minpos = pos[cur];
          }
      }else{
          int mid = cl+cr>>>1;
          if(cl < r && l < mid)min(l, r, cl, mid, 2*cur);
          if(mid < r && l < cr)min(l, r, mid, cr, 2*cur+1);
      }
  }
}


public class Main {


  private static void solve() {
    int n = ni();
    long d = ni();
    int[] a = na(n);
    int[][] p = new int[n][2];
    for (int i = 0; i < n; i ++) {
      p[i][0] = i;
      p[i][1] = a[i];
    }
    Arrays.sort(p, (o1, o2) ->o1[1] - o2[1]);
    SegmentTreeRMQLPos[] st = {new SegmentTreeRMQLPos(n), new SegmentTreeRMQLPos(n)};
    
    int[] from = new int[n * 3];
    int[] to = new int[n * 3];
    long[] w = new long[n * 3];
    
    int ptr = 0;
    for (int k = 0; k < 2; k ++) {

      int e = k == 0 ? 0 : n - 1;
      for (int i = 0; i < n; i ++) {
        int j = p[i][0];
        long ret = st[k].min(Math.min(e, j), Math.max(e, j) + 1);
        long l = k == 0 ? (n - j - 1) : j;
        if (st[k].minpos >= 0) {
          from[ptr] = j;
          to[ptr] = st[k].minpos;
          w[ptr] = ret - l * d + a[j];
          ptr ++;
        }
        st[k].update(j, a[j] + l * d);
      }
    }
    
    DisjointSet ds = new DisjointSet(n);
    long[][] idx = new long[ptr][2];
    for (int i = 0; i < ptr; i ++) {
      idx[i][0] = i;
      idx[i][1] = w[i];
    }
    Arrays.sort(idx, (o1, o2) -> Long.compare(o1[1], o2[1]));
    long ret = 0;
    for (int i = 0; i < ptr; i ++) {
      int j = (int)idx[i][0];
      if (!ds.equiv(from[j], to[j])) {
        ds.union(from[j], to[j]);
        ret += w[j];
      }
    }
    System.out.println(ret);
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
