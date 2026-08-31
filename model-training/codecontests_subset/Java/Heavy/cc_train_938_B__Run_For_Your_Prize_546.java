import java.util.*;
import java.io.*;

public class B938 {
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(in.readLine());
		int max = 0;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int j = i();
			max = Math.max(max, Math.min(j - 1, 1000000 - j));
		}

		out.println(max);

		out.close();
	}

	static {
		try {
			in = new BufferedReader(new FileReader("cf.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static int i() {return Integer.parseInt(st.nextToken());}
	static double d() {return Double.parseDouble(st.nextToken());}
	static String s() {return st.nextToken();}
	static long l() {return Long.parseLong(st.nextToken());}
}
