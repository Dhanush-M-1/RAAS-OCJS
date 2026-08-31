import java.lang.*;
import java.io.*;
import java.util.*;


public class Multiplication  {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {
	
	public void solve(InputReader in, PrintWriter out) {
		int r = in.nextInt(), x;
		int i, j, k;
		String s;
		
		for (i=1; i<r; ++i) {
			for (j=1,x=i; j<r; ++j,x+=i) {
				s = f(x, r);
				out.print(s + " ");
			}
			out.println();
		}
	}
	
	String f(int x, int r) {
		StringBuilder sb = new StringBuilder();
		
		while (x > 0) {
			sb.append((char) (x%r+'0'));
			x /= r;
		}
		
		return sb.reverse().toString();
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
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