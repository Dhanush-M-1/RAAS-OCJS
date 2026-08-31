import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][][] F = new int[N][5][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 5; j++) {
        F[i][j][0] = sc.nextInt();
        F[i][j][1] = sc.nextInt();
      }
    }
    int[][] P = new int[N][11];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= 10; j++) {
        P[i][j] = sc.nextInt();
      }
    }
    
    //
    int ans = Integer.MIN_VALUE;
    int m = 1 << 10;
    for (int b = 1; b < m; b++) {
      int sum = 0;
      for (int i = 0; i < N; i++) {
        int count = 0;
        int w = b;
        int j = 0;
        while (w != 0) {
          int am = w % 2;
          w /= 2;
          int pm = w % 2;
          w /= 2;
          if (F[i][j][0] == 1 && am == 1) {
            count++;
          }
          if (F[i][j][1] == 1 && pm == 1) {
            count++;
          }
          j++;
        }
        sum += P[i][count];
      }
      ans = Math.max(ans, sum);
    }
    System.out.println(ans);
  }
}