import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    int[][] s = new int[N][2];
    for (int i = 0; i < N; i++) {
      s[i][0] = sc.nextInt();
      s[i][1] = sc.nextInt();
    }
    
    int[][] cp = new int[M][2];
    for (int i = 0; i < M; i++) {
      cp[i][0] = sc.nextInt();
      cp[i][1] = sc.nextInt();
    }
    
    for (int i = 0; i < N; i++) {
      int minValue = Integer.MAX_VALUE;
      int minIdx = 0;
      for (int j = 0; j < M; j++) {
        int value = Math.abs(s[i][0]-cp[j][0]) + Math.abs(s[i][1]-cp[j][1]);
        if (value < minValue) {
          minValue = value;
          minIdx = j;
        }
      }
      System.out.println(minIdx+1);
    }
  }
}