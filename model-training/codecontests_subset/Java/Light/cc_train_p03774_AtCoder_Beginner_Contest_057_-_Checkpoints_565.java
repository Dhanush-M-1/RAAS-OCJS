import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.next());
    int M = Integer.parseInt(sc.next());
    
    int[][] stu = new int[N][2];
    for(int i = 0; i < N; i++){
      stu[i][0] = Integer.parseInt(sc.next());
      stu[i][1] = Integer.parseInt(sc.next());
    }
    
    int[][] check = new int[M][2];
    for(int i = 0; i < M; i++){
      check[i][0] = Integer.parseInt(sc.next());
      check[i][1] = Integer.parseInt(sc.next());
    }
    
    for(int i = 0; i < N; i++){
      int ans = 0;
      int min = 1000000000;
      int x1 = stu[i][0];
      int y1 = stu[i][1];
      for(int j = 0; j < M; j++){
        int x2 = check[j][0];
      	int y2 = check[j][1];
        int dis = Math.abs(x1-x2) + Math.abs(y1-y2);
        if(min > dis){
          min = dis;
          ans = j;
        }
      }
      System.out.println(ans+1);
    }
  }
}