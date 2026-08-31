import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] f = new int[n][10];
    int[][] p = new int[n][11];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 10; j++) {
        f[i][j] = sc.nextInt();
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 11; j++) {
        p[i][j] = sc.nextInt();
      }
    }
    int ans = (-1) * Integer.MAX_VALUE;
    for(int i = 1; i < (int)Math.pow(2, 10); i++) {
      int[] kaiten = new int[n];
      for(int j = 0; j < 10; j++) {
        if((i & (1 << j)) != 0) {
          for(int k = 0; k < n; k++) {
            if(f[k][j] == 1) kaiten[k]++;
          }
        }
      }
      int sum = 0;
      for(int j = 0; j < n; j++) {
        sum += (p[j][kaiten[j]]);
      }
      ans = Math.max(ans, sum);
    }
    System.out.println(ans);
  }
}