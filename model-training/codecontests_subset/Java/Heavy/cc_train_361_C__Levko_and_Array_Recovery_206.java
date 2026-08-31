import static java.util.Arrays.*;

public class A {

	private final static boolean autoflush = false;

	public A () {
		int N = sc.nextInt();
		int M = sc.nextInt();
		Integer [][] Y = sc.nextInts(M);

		long [] B = new long [N];
		fill(B, 1L*INF*INF);

		for (int j = M-1; j >= 0; --j) {
			Integer [] y = Y[j];
			int a = y[1] - 1, b = y[2] - 1, d = y[3];

			switch(y[0]) {
			case 1:
				for (int i = a; i <= b; ++i)
					B[i] -= d;
				break;
			case 2:
				boolean ok = false;
				for (int i = a; i <= b; ++i)
					if (B[i] >= d) {
						B[i] = d;
						ok = true;
					}

				if (!ok)
					exit("NO");
				break;
			}
		}

		for (int i = 0 ; i < N; ++i) {
			if (B[i] < -INF)
				exit("NO");
			B[i] = Math.min(B[i], INF);
		}

		long [] res = copyOf(B, N);

		for (int j = 0; j < M; ++j) {
			Integer [] y = Y[j];
			int a = y[1] - 1, b = y[2] - 1, d = y[3];

			switch(y[0]) {
			case 1:
				for (int i = a; i <= b; ++i)
					B[i] += d;
				break;
			case 2:
				boolean ok = false;
				for (int i = a; i <= b; ++i)
					if (B[i] == d) {
						ok = true;
						break;
					}

				if (!ok)
					exit("NO");
				break;
			}
		}

		print("YES");
		exit(res);
	}

	///////////////////////////////////////////////////////////////////////////
	private static final int INF = (int) 1e9;
	////////////////////////////////////////////////////////////////////////////////////
	private final static MyScanner sc = new MyScanner();
	private static class MyScanner {
		public String next() { newLine(); return line[index++]; }
		public int nextInt() { return Integer.parseInt(next()); }
		public String nextLine() { line = null; return readLine(); }
		public String [] nextStrings() { return nextLine().split(" "); }
		public Integer [] nextInts() {
			String [] L = nextStrings();
			Integer [] res = new Integer [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Integer.parseInt(L[i]);
			return res;
		}
		public Integer [][] nextInts (int N) {
			Integer [][] res = new Integer [N][];
			for (int i = 0; i < N; ++i)
				res[i] = nextInts();
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
				line = readLine().split(" ");
				index = 0;
			}
		}
	}
	private static void print (Object o, Object... a) { printDelim(" ", o, a); }
	private static void printDelim (String delim, Object o, Object... a) { pw.println(build(delim, o, a)); }
	private static void exit (Object o, Object... a) { print(o, a); exit(); }
	private static void exit() {
		pw.close();
		System.out.flush();
		System.err.println("------------------");
		System.err.println("Time: " + ((millis() - t) / 1000.0));
		System.exit(0);
	}
	////////////////////////////////////////////////////////////////////////////////////
	private static String build (String delim, Object o, Object... a) {
		StringBuilder b = new StringBuilder();
		append(b, o, delim);
		for (Object p : a)
			append(b, p, delim);
		return b.substring(delim.length());
	}
	private static void append(StringBuilder b, Object o, String delim) {
		if (o.getClass().isArray()) {
			int L = java.lang.reflect.Array.getLength(o);
			for (int i = 0; i < L; ++i)
				append(b, java.lang.reflect.Array.get(o, i), delim);
		} else if (o instanceof Iterable<?>)
			for (Object p : (Iterable<?>)o)
				append(b, p, delim);
		else
			b.append(delim).append(o);
	}
	////////////////////////////////////////////////////////////////////////////////////
	private static void start() { t = millis(); }
	private static java.io.PrintWriter pw = new java.io.PrintWriter(System.out, autoflush);
	private static long t;
	private static long millis() { return System.currentTimeMillis(); }
	public static void main (String[] args) { new A(); exit(); }
}
