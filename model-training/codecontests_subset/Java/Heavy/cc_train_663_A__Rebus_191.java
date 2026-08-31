import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

	static class Pair implements Comparable<Pair> {

		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			int comp1 = Integer.compare(x, o.x);
			if (comp1 != 0) {
				return comp1;
			}
			return Integer.compare(y, o.y);
		}

	}

	static int MOD = 1000 * 1000 * 1000 + 7;

	public static void shuffleArray(int[] arr) {
		int n = arr.length;
		Random rnd = new Random();
		for (int i = 0; i < n; ++i) {
			int tmp = arr[i];
			int randomPos = i + rnd.nextInt(n - i);
			arr[i] = arr[randomPos];
			arr[randomPos] = tmp;
		}
	}

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		solve(in, out);
		out.close();
		System.exit(0);
	}

	private static void solve(InputReader in, PrintWriter out) {
		String a = in.nextLine();
		if (a.charAt(0) != '-') {
			a = "+" + a;
		}

		ArrayList<Integer> ar = new ArrayList<>();
		int eqPos = a.indexOf('=');
		int plus = 0;
		int minus = 0;
		for (int i = 2; i < a.length(); i++) {
			if (a.charAt(i - 2) == '+') {
				ar.add(1);
				plus++;
			} else if (a.charAt(i - 2) == '-') {
				ar.add(-1);
				minus++;
			}
		}

		String nStr = a.substring(eqPos + 2);
		int n = Integer.parseInt(nStr);
		int N = n;
		int k = ar.size();
		int[] tab = new int[k];
		n -= plus;
		n += minus;

		for (int i = 0; i < k; i++) {
			if (n > 0 && ar.get(i) > 0) {
				tab[i] += Math.min(n, N - 1);
				n -= tab[i];
			} else if (n < 0 && ar.get(i) < 0) {
				tab[i] += Math.min(-n, N - 1);
				n += tab[i];
			}
		}
		//
		// for (int i = 0; i < k; i++) {
		// if (n > 0 && ar.get(i) < 0) {
		// tab[i] += Math.min(n, N - 1);
		// n -= tab[i];
		// } else if (n < 0 && ar.get(i) > 0) {
		// tab[i] += Math.min(n, N - 1);
		// n += tab[i];
		// }
		// }

		int pos = 0;
		if (a.charAt(0) == '+') {
			a = a.substring(1);
		}
		if (n == 0) {
			out.println("Possible");
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == '?') {
					out.print(tab[pos++] + 1);
				} else {
					out.print(a.charAt(i));
				}
			}
		} else {
			out.print("Impossible");
		}

	}

	/*
		* 
		*/
	// --------------------------------------------------------

	private static int gcd(int n, int m) {
		if (m == 0) {
			return n;
		}

		return gcd(m, n % m);
	}

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