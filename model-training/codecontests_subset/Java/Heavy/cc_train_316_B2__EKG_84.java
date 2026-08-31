import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

public class P316B {
  static int n, x;
  static int tag = 0;
  static int[] comp = null;
  static int[] amt = null;
  static boolean[] dp = null;
  static boolean[] visited = null;
  public static void main(String[] args) throws Exception {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());
    n = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken()) - 1;
    int[] f = new int[n];
    st = new StringTokenizer(r.readLine());
    for (int i = 0; i < n; i++) {
      f[i] = Integer.parseInt(st.nextToken()) - 1;  
    }
    comp = new int[n];
    Arrays.fill(comp, -1);
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (f[i] != -1) {
        graph[i].add(f[i]);
        graph[f[i]].add(i);
      }
    }
    for (int i = 0; i < n; i++) {
      if(comp[i] == -1) dfs(graph, i, tag++);
    }
    amt = new int[tag];
    Arrays.fill(amt, 0);
    int color = -1;
    for (int i = 0; i < n; i++) {
      if (i == x) color = comp[i];
      amt[comp[i]]++;
    }
    dp = new boolean[n + 1];
    knapsack(color);
    int pos = findInd(x, f);
    for (int i = 0; i < dp.length; i++) {
      if (dp[i]) {
        int ans = pos + i;
        System.out.println(ans);
      }
    }
    System.exit(0);
  }
  static void knapsack(int no) {
    Arrays.fill(dp, false);
    dp[0] = true;
    for (int i = 0; i < tag; i++) {
      if (i == no) continue;
      for (int j = n - 1; j >= 0; j--) {
        if (dp[j] && j + amt[i] < n) {
          dp[j + amt[i]] = true;
        }
      }
    }

  }
  static void dfs(ArrayList<Integer>[] graph, int v, int tag) {
    comp[v] = tag;
    for (int i = 0; i < graph[v].size(); i++) {
      int neighbor = graph[v].get(i);
      if (comp[neighbor] == -1) dfs(graph, neighbor, tag);
    }
  }
  static int findInd(int x, int[] f) {
    int next = x;
    int pos = 0;
    while (next != -1) {
      pos++;
      next = f[next];
    }
    return pos;
  }
}
