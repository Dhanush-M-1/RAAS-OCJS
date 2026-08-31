import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndirectedGraph {
  static List<Integer>[] vert, res;
  static int[] color;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    color = new int[n+1];
    vert = new ArrayList[n+1];
    res = new ArrayList[2];
    for(int i = 1 ; i <= n ; i++) 
      vert[i] = new ArrayList<>();
    for(int i = 0 ; i < 2 ; i++)
      res[i] = new ArrayList<>();
    for(int i = 0 ; i < m ; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      vert[u].add(v);
      vert[v].add(u);
    }  
    for(int i = 2 ; i <= n; i++) {
      if(color[i] == 0) {
        if(vert[i].isEmpty())
          continue;
        if(dfs(i, 2)) {
          System.out.println(-1);
          return;
        }
      }
    }
    for(int i = 0 ; i < 2 ; i++) {
      System.out.println(res[i].size());
      for(int x : res[i]) 
        System.out.print(x + " ");
      System.out.println();
    }
  }
  private static boolean dfs(int a, int b) {
    color[a] = b;
    res[b - 1].add(a);
    for(int c : vert[a]) {
      if(color[c] == 0 && dfs(c, 3 - b)) 
        return true;
      if(color[c] != 3 - b) 
        return true;
    }
    return false;
  }

}
