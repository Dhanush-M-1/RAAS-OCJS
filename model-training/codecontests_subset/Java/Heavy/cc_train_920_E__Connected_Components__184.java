import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Set;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author htvu
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    EConnectedComponents solver = new EConnectedComponents();
    solver.solve(1, in, out);
    out.close();
  }

  static class EConnectedComponents {
    Set<Integer>[] g;
    Set<Integer> remained;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt(), m = in.nextInt();
      g = Graph.build(in, n, m, false);
      remained = new TreeSet<>();
      for (int i = 1; i <= n; ++i)
        remained.add(i);

      List<Integer> comps = new ArrayList<>();
      for (int v = 1; v <= n; ++v)
        if (remained.contains(v)) {
          comps.add(bfs(v));
        }

      Collections.sort(comps);
      out.println(comps.size());
      for (int c : comps)
        out.print(c + " ");
    }

    private int bfs(int start) {
      Deque<Integer> q = new ArrayDeque<>();
      q.offer(start);
      remained.remove(start);
      int count = 1;
      while (!q.isEmpty()) {
        int v = q.poll();
        List<Integer> next = new ArrayList<>();
        for (int u : remained)
          if (!g[v].contains(u)) {
            next.add(u);
          }
        for (int u : next) {
          remained.remove(u);
          q.offer(u);
        }
        count += next.size();
      }
      return count;
    }

  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

  }

  static class Graph {
    public static Set<Integer>[] build(InputReader in, int numV, int numE, boolean zeroIndex) {
      // offset for neighbors array
      int offset = zeroIndex ? 0 : 1;
      Set<Integer>[] g = new Set[numV + offset];
      for (int i = offset; i < numV + offset; ++i)
        g[i] = new HashSet<>();

      for (int i = 0; i < numE; ++i) {
        // offset for vertices
        offset = zeroIndex ? 1 : 0;
        int u = in.nextInt() - offset, v = in.nextInt() - offset;
        g[u].add(v);
        g[v].add(u);
      }
      return g;
    }

  }
}

