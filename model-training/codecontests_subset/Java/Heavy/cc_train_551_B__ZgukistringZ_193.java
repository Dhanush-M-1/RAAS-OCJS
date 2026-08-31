import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

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

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			int c1 = Integer.compare(x, o.x);
			int c2 = Integer.compare(y, o.y);
			if (c1 != 0) {
				return c1;
			}
			return c2;
		}

	}

	private static void solve(InputReader in, PrintWriter out) {
		char[] a = in.next().toCharArray(), b = in.next().toCharArray(), c = in.next().toCharArray();
		long[] cntA = new long[26];
		long[] cntB = new long[26];
		long[] cntC = new long[26];
		fillCntTable(a, cntA);
		fillCntTable(b, cntB);
		fillCntTable(c, cntC);
		long res = 0;
		int bestI = 0;
		int bestJ = 0;
		for (int numB = 0; numB <= a.length; numB++) {
			boolean isOK = true;
			for (int j = 0; j < 26; j++) {
				if (cntA[j] < numB * cntB[j]) {
					isOK = false;
				}
			}
			if (!isOK) {
				continue;
			}
			int numC = a.length;
			for (int j = 0; j < 26; j++) {
				if (cntC[j] == 0) {
					continue;
				}

				numC = Math.min(numC, (int) ((cntA[j] - numB * cntB[j]) / cntC[j]));
			}

			if (res < numB + numC) {
				bestI = numB;
				bestJ = numC;
				res = bestI + bestJ;
			}
		}
		for (int i = 0; i < bestI; i++) {
			out.print(new String(b));
		}
		for (int i = 0; i < bestJ; i++) {
			out.print(new String(c));
		}
		for (int i = 0; i < 26; i++) {
			for (int k = 0; k < cntA[i] - bestI * cntB[i] - bestJ * cntC[i]; k++) {
				out.print((char) (i + 'a'));
			}
		}
	}

	private static void fillCntTable(char[] c, long[] cntC) {
		for (int i = 0; i < c.length; i++) {
			cntC[c[i] - 'a']++;
		}
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