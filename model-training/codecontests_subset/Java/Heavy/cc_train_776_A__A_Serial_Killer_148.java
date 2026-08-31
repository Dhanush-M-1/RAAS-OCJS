import java.io.*;
import java.util.*;

public class Main {
	static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

	boolean checkIndex(int index, int size) {
		return (0 <= index && index < size);
	}

	// ======================================================
	void solve() throws IOException {
		String a = rS();
		String b = rS();
		int n = rI();
		String[][] ans = new String[n + 1][2];
		ans[0][0] = a;
		ans[0][1] = b;
		for (int i = 1; i <= n; i++) {
			String c = rS();
			String d = rS();
			if (c.equals(a)) {
				a = d;
			} else {
				b = d;
			}
			ans[i][0] = a;
			ans[i][1] = b;
		}
		for (int i = 0; i <= n; i++) {
			out.println(ans[i][0] + " " + ans[i][1]);
		}
	}

	// ===========================================================================
	long summ(int[] a) {
		long ans = 0;
		for (int i = 0; i < a.length; i++) {
			ans += a[i];
		}
		return ans;
	}

	long summToIndex(int[] a, int index) {
		long ans = 0;
		for (int i = 0; i < index; i++) {
			ans += a[i];
		}
		return ans;
	}

	int minInt(int... values) {
		int min = Integer.MAX_VALUE;
		for (int value : values) {
			min = Math.min(min, value);
		}
		return min;
	}

	int maxInt(int... values) {
		int max = Integer.MIN_VALUE;
		for (int value : values) {
			max = Math.max(max, value);
		}
		return max;
	}

	long minLong(long... values) {
		long min = Long.MAX_VALUE;
		for (long value : values) {
			min = Math.min(min, value);
		}
		return min;
	}

	long maxLong(long... values) {
		long min = Long.MIN_VALUE;
		for (long value : values) {
			min = Math.max(min, value);
		}
		return min;
	}

	// ==============================================================================

	public static void main(String[] args) {
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;

	long maxA(int[] each) {
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < each.length; i++) {
			if (each[i] > max) {
				max = each[i];

			}
		}
		return max;
	}

	long minA(long[] a) {
		long min = Long.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	void init() throws FileNotFoundException {
		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}

		tok = new StringTokenizer("");
	}

	void run() {
		try {
			long timeStart = System.currentTimeMillis();

			init();
			solve();

			out.close();

			long timeEnd = System.currentTimeMillis();
			System.err.println("Time = " + (timeEnd - timeStart) + " COMPILED");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	long memoryTotal, memoryFree;

	void memory() {
		memoryFree = Runtime.getRuntime().freeMemory();
		System.err.println("Memory = " + ((-memoryTotal + memoryFree) >> 10) + " KB");
	}

	String readLine() throws IOException {
		return in.readLine();
	}

	String delimiter = " ";

	String rS() throws IOException {
		while (!tok.hasMoreTokens()) {
			String nextLine = readLine();
			if (null == nextLine)
				return null;

			tok = new StringTokenizer(nextLine);
		}

		return tok.nextToken(delimiter);
	}

	int[] rA(int b) {
		int a[] = new int[b];
		for (int i = 0; i < b; i++) {
			try {
				a[i] = rI();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return a;
	}

	int rI() throws IOException {
		return Integer.parseInt(rS());
	}

	long rL() throws IOException {
		return Long.parseLong(rS());
	}

	void sort(int[] a) {
		Integer arr[] = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		Arrays.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr[i];
		}
	}

}
