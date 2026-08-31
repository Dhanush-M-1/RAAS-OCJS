import java.util.*;
import java.io.*;
public class destroyIt {
	static int n;
	static ArrayList[][] arr;
	static long[][] dp;
	public static void main(String[] args) {
		FS sc = new FS();
		n = sc.nextInt();
		arr = new ArrayList[n][3];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < 3; ++j) arr[i][j] = new ArrayList<>();
			
			int k = sc.nextInt();
			for(int j = 0; j < k; ++j) {
				int c = sc.nextInt(), d = sc.nextInt();
				arr[i][c - 1].add(d);
			}
			
			for(int j = 0; j < 3; ++j) Collections.sort(arr[i][j]);
		}
		
		dp = new long[10][n + 1];
		for(long[] z : dp) Arrays.fill(z, -1);
		
		long out = go(0, 0);
		
		System.out.println(out);
	}
	static long go(int mod, int idx) {
		if(dp[mod][idx] != -1) return dp[mod][idx];
		
		if(idx == n) return dp[mod][idx] = 0;
		
		long out = 0;
		long big1 = -1, big2 = -1, big3 = -1;
		if(!arr[idx][0].isEmpty()) big1 = (int)arr[idx][0].get(arr[idx][0].size() - 1);
		if(!arr[idx][1].isEmpty()) big2 = (int)arr[idx][1].get(arr[idx][1].size() - 1);
		if(!arr[idx][2].isEmpty()) big3 = (int)arr[idx][2].get(arr[idx][2].size() - 1);
		//try taking one of the threes
		if(big3 != -1) {
			int newMod = (mod + 1) % 10;
			long curr = big3 * (newMod < mod ? 2 : 1) + go(newMod, idx + 1);
			out = Math.max(out, curr);
		}
		//try taking one of the twos and maybe one of the ones
		if(big2 != -1) {
			int newMod = (mod + 1) % 10;
			//try just one two
			long curr = big2 * (newMod < mod ? 2 : 1) + go(newMod, idx + 1);
			out = Math.max(out, curr);
			
			//try also taking a one
			if(big1 != -1) {
				//if we have both and we happen to be using one of our %10 == 0 cards, choose the bigger one to double and use the other as a single
				long bigger = Math.max(big2, big1), smaller = Math.min(big2, big1);
				newMod = (mod + 2) % 10;
				curr = bigger * (newMod < mod ? 2 : 1) + smaller + go(newMod, idx + 1);
				out = Math.max(out, curr);
			}
		}
		//try taking 1, 2, or 3 1s
		if(big1 != -1) {
			long remSum = 0;
			for(int j = 0; j < 3; ++j) {
				int newMod = (mod + 1 + j) % 10;
				int addIdx = arr[idx][0].size() - 1 - j;
				if(addIdx < 0) break;
				if(j != 0) remSum += (int)arr[idx][0].get(addIdx);
				long curr = big1 * (newMod < mod ? 2 : 1) + remSum + go(newMod, idx + 1);
				out = Math.max(out, curr);
			}
		}
		//also try not taking anything lmao
		long curr = go(mod, idx + 1);
		out = Math.max(out, curr);
		
		return dp[mod][idx] = out;
	}
	static class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
/*
4
3
1 2
1 2
1 2
3
1 2
1 2
1 2
2
1 2
1 2
3
1 5
1 6
1 7

*/