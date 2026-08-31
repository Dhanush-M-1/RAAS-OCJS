 import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 
public class OOPS {
	
	static int n;
	static int k;
	
	static int[] arr;
	static int[] prev;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] arr = new int[n];
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
			
		if(sum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		
		int[][] dp = new int[n][sum/2 + 1];
		
		for(int i=0; i<=sum/2; i++) {
			if(arr[0] > i) {
				dp[0][i] = 0;
			}
			else {
				dp[0][i] = arr[0];
			}
		}
		
		for(int i=1; i<n; i++) {
			
			for(int j=0; j<=sum/2; j++) {
				
				// take this 
				dp[i][j] = dp[i-1][j];
				
				if(j - arr[i] >= 0)
					dp[i][j] = Math.max(dp[i][j], arr[i] +  dp[i-1][j - arr[i]]); 
			}
		}
		
		if(dp[n-1][sum/2] == sum/2) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");

		}
		
		
	}
	
}


