import java.util.*;
import java.io.*;
public class d {
	static int n;
	static long l, r;
	public static void main(String[] args) {
		FS sc = new FS();
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int tt = 1; tt <= t; ++tt) {
			n = sc.nextInt();
			l = sc.nextLong();
			r = sc.nextLong();

			// binary search for index i
			int lo = 1, hi = n;
			while(lo < hi) {
				int g = (lo + hi + 1) / 2;

				if(getNumBehind(g) < l) lo = g;
				else hi = g - 1;
			}

			// calculate start j?
			//			System.out.println(lo);

			long idx = getNumBehind(lo) + 1;
			floop : for(int i = lo; ; ++i) {
				if(i == n) {
					pw.print("1 ");
					break;
				}
				for(int j = i + 1; j <= n; ++j) {
					if(idx++ >= l) pw.print(i + " ");
					if(idx > r) break floop;
					if(idx++ >= l) pw.print(j + " ");
					if(idx > r) break floop;
				}
			}

			pw.println();
		}
		pw.flush();
	}
	static long getNumBehind(int i) {
		long out = sum(n - 1);
		out -= sum(n - i);
		return out * 2;
	}
	static long sum(long in) {
		return in * (in + 1) / 2;
	}
	static class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}