import java.io.*;
import java.util.*;

public class C {

	static long mod = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		long dp[][] = new long[(int) (2e5 + 5)][10];
		int mx = dp.length;
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < 10; i++) {
			int d[] = new int[10];
			d[i] = 1;
			int idx = 1;
			while (idx < mx) {
				int nd[] = new int[10];
				for (int g = 0; g < 9; g++)
					nd[g + 1] = d[g];
				if (d[9] != 0) {
					nd[0] += d[9];
					nd[1] += d[9];
					nd[0] %= mod;
					nd[1] %= mod;
				}
				long cnt = 0;
				for (long v : nd) {
					cnt += v;
					cnt %= mod;
				}
				dp[idx][i] = cnt;
				d = nd;
				idx++;
			}
		}
		int T = scn.ni(), tcs = 0;
		C: while (tcs++ < T) {
			int n = scn.ni();
			int m = scn.ni();
			int d[] = new int[10];
			while (n != 0) {
				d[n % 10]++;
				n /= 10;
			}
			int mod = (int) (1e9 + 7);
			long ans = 0;
			for (int i = 0; i < 10; i++) {
				if (d[i] == 0)
					continue;
				long p = d[i] * dp[m][i];
				p %= mod;
				ans += p;
				ans %= mod;
			}
			sb.append(ans);
			sb.append("\n");
		}
		out.print(sb);
		out.close();
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int ni() throws IOException {
			return Integer.parseInt(next());
		}

		public long nl() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nia(int n) throws IOException {
			int a[] = new int[n];
			String sa[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(sa[i]);
			return a;
		}

		public long[] nla(int n) throws IOException {
			long a[] = new long[n];
			String sa[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(sa[i]);
			return a;
		}

		public void sort(int[] a) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int v : a)
				l.add(v);
			Collections.sort(l);
			for (int i = 0; i < a.length; i++)
				a[i] = l.get(i);
		}

		public void sort(long[] a) {
			ArrayList<Long> l = new ArrayList<>();
			for (long v : a)
				l.add(v);
			Collections.sort(l);
			for (int i = 0; i < a.length; i++)
				a[i] = l.get(i);
		}
	}
}