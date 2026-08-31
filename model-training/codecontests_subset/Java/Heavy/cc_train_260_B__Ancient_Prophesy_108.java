import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class B {

	final int MOD = (int)1e9 + 7;
	final double eps = 1e-12;
	final int INF = (int)1e9;
	
	int [] M = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	int digit(char c) {
		return c - '0';
	}
	
	public B () {
		char [] D = sc.next().toCharArray();
		int [] C = new int [100000];
		
		for (int i = 0; i <= D.length - 10; ++i) {
			boolean ok = true;
			ok = ok && D[i+2] == '-';
			ok = ok && D[i+5] == '-';

			ok = ok && D[i+6] == '2';
			ok = ok && D[i+7] == '0';
			ok = ok && D[i+8] == '1';
			ok = ok && D[i+9] >= '3';
			ok = ok && D[i+9] <= '5';
			
			ok = ok && isDigit(D[i]);
			ok = ok && isDigit(D[i+1]);
			ok = ok && isDigit(D[i+3]);
			ok = ok && isDigit(D[i+4]);
			
			int dd = 10 * digit(D[i]) + digit(D[i+1]);
			int mm = 10 * digit(D[i+3]) + digit(D[i+4]);
			int y = digit(D[i+9]);
			
			ok = ok && mm >= 1 && mm <= 12;
			ok = ok && dd >= 1 && dd <= M[mm];
			
			if (ok) {
				int date = 1000 * dd + 10 * mm + y;
				++C[date];
			}
		}
		
		int k = 0;
		for (int i = 0; i < C.length; ++i)
			if (C[i] > C[k])
				k = i;
		
		int dd = k / 1000, mm = (k % 1000) / 10, y = k % 10;
		String res = pad(dd, 100) + '-' + pad(mm, 100) + "-201" + y;
		exit(res);
	}

	String pad(int n, int L) {
		return ("" + (L + n)).substring(1);
	}
	
	static class Counter<T> extends HashMap<T, Integer> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		public Integer get(Object key) {
			return containsKey((T)key) ? super.get(key) : 0;
		}
		
		public void inc(T key) {
			put(key, 1 + get(key));
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	static MyScanner sc;
	
	static class MyScanner {
		public String next() {
			newLine();
			return line[index++];
		}
		
		public char nextChar() {
			return next().charAt(0);
		}
				
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public String nextLine() {
			line = null;
			return readLine();
		}
		
		public String [] nextStrings() {
			line = null;
			return readLine().split(" ");
		}
		
		public char [] nextChars() {
			return next().toCharArray();
		}

		public Integer [] nextInts() {
			String [] L = nextStrings();
			Integer [] res = new Integer [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Integer.parseInt(L[i]);
			return res;
		}	
		
		public Long [] nextLongs() {
			String [] L = nextStrings();
			Long [] res = new Long [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Long.parseLong(L[i]);
			return res;
		}

		public Double [] nextDoubles() {
			String [] L = nextStrings();
			Double [] res = new Double [L.length];
			for (int i = 0; i < L.length; ++i)
				res[i] = Double.parseDouble(L[i]);
			return res;
		}

		//////////////////////////////////////////////
		
		private boolean eol() {
			return index == line.length;
		}

		private String readLine() {
			try {
				return r.readLine();
			} catch (Exception e) {
				throw new Error(e);
			}
		}
		private final BufferedReader r;

		MyScanner () {
			this(new BufferedReader(new InputStreamReader(System.in)));
		}
		
		MyScanner(BufferedReader r) {
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
	
	static void print (Object o, Object... a) {
		pw.println(build(o, a));
	}

	static void exit (Object o, Object... a) {
		print(o, a);
		exit();
	}

	static void exit () {
		pw.close();
		System.out.flush();
		System.err.println("------------------");
		System.err.println("Time: " + ((millis() - t) / 1000.0));
		System.exit(0);
	}
	
	void NO() {
		throw new Error("NO!");
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	static String build(Object... a) {
		StringBuilder b = new StringBuilder();
		for (Object o : a)
			append(b, o);
		return b.toString().trim();		
	}
	
	static void append(StringBuilder b, Object o) {
		if (o.getClass().isArray()) {
			int L = Array.getLength(o);
			for (int i = 0; i < L; ++i)
				append(b, Array.get(o, i));
		} else if (o instanceof Iterable<?>) {
			for (Object p : (Iterable<?>)o)
				append(b, p);
		} else
			b.append(" ").append(o);		
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		sc = new MyScanner ();
		new B();
		exit();
	}

	static void start() {
		t = millis();
	}

	static PrintWriter pw = new PrintWriter(System.out);
	
	static long t;
	
	static long millis() {
		return System.currentTimeMillis();
	}	
}
