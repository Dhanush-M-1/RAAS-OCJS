import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

	static int n, m, next[][];
	static char[] grid;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		n = sc.nextInt();
		m = sc.nextInt();
		char[][] gridOrg = new char[n][m];
		for(int i = 0; i < n; ++i)
			gridOrg[i] = sc.next().toCharArray();
		int ans = 0, count = 0;
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < m; ++j)
				if(gridOrg[i][j] != '.')
				{
					make(gridOrg);

					int cur = play(i * m + j);
					if(cur > ans)
					{
						ans = cur; count = 0;
					}
					if(cur == ans)
						++count;
				}
		out.println(ans + " " + count);
		out.close();
	}

	static int play(int cell)
	{
		int ret = 0;
		while(cell != -1)
		{
			++ret;
			cell = next(go(cell), cell);
		}
		return ret;
	}

	static int go(int cell)
	{
		int ret;
		switch(grid[cell])
		{
		case 'U': ret = 0;break;
		case 'R': ret = 1;break;
		case 'D': ret = 2;break;
		default: ret = 3;
		}
		grid[cell] = '.';
		return ret;
	}

	static int next(int d, int cell)
	{
		int ret = next[d][cell];
		while(ret != -1 && grid[ret] == '.')
			ret = next[d][ret];
		return next[d][cell] = ret;
	}

	static void make(char[][] gridOrg)
	{
		grid = new char[n * m];
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < m; ++j)
				grid[i * m + j] = gridOrg[i][j];

		next = new int[4][n * m];
		
		//Left
		for(int i = 0; i < n; ++i)
		{
			next[3][i * m] = -1;
			for(int j = 1; j < m; ++j)
				next[3][i * m + j] = i * m + j - 1;
		}
		
		//Right
		for(int i = 0; i < n; ++i)
		{
			next[1][i * m + m - 1] = -1;
			for(int j = m - 2; j >= 0; --j)
				next[1][i * m + j] = i * m + j + 1;
		}

		//Up
		for(int j = 0; j < m; ++j)
		{
			next[0][j] = -1;
			for(int i = 1; i < n; ++i)
				next[0][i * m + j] = (i - 1) * m + j;
		}

		//Down
		for(int j = 0; j < m; ++j)
		{
			next[2][(n - 1) * m + j] = -1;
			for(int i = n - 2; i >= 0; --i)
				next[2][i * m + j] = (i + 1) * m + j;
		}
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public boolean ready() throws IOException {return br.ready();}


	}
}