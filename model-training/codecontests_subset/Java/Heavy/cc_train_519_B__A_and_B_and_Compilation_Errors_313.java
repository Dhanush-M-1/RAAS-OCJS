import java.util.*;
import java.io.*;

public class CF_519B{
  public static void main(String[] args) throws IOException{
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = in.nextInt();
    int one = 0, two = 0, three = 0;
    for( int i = 0; i < n; i++ ) one += in.nextInt();
    for( int i = 0; i < n-1; i++ ) two += in.nextInt();
    for( int i = 0; i < n-2; i++ ) three += in.nextInt();
    out.println(one-two);
    out.println(two-three);
    out.close();
  }
  public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = null;
		}
		public String next() throws IOException {
			while(st == null || !st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}