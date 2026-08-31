import java.util.Arrays;
import java.util.Scanner;

public class D1831A {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		int[] a = new int[1005];
		int[] b = new int[2005];
		int[][]dp = new int[1005][2005];
		int[][]min = new int[1005][2005];
		
		String str = s.nextLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int k = Integer.parseInt(str.split(" ")[1]);
		int o = Integer.parseInt(str.split(" ")[2]);
		String pp = s.nextLine();
		for(int i = 1; i <= n; i++) 
			a[i]=Integer.parseInt(pp.split(" ")[i-1]);
		String kk = s.nextLine();
		for(int i = 1; i <= k; i++)
			b[i]=Integer.parseInt(kk.split(" ")[i-1]);

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++){
				dp[i][j] = Integer.MAX_VALUE;
				min[i][j] = Integer.MAX_VALUE;
			}
		}
		Arrays.sort(a,1,n+1);
		Arrays.sort(b,1,k+1);
		
		for(int i = 1; i <= k; i++) {
			dp[1][i]= Math.abs(a[1]-b[i])+Math.abs(b[i]-o);
			if(i == 1)
				min[1][i] = dp[1][i];
			else
				min[1][i] = Math.min(min[1][i-1], dp[1][i]);
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = i; j <= k; j++) {
				dp[i][j] = Math.max(Math.abs(a[i]-b[j])+Math.abs(b[j]-o), min[i-1][j-1]);
				min[i][j] = Math.min(min[i][j-1], dp[i][j]);
			}
		}
		
		long ans = Long.MAX_VALUE;
		for(int i = n; i <= k; i++)
			ans = Math.min(ans, dp[n][i]);
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
	}
}
