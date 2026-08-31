import java.lang.reflect.Array;
import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); 
    int M = sc.nextInt(); 
    boolean b[] = new boolean[N+1]; 
    long dp[] = new long[N+1];

    Arrays.fill(b,true);
    for(int i = 0; i < M; i++){
      int tmp = sc.nextInt();  
      b[tmp]= false; 
    }
    dp[0] = 1;
    if(b[1]==true){
      dp[1] = 1;
    }else{
      dp[1] = 0;
    }
    for(int i = 2; i < N+1; i++){
      if(b[i]==true){
        dp[i] = (dp[i-1] + dp[i-2])%1000000007; 
      }else{
        dp[i] = 0; 
      }
    }  
    System.out.println(dp[N]);      
  }
}


