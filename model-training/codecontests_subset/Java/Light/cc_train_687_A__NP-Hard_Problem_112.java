import java.util.LinkedList;
import java.util.Scanner;

public class NPHard {

  static int n, m, x, y;
  static int[] colors = new int[1000000];
  static LinkedList<Integer> v[];
  static LinkedList<Integer> edges[];

  public static void main(String[] args) {
    driver();
  }

  static void driver() {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    v = new LinkedList[2];
    v[0] = new LinkedList();
    v[1] = new LinkedList();

    edges = new LinkedList[n+1];
    for (int i=1; i<=n; i++) {
        edges[i] = new LinkedList();
    }

    for (int i=0; i<m; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      edges[x].add(y);
      edges[y].add(x);
    }


    for (int i=1; i <= n; i++) {
      if (colors[i] == 0) {
        if(edges[i] != null && edges[i].isEmpty()) { continue; }
        if(dfs(i,2)) {
          System.out.println("-1");
          return;
        }
      }
    }

    for (int i=0; i<2; i++) {
      System.out.println(v[i].size());
      for (int y : v[i]) {
        System.out.print(y + " ");
      }
      System.out.println();
    }
  }

  static boolean dfs(int x, int c) {
    colors[x] = c;
    v[c-1].add(x);
    for (int y : edges[x]) {
      if(colors[y] == 0 && dfs(y, 3-c)) { return true; }
      if(colors[y] != 3-c) { return true; }
    }
    return false;
  }
}
