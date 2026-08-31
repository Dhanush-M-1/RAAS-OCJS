import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;


public class D {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static int[]p;
	static class Sort implements Comparable<Sort> {
		int p, ind;
		public int compareTo(Sort arg0) {
			if (this.p==arg0.p)
				return this.ind-arg0.ind;
			return this.p-arg0.p;
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		int m = nextInt();
		int[]a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
		}
		p = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		Random rm = new Random();
		for (int i = 1; i <= m; i++) {
			int x = nextInt();
			int y = nextInt();
			int px = get_fath(x);
			int py = get_fath(y);
			if (px != py) {
				if (rm.nextInt() % 2==0)
					p[px] = py;
				else
					p[py] = px;
			}
		}
		for (int i = 1; i <= n; i++) {
			p[i] = get_fath(i);
		}
		Sort[]c = new Sort[n+1];
		for (int i = 1; i <= n; i++) {
			c[i] = new Sort();
			c[i].ind = i;
			c[i].p = p[i];
		}
		Arrays.sort(c, 1, n+1);
		int[]ans = new int[n+1];
		Integer[]b = new Integer[n+1];
		int last = 1;
		for (int i = 2; i <= n+1; i++) {
			if (i==n+1 || c[i].p != c[i-1].p) {
				int cnt = 0;
				for (int j = last; j <= i-1; j++) {
					b[++cnt] = a[c[j].ind];
				}
				Arrays.sort(b, 1, cnt+1);
				for (int j = last; j <= i-1; j++) {
					ans[c[j].ind] = b[cnt--];
				}
				last = i;
			}
		}
		for (int i = 1; i <= n; i++) {
			pw.print(ans[i]+" ");
		}
		pw.close();
	}
	private static int get_fath(int x) {
		if (p[x]==x)
			return x;
		return p[x] = get_fath(p[x]);
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
