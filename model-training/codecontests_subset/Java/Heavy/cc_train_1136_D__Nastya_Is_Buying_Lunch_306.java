import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1136D
{
	static HashSet<Long> set = new HashSet<>();
	public static void main(String[] args)
	{
		FastScanner scan = new FastScanner();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		for (int i = 0; i < m; i++)
		{
			long a = scan.nextInt();
			long b = scan.nextInt();
			add(a, b);
		}
		boolean[] done = new boolean[n];
		int[] next = new int[n];
		for (int i = 0; i < next.length; i++)
			next[i] = i+1;
		int[] prev = new int[n];
		for (int i = 0; i < prev.length; i++)
			prev[i] = i-1;
		
		int skip = 0;
		for (int i = n-2; i >= 0; i--)
		{
			boolean can = true;
			for (int j = i+1; j < n; j = next[j])
			{
				if (done[j])
					continue;
				if (!has(arr[i], arr[j]))
				{
					can = false;
					break;
				}
			}
			if (can)
			{
				skip++;
				if (prev[i] >= 0)
					next[prev[i]] = next[i];
				if (next[i] < n)
					prev[next[i]] = prev[i];
				done[i] = true;
			}
		}
		System.out.println(skip);
	}
	private static boolean has(long a, long b)
	{
		return set.contains(a*1000000 + b);
	}
	private static void add(long a, long b)
	{
		set.add(a*1000000 + b);
	}
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		public FastScanner()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		public String next()
		{
			if (st.hasMoreTokens())
				return st.nextToken();
			try
			{
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public long nextLong()
		{
			return Long.parseLong(next());
		}

		public String nextLine()
		{
			String line = "";
			try
			{
				line = br.readLine();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return line;
		}
	}
}
