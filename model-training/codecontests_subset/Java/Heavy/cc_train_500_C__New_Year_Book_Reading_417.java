import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
  BufferedReader reader;

  int nextInt() throws IOException {
    tokenizer.nextToken();
    return (int) tokenizer.nval;
  }

  String next() throws IOException {
    tokenizer.nextToken();
    return tokenizer.sval;
  }

  StreamTokenizer tokenizer;
  Scanner in;

  void run() throws IOException {
    in = new Scanner(System.in);
    //    in = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(System.out);
    reader = new BufferedReader(new InputStreamReader(System.in));
    //    reader = new BufferedReader(new FileReader(new File("input.txt")));
    tokenizer = new StreamTokenizer(reader);
    solve();
    in.close();
    reader.close();
    out.close();

  }


  int[] readAr(int n) throws IOException {
    int[] res = new int[n];
    String[] s = reader.readLine().split(" ");
    for (int i = 0; i < n; i++) res[i] = Integer.parseInt(s[i]);
    return res;
  }


  boolean[][] canSwap;
  int n;
  boolean[] visited;


  int solve(int[] w, int[] perm, int[] read) {
    int res = 0;
    int n = w.length;

    for (int r : read) {
      int where = -1;
      for (int j = 0; j < n; j++) if (perm[j] == r - 1) where = j;
      for (int i = 0; i < where; i++) {
        res += w[perm[i]];
      }
      int x = perm[where];
      for (int i = where; i > 0; i--) {
        perm[i] = perm[i - 1];
      }
      perm[0] = x;
    }
    return res;
  }

  void dfs(int v, List<Integer> comp) {
    comp.add(v);
    visited[v] = true;
    for (int i = 0; i < n; i++) {
      if (canSwap[v][i] && !visited[i]) {
        dfs(i, comp);
      }
    }
  }

  private void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) w[i] = nextInt();
    int[] read = new int[m];
    boolean[] used = new boolean[n];
    int[] perm = new int[n];
    int p = 0;
    for (int i = 0; i < m; i++) read[i] = nextInt();
    for (int r : read) {
      if (!used[r - 1]) {
        perm[p++] = r - 1;
        used[r - 1] = true;
      }
    }

    for (int i = 0; i < n; i++) {
      if (!used[i]) perm[p++] = i;
    }
    System.out.println(solve(w, perm, read));
  }

  private boolean less(int[] a, int[] b) {
    int i = 0;
    while (i < a.length && a[i] == b[i]) i++;
    if (i == a.length) return false;
    return a[i] < b[i];
  }

  public static void main(String[] args) throws IOException {
    new Solution().run();
  }

}