import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}

	static class Task {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			long INF = (long) 10e12;
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int[] s = new int[m];
			int[] street = new int[n];
			int[] slip = new int[n];

			int maxContin = 0;
			if (m > 0) {
				maxContin = 1;
			}
			int count = 1;
			for (int i = 0; i < m; i++) {
				s[i] = in.nextInt();
				street[s[i]] = 1;
				if (i > 0) {
					if (s[i] == s[i - 1] + 1) {
						count++;
					} else {
						if (maxContin < count) {
							maxContin = count;
						}
						count = 1;
					}
					if (i == m - 1) {
						if (maxContin < count) {
							maxContin = count;
						}
						count = 1;
					}
				} else {
					if (s[i] == 0) {
						out.println(-1);
						return;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (street[i] == 0) {
					slip[i] = i;
				} else {
					slip[i] = slip[i - 1];
				}
			}
			if (maxContin + 1 > k) {
				out.println(-1);
				return;
			}
			List<Lamp> availableLamps = new ArrayList<>();
			for (int i = 1; i <= k; i++) {
				long cost = in.nextLong();
				if (i >= maxContin + 1) {
					availableLamps.add(new Lamp(i, cost));
				}
			}
			
			long minCost = INF;
			for (int i = 0; i < availableLamps.size(); i++) {
				Lamp lamp = availableLamps.get(i);
				long lampNeed = 0;
				int pos = 0;
				while (pos < n) {
					lampNeed++;
					if (lamp.power >= n - pos) {
						break;
					}
					pos = slip[pos + lamp.power];
				}

				if (lampNeed * lamp.cost < minCost) {
					minCost = lampNeed * lamp.cost;
				}
			}
			out.println(minCost);
		}

		static class Lamp {
			int power;
			long cost;

			public Lamp(int power, long cost) {
				this.power = power;
				this.cost = cost;
			}
		}
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

		public Long nextLong() {
			return Long.parseLong(next());
		}

	}
}