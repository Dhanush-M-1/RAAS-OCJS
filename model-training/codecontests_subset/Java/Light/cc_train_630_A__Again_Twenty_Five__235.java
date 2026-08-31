import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        solve(in, out);
        
        out.close();
    }
    
// ----------- <solution> ----------------
	public static void solve(InputReader in, PrintWriter out) {
		out.println("25");
	}
// ----------- </solution> ----------------

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try { tokenizer = new StringTokenizer(reader.readLine()); }
					catch (IOException e) { throw new RuntimeException(e); }
				}
				return tokenizer.nextToken();
			}

		public int nextInt() { return Integer.parseInt(next()); }
		public long nextLong() { return Long.parseLong(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
	}
}
