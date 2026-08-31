import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ForProblems {

  int n;
  double[] need, have;
  int[][] p;

  int[] parent;
  List<List<Integer>> tree = new ArrayList<>();
  boolean[] used;

  void solve() {
    n = nextInt();
    have = new double[n];
    for (int i = 0; i < n; i++) {
      have[i] = nextDouble();
    }
    need = new double[n];
    for (int i = 0; i < n; i++) {
      need[i] = nextDouble();
    }
    p = new int[n - 1][2];
    parent = new int[n];
    parent[0] = -1;
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      p[i][0] = nextInt() - 1;
      p[i][1] = nextInt();
      parent[i + 1] = p[i][0];
      tree.get(p[i][0]).add(i + 1);
    }
    used = new boolean[n];
    dfs(0);
    if (have[0] >= need[0]) {
      out.print("YES");
    } else {
      out.print("NO");
    }
  }

  void dfs(int x) {
    used[x] = true;
    for (int y : tree.get(x)) {
      if (!used[y]) {
        dfs(y);
      }
    }
    if (x == 0) {
      return;
    }
    if (have[x] >= need[x]) { //излишки
      double delta = have[x] - need[x];
      have[parent[x]] += delta;
      have[x] -= delta;
    } else { //недостаток
      double delta = need[x] - have[x];
      double k = delta * p[x - 1][1];
      have[x] += k;
      have[parent[x]] -= k;
    }
  }

  public static void main(String[] args) {
    new ForProblems().run();
  }

  void run() {
    try {
      init();
      solve();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  PrintWriter out;
  BufferedReader in;
  StringTokenizer tok = new StringTokenizer("");

  void init() {
    out = new PrintWriter(System.out);
    in = new BufferedReader(new InputStreamReader(System.in));
  }

  String nextString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (Exception e) {
        return null;
      }
    }
    return tok.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(nextString());
  }

  long nextLong() {
    return Long.parseLong(nextString());
  }

  double nextDouble() {
    return Double.parseDouble(nextString());
  }
}
