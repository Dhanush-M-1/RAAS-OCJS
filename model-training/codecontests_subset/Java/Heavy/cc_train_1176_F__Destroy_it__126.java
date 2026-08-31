import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	
	private static long[] dp = new long[10] , nextDp = new long[10];	
	private static boolean[] vis = new boolean[10];	
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);				
		int i , t = scan.nextInt();
		Arrays.fill(dp , - 1);
		dp[0] = 0;		
		while (t > 0) {
			int k = scan.nextInt();
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			int max2 = 0 , max3 = 0;			
			for (i = 0;i < k;i ++) {
				int cost , damage;
				cost = scan.nextInt();
				damage = scan.nextInt();
				if (cost == 1) {
					queue.add(damage);
					if (queue.size() > 3) {
						queue.poll();
					} 
				} else if (cost == 2) {
					max2 = Math.max(max2 , damage);
				} else {
					max3 = Math.max(max3 , damage);					
				}
			}
			List<int[]> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				list.add(new int[] {1 , queue.poll()});				
			}
			if (max2 > 0) {
				list.add(new int[] {2 , max2});
			}
			if (max3 > 0) {
				list.add(new int[] {3 , max3});
			}			
			// find all permutations
			for (i = 0;i < 10;i ++) {
				nextDp[i] = dp[i];
			}
			Arrays.fill(vis , false);			
			backtracking(list , 0 , new ArrayList<>());
			for (i = 0;i < 10;i ++) {
				dp[i] = nextDp[i];				
			}
			t --;
		}
		long ans = 0;
		for (i = 0;i < 10;i ++) {
			ans = Math.max(ans , dp[i]);
		}
		System.out.println(ans);
	}
	
	private static void backtracking(List<int[]> list , int cost , List<Integer> damageList) {
		if (cost > 3) {
			return;			
		} else {
			if (!damageList.isEmpty()) {
				// try update nextDp
				for (int i = 0;i < 10;i ++) {
					if (dp[i] >= 0) {						
						long value = dp[i];					
						int index = i;					
						for (int j = 0;j < damageList.size();j ++) {
							index = (index + 1) % 10;
							if (index == 0) {
								value += damageList.get(j) * 2;							
							} else {
								value += damageList.get(j);							
							}
						}
						if (value > nextDp[index]) {
							nextDp[index] = value;						
						}
					}
				}
			}
		}		
		int i , n = list.size();
		for (i = 0;i < n;i ++) {
			if (!vis[i]) {
				vis[i] = true;				
				damageList.add(list.get(i)[1]);				
				backtracking(list , cost + list.get(i)[0] , damageList);
				damageList.remove(damageList.size() - 1);				
				vis[i] = false;
			}
		}
	}
	
}



