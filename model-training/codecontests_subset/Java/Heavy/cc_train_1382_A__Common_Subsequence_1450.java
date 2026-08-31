import java.util.*;
import java.io.*;

public class a {
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-->0) {
			int n = in.nextInt(), m = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			//StringBuilder as = new StringBuilder();
			//StringBuilder bs = new StringBuilder();
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				//as.append(a[i]);
			}
			for (int i = 0; i < m; i++) {
				b[i] = in.nextInt();
				//bs.append(b[i]);
			}
			boolean flag = false;
			int len = 0;
			if (n < m) { // a is shorter
				while (len++ <= n && !flag) {
					int i;
					if ((i = commonssIndex(a, b, len)) > -1) {
						flag = true;
						out.println("YES");
						StringBuilder sb = new StringBuilder();
						sb.append(len + " ");
						for (int j = 0; j < len; j++)
							sb.append(a[i+j]);
						out.println(sb);
					}
				}
			}
			else { // a >= b
				while (len++ <= m && !flag) {
					int i;
					if ((i = commonssIndex(b, a, len)) > -1) {
						flag = true;
						out.println("YES");
						StringBuilder sb = new StringBuilder();
						sb.append(len + " ");
						for (int j = 0; j < len; j++)
							sb.append(b[i+j]);
						out.println(sb);
					}
				}
			}
			if (!flag)
				out.println("NO");
		}
		out.close();
	}
	
	static int commonssIndex(int[] small, int[] big, int len) {
		for (int i = 0; i <= small.length - len; i++) {
			for (int j = 0; j <= big.length - len; j++) {
				boolean same = true;
				for (int k = 0; k < len; k++)
					if (small[i] != big[j+k]) {
						same = false;
						break;
					}
				if (same)
					return i;
			}
		}
		return -1;
	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}