import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.security.auth.kerberos.KerberosKey;
import javax.tools.JavaFileObject.Kind;

import static java.lang.Math.*;

import java.math.BigInteger;
import java.util.Random;

public class Main {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	//final boolean ONLINE_JUDGE = true;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void init() throws FileNotFoundException {
		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	int fib(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		else
			return fib(n - 1) + fib(n - 2);
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	public static void main(String[] args) {
		new Main().run();
		// Sworn to fight and die
	}

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
		final int MAGIC_VALUE = 50;
		if (levtIndex < rightIndex) {
			if (rightIndex - levtIndex <= MAGIC_VALUE) {
				insertionSort(a, levtIndex, rightIndex);
			} else {
				int middleIndex = (levtIndex + rightIndex) / 2;
				mergeSort(a, levtIndex, middleIndex);
				mergeSort(a, middleIndex + 1, rightIndex);
				merge(a, levtIndex, middleIndex, rightIndex);
			}
		}
	}

	private static void merge(int[] a, int levtIndex, int middleIndex,
			int rightIndex) {
		int length1 = middleIndex - levtIndex + 1;
		int length2 = rightIndex - middleIndex;
		int[] levtArray = new int[length1];
		int[] rightArray = new int[length2];
		System.arraycopy(a, levtIndex, levtArray, 0, length1);
		System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
		for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
			if (i == length1) {
				a[k] = rightArray[j++];
			} else if (j == length2) {
				a[k] = levtArray[i++];
			} else {
				a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
						: rightArray[j++];
			}
		}
	}

	private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
		for (int i = levtIndex + 1; i <= rightIndex; i++) {
			int current = a[i];
			int j = i - 1;
			while (j >= levtIndex && a[j] > current) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = current;
		}
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			init();
			solve();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	class LOL implements Comparable<LOL> {
		int x;
		int y;

		public LOL(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(LOL o) {

			// if (y == o.y)
			// return (o.x - x);
			return (int)(x - o.x); // ---->
			// return o.x - x; // <----
			// return o.y-y;
		}

	}

	public int binarySearch(int[] a, int k) {
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (a[m] == k)
				return m;
			else if (a[m] > k)
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}
	public int count(int n, int k) {
		if (n == 0) return 1;
		if (n == 1) return k - 1;
		return (k - 1)*(count(n - 1, k) + count(n - 2, k));
	}
	
	
	public void solve() throws IOException {
		int n = readInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (readInt() == 100)
				sum++;
		}
		if (n == 1) {
			out.print("NO");
			return;
		}
		if (n % 2 == 0) {
			if (sum % 2 == 0) {
				out.print("YES");
				return;
			}
			out.print("NO");
		}
		else {
			if ((sum % 2 == 0) && (sum != 0)) {
				out.print("YES");
				return;
			}
			out.print("NO");
		}
	}
}
