import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.BigInteger;
import static java.lang.Math.*;

public class Sol implements Runnable {
	final int [] dx = new int[] {-1, 0, 0, 1};
	final int [] dy = new int[] {0, -1, 1, 0};
	final int INF = Integer.MAX_VALUE;

	char [][] b;
	int [] dirs;

	int getDir(char ch) {
		if (ch == 'L') return 0;
		if (ch == 'U') return 1;
		if (ch == 'D') return 2;
		if (ch == 'R') return 3;
		return -1;
	}

      
      int go(int pos, int [][] next) {
      	if (pos == INF || dirs[pos] == -1) return 0;
      	for (int dir = 0; dir < 4; dir++) {
      		int npos = next[dir][pos];
      		if (npos == INF) continue;
      		next[3 - dir][npos] = next[3 - dir][pos];
      	}
      	int cdir = dirs[pos];
      	int npos = next[cdir][pos];
      	return go(npos, next) + 1;
      }
	
	void solve() throws Exception {
		int n = nextInt(), m = nextInt();
		int K = n * m;
		b = new char[n][m];
		for (int i = 0; i < n; i++) {
			b[i] = in.readLine().toCharArray();
		}
		dirs = new int[K];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dirs[i * m + j] = getDir(b[i][j]);
			}
		}

		int [][] next = new int[4][K];
		for (int i = 0; i < n; i++) {
			next[0][i * m + 0] = INF;
			for (int j = 1; j < m; j++) {
				next[0][i * m + j] = (b[i][j - 1] == '.') ? next[0][i * m + j - 1] : i * m + (j - 1);
			}
			next[3][i * m + m - 1] = INF;
			for (int j = m - 2; j >= 0; j--) {
				next[3][i * m + j] = (b[i][j + 1] == '.') ? next[3][i * m + j + 1] : i * m + (j + 1);
			}			
		}
		for (int i = 0; i < m; i++) {
			next[1][0 * m + i] = INF;
			for (int j = 1; j < n; j++) {
				next[1][j * m + i] = (b[j - 1][i] == '.') ? next[1][(j - 1) * m + i] : (j - 1) * m + i;
			}
			next[2][(n - 1) * m + i] = INF;
			for (int j = n - 2; j >= 0; j--) {
				next[2][j * m + i] = (b[j + 1][i] == '.') ? next[2][(j + 1) * m + i] : (j + 1) * m + i;
			}			
		}

		int [][] buf = new int[4][K];
		int [][] ans = new int[n][m];
		int best = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int dir = 0; dir < 4; dir++) {
					System.arraycopy(next[dir], 0, buf[dir], 0, K);
				}
				ans[i][j] = go(i * m + j, buf);
				best = max(best, ans[i][j]);	
			}
		}

		int bestCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ans[i][j] == best) {
					bestCount++;
				}
			}
		}

		out.println(best + " " + bestCount);
	}

	public static void main(String[] args) {
		new Thread(new Sol()).start();
	}

	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	StringTokenizer tokenizer = new StringTokenizer("");
	BufferedReader in;
	PrintWriter out;
	long time;

	void sTime() {
		time = System.currentTimeMillis();
	}

	long gTime() {
		return System.currentTimeMillis() - time;
	}

	void gMemory() {
		debug("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + " kb");
	}

	public void debug(Object o) {
		System.err.println(o);
	}
	
	boolean seekForToken() {
		while (!tokenizer.hasMoreTokens()) {
			String s = null;
			try {
				s = in.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (s == null)
				return false;
			tokenizer = new StringTokenizer(s);
		}
		return true;
	}

	String nextToken() {
		return seekForToken() ? tokenizer.nextToken() : null;
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBig() {
		return new BigInteger(nextToken());
	}
}
