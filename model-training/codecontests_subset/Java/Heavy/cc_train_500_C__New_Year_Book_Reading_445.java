import java.util.*;

public class C {

  public static int n, m;
  
  public static int[] w = new int [501], b = new int[1001];
  
  public static int[] ordered = new int [1001];
  
  public static boolean[] visited = new boolean[1001];

  public static void main(String [] args) {
    
    Scanner S = new Scanner(System.in);
    n = S.nextInt();
    m = S.nextInt();
    for (int i = 0 ; i < n ; i++)
      w[i] = S.nextInt();
    int k = 0;
    for (int i = 0 ; i < m ; i++) {
      b[i] = S.nextInt() - 1;
      if (!visited[b[i]]) {
        ordered[k++] = b[i];
        visited[b[i]] = true;
      }
    }
    int sum = 0;
    for (int i = 0 ; i < m ; i++) {
      int sumtmp = 0, j = 0;
      for (j = 0 ; ordered[j] != b[i] ; j++)
        sumtmp += w[ordered[j]];
      for ( ; j > 0 ; j--)
        ordered[j] = ordered[j-1];
      ordered[0] = b[i];
      sum += sumtmp;
    }
    System.out.println(sum);
    
  }

}