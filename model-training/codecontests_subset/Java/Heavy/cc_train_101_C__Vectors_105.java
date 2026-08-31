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
					
					long prevTime = System.currentTimeMillis();
					new Main().run();
					System.err.println("Total time: " + (System.currentTimeMillis() - prevTime) + " ms");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	/*************************************************************** 
	 * Solution
	 **************************************************************/
	void solve() throws IOException  {
		Point pA = new Point(nextInt(), nextInt());
		Point pB = new Point(nextInt(), nextInt());
		Point pC = new Point(nextInt(), nextInt());
		
		boolean ans = false;
		ans |= can(pA, pB, pC); pB = pB.rot90();
		ans |= can(pA, pB, pC); pB = pB.rot90();
		ans |= can(pA, pB, pC); pB = pB.rot90();
		ans |= can(pA, pB, pC); pB = pB.rot90();
		
		out.println(ans ? "YES" : "NO");
	}

	boolean can(Point pA, Point pB, Point pC) {
		if (pC.squareLen() != 0L) {
			Point need = pB.sub(pA);
			return good(need, pC) && good(need, pC.rot90());
		} else {
			return pA.equals(pB);
		}
	}

	boolean good(Point vec, Point base) {
		long dotProduct = dot(base, vec);
		return dotProduct % base.squareLen() == 0L;
	}

	long dot(Point p1, Point p2) {
		return p1.x * p2.x + p1.y * p2.y;
	}

	class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		long squareLen() {
			return x * x + y * y;
		}

		Point sub(Point v) {
			return new Point(x - v.x, y - v.y);
		}

		Point rot90() {
			return new Point(-y, x);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		}
	}
	
	/*************************************************************** 
	 * Input 
	 **************************************************************/
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
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
	
	/*************************************************************** 
	 * Output 
	 **************************************************************/
	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}
	
	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array, String spec) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}
	
	void printArray(Object[] array) {
		boolean blank = false;
		for (Object x : array) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		boolean blank = false;
		for (Object x : collection) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	/*************************************************************** 
	 * Utility
	 **************************************************************/
	void checkMemory() {
		System.err.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB");
	}
	
	long prevTimeStamp = Long.MIN_VALUE;
	
	void updateTimer() {
		prevTimeStamp = System.currentTimeMillis();
	}
	
	void checkTimer() {
		System.err.println((System.currentTimeMillis() - prevTimeStamp) + " ms");
	}
}
