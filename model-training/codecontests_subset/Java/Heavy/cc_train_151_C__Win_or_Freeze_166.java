/**
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author yxq
 * @data 2014年8月9日下午12:06:51
 * @version jdk1.7
 * @package Acm
 * @fileName Main16.java
 */
public class Main{
	public static void main(String[] args) {

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

	BufferedReader in;
	PrintWriter out;
	StringTokenizer strTok = new StringTokenizer("");

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Object o = solve();
		if (o != null)
			out.println(o);
		out.flush();
		out.close();
		in.close();
	}

	int[] f = new int[100010];
	/**
	 * @return
	 * @throws IOException
	 */
	long ans;

	void dfs(int n, int m) {
		if (m <= 0) {
			ans++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (f[i] > 0) {
				f[i]--;
				dfs(n, m - 1);
				f[i]++;
			}
		}
	}

	private Object solve() throws IOException {
		int m, k;
		long x, y, a, b, n,i;
		long[] dp = new long[15000000];
		String str;
		while (EOF() != true) {
			n = nl();
			k = 0;
			for (int j = 0; j < dp.length; j++) {
				dp[j] = 0;
			}
			for (i = 2; i * i <= n; i++) {
				while (n % i == 0) {
					dp[k++] = i;
					n /= i;
				}
			}
			if (n > 1)
				dp[k++] = n;
			if (k < 2) {
				out.println(1);
				out.println(0);
			} else if (k == 2)
				out.println(2);
			else {
				out.println(1);
				out.println(dp[0] * dp[1]);
			}
			out.flush();
		}
		return null;
	}

	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory() >> 20)
				+ "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}

	String nextToken() throws IOException {
		while (!strTok.hasMoreTokens())
			strTok = new StringTokenizer(in.readLine());
		return strTok.nextToken();
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

	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
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
		strTok = new StringTokenizer("");
		return in.readLine();
	}

	boolean EOF() throws IOException {
		while (!strTok.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			strTok = new StringTokenizer(s);
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

	public void pln() {
		out.println();
	}

	public void pln(int arg) {
		out.println(arg);
	}

	public void pln(long arg) {
		out.println(arg);
	}

	public void pln(double arg) {
		out.println(arg);
	}

	public void pln(String arg) {
		out.println(arg);
	}

	public void pln(boolean arg) {
		out.println(arg);
	}

	public void pln(char arg) {
		out.println(arg);
	}

	public void pln(float arg) {
		out.println(arg);
	}

	public void pln(Object arg) {
		out.println(arg);
	}

	public void p(int arg) {
		out.print(arg);
	}

	public void p(long arg) {
		out.print(arg);
	}

	public void p(double arg) {
		out.print(arg);
	}

	public void p(String arg) {
		out.print(arg);
	}

	public void p(boolean arg) {
		out.print(arg);
	}

	public void p(char arg) {
		out.print(arg);
	}

	public void p(float arg) {
		out.print(arg);
	}

	public void p(Object arg) {
		out.print(arg);
	}
}

class po {
	int x, y;

	po(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class SortByY implements Comparator<po> {
	@Override
	public int compare(po o1, po o2) {
		if (o1.y != o2.y)
			return o2.y - o1.y;
		return o2.x - o1.x;
	}
}
