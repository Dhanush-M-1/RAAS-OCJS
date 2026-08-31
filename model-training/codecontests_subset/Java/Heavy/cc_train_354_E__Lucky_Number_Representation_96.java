import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProblemE {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.valueOf(in.readLine());
		for (int i = 0 ; i < T ; i++) {
			long[] ans = solve(Long.valueOf(in.readLine()));
			if (ans == null) {
				out.println(-1);
			} else {
				out.println(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + " " + ans[4] + " " + ans[5]);
			}
		}
		out.flush();
	}
	


	private static long[] solve(long v) {
		char[] c = new StringBuilder(String.valueOf(v)).reverse().toString().toCharArray();
		int l = c.length;
		boolean[][][] dp = new boolean[l+1][7][5];
		int[][][][] taken = new int[l+1][7][5][4];
		
		for (int i = 0 ; i < 7 ; i++) {
			dp[0][i][0] = true;
		}
		for (int i = 0 ; i < l ; i++) {
			for (int live = 0 ; live < 7 ; live++) {
				for (int up = 0 ; up < 5 ; up++) {
					if (!dp[i][live][up]) {
						continue;
					}
					for (int four = 0 ; four <= live ; four++) {
						for (int seven = 0 ; four + seven <= live ; seven++) {
							int digit = four * 4 + seven * 7 + up;
							if (digit % 10 != c[i] - '0') {
								continue;
							}
							int nd = digit/10;
							for (int tl = (live - four - seven) ; tl <= live ; tl++) {
								dp[i+1][tl][nd] = true; 
								taken[i+1][tl][nd][0] = four;
								taken[i+1][tl][nd][1] = seven;
								taken[i+1][tl][nd][2] = live;
								taken[i+1][tl][nd][3] = up;
							}
						}
					}
				}
			}
		}
		
		for (int live = 0 ; live < 7 ; live++) {
			for (int up = 0 ; up <= 0 ; up++) {
				if (dp[l][live][up]) {
					long[] res = new long[6];
					for (int i = l ; i >= 1 ; i--) {
						int f = taken[i][live][up][0];
						int s = taken[i][live][up][1];
						int nlive = taken[i][live][up][2];
						int nup = taken[i][live][up][3];
						long base = (long)Math.pow(10L, i-1);
						for (int j = 0 ; j < f ; j++) {
							res[j] += base * 4;
						}
						for (int j = f ; j < f + s ; j++) {
							res[j] += base * 7;							
						}
						live = nlive;
						up = nup;
					}
					return res;
				}
			}
		}
		return null;
	}



	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}
