import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		FastReader reader = new FastReader();
		PrintWriter writer = new PrintWriter(System.out);
		long mod = 998244353L;

		int n = reader.nextInt();
		long[] a = new long[n];
		for (int i=0; i<n; i++)
			a[i] = reader.nextLong();

		long[] pow = new long[30];
		pow[0] = 1;
		for (int i=1; i<30; i++)
			pow[i] = (pow[i-1]*10) % mod;
		
		long[] count = new long[11];
		for (int i=0; i<n; i++) {
			long temp = a[i];
			int cnt = 0;

			while (temp > 0) {
				temp /= 10;
				cnt++;
			}

			count[cnt]++;
		}

		long ans = 0;

		for (int i=0; i<n; i++) {
			long temp = a[i];
			int cnt = 0;

			while (temp > 0) {
				long dig = temp%10;
				temp /= 10;
				cnt++;

				for (int j=1; j<cnt; j++) {
					ans += (dig*pow[cnt+j-1]*count[j])%mod;
					ans += (dig*pow[cnt+j-1]*count[j])%mod;
					ans %= mod;
				}

				for (int j=cnt; j<11; j++) {
					ans += (dig*pow[2*cnt-1]*count[j])%mod;
					ans += (dig*pow[2*cnt-2]*count[j])%mod;
					ans %= mod;
				}
			}
		}

		writer.println(ans);
		writer.close();
	}

	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}
}