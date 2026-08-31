
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//not greeeeedy

public class Woodcutters {

	static int n , memo[][] , x[],h[];
	//0 --> last is left
	//1 --> last did not fall
	//2 --> last is right


	static int INF = -((int)(1e9)+10);
	static int solve(int i , int state)
	{
		if(i == n)
			return 0;

		if(memo[i][state] != -1)
			return memo[i][state];

		int last = -1;
		if(i == 0)
			last = INF;
		else
		{
			if(state == 0 || state == 1)
				last = x[i-1];
			else
				last = x[i-1]+h[i-1];
		}
		int ans  = 0;
		if(x[i]-h[i]>last)														 //try left
			ans = Math.max(ans, 1+solve(i+1,0));
		ans = Math.max(ans, solve(i+1,1)); 										 //try not to fall it
		if(i==n-1 || x[i]+h[i]<x[i+1]) 											 //try right
			ans = Math.max(ans , 1+solve(i+1,2));

		return memo[i][state] = ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		x = new int[n];
		h = new int[n];
		for(int i=0;i<n;i++)
		{
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		memo = new int[n+1][4];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		int cc = n-10;
		while(cc>0)
		{
			solve(cc,0);
			solve(cc,1);
			solve(cc,2);
			cc-=1000;
		}
		
		System.out.println(solve(0,0));
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
