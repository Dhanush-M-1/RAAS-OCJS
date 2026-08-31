import java.io.*;
import java.util.*;
public class a {
	public static void main(String[] arg) throws IOException {
		new a();
	}
	public a() throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int l = in.nextInt();
		int r = in.nextInt();
		if(l == r) out.println(l);
		else out.println(2);
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