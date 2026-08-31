import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);       
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[n+1];
		for(int i=0; i<m; i++) {
		    a[i] = Integer.parseInt(sc.next());
		    b[a[i]] = 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 1;
		if(b[1] == 1) dp[1] = 0;
		else dp[1] = 1;
		if(n > 1) {
		    for(int i=2; i<n+1; i++) {
		        if(b[i] == 1) dp[i] = 0;
		        else dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
		    }
		}else {
		    dp[1] = 1;
		}
		System.out.println(dp[n]);
	}
}