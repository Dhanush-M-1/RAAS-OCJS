import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		FastPrinter out = new FastPrinter(System.out);
		int n = in.nextInt(), count = 0;
		boolean f = true;
		String s = in.nextLine();
		if (s.contains("*"))
			s = s.substring(s.indexOf('*'));
		while (s.length() > 0) {
			for (int i = 1; i < s.length(); i++) {
				count = 0;
				for (int j = 0; j < s.length(); j += i) {
					if (s.charAt(j) == '*')
						count++;
					else
						break;
					if (count == 5) {
						f = false;
						System.out.println("yes");
						break;
					}
				}
				if (count == 5)
					break;
			}
			if (count == 5)
				break;
			s = s.substring(1);
		}
		if (f)
			System.out.println("no");
		out.close();
	}
}

class ArrayUtils {
	static final Random rand = new Random(System.nanoTime());

	static final public int[] sortAndUnique(int[] a) {
		int[] ret = a.clone();
		sort(ret);
		if (ret.length == 0) {
			return ret;
		}
		int last = ret[0];
		int j = 1;
		for (int i = 1; i < ret.length; i++)
			if (last != ret[i]) {
				ret[j++] = ret[i];
				last = ret[i];
			}
		return Arrays.copyOf(ret, j);
	}

	public static final void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	public static final void shuffle(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int j = rand.nextInt(i + 1);
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}

}

class InputReader {
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

	public String nextLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int[] readIntArray(int n) {
		int[] ret = new int[n];
		for (int i = 0; i < n; i++)
			ret[i] = nextInt();
		return ret;
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

	public BigInteger nextBigInt() {
		return new BigInteger(next());
	}
}

class FastPrinter extends PrintWriter {

	public FastPrinter(OutputStream out) {
		super(out);
	}

	public FastPrinter(Writer out) {
		super(out);
	}

}