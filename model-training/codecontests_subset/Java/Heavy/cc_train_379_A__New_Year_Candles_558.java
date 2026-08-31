import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewYearCandles {

	static class FastReader {
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int a = fr.nextInt();
		int b = fr.nextInt();
		int count = a;
		
		while(a>=b) {
			count += a/b;
			a = (a/b) + (a%b);
		}
		
		System.out.println(count);
	}
}
