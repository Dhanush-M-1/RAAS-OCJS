import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int[][] F = new int[N][10];
    int[][] P = new int[N][11];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 10; j++) {
        F[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 11; j++) {
        P[i][j] = sc.nextInt();
      }
    }

    sc.close();
    
    int max = Integer.MIN_VALUE;

    // 0000000000 ~ 1111111111パターン生成
    for(int mask = 1 ; mask < (1 << 10) ; mask++) {

			int score = 0;
      
      for(int i = 0 ; i < N ; i++) {
      
        int cnt = 0;
      
        for(int j = 0 ; j < 10 ; j++) {
      
          if(((mask >> j)&1) == 1 && F[i][j] == 1) {
            cnt++;
          }
      
        }
      
        score += P[i][cnt];
      
      }
      
      max = Math.max(max, score);
    
    }
    
    System.out.println(max);

  }

}