import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					long prevTime = System.currentTimeMillis();
					new Main().run();
					System.err.println("Total time: "
							+ (System.currentTimeMillis() - prevTime) + " ms");
					System.err.println("Memory status: " + memoryStatus());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start();
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Object o = solve();
		if (o != null)
			out.println(o);
		out.close();
		in.close();
	}

	private Object solve() throws IOException {
		int n = ni();
		int me = ni() - 1;
		int[] front = nia(n);
		for (int i = 0; i < n; i++)
			front[i]--;
		int[] back = new int[n];
		Arrays.fill(back, -1);
		for (int i = 0; i < n; i++)
			if (front[i] != -1)
				back[front[i]] = i;
		List<Integer> qs = new ArrayList<Integer>();
		int mypos = -1;
		for (int i = 0; i < n; i++)
			if (front[i] == -1) {
				int a = i;
				int size = 0;
				while (a != -1) {
					size++;
					if (a == me) {
						mypos = size;
						break;
					} else {
						a = back[a];
					}
				}
				if (a != me)
					qs.add(size);

			}
		int m = qs.size();
		if (m == 0)
			return mypos;
		boolean[][] dp = new boolean[m][n + 1];
		dp[0][0] = dp[0][qs.get(0)]=true;
		for (int i = 0; i < m - 1; i++)
			for (int j = 0; j <= n; j++)
				if (dp[i][j])
					dp[i + 1][j] = dp[i + 1][j + qs.get(i + 1)]=true;
		int index = 0;
		for (int i = 0; i <= n; i++)
			if (dp[m - 1][i])
				if (index == 0)
					out.println(i + mypos);

		return null;
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nl() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nd() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int[] nia(int size) throws IOException {
		int[] ret = new int[size];
		for (int i = 0; i < size; i++)
			ret[i] = ni();
		return ret;
	}

	long[] nla(int size) throws IOException {
		long[] ret = new long[size];
		for (int i = 0; i < size; i++)
			ret[i] = nl();
		return ret;
	}

	double[] nda(int size) throws IOException {
		double[] ret = new double[size];
		for (int i = 0; i < size; i++)
			ret[i] = nd();
		return ret;
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

	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}

	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array, String spec) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}

	void printArray(Object[] array) {
		boolean blank = false;
		for (Object x : array) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		boolean blank = false;
		for (Object x : collection) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory() >> 20)
				+ "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}
}