	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;
	import java.util.PriorityQueue;
	import java.util.Queue;
	import java.util.Scanner;
	import java.util.Set;

	public class Main{

		public static void main(String[] args) {

			Scanner scanner = new Scanner(System.in);
			String[] t = scanner.nextLine().split(" ");
			int n = Integer.parseInt(t[0]);
			int m = Integer.parseInt(t[1]);
			HashSet<Integer> set = new HashSet<>();

			for(int i = 0; i < m;i++) {
				set.add(scanner.nextInt() - 1);
			}

			long mod = 1000000007;

			long[] dp = new long[n];

			for(int i = 0; i < n; i++) {

				if(!set.contains(i)) {
					if(i == 0) {
						dp[0] = 1;
					}else if(i == 1) {
						dp[i] = dp[0] + 1;
					}else{

					dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
					}
				}

			}


			System.out.println(dp[n - 1]);
		}
	}