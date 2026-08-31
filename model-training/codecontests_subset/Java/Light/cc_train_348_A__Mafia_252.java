import java.util.*;
import java.io.*;
/*
 * author:yanghui
 */
public class A {

	class InputReader {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader() throws FileNotFoundException {
			reader = new BufferedReader(new FileReader("d:/input.txt"));
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

	}

	public void run() {

		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int a[] = new int[n];
		long sum = 0;
		long max = -1;
		for(int i = 0 ; i < n ; i ++){
			a[i] = reader.nextInt();
			sum += (long)a[i];
			max = Math.max(max, a[i]);
		}
		long ans = sum / (long)(n-1);
		if(sum % (n-1) != 0)
			ans ++;
		ans = Math.max(ans, max);
		System.out.println(ans);
	}

	public static void main(String args[]) {
		new A().run();
	}
}
