import java.io.*;
import java.util.*;
import java.util.function.*;

final class Solver {
	static final Solver INSTANCE = new Solver();

	void solve(Supplier<String> sc) {
		int N = Integer.parseInt(sc.get());
		int M = Integer.parseInt(sc.get());
		BitSet A = new BitSet(N + 1);
		for (int i = 0; i < M; i++) {
			A.set(Integer.parseInt(sc.get()));
		}


		int[] table = new int[N + 1];
		table[0] = A.get(0) ? 0:1;
		table[1] = A.get(1) ? 0:1;
		for (int i = 2; i <= N; i++) {
			if (A.get(i)) continue;
			table[i] = (table[i - 1]  + table[i - 2]) % 1000000007;
		}
		System.out.println(table[N]);
	}
}

class Main {
	public static void main(String... args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Solver.INSTANCE.solve(new Supplier<String>() {
			StringTokenizer line;

			public String get() {
				while (line == null || !line.hasMoreTokens()) try {
					line = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
				return line.nextToken();
			}
		});
	}
}