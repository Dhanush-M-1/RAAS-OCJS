import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static class FastScanner {
		BufferedReader s;
		StringTokenizer st;

		public FastScanner(InputStream InputStream) {
			st = new StringTokenizer("");
			s = new BufferedReader(new InputStreamReader(InputStream));
		}

		public FastScanner(File f) throws FileNotFoundException {
			st = new StringTokenizer("");
			s = new BufferedReader(new FileReader(f));
		}

		public int nextInt() throws IOException {
			if (st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextInt();
			}
		}

		public BigInteger big() throws IOException {
			if (st.hasMoreTokens())
				return new BigInteger(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return big();
			}
		}

		public double nextDouble() throws IOException {
			if (st.hasMoreTokens())
				return Double.parseDouble(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextDouble();
			}
		}

		public long nextLong() throws IOException {
			if (st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextLong();
			}
		}

		public String next() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			else {
				st = new StringTokenizer(s.readLine());
				return next();
			}

		}

		public String nextLine() throws IOException {
			return s.readLine();
		}

		public void close() throws IOException {
			s.close();
		}

	}
	
	public static void main(String[] args) throws java.lang.Exception {
		FastScanner in = new FastScanner(System.in);
		int n = in.nextInt();
		pair arr[] = new pair[n];
		for(int x = 0; x < n; x++) {
			arr[x] = new pair(in.nextInt(), in.nextInt());
		}
		Arrays.sort(arr);
		if(n<=2) {
			System.out.println(n);
			return;
		}
		int[] diff = new int[n - 1];
		for(int x = 1; x < n; x++)
			diff[x - 1] = arr[x].a - arr[x - 1].a - 1;
		int[] dp[] = new int[n][2];
		System.out.println(maxTree(diff, 1, arr, dp) + 2);
	}

	private static int maxTree(int[] diff, int i, pair[] arr, int[][] dp) {
		if(i == diff.length)
			return 0;
		maxTree(diff, i + 1, arr, dp);
		dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]) + (diff[i - 1] >= arr[i].b? 1 : 0);
		dp[i][1] = (diff[i] >= arr[i].b? (diff[i] >= arr[i].b + arr[i + 1].b ? 1 + Math.max(dp[i + 1][0], dp[i + 1][1]):1 + dp[i + 1][1]): Math.max(dp[i + 1][0], dp[i + 1][1]));
		return Math.max(dp[i][0], dp[i][1]);
	}

	static class pair implements Comparable<pair>{
		int a, b;
		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(pair obj) {
			return a - obj.a;
		}
	}
}