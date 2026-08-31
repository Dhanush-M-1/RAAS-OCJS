import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.lang.*;


public class Main{
	public static void main(String[] args){
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
	static class TaskA{
		public static void solve(InputReader in, PrintWriter out){
			String a, b, c, d;
			a = in.next();
			b = in.next();
			int n = in.nextInt();
			out.println(a + ' ' + b);
			for(int i = 1; i <= n; ++i){
				c = in.next();
				d = in.next();
				if( a.equals(c)){
					a = d;
				}
				else{
					b = d;
				}
				out.println(a + ' ' + b);
			}
		}
	}
	static class InputReader{
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
	}
}
