import java.io.*;
import java.util.*;

public class B {
	public static void solution(BufferedReader reader, PrintWriter out)
			throws IOException {
		In in = new In(reader);
		int max = 0, min = 0, sum = 0;
		ArrayList<Character> op = new ArrayList<Character>();
		op.add('+');
		while (true) {
			String s = in.next();
			if (s.charAt(0) == '+' || s.charAt(0) == '-')
				op.add(s.charAt(0));
			if (s.charAt(0) == '=') {
				sum = in.nextInt();
				break;
			}
		}
		for (char c : op) {
			if (c == '+') {
				max += sum;
				min += 1;
			} else {
				max -= 1;
				min -= sum;
			}
		}
		if (min > sum || sum > max) {
			out.println("Impossible");
			return;
		}
		out.println("Possible");

		int[] num = new int[op.size()];
		for (int i = 0; i < op.size(); i++)
			num[i] = op.get(i) == '+' ? 1 : sum; // init to min
		for (int i = 0; i < op.size(); i++) {
			if (op.get(i) == '+') {
				int add = Math.min(sum - 1, sum - min);
				num[i] += add;
				min += add;
			} else {
				int add = Math.min(sum - 1, sum - min);
				num[i] -= add;
				min += add;
			}
		}

		for (int i = 0; i < op.size(); i++) {
			out.print(i > 0 ? op.get(i) + " " : "");
			out.print(num[i] + " ");
		}
		out.println("= " + sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		solution(reader, out);
		out.close();
	}

	protected static class In {
		private BufferedReader reader;
		private StringTokenizer tokenizer = new StringTokenizer("");

		public In(BufferedReader reader) {
			this.reader = reader;
		}

		public String next() throws IOException {
			while (!tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
