import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(),m = sc.nextInt();
    int a[] = new int[n],b[] = new int[n];
    int c[] = new int[m],d[] = new int[m];
    for(int i = 0;i < n;i++){
      a[i] = sc.nextInt(); b[i] = sc.nextInt();
    }
    for(int i = 0;i < m;i++){
      c[i] = sc.nextInt(); d[i] = sc.nextInt();
    }
    int place[] = new int[n];
    int dis;
    int near;
    for(int i = 0;i < n;i++){
      near = 200000000;
      for(int j = 0;j < m;j++){
        dis = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);//iとjの距離計算
        if(dis < near){//最も近い地点の記録
          near = dis;
          place[i] = j;
        }
      }
    }
    for(int i = 0;i < n;i++){
      System.out.println(place[i]+1);
    }
  }
}
