import java.io.*;
import java.util.*;
import java.lang.reflect.*;


public class Main {

	static long CURRENT_TIME_NANO = System.nanoTime();

	public static void main(String[] args) throws Exception {

		int n = next();
		int m = next();

		long[] max = new long[n];
		Arrays.fill(max, 1000000000000L);

		int[] type = new int[m];
		int[] l = new int[m];
		int[] r = new int[m];
		int[] x = new int[m];

		for (int i = 0; i < m; i++) {
			type[i] = next();
			l[i] = next() - 1;
			r[i] = next() - 1;
			x[i] = next();
		}

		for (int j = m - 1; j >= 0; j--) {
			if (type[j] == 1) {
				for (int i = l[j]; i <= r[j]; i++) max[i] -= x[j];
			} else {
				for (int i = l[j]; i <= r[j]; i++) max[i] = Math.min(max[i], x[j]);
			}
		}

		for (int i = 0; i < n; i++) max[i] = Math.min(max[i], 1000000000);
		for (int i = 0; i < n; i++) max[i] = Math.max(max[i], -1000000000);

		boolean ans = true;
		int[] mm = new int[n];
		for (int i = 0; i < n; i++) mm[i] = (int)max[i];
		
		for (int j = 0; j < m; j++) {
			if (type[j] == 1) {
				for (int i = l[j]; i <= r[j]; i++) max[i] += x[j];
			} else {
				long mx = Long.MIN_VALUE;
				for (int i = l[j]; i <= r[j]; i++) mx = Math.max(max[i], mx);
				if (mx != x[j]) ans = false;
			}			
		}

		if (ans) {
			out.println("YES");
			for (int i = 0; i < n; i++) out.print(mm[i] + " ");
			out.println();
		} else out.println("NO");

		out.close();
	}
	
	static void printtime() {System.out.println((System.nanoTime() - CURRENT_TIME_NANO)*1e-9);}
	static void nexttime() {printtime(); CURRENT_TIME_NANO = System.nanoTime();}
	static PrintWriter out = new PrintWriter(System.out);
	
	static BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in = new StringTokenizer("");

	static String nextToken() throws Exception {
		if (!in.hasMoreTokens()) in = new StringTokenizer(bufferedreader.readLine());
		return in.nextToken();
	}

	static int next()  throws Exception {return Integer.parseInt(nextToken());};
	static int[] next(int n) throws Exception {
		int[] x = new int[n];
		for (int i = 0; i < n; i++) x[i] = next();
		return x;
	}
	static int[][] next(int n, int m) throws Exception {
		int[][] x = new int[n][];
		for (int i = 0; i < n; i++) x[i] = next(m);
		return x;
	}

	static long nextl() throws Exception {return Long.parseLong(nextToken());};
	static long[] nextl(int n) throws Exception {
		long[] x = new long[n];
		for (int i = 0; i < n; i++) x[i] = nextl();
		return x;
	}
	static long[][] nextl(int n, int m) throws Exception {
		long[][] x = new long[n][];
		for (int i = 0; i < n; i++) x[i] = nextl(m);
		return x;
	}

	static double nextd() throws Exception {return Double.parseDouble(nextToken());};
	static double[] nextd(int n) throws Exception {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) x[i] = nextd();
		return x;
	}
	static double[][] nextd(int n, int m) throws Exception {
		double[][] x = new double[n][];
		for (int i = 0; i < n; i++) x[i] = nextd(m);
		return x;
	}

	static String nextline() throws Exception {
		in = new StringTokenizer("");
		return bufferedreader.readLine();
	}

	static void sout(long x) {System.out.println(x);}
	static void sout(String s) {System.out.println(s);}
	static void sout(int[] x) {for (int xx : x) System.out.print(xx + " "); System.out.println();}
	static void sout(long[] x) {for (long xx : x) System.out.print(xx + " "); System.out.println();}
	static void sout(int[][] x) {for (int[] xx : x) sout(xx); System.out.println();}
	static void sout(long[][] x) {for (long[] xx : x) sout(xx); System.out.println();}


}