import java.io.*;
import java.util.*;
 
public class ProgEc {
	
	public static void main(String[] args) throws Exception {
		//FileInputStream inputStream = new FileInputStream("input.txt");
		//FileOutputStream outputStream = new FileOutputStream("output.txt");
		
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		Solver solver = new Solver();
		solver.solve(1, in, out);
		
		out.close();
	}
	
	static class Solver {
		
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				long l = in.nextLong();
				long r = in.nextLong();
				long d = in.nextLong();
				
				if (d < l || d > r) { out. println(d); continue; }
				long k = r/d;
				out.println(d*(k+1));
				
			}
		}
		
	}
	
	static class InputReader {
		
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		public String next() {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException (e);
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
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
	}
}