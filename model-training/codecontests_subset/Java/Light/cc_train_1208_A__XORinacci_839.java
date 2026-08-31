import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int test = scan.nextInt();
		StringBuilder ans = new StringBuilder();
		for(int t=0;t<test;t++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			int xor = a^b;
			if(n%3==0) {
				ans.append(a);
			} else if(n%3==1) {
				ans.append(b);
			} else {
				ans.append(xor);
			}
			ans.append("\n");
		}
		System.out.println(ans.toString());
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
	}
}
