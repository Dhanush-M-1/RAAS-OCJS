import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
hp
2
ht
tp

 */
public class a {
	static String target;
	static String[] ss;
	static int n;
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		target = in.next();
		n = in.nextInt();
		ss = in.nextStringArray(n);
		memo = new Boolean[target.length()+5];
		boolean ans = go(0);
		for(String s :ss) {
			if(s.charAt(1) == target.charAt(0))
				ans |= go(1);
		}
//		System.out.println(go(0));
		System.out.println(ans ? "YES" : "NO");
	}
	static Boolean[] memo;
	static boolean go(int idx) {
		if(idx >= target.length())
			return true;
		if(memo[idx] != null)
			return memo[idx];
		String tar = target.substring(idx, Math.min(idx+2, target.length()));
//		System.out.println("idx " + idx + " tar" + tar);
		for(int i=0;i<n;i++) {
			if(ss[i].equals(tar) || ss[i].substring(0, 1).equals(tar)) {
				if(go(idx+2))
					return memo[idx] = true;
			}
		}
		return memo[idx] = false;
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream i) {
			br = new BufferedReader(new InputStreamReader(i));
			st = null;
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

		public String[] nextStringArray(int n) throws IOException {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = next();
			return arr;
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
