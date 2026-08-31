
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author b
 *
 */
public class A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner();
		PrintWriter writer = new PrintWriter(System.out);
		int tests = scanner.nextInt();
		for (int i = 0; i < tests; i++) {
			solve(scanner, writer);
		}
		writer.close();
	}

	private static void solve(Scanner scanner, PrintWriter writer) {

		int n = scanner.nextInt(), m = scanner.nextInt();

		Set<Integer> first = new HashSet<>(n);
		for (int i = 0; i < n; i++)
			first.add(scanner.nextInt());

		boolean isPossible = false;
		int val = -1;
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			if (!isPossible && first.contains(x)) {
				isPossible = true;
				val = x;
			}
		}

		if (isPossible) {
			writer.println("YES");
			writer.println("1 " + val);
		} else {
			writer.println("NO");
		}

	}

	@SuppressWarnings("unused")
	private static void print(String... args) {

		for (String arg : args) {

			System.out.print(arg + " ");
		}
		System.out.println();
	}

	// Props to SecondThread
	static class Scanner {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer("");

		String next() {
			while (!tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}

		long[] nextLongArr(int num) {
			long[] vals = new long[num];
			for (int i = 0; i < num; i++)
				vals[i] = nextLong();
			return vals;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArr(int numberOfElements) {
			int[] values = new int[numberOfElements];
			for (int i = 0; i < numberOfElements; i++)
				values[i] = nextInt();
			return values;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
