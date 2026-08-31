import java.io.*;
import java.util.*;

public class A {

	static long mod = (long) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		A: while (t-- > 0) {
			int n = scn.nextInt(), m = scn.nextInt();
			HashSet<Integer> a = new HashSet<>(), b = new HashSet<>();
			for (int i = 0; i < n; i++)
				a.add(scn.nextInt());
			boolean bool = false;
			for (int i = 0; i < m; i++) {
				int v = scn.nextInt();
				if (a.contains(v) && !bool) {
					sb.append("YES\n");
					sb.append(1 + " " + v);
					bool = true;
				}
			}
			if (!bool)
				sb.append("NO");
			sb.append("\n");
		}
		System.out.print(sb);
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