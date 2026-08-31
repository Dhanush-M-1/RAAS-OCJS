import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import sun.rmi.server.UnicastRef;

/*
 public class _920e {

 }

 */
public class _920e {
  public void solve() throws FileNotFoundException {
    InputStream inputStream = System.in;

    InputHelper in = new InputHelper(inputStream);

    // actual solution
    int n = in.readInteger();

    int m = in.readInteger();

    Set[] g = new Set[n];

    for (int i = 0; i < n; i++) {
      g[i] = new HashSet<Integer>();
    }

    for (int i = 0; i < m; i++) {
      int x = in.readInteger() - 1;
      int y = in.readInteger() - 1;

      g[x].add(y);
      g[y].add(x);
    }

    TreeSet<Integer> unvisv = new TreeSet<Integer>();
    for (int i = 0; i < n; i++) {
      unvisv.add(i);
    }

    boolean[] vis = new boolean[n];

    List<Integer> ans = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      cs = 0;
      if (!vis[i]) {
        dfs(i, vis, unvisv, g);
        ans.add(cs);
      }
    }

    ans.sort((x1, x2) -> x1 - x2);

    System.out.println(ans.size());

    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
    // end here
  }

  int cs = 0;

  void dfs(int u, boolean[] vis, TreeSet<Integer> unvisv, Set[] g) {
    vis[u] = true;
    unvisv.remove(u);
    cs++;

    int lv = -1;
    while (unvisv.ceiling(lv + 1) != null) {
      int nv = unvisv.ceiling(lv + 1);
      lv = nv;
      if (g[u].contains(lv))
        continue;
      dfs(nv, vis, unvisv, g);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    (new _920e()).solve();
  }

  class InputHelper {
    StringTokenizer tokenizer = null;
    private BufferedReader bufferedReader;

    public InputHelper(InputStream inputStream) {
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      bufferedReader = new BufferedReader(inputStreamReader, 16384);
    }

    public String read() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          String line = bufferedReader.readLine();
          if (line == null) {
            return null;
          }
          tokenizer = new StringTokenizer(line);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      return tokenizer.nextToken();
    }

    public Integer readInteger() {
      return Integer.parseInt(read());
    }

    public Long readLong() {
      return Long.parseLong(read());
    }
  }
}
