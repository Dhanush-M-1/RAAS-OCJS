import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static boolean Win(long a, long b) {
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (a == 0) return false;
		if (!Win(a, b % a)) return true;
		
		if (a % 2 == 1) {
			return ((b / a) % 2 == 0);  
		} else {
			return  (((b / a) % (a + 1)) % 2 == 0);
		}
	}
	public static void main(String args[]) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		for (int tests = nextInt(); tests > 0; --tests) {
			long a = nextLong();
			long b = nextLong();

			if (Win(a, b)) out.println("First"); else
			out.println("Second");
		}
		out.close();	
	}
}