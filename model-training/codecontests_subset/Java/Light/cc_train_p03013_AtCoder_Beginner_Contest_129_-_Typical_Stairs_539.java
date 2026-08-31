import java.util.Scanner;


	public class Main {
		
		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[] a = new boolean[n+1];
			long[] dp = new long[n+1];
			
			for(int i=0;i<m;i++) {
				a[sc.nextInt()] = true;
			}
			
			dp[0] = 1;
			
			for(int i=1;i<=n;i++) {
				if(a[i]) {
					continue;
				}else {
					dp[i]+=dp[i-1]%1000000007L;
					dp[i]%=1000000007L;
					
					if(i>=2) {
						dp[i]+=dp[i-2]%1000000007L;
						dp[i]%=1000000007L;
					}
				}
			}
			
			System.out.println(dp[n]);
	    }
		
	}
	
