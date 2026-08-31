import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    // [i][0]: x1 位置 [i][1]: y1 位置
    int[][] student = new int[N][2];

    // [i][0]: x2 位置 [i][1]: y2 位置
    int[][] checkpoint = new int[M][2];

    for (int i = 0; i < N; i++) {
      student[i][0] = sc.nextInt();
      student[i][1] = sc.nextInt();
    }

    for (int i = 0; i < M; i++) {
      checkpoint[i][0] = sc.nextInt();
      checkpoint[i][1] = sc.nextInt();
    }

    sc.close();

    for (int i = 0; i < N; i++) {
      int min = Integer.MAX_VALUE;
      int n = Integer.MAX_VALUE;
      for (int j = 0; j < M; j++) {
        int d = Math.abs(student[i][0] - checkpoint[j][0]) + Math.abs(student[i][1] - checkpoint[j][1]);
        if (d < min){
          min = d;
          n = j + 1;
        }
      }
      System.out.println(n);
    }

  }

}