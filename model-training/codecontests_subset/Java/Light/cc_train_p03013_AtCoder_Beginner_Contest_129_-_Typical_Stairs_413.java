import java.util.*;
public class Main{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      int[] dp = new int[n+3];
      Set<Integer> set = new HashSet<Integer>();
      for(int i = 0;i < m;i++){
        a[i] = sc.nextInt();
        set.add(a[i]);
      }
      dp[0] = 0;
      if(set.contains(1)){
        dp[1]=0;
      }else dp[1]=1;
      if(set.contains(2)){
      	dp[2]=0;
      }else dp[2] = dp[1]+1;
      for(int i = 3;i <= n;i++){
      	if(set.contains(i)) dp[i]=0;
        else dp[i]=(dp[i-1]+dp[i-2])%1000000007;
      }
      System.out.println(dp[n]);
    }
    public static int lcm(int x, int y){
      return x*y/gcd(x,y);
    }
    public static int gcd(int x, int y){
      if(x < y)return gcd(y,x);
      if(y==0)return x;
      return gcd(y,x%y);
    }
}