
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bottles {
	static int n,a[],b[];
	static Pair memo[][];
	public static Pair dp(int index,int curVol)
	{
		if (index==n)
		{
			if (curVol>=0)
				return new Pair(0,0);
			else
				return new Pair(10000,0);
		}
		if (memo[index][curVol+10000]!=null)
			return memo[index][curVol+10000];
		Pair p1 = dp(index+1,curVol+b[index]-a[index]);
		Pair p2 = dp(index+1,curVol-a[index]);
		Pair res;
		if (p1.k+1<p2.k)
			res =  new Pair(p1.k+1,p1.t);
		else if (p1.k+1>p2.k)
			res = new Pair(p2.k,p2.t+a[index]);
		else
			res = new Pair(p2.k,Math.min(p1.t, p2.t+a[index]));
		return memo[index][curVol+10000]= res;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		memo = new Pair[n][20005];
		for (int i=0;i<n;i++)
			a[i] = sc.nextInt();
		for (int i=0;i<n;i++)
			b[i] = sc.nextInt();
		System.out.println(dp(0,0));
	}
	static class Pair
	{
		int k;
		int t;
		public Pair(int k,int t)
		{
			this.k = k;
			this.t = t;
		}
		public String toString()
		{
			return k+" "+t;
		}
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
