import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Traffic implements Runnable {
	private void solve() throws IOException {
		String s = null;
		int count = 0;
		int res = 0;
		while(true) {
			try {
				s = reader.readLine();
				if (s.charAt(0) == '+') {
					++count;
				} else if (s.charAt(0) == '-') {
					--count;
				} else {
					res += (long) count * (s.length() - s.indexOf(':') - 1);
				}
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(res);
	}
	public static void main(String[] args) {
		new Traffic().run();
	}
	StringTokenizer tokenizer;
	PrintWriter writer;
	BufferedReader reader;
	@Override
	public void run() {
		try {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}
