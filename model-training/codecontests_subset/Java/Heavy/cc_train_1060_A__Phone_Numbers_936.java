import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Phone {
	public void run() throws Exception {
		FastScanner sc = new FastScanner();
		
		int a = sc.nextInt();
		String s = sc.next();
		int count = 0;
		for (int i = 0; i<a; i++) {
			int n = Integer.parseInt(s.substring(i, i+1));
			if (n == 8) {
				count++;
			}
		}
		if (a<11) { System.out.println(0); return;}
		if ((a/11) <= count) {
			System.out.println(a/11); 
		return;}
		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
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
		new Phone().run();
	}
}