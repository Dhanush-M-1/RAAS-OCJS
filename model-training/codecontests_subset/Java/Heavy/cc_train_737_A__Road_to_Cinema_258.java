import java.io.*;
import java.util.*;

public class SolveC {
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}
	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new SolveC().run();
	}

	void run() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	class Segment implements Comparable<Segment>{
		long begin;
		long end;
		long len;
		public Segment(long begin, long end) {
			this.begin = begin;
			this.end = end;
			this.len = end - begin;
		}
		@Override
		public int compareTo(Segment that) {
			if (this.len == that.len) {
				return Long.compare(this.begin, that.begin);
			}
			return Long.compare(this.len, that.len);
		}
		
	}
	void solve() throws NumberFormatException, IOException {
			int n = nextInt();
			int k = nextInt();
			long s = nextInt();
			long t = nextInt();
			long[] c = new long[n];
			long[] v = new long[n];
			for (int i = 0; i < n; i++) {
				c[i] = nextLong();
				v[i] = nextLong();
			}
			long[] g = new long[k + 2];
			g[0] = 0;
			g[1] = s;
			for (int i = 2; i <= k + 1; i++) {
				g[i] = nextLong();
			}
			Arrays.sort(g);
			Segment[] segments = new Segment[k + 1];
			for (int i = 0; i <= k; i++) {
				segments[i] = new Segment(g[i], g[i + 1]);
			}
			if (s > t) {
				out.println(-1);
				return;
			}
			Arrays.sort(segments);
			long vcur = segments[segments.length - 1].len;
			long tcur = 2 * s;
			for (Segment seg : segments) {
				long len = seg.len;
				long mint = tcur;
				long minv = vcur;
				long maxt = tcur - len;
				long maxv = Math.max(vcur, len * 2);
				if (maxt > t) {
					tcur = maxt;
					vcur = maxv;
					continue;
				} else {
					//[maxt,mint]
					long res = mint - 2 * len;
					long a = t - len - res;
					long b = len - a;
					tcur = t;
					vcur = Math.max(vcur, a + 2 * b);
					break;
				}
			}
			if (tcur != t) {
				out.println(-1);
				return;
			}
			long ans = Long.MAX_VALUE;
			for (int i =0; i < n; i++) {
				if (v[i] >= vcur) {
					ans = Math.min(ans, c[i]);
				}
			}
			if (ans == Long.MAX_VALUE) {
				out.println(-1);
				return;
			}
			out.println(ans);
	}
}
