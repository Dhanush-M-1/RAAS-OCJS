import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bottles {
	static int[][][] dp;
	static int n;
	static int[] soda, cap;
	static Pair[] bottles;
	static int inf = (int) 10e7;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() + " " + br.readLine());
		soda = new int[n];
		cap = new int[n];
		bottles = new Pair[n];
		
		
		int total = 0;
		for (int i = 0; i < n; i++){
			soda[i] = Integer.parseInt(st.nextToken());
			total += soda[i];
		}
		
		for (int i = 0; i < n; i++) 
			cap[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) 
			bottles[i] = new Pair(cap[i], soda[i]);
		
		Arrays.sort(bottles);
		int k = 0;
		int max = total;
		
		for(int i = 0; i < n; i++) {
			if(max <= 0)
				break;
			max -= bottles[i].cap;
			k++;
		}
		
		dp = new int[n + 1][k + 1][100*100+1];
		for (int i = 0; i < dp.length; i++) 
			for (int j = 0; j < dp[i].length; j++) 
				for(int l = 0; l < dp[i][j].length; l++)
					dp[i][j][l] = -1;
		
		for(int[][] a: dp)
			for(int [] b : a)
				Arrays.fill(b, -1);
		
		int sol = solve(0, k, total);
//		System.out.println(sol);
		System.out.println(k + " " + (total - sol));
	}
	
	public static int solve(int i, int taken, int w)
	{
		if(taken == 0){
			if(w <= 0)
				return 0;
			else
				return -inf;
		}
		if(w <= 0)
			return 0;
		if(i >= n)
			return -inf;
		
		if(dp[i][taken][w] != -1)
			return dp[i][taken][w];
		
		int a = solve(i + 1, taken, w);
		int b = bottles[i].soda + solve(i + 1, taken - 1, w - bottles[i].cap);
		
		return dp[i][taken][w] = Math.max(a, b);
	}
	
	static class Pair implements Comparable<Pair>{
		int cap, soda;
		
		public Pair(int c, int s)
		{
			cap = c;
			soda = s;
		}

		@Override
		public int compareTo(Pair o) {
			return -((Integer)cap).compareTo(o.cap);
		}
		
		
	}
}