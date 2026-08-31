import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.lang.Integer.parseInt;

public class m implements Runnable {
  private static final boolean ONLINE_JUDGE = true; //System.getProperty("ONLINE_JUDGE") != null;

  public static void main(String[] args) {
    new Thread(new m()).start();
  }

  @Override
  public void run() {
    try (BufferedReader reader = ONLINE_JUDGE ? new BufferedReader(new InputStreamReader(System.in))
                                              : new BufferedReader(new FileReader("input"));
         Writer writer = ONLINE_JUDGE ? new OutputStreamWriter(System.out) : new FileWriter("output");
         PrintWriter printWriter = new PrintWriter(writer);) {
      Solver solver = new Solver(reader, printWriter);
      while (solver.solve());
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
  }

  static final class Solver {
    final BufferedReader in;
    final PrintWriter out;

    public Solver(BufferedReader reader, PrintWriter writer) {
      in = reader;
      out = writer;
    }

    boolean solve() throws IOException {
      String line = in.readLine();
      if (line == null) {
        return false;
      }
      if (line.isEmpty()) {
        return true;
      }

      StringTokenizer tok = new StringTokenizer(line);
      int n = parseInt(tok.nextToken());
      List<Integer> [] ar = new List[n];
      int[] deg = new int[n];
      for (int i = 1; i < n; ++i) {
        tok = new StringTokenizer(in.readLine());
        int u = parseInt(tok.nextToken()) - 1;
        int v = parseInt(tok.nextToken()) - 1;
        deg[u]++;
        deg[v]++;
        if (ar[u] == null) ar[u] = new ArrayList<Integer>();
        if (ar[v] == null) ar[v] = new ArrayList<Integer>();
        ar[u].add(v);
        ar[v].add(u);
      }

      for (int i = 0; i < n; ++i) {
        if (deg[i] == 2) {
          out.println("NO");
          return true;
        }
      }
      out.println("YES");
      return true;
    }
  }

  static void debug(String s) {
    System.out.println(s);
  }
}
