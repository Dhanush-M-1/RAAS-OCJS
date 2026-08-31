import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    final int modder=1000000007;
    int n=sc.nextInt();
    int m=sc.nextInt();
    int dp[]=new int[n+1];
    Arrays.fill(dp,0);
    for(int i=0;i<m;i++){
      dp[sc.nextInt()]=-1;
    }
    dp[0]=1;
    dp[1]=dp[1]==-1?0:1;
    for(int i=2;i<=n;i++){
      if(dp[i]!=-1){
        dp[i]=(dp[i-1]+dp[i-2])%modder;
      }else{
        dp[i]=0;
      }
    }
    System.out.println(dp[n]);
  }
}
