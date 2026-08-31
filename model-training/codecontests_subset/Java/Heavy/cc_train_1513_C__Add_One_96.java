import java.util.*;
import java.io.*;
public class B{
	static long mod = (long)(1e9+7);
	static long[][] dp;
	
	static long make(int dig, int moves)
	{
		if(moves<=0)return 1;
		if(dp[dig][moves]!=0)return dp[dig][moves];
		long ans = 0;
		if(dig<9)
		{
			ans = make(dig+1,moves-1);
		}
		else
		{
			ans = (make(0,moves-1)%mod+make(1,moves-1)%mod)%mod;
		}
		dp[dig][moves] = ans;
		return ans%mod;
	}
	
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		dp = new long[10][200005];
//		for(int i=0;i<10;i++)for(int j=0;j<200005;j++)dp[i][j] = -1;
		for(int i=0;i<10;i++)for(int j=0;j<200005;j++)dp[i][j] = make(i,j);
		int t = fs.nextInt();
		for(int tt=0;tt<t;tt++)
		{
			String str = fs.next(); int moves = fs.nextInt();
			long ans = 0;
			for(int i=0;i<str.length();i++)
			{
				int num = str.charAt(i)-'0';
				ans = (ans+dp[num][moves])%mod;
			}
			out.println(ans);
		}
		out.close();
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static int[] sort(int[] arr)
	{
		List<Integer> temp = new ArrayList();
		for(int i:arr)temp.add(i);
		Collections.sort(temp);
		int start = 0;
		for(int i:temp)arr[start++]=i;
		return arr;
	}
}