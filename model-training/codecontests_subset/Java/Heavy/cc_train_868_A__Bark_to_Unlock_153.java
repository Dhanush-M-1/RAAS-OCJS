import java.util.*;
import java.io.*;
public class a {
	public static void main(String[] arg) throws IOException {
		new a();
	}
	public a() throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String pattern = in.next();
		int n = in.nextInt();
		String[] vs = new String[n];
		for(int i = 0; i < n; i++) vs[i] = in.next();
		boolean f = false;
		for(int i = 0; i < n; i++) {
			if(vs[i].equals(pattern)) {
				f = true;
			}
			for(int j = 0; j < n; j++) {
				if(vs[i].charAt(1) == pattern.charAt(0) && vs[j].charAt(0) == pattern.charAt(1)) {
					f = true;
				}
			}
		}
		out.println(f?"YES":"NO");
		in.close(); out.close();
	}
	class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}
		public String next() throws IOException {
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public void close() throws IOException {
			br.close();
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
