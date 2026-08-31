import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KingsPath
{
	static HashMap<Long, Boolean> allowed = new HashMap<Long, Boolean>();
	static HashMap<Long, Integer> dist = new HashMap<Long, Integer>();
	static int[] dx = {1,1,1,-1,-1,-1,0,0};
	static int[] dy = {0,1,-1,0,1,-1,-1,1};
	static int xf, yf;
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		xf = sc.nextInt();
		yf = sc.nextInt();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			int r = sc.nextInt();
			int from = sc.nextInt();
			int to = sc.nextInt();
			for (int j = from; j <= to; j++)
				allowed.put(get(r, j), true);
			
		}
		
		bfs(x, y);
		int ans = dist.get(get(xf, yf)) != null?dist.get(get(xf, yf)):-1;
		System.out.println(ans);
	}
	
	private static void bfs(int x, int y)
	{
		dist.put(get(x, y), 0);
		Queue<Long> q = new LinkedList<Long>();
		q.add(get(x,y));
		while(!q.isEmpty())
		{
			long res = q.poll();
			int x1 = (int)(res/1000000005);
			int y1 = (int)(res%1000000005);
			if(x1 == xf && y1 == yf)
				return;
			for (int i = 0; i < 8; i++)
			{
				int newX = x1+dx[i];
				int newY = y1+dy[i];
				if(allowed.get(get(newX, newY)) != null)
				{
					if(dist.get(get(newX, newY)) == null)
					{
						q.add(get(newX, newY));
						dist.put(get(newX, newY), dist.get(get(x1, y1))+1);
					}
				}
			}
		}
	}

	public static long get(int x, int y)
	{
		return 1l*1000000005*x + y;
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}
	}
}
