import java.util.*;
import java.io.*;

public class A915 {
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		int n = i(), l = i();

		int max = -1;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int temp = i();
			if (l % temp == 0 && temp > max) max = temp;
		}

		out.println(l / max);

		out.close();
	}

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
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
