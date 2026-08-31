import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class quad {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (a == 0 && b == 0) {
			if (c == 0) System.out.println(-1);
			else System.out.println(0);
			return;
		}
		if (a == 0) {
			double root = -(double)c/b;
			System.out.println(1);
			System.out.println(root);
			return;
		}
		double x = (double)b*b-4.0*a*c;
		if (x<0) System.out.println(0);
		else if (x == 0) {
			double root = (-b+Math.sqrt(x))/2.0/a;
			System.out.println(1);
			System.out.println(root);
		}
		else {
			double r1 = (-b+Math.sqrt(x))/2.0/a;
			double r2 = (-b-Math.sqrt(x))/2.0/a;
			System.out.println(2);
			double root1 = Math.min(r1, r2);
			double root2 = Math.max(r1, r2);
			System.out.printf("%.10f",root1);
			System.out.println();
			System.out.printf("%.10f", root2);
		}
		
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
	public static void main (String[] args) throws Exception {
		new quad().run();
	}
}