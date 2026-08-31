import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] arhh) {
		Cin in = new Cin();
		int tt = in.nextInt();
		while(tt-->0) {
			int a = in.nextInt(),b = in.nextInt(),n = in.nextInt();
			switch (n%3) {
				case 0 :
					wr.print(a+"\n");
					break;
				case 1:
					wr.print(b+"\n");
					break;
				default:
				wr.print((a^b)+"\n");
			}
		}
		wr.close();
	}


// -- :
	static PrintWriter wr = new PrintWriter(System.out);
	static class Cin {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String next() {
			while(st==null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(reader.readLine());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		long nextLong() { return Long.parseLong(next());}
	}
}