import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		solve(in, out);
		out.close();
		System.exit(0);
	}

	static class Pow implements Comparable<Pow> {

		private double x;
		private String rep;
		double val;
		int i;

		Pow(int i, String rep, double x, double y, double z, boolean isBracket) {
			this.i = i;
			this.rep = rep;
			this.x = x;
			val = 0;

			if (x <= 1) {
				x = 1 / x;
			}

			if (!isBracket) {
				val = z * Math.log(y) + Math.log(Math.log(x));
			} else {
				val = Math.log(y) + Math.log(z) + Math.log(Math.log(x));
			}

		}

		@Override
		public String toString() {
			return rep;
		}

		@Override
		public int compareTo(Pow o) {
			if (x <= 1 && o.x > 1) {
				return -1;
			}
			if (x <= 1 && o.x <= 1) {
				int comp = Double.compare(val, o.val);
				if (comp != 0) {
					return -comp;
				}
			}

			if (x > 1 && o.x <= 1) {
				return 1;
			}
			if (x > 1 && o.x > 1) {
				int comp = Double.compare(val, o.val);
				if (comp != 0) {
					return comp;
				}
			}

			return -Integer.compare(i, o.i);
		}
	}

	private static void solve(InputReader in, PrintWriter out) {

		double x = in.nextDouble();
		double y = in.nextDouble();
		double z = in.nextDouble();

		Pow[] pow = new Pow[12];
		pow[0] = new Pow(1, "x^y^z", x, y, z, false);
		pow[1] = new Pow(2, "x^z^y", x, z, y, false);
		pow[2] = new Pow(3, "(x^y)^z", x, y, z, true);
		pow[3] = new Pow(4, "(x^z)^y", x, z, y, true);
		pow[4] = new Pow(5, "y^x^z", y, x, z, false);
		pow[5] = new Pow(6, "y^z^x", y, z, x, false);
		pow[6] = new Pow(7, "(y^x)^z", y, x, z, true);
		pow[7] = new Pow(8, "(y^z)^x", y, z, x, true);
		pow[8] = new Pow(9, "z^x^y", z, x, y, false);
		pow[9] = new Pow(10, "z^y^x", z, y, x, false);
		pow[10] = new Pow(11, "(z^x)^y", z, x, y, true);
		pow[11] = new Pow(12, "(z^y)^x", z, y, x, true);

		Arrays.sort(pow);

		out.print(pow[pow.length - 1]);
	}

	/*
	 * 
	 */
	// --------------------------------------------------------
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return str;
		}
	}
}