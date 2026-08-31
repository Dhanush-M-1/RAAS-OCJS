import java.math.*;
import java.util.*;
import java.util.stream.*;

public class E {

	public Object solve() {
		int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
		int [][] E = dec(sc.nextInts(M));

		int [][] G = graph(N, E);
		PriorityQueue<int[]> Q = new PriorityQueue<>(by(1));
		boolean [] W = new boolean [N];
		int [] L = new int [N];
		for (int i : rep(N))
			Q.add(new int [] { i, L[i] = G[i].length });

		HashSet<Long> H = new HashSet<>();
		long P = BigInteger.probablePrime(30, new Random()).longValue();

		int [] res = new int [M]; int R = N;
		for (int j : sep(M)) {
			while (!Q.isEmpty() && Q.peek()[1] < K) {
				int [] m = Q.poll();
				int i = m[0];
				if (W[i])
					continue;
				for (int n : G[i])
					if (!W[n] && !H.contains(P*i + n) && !H.contains(P*n + i))
						Q.add(new int [] { n, --L[n] });
				W[i] = true;
				--R;
			}

			res[j] = R;

			int x = E[j][0], y = E[j][1];
			if (!W[x] && !W[y]) {
				Q.add(new int [] { x, --L[x] });
				Q.add(new int [] { y, --L[y] });
				H.add(P*x + y); H.add(P*y + x);
			}
		}

		for (int i : rep(M))
			print(res[i]);
		return null;
	}

	private static final boolean ONE_TEST_CASE = true;

	private static void init() {
	}

	private static final int INF = (int) 1e9 + 10;
	private static Comparator<int[]> by (final int ... J) { return new Comparator<int[]>() { @Override
	public int compare(int[] x, int[] y) { for (int i : J) if (x[i] != y[i]) return x[i] - y[i]; return 0; }}; }
	private static int [][] dec (int [] ... E) { return dec(E, INF); }
	private static int [][] dec (int [][] E, int N) { for (int [] e : E) for (int i = 0; i < e.length && i < N; ++i) --e[i]; return E; }
	private static int [][][] dwgraph (int N, int [][] E) {
		int [] D = new int [N];
		for (int [] e : E)
			++D[e[0]];
		int [][][] res = new int [2][N][];
		for (int i = 0; i < 2; ++i)
			for (int j = 0; j < N; ++j)
				res[i][j] = new int [D[j]];
		D = new int [N];
		for (int [] e : E) {
			int x = e[0], y = e[1], z = e.length > 2 ? e[2] : 1;
			res[0][x][D[x]] = y;
			res[1][x][D[x]] = z;
			++D[x];
		}
		return res;
	}
	private static int [][] dup (int [][] E) {
		int [][] res = new int [2*E.length][];
		for (int i = 0; i < E.length; ++i) {
			res[2*i] = E[i].clone();
			res[2*i+1] = E[i].clone();
			res[2*i+1][0] = E[i][1]; res[2*i+1][1] = E[i][0];
		}
		return res;
	}
	private static int [][] graph (int N, int [][] E) { return wgraph(N, E)[0]; }
	private static IntStream range(int N) { return IntStream.range(0, N); }
	private static Iterable<Integer> rep (int N) { return rep(0, N); }
	private static Iterable<Integer> rep (final int S, final int T) { return new Iterable<Integer>() { @Override
	public Iterator<Integer> iterator() { return S < T ? java.util.stream.IntStream.range(S,  T).iterator() : Collections.emptyIterator(); } }; }
	private static Iterable<Integer> sep (int N) { return sep(0, N); }
	private static Iterable<Integer> sep (final int S, final int T) { return new Iterable<Integer>() { @Override
	public Iterator<Integer> iterator() { return S < T ? java.util.stream.IntStream.range(S,  T).map(i -> (T - 1) - (i - S)).iterator() : Collections.emptyIterator(); } }; }
	private static int [][][] wgraph (int N, int [][] E) { return dwgraph(N, dup(E)); }
	////////////////////////////////////////////////////////////////////////////////////
	private static IOUtils.MyScanner sc = new IOUtils.MyScanner();
	private static Object print (Object o, Object ... A) { IOUtils.print(o, A); return null; }
	private static class IOUtils {
		public static class MyScanner {
			public String next() { newLine(); return line[index++]; }
			public int nextInt() { return Integer.parseInt(next()); }
			public String nextLine() { line = null; return readLine(); }
			public String [] nextStrings() { return split(nextLine()); }
			public int[] nextInts() { return nextStream().mapToInt(Integer::parseInt).toArray(); }
			public int[][] nextInts(int N) { return range(N).mapToObj(i -> nextInts()).toArray(int[][]::new); }
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
			private java.util.stream.Stream<String> nextStream() { return java.util.Arrays.stream(nextStrings()); }
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
		private static final java.text.DecimalFormat formatter = new java.text.DecimalFormat("#.#########");
		private static void start() { if (t == 0) t = millis(); }
		private static void append(java.util.function.Consumer<Object> f, java.util.function.Consumer<Object> g, final Object o) {
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
		private static void append(final StringBuilder b, Object o, final String delim) {
			append(x -> { append(b, x, delim); }, x -> b.append(delim).append(x), o);
		}
		private static java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
		private static Object print(Object o, Object ... A) { pw.println(build(o, A)); return null; }
		private static void err(Object o, Object ... A) { System.err.println(build(o, A)); }
		private static boolean PRINT;
		private static void write(Object o) {
			err(o, '(', time(), ')');
			if (PRINT)
				pw.println(o);
		}
		private static void exit() {
			IOUtils.pw.close();
			System.out.flush();
			err("------------------");
			err(time());
			System.exit(0);
		}
		private static long t;
		private static long millis() { return System.currentTimeMillis(); }
		private static String time() { return "Time: " + (millis() - t) / 1000.0; }
		private static void run(int N) {
			try { PRINT = System.getProperties().containsKey("PRINT"); }
			catch (Throwable t) {}

			for (int n = 1; n <= N; ++n) {
				Object res = new E().solve();
				if (res != null)
					write("Case #" + n + ": " + build(res));
			}
			exit();
		}
	}
	public static void main(String[] args) {
		init();
		int N = ONE_TEST_CASE ? 1 : sc.nextInt();
		IOUtils.run(N);
	}
}
