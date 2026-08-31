import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            pass System Test!
*/

public class D {
  private static class Task {
    final long INF = (long) 1e18;

    class Edge {
      int from;
      int to;
      boolean undefined;
      Edge(int from, int to, boolean undefined) {
        this.from = from;
        this.to = to;
        this.undefined = undefined;
      }
    }

    class State implements Comparable<State> {
      int v;
      long weight;
      State(int v, long weight) {
        this.v = v;
        this.weight = weight;
      }

      @Override
      public int compareTo(State o) {
        return Long.signum(this.weight - o.weight);
      }
    }

    ArrayList<Edge>[] graph;
    long[][] weights;

    long dijkstra(int s, int t) {
      int N = graph.length;
      long[] dist = new long[N];
      Arrays.fill(dist, INF);
      dist[s] = 0;
      PriorityQueue<State> queue = new PriorityQueue<>();
      queue.add(new State(s, 0));
      while (!queue.isEmpty()) {
        if (queue.peek().v == t) return queue.peek().weight;
        int v = queue.poll().v;
        for (Edge edge : graph[v]) {
          long d = weights[v][edge.to];
          if (dist[edge.to] <= dist[v] + d) continue;
          dist[edge.to] = dist[v] + d;
          queue.add(new State(edge.to, dist[edge.to]));
        }
      }
      return dist[t];
    }

    void solve(FastScanner in, PrintWriter out) {
      int N = in.nextInt();
      int M = in.nextInt();
      int L = in.nextInt();
      int s = in.nextInt();
      int t = in.nextInt();
      graph = new ArrayList[N];
      for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

      int[][] edges = new int[M][];
      weights = new long[N][N];
      for (int i = 0; i < M; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        int w = in.nextInt();

        graph[u].add(new Edge(u, v, w == 0));
        graph[v].add(new Edge(v, u, w == 0));

        edges[i] = new int[]{u, v};

        weights[u][v] = w;
        weights[v][u] = w;
      }

      for (ArrayList<Edge> g : graph)
        for (Edge e : g)
          if (e.undefined) {
            weights[e.to][e.from] = 1;
            weights[e.from][e.to] = 1;
          }
      long min = dijkstra(s, t);
      for (ArrayList<Edge> g : graph)
        for (Edge e : g)
          if (e.undefined) {
            weights[e.to][e.from] = INF;
            weights[e.from][e.to] = INF;
          }
      long max = dijkstra(s, t);

      if (L < min || max < L) {
        out.println("NO");
        return;
      }

      if (L < max) {
        for (int i = 0; i < N; i++) {
          ArrayList<Edge> g = graph[i];
          for (Edge e : g)
            if (e.undefined) {
              weights[e.to][e.from] = 1;
              weights[e.from][e.to] = 1;
              long d = dijkstra(s, t);
              if (d <= L) {
                weights[e.to][e.from] = L - d + 1;
                weights[e.from][e.to] = L - d + 1;
                break;
              }
            }
        }
      }

      out.println("YES");
      for (int[] uv : edges) {
        out.println(uv[0] + " " + uv[1] + " " + weights[uv[0]][uv[1]]);
      }
    }
  }

  /**
   * ここから下はテンプレートです。
   */
  public static void main(String[] args) {
    OutputStream outputStream = System.out;
    FastScanner in = new FastScanner();
    PrintWriter out = new PrintWriter(outputStream);
    Task solver = new Task();
    solver.solve(in, out);
    out.close();
  }
  private static class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int bufferLength = 0;

    private boolean hasNextByte() {
      if (ptr < bufferLength) {
        return true;
      } else {
        ptr = 0;
        try {
          bufferLength = in.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (bufferLength <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) return buffer[ptr++];
      else return -1;
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
    }

    boolean hasNext() {
      skipUnprintable();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) throw new NoSuchElementException();
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    long nextLong() {
      if (!hasNext()) throw new NoSuchElementException();
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    double[] nextDoubleArray(int n) {
      double[] array = new double[n];
      for (int i = 0; i < n; i++) {
        array[i] = nextDouble();
      }
      return array;
    }

    double[][] nextDoubleMap(int n, int m) {
      double[][] map = new double[n][];
      for (int i = 0; i < n; i++) {
        map[i] = nextDoubleArray(m);
      }
      return map;
    }

    public int nextInt() {
      return (int) nextLong();
    }

    public int[] nextIntArray(int n) {
      int[] array = new int[n];
      for (int i = 0; i < n; i++) array[i] = nextInt();
      return array;
    }

    public long[] nextLongArray(int n) {
      long[] array = new long[n];
      for (int i = 0; i < n; i++) array[i] = nextLong();
      return array;
    }

    public String[] nextStringArray(int n) {
      String[] array = new String[n];
      for (int i = 0; i < n; i++) array[i] = next();
      return array;
    }

    public char[][] nextCharMap(int n) {
      char[][] array = new char[n][];
      for (int i = 0; i < n; i++) array[i] = next().toCharArray();
      return array;
    }

    public int[][] nextIntMap(int n, int m) {
      int[][] map = new int[n][];
      for (int i = 0; i < n; i++) {
        map[i] = nextIntArray(m);
      }
      return map;
    }
  }
}