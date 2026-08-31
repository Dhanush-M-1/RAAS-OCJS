import java.io.*;
import java.util.*;

public class taskD {
	public static void main(String[] args) {
		new taskD().run();
	}

	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void solve() throws IOException {
		int m = nextInt();
		int n = nextInt();
		int l = 0;
		String[] s = new String[m];
		for (int i = 0; i < m; i++) {
			s[i] = br.readLine();
			l = s[i].length();
		}
		int[][] left = new int[m][l];
		int[][] right = new int[m][l];
		int[][] up = new int[m][l];
		int[][] down = new int[m][l];
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < l; j++) {
				if (s[i].charAt(j) == s[i - 1].charAt(j))
					up[i][j] = up[i - 1][j];
				else
					up[i][j] = i;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < l; j++) {
				if (s[i].charAt(j) == s[i].charAt(j - 1))
					left[i][j] = left[i][j - 1];
				else
					left[i][j] = j;
			}
		}
		for (int i = 0; i < m; i++)
			right[i][l - 1] = l - 1;
		for (int i = 0; i < l; i++)
			down[m - 1][i] = m - 1;
		for (int i = m - 1; i >= 0; i--)
			for (int j = l - 2; j >= 0; j--) {
				if (s[i].charAt(j) == s[i].charAt(j + 1))
					right[i][j] = right[i][j + 1];
				else
					right[i][j] = j;

			}
		for (int i = m - 2; i >= 0; i--)
			for (int j = l - 1; j >= 0; j--) {
				if (s[i].charAt(j) == s[i + 1].charAt(j))
					down[i][j] = down[i + 1][j];
				else
					down[i][j] = i;
			}
		int x = 0;
		int y = 0;
		int dp = 0;
		boolean cp = false;
		for (int i = 0; i < n; i++) {
			int nx = x;
			int ny = y;
			if (dp == 0) {
				ny = right[x][y] + 1;
				if (!cp)
					nx = up[x][y];
				else
					nx = down[x][y];
			}
			if (dp == 1) {
				nx = down[x][y] + 1;
				if (!cp)
					ny = right[x][y];
				else
					ny = left[x][y];
			}
			if (dp == 2) {
				ny = left[x][y] - 1;
				if (cp)
					nx = up[x][y];
				else
					nx = down[x][y];
			}
			if (dp == 3) {
				nx = up[x][y] - 1;
				if (cp)
					ny = right[x][y];
				else
					ny = left[x][y];
			}
			if ((nx >= 0) && (nx < m) && (ny >= 0) && (ny < l)
					&& (s[nx].charAt(ny) != '0')) {
				x = nx;
				y = ny;
				continue;
			}
			if (cp)
				dp++;
			dp %= 4;
			cp = !cp;

		}
		out.println(s[x].charAt(y));

	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//br = new BufferedReader(new FileReader("taskD.in"));
			//out = new PrintWriter("taskD.out");

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}