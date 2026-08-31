import java.io.*;
import java.util.*;

public class C {

	static long m = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scn.nextInt(), tcs = 0;
		C: while (tcs++ < T) {
			int n = scn.nextInt();
			double x = Math.PI / (4 * n);
			double ans = Math.sin(x) * 2;
			ans = 1 / ans;
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

	static double polydiagonal(double n, double a) {
		if (a < 0 && n < 0)
			return -1;
		double rad = Math.toRadians(180 / n);
		return (double) (1 / Math.sin(rad));
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

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}