
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob1 {
	
	private void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = in.nextInt()-1;
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			if (i <= a[i]) list[a[i]-i]++;
			else list[n-i+a[i]]++;
		}
		int increases = 0;
		for (int i = 0; i < n; i++) {
			if (i >= a[i]) increases++;
		}
		long current = 0;
		for (int i = 0; i < n; i++) {
			current += Math.abs(a[i]-i);
		}
		long minDeviation = current;
		int minShift = 0;
		for (int i = 1; i < n; i++) {
			current -= Math.abs(n-1-a[n-i]);
			current += a[n-i];
			current += (increases-1);
			current -= (n-increases);
			increases--;
			increases += list[i];
			if (current < minDeviation) {
				minDeviation = current;
				minShift = i;
			}
		}
		System.out.println(minDeviation + " " + minShift);
	}
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Prob1 solver = new Prob1();
		solver.solve(in, out);
		out.close();
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
	}

}
