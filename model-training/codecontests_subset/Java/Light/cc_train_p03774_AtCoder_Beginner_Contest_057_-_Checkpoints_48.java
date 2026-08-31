import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
    
		// 整数の入力
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] students = new int[n][2];
        for(int i = 0; i < n; i++) {
          students[i][0] = sc.nextInt();
          students[i][1] = sc.nextInt();
        }
        int[][] points = new int[m][2];
        for(int i = 0; i < m; i++) {
          points[i][0] = sc.nextInt();
          points[i][1] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
          int x1 = students[i][0];
          int y1 = students[i][1];
          int nearestIndex = 0;
          int ans = Integer.MAX_VALUE;
          for(int index = 0; index < m; index++) {
            int value = Math.abs(x1 - points[index][0]) 
                + Math.abs(y1 - points[index][1]);
            if (value < ans) {
              nearestIndex = index;
              ans = value;
            }
          }
          // 出力
		  System.out.println(nearestIndex + 1);
        }
	}
}