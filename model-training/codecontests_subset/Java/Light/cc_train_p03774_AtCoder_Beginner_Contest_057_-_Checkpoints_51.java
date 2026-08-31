import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] d = new int[n+m][2];
    int [] id = new int[n];//距離が最小となるときの地点を格納する配列

    for(int i = 0; i < n+m; i++){
      d[i][0] = sc.nextInt();
      d[i][1] = sc.nextInt();
    }

    for(int i = 0; i < n; i++){
      int min = 4 * (int)Math.pow(10, 8);
      for(int j = n; j < n+m; j++){
        int l = Math.abs(d[i][0] - d[j][0]) + Math.abs(d[i][1] - d[j][1]);
        if(min > l){
          min = l;
          id[i] = j-n+1;
        }else if(min == l && id[i] > j-n+1){
          id[i] = j-n+1;
        }
      }
    }

    for(int i = 0; i < n; i++){
      System.out.println(id[i]);
    }

  }
}
