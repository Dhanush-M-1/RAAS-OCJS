//package ;
import java.io.*;
import java.util.*;

public class C {
	static int n,k,l;static Integer a[],key[] ;
	static long dp[][];
	static HashMap<Integer, Integer>hm;
	static long dp(int person,int kkey)
	{
		if( person == n)
			return 0;
		if(kkey == k)
			return (long)1e18;
		if(dp[person][kkey] !=-1)
			return dp[person][kkey];
		long take = Math.max(dp(person+1,kkey+1), Math.abs(a[person]-key[kkey])+Math.abs(l-key[kkey]));
		long leave = dp(person,kkey+1);
		
		return dp[person][kkey] = Math.min(take, leave);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=sc.nextInt();k=sc.nextInt();l=sc.nextInt();
		a=sc.nextIntegerArray(n);
		key=sc.nextIntegerArray(k);
		hm=new HashMap<>();
		dp=new long[n][k];
		Arrays.sort(a);
		Arrays.sort(key);
		for(int i=0;i<n;i++)
			Arrays.fill(dp[i], -1);
		System.out.println(dp(0,0));
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		char[] nextCharArray() throws IOException {
			return br.readLine().toCharArray();
		}

		public double[] nextDoubleArray(int n) throws IOException {
			double[] ans = new double[n];
			for (int i = 0; i < n; i++)
				ans[i] = nextDouble();
			return ans;
		}

	}
}
