import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		// try {
		// InputStream inputStream = new FileInputStream(
		// "D:\\codeforse\\CF\\input.txt");
		// OutputStream outputStream = new FileOutputStream(
		// "D:\\codeforse\\CF\\output.txt");
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		C solver = new C();
		// int t = in.nextInt();
		// for (int i = 1; i <= t; i++) {
		solver.solve(1, in, out);
		// }
		out.close();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}

class C {
	Pair[] p;

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();

		int a100 = 0;
		int a200 = 0;
		for (int i = 0; i < n; i++) {
			if (in.nextInt() == 100) {
				a100++;
			} else {
				a200++;
			}
		}
		if (a200 % 2 == 0 && a100 % 2 == 0) {
			out.print("YES");
		} else if (a200 % 2 == 0 && a100 % 2 == 1) {
			out.print("NO");
		} else if (a200 % 2 == 1 && a100 > 1) {
			a100 -= 2;
			if (a100 % 2 == 0) {
				out.print("YES");
			} else {
				out.print("NO");
			}
		} else {
			out.print("NO");
		}
		//out.print(n);
	}

	class Pair implements Comparable<Pair> {
		// ArrayList<Pair> p = new ArrayList<Pair>();
		// Collections.sort(p, Comparators.AGE);
		int r;

		int color;

		public Pair(String s) {

		}

		@Override
		public int compareTo(Pair o) {
			return Comparators.AGE.compare(this, o);
		}

		public String toString() {
			return "color " + color + " ";
		}

	}

	public static class Comparators {

		public static Comparator<Pair> AGE = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.r > o2.r ? 1 : (o1.r < o2.r ? -1 : 0);
			}
		};
	}
}

class InputReader {

	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
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

	public Double nextDouble() {
		return Double.parseDouble(next());
	}

	public String nextString() {
		return next();
	}

}
