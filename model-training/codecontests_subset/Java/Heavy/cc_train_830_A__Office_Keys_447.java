 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// author : Enigma27


public class RobinKarp {

	static int n;
	static int k;
	static int office;
	
	static long[][] dp;

	static List<Integer> people = new ArrayList<>();
	static List<Integer> keys = new ArrayList<>();

	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		k = in.nextInt();
		office = in.nextInt();
		
		for(int i=0; i<n; i++) {
			people.add(in.nextInt());
		}
		
		for(int i=0; i<k; i++) {
			keys.add(in.nextInt());
		}
		
		Collections.sort(people, Collections.reverseOrder());
		Collections.sort(keys, Collections.reverseOrder());
		
		dp = new long[n][k];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], 9999999999999l);
		}
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<k; j++) {
				
				// take
				
				long takeCalc;
				
				if(i - 1 < 0) {
					takeCalc = 0;
				}
				else if(j - 1 < 0) {
					takeCalc = 9999999999999l;
				}
				else {
					takeCalc = dp[i-1][j-1];
				}
				
				dp[i][j] = Math.max( dist(people.get(i), keys.get(j)), takeCalc);
				
				if(j - 1 >= 0)
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				
			}
		}
		
		System.out.println(dp[n-1][k-1]);

	}


	private static long dist(int x, int xx) {
		return Math.abs(x - xx) + Math.abs(xx - office);
	}

}