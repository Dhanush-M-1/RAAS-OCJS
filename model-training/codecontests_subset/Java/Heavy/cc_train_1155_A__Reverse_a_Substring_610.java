import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static InputReader scan = new InputReader(new BufferedInputStream(System.in));
	static int n;
	public static void main(String[] args) {
		n=scan.nextInt();
		char[]temp=scan.next().toCharArray();
		for (int i = 1; i < n; i++) {
			if(temp[i-1]>temp[i]){
				System.out.println("YES");
				System.out.println(i+" "+(i+1));
				return;
			}
		}
		System.out.println("NO");
		
		
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