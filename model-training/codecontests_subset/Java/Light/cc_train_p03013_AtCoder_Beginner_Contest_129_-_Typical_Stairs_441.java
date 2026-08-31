import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int []a = new int [m];
		boolean []jdg = new boolean [n+1];
		long []Dp = new long [n+1];
		int p = 1000000007;
		
		for(int i = 0; i < m ; i++) {
			a[i] = sc.nextInt();
			jdg [a[i]] = true;
		}
		Dp[0] = 1;
		
		for(int i = 1 ; i <= n; i++) {
			if(jdg[i] == false) {
			 if(i == 1)
				Dp[i] = Dp[i -1];
			 if(i >= 2) {
				 Dp[i] = (Dp[i-1])%p+(Dp[i-2])%p;
			     Dp[i] = Dp[i]%p;
			}
		}
			if(jdg[i] == true) {
				Dp[i] = 0;
			}
		
		}
		System.out.println(Dp[n]);
	}
		
}


