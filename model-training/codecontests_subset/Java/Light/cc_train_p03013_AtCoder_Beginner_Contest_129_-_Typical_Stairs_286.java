import java.util.*;

public class Main {
	
	static long MOD  = 1000000007;
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		HashSet<Integer> broken = new HashSet<>();
		
		for(int i =0;i<m;i++)broken.add(sc.nextInt());
		
		long[] dp = new long[n+1];
		
		
		dp[0]=1;
		if(broken.contains(1))dp[1]=0;
		else dp[1]=1;
		
		for(int i=2;i<n+1;i++) {
			if(broken.contains(i)) {
				dp[i]=0;
			}else{
				dp[i]=dp[i-2]%MOD +dp[i-1]%MOD;
			}
		}
		
		//for(int i=0;i<n+1;i++)System.out.println(dp[i]);
		long ans = dp[n]%MOD;
		System.out.println(ans);
		
		
	}

}
