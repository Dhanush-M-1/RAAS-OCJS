import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class A {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		int mn = Integer.MAX_VALUE;
		int n = sc.nextInt();
		int k =  sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(k % a == 0) {
				mn = Math.min(k/a, mn);
			}
		}
		System.out.println(mn);
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
}