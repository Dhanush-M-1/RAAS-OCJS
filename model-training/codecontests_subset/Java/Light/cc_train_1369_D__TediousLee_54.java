import java.util.*;

public class First {
	public static void main(String[] args) {
		
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		long[] dp = new long[2000001];
		dp[2]=0;
		dp[1]=0;
		for(int i=3;i<2000001;i++){
			dp[i]=(dp[i-1])%1000000007;
			dp[i]+=(2*dp[i-2])%1000000007;
			
			if(i%3==0){
				dp[i]+=1;
			}
			dp[i]=dp[i]%1000000007;
		}
		while(t--!=0){
			int n = sc.nextInt();
			long x=(dp[n]*4)%1000000007;
			System.out.println(x);
		}

	}
}