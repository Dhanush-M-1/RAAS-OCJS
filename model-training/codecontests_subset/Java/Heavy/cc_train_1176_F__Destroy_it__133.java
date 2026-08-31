import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class F {

	static int N;
	static int turnGet[];
	static ArrayList<Long> ds[][];
	static long dp[][];
	static long best[][];
	static int sz[][];
	public static void main(String[] args) {
		FS in = new FS();
		N = in.nextInt();
		turnGet = new int[N];
		ds = new ArrayList[3][N];
		for(int i = 0; i < N; i++) {
			turnGet[i] = in.nextInt();
			for(int j = 0; j < 3; j++)
				ds[j][i] = new ArrayList<Long>();
			
			for(int j = 0; j < turnGet[i]; j++) {
				int c = in.nextInt();
				long d = in.nextInt();
				ds[c-1][i].add(d);
			}
		}
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < N; j++)
				Collections.sort(ds[i][j], Collections.reverseOrder());
		sz = new int[3][N];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < N; j++)
				sz[i][j] = ds[i][j].size();
		
		best = new long[3][N];
		for(long a[] : best) Arrays.fill(a, -1);
		for(int i = 0; i < N; i++) {
			if(sz[0][i] > 0)
				best[0][i] = max(best[0][i], ds[0][i].get(0));
			if(sz[0][i] > 1)
				best[1][i] = max(best[1][i], ds[0][i].get(0) + ds[0][i].get(1));
			if(sz[0][i] > 2)
				best[2][i] = max(best[2][i], ds[0][i].get(0) + ds[0][i].get(1) + ds[0][i].get(2));

			if(sz[1][i] > 0)
				best[0][i] = max(best[0][i], ds[1][i].get(0));
			
			if(sz[2][i] > 0)
				best[0][i] = max(best[0][i], ds[2][i].get(0));
			
			if(sz[1][i] > 0 && sz[0][i] > 0)
				best[1][i] = max(best[1][i], ds[0][i].get(0) + ds[1][i].get(0));
		}
		
		dp = new long[10][N];
		for(long a[] : dp)Arrays.fill(a, -1);
		long res = go(0,0);
		System.out.println(res);
	}

	static long max(long a, long b) { return a > b ? a : b;}
	static long go(int cnt, int id) {
		if(id == N) return 0;
		if(dp[cnt][id] != -1) return dp[cnt][id];
		long res = go(cnt, id+1);
		int next = 9-cnt;
		for(int play = 0; play < 3; play++) {
			if(best[play][id] == -1) continue;
			if(play >= next) {
				long score = 0;
				if(play == 0) {
					score = best[0][id] + best[0][id];
				}
				if(play == 1) {
					// 11 or 21
					long sc1 = -1;
					long sc2 = -1;
					if(sz[0][id] > 1)
						sc1 = ds[0][id].get(0) + ds[0][id].get(1) + ds[0][id].get(0);
					if(sz[1][id] > 0 && sz[0][id] > 0)
						sc2 = ds[1][id].get(0) + ds[0][id].get(0) + max(ds[1][id].get(0), ds[0][id].get(0));
					
					score = max(sc1,sc2);
				}
				if(play == 2) {
					score = best[2][id] + ds[0][id].get(0);
				}
				res = max(res, score + go((cnt+play+1)%10,id+1));
			}
			else {
				res = max(res, best[play][id] + go((cnt+play+1)%10, id+1));
			}
		}
		
		return dp[cnt][id] = res;
	}
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
