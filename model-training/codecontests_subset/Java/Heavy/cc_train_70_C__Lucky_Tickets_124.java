import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main implements Runnable {
	static class Fraction implements Comparable<Fraction> {
		int num;
		int den;

		public Fraction(int num, int den) {
			int d = gcd(num, den);
			num /= d;
			den /= d;
			this.num = num;
			this.den = den;
		}

		private int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}

		@Override
		public int compareTo(Fraction o) {
			if (num != o.num) {
				return num - o.num;
			} else {
				return den - o.den;
			}
		}

		@Override
		public boolean equals(Object obj) {
			Fraction other = (Fraction) obj;
			return num == other.num && den == other.den;
		}

		@Override
		public int hashCode() {
			return num * 99991 + den;
		}

		@Override
		public String toString() {
			return num + "/" + den;
		}
	}

	public void solution() throws IOException {
		int maxX = in.nextInt();
		int maxY = in.nextInt();
		int need = in.nextInt();
		Fraction[] fractions = calcAll(Math.max(maxX, maxY));
		HashMap<Fraction, List<Integer>> reverse = new HashMap<Main.Fraction, List<Integer>>();
		for (int i = 0; i < fractions.length; ++i) {
			Fraction cur = new Fraction(fractions[i].den, fractions[i].num);
			if (!reverse.containsKey(cur)) {
				reverse.put(cur, new ArrayList<Integer>());
			}
			reverse.get(cur).add(i);
		}
		long best = Long.MAX_VALUE;
		int x = -1;
		int y = -1;
		long curCount = 0;
		int j = maxY - 1;
		for (int i = 0; i < maxX; ++i) {
			curCount += count(i, 0, j, reverse, fractions);
			while (j > 0 && curCount - count(j, 0, i, reverse, fractions) >= need) {
				curCount -= count(j, 0, i, reverse, fractions);
				--j;
			}
			if (curCount >= need) {
				if (best > (long) (i + 1) * (j + 1)) {
					best = (long) (i + 1) * (j + 1);
					x = i + 1;
					y = j + 1;
				}
			}
		}
		out.println(best == Long.MAX_VALUE ? "-1" : x + " " + y);
	}

	private long count(int id, int first, int last, HashMap<Fraction, List<Integer>> reverse, Fraction[] fractions) {
		if (first > last) {
			return 0;
		}
		return count(reverse.get(fractions[id]), last) - count(reverse.get(fractions[id]), first - 1);
	}

	private int count(List<Integer> list, int value) {
		if (list == null) {
			return 0;
		}
		int l = 0;
		int r = list.size() - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (list.get(m) <= value) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
	}

	private Fraction[] calcAll(int n) {
		Fraction[] res = new Fraction[n];
		for (int i = 1; i <= n; ++i) {
			res[i - 1] = new Fraction(i, rev(i));
		}
		return res;
	}

	private int rev(int n) {
		int res = 0;
		while (n > 0) {
			res = res * 10 + n % 10;
			n /= 10;
		}
		return res;
	}

	public void run() {
		try {
			// String fileName = "";
			// try {
			// in = new Scanner(new FileReader(fileName + ".in"));
			// out = new PrintWriter(fileName + ".out");
			// } catch (Exception e) {
			// }
			solution();
			in.reader.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Thread(null, new Main(), "", 1 << 28).start();
	}

	private static class Scanner {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public Scanner(Reader reader) {
			this.reader = new BufferedReader(reader);
			this.tokenizer = new StringTokenizer("");
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String line = reader.readLine();
				if (line == null) {
					return false;
				}
				tokenizer = new StringTokenizer(line);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
	Scanner in = new Scanner(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
