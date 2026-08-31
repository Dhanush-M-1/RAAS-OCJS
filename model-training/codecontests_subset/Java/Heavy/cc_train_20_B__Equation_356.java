import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();
		
		if (a == 0) {
			if (b == 0) {
				out.println(c == 0 ? -1 : 0);
			} else {
				solevLE(b, c);
			}
		} else {
			solveQE(a, b, c);
		}
		
		out.close();
	}
	
	void solevLE(double a, double b) {
		out.println(1);
		out.printf(Locale.US, "%.12f%n", -b / a);
	}

	void solveQE(long a, long b, long c) {
		long D = b * b - 4L * a * c;
		if (D < 0) {
			out.println(0);
		} else if (D == 0) {
			out.println(1);
			out.printf(Locale.US, "%.12f%n", -b / (2.0 * a));
		} else {
			double[] roots = { (-b - sqrt(D)) / (2.0 * a), (-b + sqrt(D)) / (2.0 * a) };
			sort(roots);
			out.println(2);
			out.printf(Locale.US, "%.12f%n", roots[0]);
			out.printf(Locale.US, "%.12f%n", roots[1]);
		}
	}

	/*************************************************************** 
	 * Utility
	 **************************************************************/
	long b2mb(long b) {
		return b >> 20;
	}
	
	void checkMemory() {
		System.err.println(b2mb(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + "/" + b2mb(Runtime.getRuntime().totalMemory()) + " MB");
	}
	
	/*************************************************************** 
	 * Input 
	 **************************************************************/
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
