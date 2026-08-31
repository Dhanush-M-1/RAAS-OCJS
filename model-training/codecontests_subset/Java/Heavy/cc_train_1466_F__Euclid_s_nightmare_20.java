import static java.lang.Math.*;

import java.math.*;
import java.util.*;
import java.util.stream.*;

public class F {

	public Object solve () {
		int N = sc.nextInt(), M = sc.nextInt();
		int [][] E = sc.nextInts(N);

		int S = -1;
		DSU dsu = new DSU(M);

		List<Integer> res = new ArrayList<>();
		for (int i : rep(N)) {
			int [] e = E[i];
			if (e[0] == 1) {
				int x = dsu.root(e[1] - 1);
				if (x == S)
					continue;
				
				if (S >= 0)
					dsu.add(S, x);
				else
					S = x;
			}
			else {
				int x = dsu.root(e[1] - 1), y = dsu.root(e[2] - 1);				
				if (x == y)
					continue;
				
				dsu.add(x, y);
			}
			
			if (S >= 0)
				S = dsu.root(S);
			res.add(i+1);
		}

		long B = res.size(), A = modPow(2, B);
		print(A, B);
		return res;
	}

	private static final int CONTEST_TYPE = 1;

	private static void init () {
	}

	private static final int MOD = (int) 1e9 + 7;
	private static long modPow (long b, long e) { return modPow(b, e, MOD); }
	private static long modPow (long b, long e, int mod) { return BigInteger.valueOf(b).modPow(BigInteger.valueOf(e), BigInteger.valueOf(mod)).longValue(); }
	private static int [] rep (int N) { return rep(0, N); }
	private static int [] rep (int S, int T) { if (S >= T) return new int [0]; int [] res = new int [T-S]; for (int i = S; i < T; ++i) res[i-S] = i; return res; }
	private static class DSU {
		private final int [] C;
		public DSU (int N, int [] ... E) {
			C = rep(N);
			add(E, 0, E.length);
		}
		public boolean add (int u, int v) {
			u = root(u);
			v = root(v);
			C[u] = v;
			return u != v;
		}
		public int add (int [][] E, int s, int t) {
			int res = 0;
			for (int i = s; i < t; ++i)
				if (add(E[i][0], E[i][1]))
					++res;
			return res;
		}
		private int root (int s) {
			int res = s;
			while (C[res] != res)
				res = C[res];
			int v = s;
			while (v != res) {
				int w = v;
				v = C[v];
				C[w] = res;
			}
			return res;
		}
	}
	//////////////////////////////////////////////////////////////////////////////////// OFF
	private static IOUtils.MyScanner sc = new IOUtils.MyScanner();
	private static Object print (Object o, Object ... A) { IOUtils.print(o, A); return null; }
	private static class IOUtils {
		public static class MyScanner {
			public String next () { newLine(); return line[index++]; }
			public int nextInt () { return Integer.parseInt(next()); }
			public String nextLine () { line = null; return readLine(); }
			public String [] nextStrings () { return split(nextLine()); }
			public int[] nextInts () { return nextStream().mapToInt(Integer::parseInt).toArray(); }
			public int[][] nextInts (int N) { return IntStream.range(0, N).mapToObj(i -> nextInts()).toArray(int[][]::new); }
			//////////////////////////////////////////////
			private boolean eol () { return index == line.length; }
			private String readLine () {
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
			private void newLine () {
				if (line == null || eol()) {
					line = split(readLine());
					index = 0;
				}
			}
			private java.util.stream.Stream<String> nextStream () { return java.util.Arrays.stream(nextStrings()); }
			private String [] split (String s) { return s.length() > 0 ? s.split(" ") : new String [0]; }
		}
		private static String build (Object o, Object ... A) { return buildDelim(" ", o, A); }
		private static String buildDelim (String delim, Object o, Object ... A) {
			StringBuilder b = new StringBuilder();
			append(b, o, delim);
			for (Object p : A)
				append(b, p, delim);
			return b.substring(min(b.length(), delim.length()));
		}
		//////////////////////////////////////////////////////////////////////////////////
		private static java.text.DecimalFormat formatter = new java.text.DecimalFormat("#.#########");
		private static void start () { if (t == 0) t = millis(); }
		private static void append (java.util.function.Consumer<Object> f, java.util.function.Consumer<Object> g, final Object o) {
			if (o.getClass().isArray()) {
				int len = java.lang.reflect.Array.getLength(o);
				for (int i = 0; i < len; ++i)
					f.accept(java.lang.reflect.Array.get(o, i));
			}
			else if (o instanceof Iterable<?>)
				((Iterable<?>)o).forEach(f::accept);
			else
				g.accept(o instanceof Double ? formatter.format(o) : o);
		}
		private static void append (final StringBuilder b, Object o, final String delim) {
			append(x -> { append(b, x, delim); }, x -> b.append(delim).append(x), o);
		}
		private static java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
		private static void print (Object o, Object ... A) {
			String res = build(o, A);
			if (DEBUG == 2)
				err(res, '(', time(), ')');
			if (res.length() > 0)
				pw.println(res);
			if (DEBUG == 1) {
				pw.flush();
				System.out.flush();
			}
		}
		private static void err (Object o, Object ... A) { System.err.println(build(o, A)); }
		private static int DEBUG;
		private static void exit () {
			String end = "------------------" + System.lineSeparator() + time();
			switch(DEBUG) {
			case 1: print(end); break;
			case 2: err(end); break;
			}
			IOUtils.pw.close();
			System.out.flush();
			System.exit(0);
		}
		private static long t;
		private static long millis () { return System.currentTimeMillis(); }
		private static String time () { return "Time: " + (millis() - t) / 1000.0; }
		private static void run (int N) {
			try { DEBUG = Integer.parseInt(System.getProperties().get("DEBUG").toString()); }
			catch (Throwable t) {}

			for (int n = 1; n <= N; ++n) {
				Object res = new F().solve();
				if (res != null) {
					@SuppressWarnings("all")
					Object o = CONTEST_TYPE == 0 ? "Case #" + n + ": " + build(res) : res;
					print(o);
				}
			}
			exit();
		}
	}
	////////////////////////////////////////////////////////////////////////////////////
	public static void main (String[] args) {
		init();
		@SuppressWarnings("all")
		int N = CONTEST_TYPE == 1 ? 1 : sc.nextInt();
		IOUtils.run(N);
	}
}
