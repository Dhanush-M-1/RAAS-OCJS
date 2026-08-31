
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * B. Rebus
 */
public class D2B {

	public static void main(String args[] ) throws IOException {
		try (MyScanner in = new MyScanner();
				PrintWriter out = new PrintWriter(System.out);) {
			String line = in.nextLine();
			line = line.replaceAll("\\?", "1");
			String[] tokens = line.split(" ");

			long n = Long.parseLong(tokens[tokens.length - 1]);	// > 0
			long left = Long.parseLong(tokens[0]);
			ArrayList<Integer> pluses = new ArrayList<>();	// last index of
			pluses.add(-1);
			ArrayList<Integer> minuses = new ArrayList<>();
			for (int i = 1; i < tokens.length - 2; i += 2) {
				if (Objects.equals(tokens[i], "+")) {
					left += Long.parseLong(tokens[i + 1]);
					pluses.add(i);
				} else {	// if "-"
					left -= Long.parseLong(tokens[i + 1]);
					minuses.add(i);
				}
			}
			ArrayList<Integer> ops = null;
			if (left < n) {
				ops = pluses;
				for (int i = 0; i < ops.size(); i++) {
					long a = n - left + 1;
					if (a > n)
						a = n;
					left += a - 1;
					tokens[ops.get(i) + 1] = Long.toString(a, 10);
				}
			} else if (left > n) {
				ops = minuses;
				for (int i = 0; i < ops.size(); i++) {
					long a = left - n + 1;
					if (a > n)
						a = n;
					left -= a - 1;
					tokens[ops.get(i) + 1] = Long.toString(a, 10);
				}
			}
			if (left != n) {
				out.print("Impossible");
				return ;
			}
			out.println("Possible");
			out.println(Arrays.toString(tokens).replaceAll("[\\[\\],]", ""));
		}
	}

	/** see http://codeforces.com/blog/entry/7018 */
	static class MyScanner implements AutoCloseable {
		BufferedReader br; StringTokenizer st;
		MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {
			while (st == null || !st.hasMoreElements())
				try {st = new StringTokenizer(br.readLine());} catch (IOException e) {throw new IllegalStateException(e);}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine() {try {return br.readLine();} catch (IOException e) {throw new IllegalStateException(e);}}
		@Override
		public void close() {try {br.close();} catch (IOException e) {throw new IllegalStateException(e);}}
	}

}