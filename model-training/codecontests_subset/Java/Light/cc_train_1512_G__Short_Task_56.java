import java.util.*;

public class short_task {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = 10000000;
		
		
		int[] dp = new int[C];
		int[] aa = new int[C + 1]; Arrays.fill(aa, -1);
		
		for (int a = 1; a < C; a++) {
			for (int b = a; b < C; b += a)
				dp[b] += a;
			int c = dp[a];
			if (c <= C && aa[c] == -1)
				aa[c] = a;
		}
		
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int c = sc.nextInt();
			System.out.println(aa[c]);
		}
		
	}
 
}
