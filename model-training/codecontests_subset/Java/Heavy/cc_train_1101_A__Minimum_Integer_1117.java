public class A {

	public Object solve () {
		long L = sc.nextLong(), R = sc.nextLong(), D = sc.nextLong();
		if (D < L)
			return print(D);
		else
			return print(ceil((R+1), D) * D);
	}

	private static final boolean ONE_TEST_CASE = false;

	private static void init () {
	}

	private static long ceil (long p, long q) { return fc(p, q, true); }
	private static long fc (long p, long q, boolean up) {
		if (up) {
			if (q < 0) return fc(-p, -q, true);
			else if (p < 0) return -fc(-p, q, false);
			else return (p+q-1) / q;
		}
		else if (q < 0) return fc(-p, -q, false);
		else if (p < 0) return -fc(-p, q, true);
		else return p / q;
	}
	//////////////////////////////////////////////////////////////////////////////////// OFF
	private static IOUtils.MyScanner sc = new IOUtils.MyScanner();
	private static Object print (Object o, Object ... A) { IOUtils.print(o, A); return null; }
	private static class IOUtils {
		public static class MyScanner {
			public String next () { newLine(); return line[index++]; }
			public int nextInt () { return Integer.parseInt(next()); }
			public long nextLong () { return Long.parseLong(next()); }
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
			private String [] split (String s) { return s.length() > 0 ? s.split(" ") : new String [0]; }
		}
		private static String build (Object o, Object ... A) { return buildDelim(" ", o, A); }
		private static String buildDelim (String delim, Object o, Object ... A) {
			StringBuilder b = new StringBuilder();
			append(b, o, delim);
			for (Object p : A)
				append(b, p, delim);
			return b.substring(delim.length());
		}
		//////////////////////////////////////////////////////////////////////////////////
		private static final java.text.DecimalFormat formatter = new java.text.DecimalFormat("#.#########");
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
			pw.println(build(o, A));
			if (DEBUG)
				pw.flush();
		}
		private static void err (Object o, Object ... A) { System.err.println(build(o, A)); }
		private static boolean DEBUG;
		private static void write (Object o) {
			err(o, '(', time(), ')');
			if (!DEBUG)
				pw.println(o);
		}
		private static void exit () {
			IOUtils.pw.close();
			System.out.flush();
			err("------------------");
			err(time());
			System.exit(0);
		}
		private static long t;
		private static long millis () { return System.currentTimeMillis(); }
		private static String time () { return "Time: " + (millis() - t) / 1000.0; }
		private static void run (int N) {
			try { DEBUG = System.getProperties().containsKey("DEBUG"); }
			catch (Throwable t) {}

			for (int n = 1; n <= N; ++n) {
				Object res = new A().solve();
				if (res != null)
					write("Case #" + n + ": " + build(res));
			}
			exit();
		}
	}
	////////////////////////////////////////////////////////////////////////////////////
	public static void main (String[] args) {
		init();
		int N = ONE_TEST_CASE ? 1 : sc.nextInt();
		IOUtils.run(N);
	}
}
