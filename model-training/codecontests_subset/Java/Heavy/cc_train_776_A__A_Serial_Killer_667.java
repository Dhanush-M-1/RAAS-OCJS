import java.io.*;
import java.util.*;
public class a {
	public static void main(String[] arg) throws IOException {
		new a();
	}
	public a() throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String op1 = in.next();
		String op2 = in.next();
		out.println(op1 + " " + op2);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			String dead = in.next();
			String next = in.next();
			if(dead.equals(op1)) op1 = next;
			else op2 = next;
			out.println(op1 + " " + op2);
		}
		in.close(); out.close();
	}
	class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}
		public void close() throws IOException {
			br.close();
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public String next() throws IOException {
			while(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
	}
}