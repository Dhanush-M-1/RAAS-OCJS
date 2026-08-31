import static java.lang.Math.*;

import java.util.*;

public class A {

	public A () {
		int N = sc.nextInt(), K = sc.nextInt(), P = sc.nextInt();
		long [] A = sc.nextLongs(), B = sc.nextLongs();

		sort(A); sort(B);
		long res = LINF;
		for (int s : req(K - N)) {
			long T = 0;
			for (int j : rep(N))
				T = max(T, abs(B[s+j] - A[j]) + abs(P - B[s+j]));
			res = min(res, T);
		}
		exit(res);
	}

	private static final long LINF = (long) 1e18 + 10;
	private static Long [] obj (long ... A) { Long [] res = new Long [A.length]; for (int i = 0; i < A.length; ++i) res[i] = A[i]; return res; }
	private static int [] rep(int N) { return rep(0, N); }
	private static int [] rep(int S, int T) { if (T <= S) return new int [0]; int [] res = new int [T-S]; for (int i = S; i < T; ++i) res[i-S] = i; return res; }
	private static int [] req(int N) { return req(0, N); }
	private static int [] req(int S, int T) { return rep(S, T+1); }
	private static long [] sort(long [] A) { Long [] B = obj(A); Arrays.sort(B); for (int i = 0; i < A.length; ++i) A[i] = B[i]; return A; }
	////////////////////////////////////////////////////////////////////////////////////
	private final static IOUtils.MyScanner sc = new IOUtils.MyScanner();
	private static void exit (Object o, Object ... A) { IOUtils.print(o, A); IOUtils.exit(); }
	private static class IOUtils {
		public static class MyScanner {
			public String next() { newLine(); return line[index++]; }
			public int nextInt() { return Integer.parseInt(next()); }
			public String nextLine() { line = null; return readLine(); }
			public String [] nextStrings() { return split(nextLine()); }
			public long [] nextLongs() {
				String [] L = nextStrings();
				long [] res = new long [L.length];
				for (int i = 0; i < L.length; ++i)
					res[i] = Long.parseLong(L[i]);
				return res;
			}
			//////////////////////////////////////////////
			private boolean eol() { return index == line.length; }
			private String readLine() {
				try {
					return r.readLine();
				} catch (Exception e) {
					throw new Error (e);
				}
			}
			private final java.io.BufferedReader r;
			private MyScanner () { this(new java.io.BufferedReader(new java.io.InputStreamReader(System.in))); }
			private MyScanner (java.io.BufferedReader r) {
				try {
					this.r = r;
					while (!r.ready())
						Thread.sleep(1);
					start();
				} catch (Exception e) {
					throw new Error(e);
				}
			}
			private String [] line;
			private int index;
			private void newLine() {
				if (line == null || eol()) {
					line = split(readLine());
					index = 0;
				}
			}
			private String [] split(String s) { return s.length() > 0 ? s.split(" ") : new String [0]; }
		}
		private static String build(Object o, Object ... A) { return buildDelim(" ", o, A); }
		private static String buildDelim(String delim, Object o, Object ... A) {
			StringBuilder b = new StringBuilder();
			append(b, o, delim);
			for (Object p : A)
				append(b, p, delim);
			return b.substring(delim.length());
		}
		//////////////////////////////////////////////////////////////////////////////////
		private static void start() { if (t == 0) t = millis(); }
		private static void append(StringBuilder b, Object o, String delim) {
			if (o.getClass().isArray()) {
				int len = java.lang.reflect.Array.getLength(o);
				for (int i = 0; i < len; ++i)
					append(b, java.lang.reflect.Array.get(o, i), delim);
			} else if (o instanceof Iterable<?>)
				for (Object p : (Iterable<?>) o)
					append(b, p, delim);
			else {
				if (o instanceof Double)
					o = new java.text.DecimalFormat("#.############").format(o);
				b.append(delim).append(o);
			}
		}
		private static java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
		private static void print(Object o, Object ... A) { pw.println(build(o, A)); }
		private static void err(Object o, Object ... A) { System.err.println(build(o, A)); }
		private static void exit() {
			IOUtils.pw.close();
			System.out.flush();
			err("------------------");
			err(IOUtils.time());
			System.exit(0);
		}
		private static long t;
		private static long millis() { return System.currentTimeMillis(); }
		private static String time() { return "Time: " + (millis() - t) / 1000.0; }
	}
	public static void main (String[] args) { new A(); IOUtils.exit(); }
}
