import java.util.*;
public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] p = new int[n+1];
      int cnt = 0;
      for(int i = 1;i <= n;i++)p[i]=sc.nextInt();
      for(int i = 1;i <= n-1;i++){
      	if(p[i]==i){
          int t = p[i+1];
          p[i+1]=p[i];
          p[i]=t;
          cnt++;
        }
      }
      if(p[n]==n)cnt++;
      System.out.println(cnt);
    }
}