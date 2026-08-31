import java.util.*;
public class task1{
  static List<Integer>[] Graph, Res;
  static int[] Color;
  static int n, m;
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    n  = input.nextInt();
    m = input.nextInt();
    
    Color = new int[n+1];
    Graph = new List[n+1];
    Res = new List[2];
    
    for(int i = 1 ; i <= n ; i++) 
      Graph[i] = new ArrayList<>();
    for(int i = 0 ; i < 2 ; i++)
      Res[i] = new ArrayList<>();
    for(int i = 0 ; i < m ; i++) {
      int u = input.nextInt();
      int v = input.nextInt();
      Graph[u].add(v);
      Graph[v].add(u);
    }  
    for(int i = 1 ; i <= n-1 ; i++) {
      if(Color[i] == 0) {
        if(Graph[i].isEmpty())
          continue;
        if(DFS(i, 2)) {
          System.out.println(-1);
          return;
        }
      }
    }
    for(int i = 0 ; i < 2 ; i++) {
      System.out.println(Res[i].size());
      for(int x : Res[i]) 
        System.out.print(x + " ");
      System.out.println();
    }
  }
  private static boolean DFS(int root, int paint) {
    Color[root] = paint;
    Res[paint - 1].add(root);
    for(int child : Graph[root]) {
      if(Color[child] == 0 && DFS(child, 3 - paint)) 
        return true;
      if(Color[child] != 3 - paint) 
        return true;
    }
    return false;
  }
}