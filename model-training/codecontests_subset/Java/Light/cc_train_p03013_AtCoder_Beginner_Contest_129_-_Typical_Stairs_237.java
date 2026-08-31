import java.util.*;

class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    final int modder=1000000007;
    int n=sc.nextInt();
    int m=sc.nextInt();
    Deque<Integer> h=new ArrayDeque<>(m);
    for(int i=0;i<m;i++){
      h.addLast(sc.nextInt());
    }
    int dp[]=new int[n+1+2];
    Arrays.fill(dp,0);
    dp[0]=1;
    for(int i=0;i<=n;i++){
      if(h.peekFirst()!=null&&h.peekFirst()==i){
        h.pollFirst();
        dp[i]=0;
      }else{
        dp[i+1]=(dp[i+1]+dp[i])%modder;
        dp[i+2]=(dp[i+2]+dp[i])%modder;
      }
    }
    System.out.println(dp[n]);
  }
}