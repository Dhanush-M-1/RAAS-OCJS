//package D613;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}

	}

	public static void main(String args[]) {
		FastReader sc = new FastReader();
		long n = sc.nextLong();
		//checking all multiple of n;
		long x=1;
		for(long i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				if(lcm(i,n/i)==n)
				{
					x=i;
				}
			}
		}
		System.out.println(x+" "+(n/x));
	}
	
	public static long gcd(long a, long b)
	{
		if(a==0) return b;
		return gcd(b%a,a);
	}
	
	public static long lcm(long a, long b)
	{
		return (a*b)/gcd(a,b);	
	}

}

