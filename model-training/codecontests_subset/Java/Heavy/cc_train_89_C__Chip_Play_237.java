import java.io.*;
import java.util.*;

public class Solution implements Runnable {

	BufferedReader input;
	StringTokenizer tokenizer;
	PrintWriter output;
	
	int[] a;
	int n, m;
	int[][] to;
	int best = -1;
	int bestcount = 0;
	
	int[] dr = new int[]{-1, 0, 0, 1};
	int[] dc = new int[]{0, -1, 1, 0};
	int[] da;

	void build()
	{
		da = new int[]{-m, -1, 1, m};
		for (int d = 0; d < 4; d++)
		{
			Arrays.fill(to[d], -1);
			for (int i = 0; i < n * m; i++)
			{
				int r = i / m;
				int c = i % m;
				int r2 = r + dr[d];
				int c2 = c + dc[d];
				int a2 = i + da[d];
				while (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m && a[a2] == -1)
				{
					r2 += dr[d];
					c2 += dc[d];
					a2 += da[d];
				}
				if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m)
				{
					to[d][i] = a2;
				}
			}
		}
	}
	
	void unlink(int u)
	{
		for (int d = 0; d < 4; d++)
		{
			int drev = 3 - d;
			int v = to[d][u];
			if (v == -1) continue;
			if (to[drev][v] != u) throw new RuntimeException();
			to[drev][v] = to[drev][u];
		}
	}
	
	int run(int u)
	{
		int res = 0;
		while (u != -1)
		{
			unlink(u);
			u = to[a[u]][u];
			res++;
		}
		return res;
	}

	private void solve() throws Exception
	{
		n = nextInt();
		m = nextInt();
		a = new int[n * m];
		to = new int[4][n * m];
		int[] map = new int[128];
		map['.'] = -1;
		map['U'] = 0;
		map['L'] = 1;
		map['R'] = 2;
		map['D'] = 3;
		for (int i = 0; i < n; i++)
		{
			char[] c = next().toCharArray();
			for (int j = 0; j < m; j++)
			{
				a[i * m + j] = map[c[j]];
			}
		}
		build();
		int[][] to_bak = new int[4][n * m];
		for (int i = 0; i < 4; i++)
		{
			System.arraycopy(to[i], 0, to_bak[i], 0, n * m);
		}
		for (int r = 0; r < n; r++)
		{
			for (int c = 0; c < m; c++)
			{
				int u = r * m + c;
				if (a[u] == -1) continue;
				for (int d = 0; d < 4; d++)
				{
					System.arraycopy(to_bak[d], 0, to[d], 0, n * m);
				}
				int res = run(u);
				if (res > best)
				{
					best = res;
					bestcount = 0;
				}
				if (res == best)
				{
					bestcount++;
				}
			}
		}
		out(best + " " + bestcount);
	}

	private int nextInt() throws Exception
	{
		return Integer.parseInt(next());
	}

	private String next() throws Exception
	{
		if (tokenizer == null || !tokenizer.hasMoreTokens())
		{
			String s = "";
			while (s.equals(""))
			{
				s = input.readLine();
			}
			tokenizer = new StringTokenizer(s);
		}
		return tokenizer.nextToken();
	}

	private void out(String s)
	{
		output.println(s);
	}

	public void run() {
		try {
			solve();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			output.close();
		}
	}
	
	public Solution() throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		output = new PrintWriter(System.out);
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		new Thread(new Solution()).start();
	}
}
