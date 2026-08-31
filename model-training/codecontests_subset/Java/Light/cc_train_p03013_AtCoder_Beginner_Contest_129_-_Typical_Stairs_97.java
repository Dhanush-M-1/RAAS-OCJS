import java.util.*;
import static java.lang.System.*;

public class Main{
  public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  
	  int N = sc.nextInt();
	  int M = sc.nextInt();
	  long [] DP = new long[N + 1]; //動的計画法

	  for(int i=0; i<M; i++) {
		  int n = sc.nextInt();
		  DP[n] = -1;
	  }
	  DP[0] = 1;
	  if(DP[1] != -1)DP[1] = 1;
	  else DP[1] = 0;
	  
	  for(int i=2; i<=N; i++) {
		  if ( DP[i] == -1) DP[i] = 0;
		  else {
			  DP[i] = DP[i-1] + DP[i-2];
			  DP[i] %= 1000000007;
		  }
	  }
	  long ans = DP[N] % 1000000007;
	  out.println(ans);
  }
}