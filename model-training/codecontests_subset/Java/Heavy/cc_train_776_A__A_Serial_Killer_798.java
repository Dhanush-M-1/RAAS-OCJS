import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Round400 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] x = new String[2];
		x[0] = sc.next();
		x[1] = sc.next();
		System.out.println(x[0] + " " + x[1]);
		int n = sc.nextInt();
		while (n-- > 0) {
			String y = sc.next();
			String z = sc.next();
			if (y.equals(x[0])) {
				x[0] = z;
			} else
				x[1] = z;
			System.out.println(x[0] + " " + x[1]);
		}

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

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
