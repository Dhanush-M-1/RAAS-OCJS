//package codeforces.round447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {
  public static void main(String[] args) throws IOException {
    D a = new D();
    a.run();
  }

  public void run() throws IOException {
    Solution solution = new Solution();
    solution.solve();
  }

  public class Solution {

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public void solve() throws IOException {
      solveNextTest();
    }

    private void solveNextTest() throws IOException {
      String allValues = sc.readLine();
      String[] possibleValues = allValues.split(" ");
      int n = Integer.parseInt(possibleValues[0]);
      int m = Integer.parseInt(possibleValues[1]);

      int[] p = new int[n];
      Set<Integer>[] adj = new Set[300003];

      allValues = sc.readLine();
      possibleValues = allValues.split(" ");
      for (int i=0;i<n;i++) {
        p[i] = Integer.parseInt(possibleValues[i]);
      }

      for (int i=0;i<m;i++) {
        allValues = sc.readLine();
        possibleValues = allValues.split(" ");
        int u = Integer.parseInt(possibleValues[0]);
        int v = Integer.parseInt(possibleValues[1]);
        if (adj[u] == null) {
          adj[u] = new HashSet<>();
        }
        adj[u].add(v);
      }

      Set<Integer> curr = new HashSet<>();
      curr.add(p[n-1]);
      int ans = 0;
      for (int i=n-2;i>=0;i--) {
        boolean flag = true;
        for (Integer x : curr) {
          if (adj[p[i]] == null || !adj[p[i]].contains(x)) {
            flag = false;
            break;
          }
        }
        if (flag) ans++;
        else curr.add(p[i]);
      }
      System.out.println(ans);
    }


  }

}
