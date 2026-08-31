import java.util.*;

import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {

	long mod1 = (long) 1e9 + 7;
	int mod2 = 998244353;

	public void solve() throws Exception {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n=sc.nextInt(), m=sc.nextInt();
			Pair arr[] = new Pair[n];
			long sumofone=0;
			int another[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=new Pair(sc.nextLong(), i+1);
				sumofone += arr[i].value;
				if(i!=0) arr[i].value += arr[i-1].value;
			}
			sort(arr);
			int min=n+1;

			for(int i=n-1;i>=0;i--) {
				min=Math.min(min, arr[i].index);
				another[i]=min;
			}
			for(int i=0;i<m;i++) {
				long result=0;
				int input=sc.nextInt();
				if(sumofone<=0 && arr[n-1].value<input) {
					out.print(-1+" ");
					continue;
				}
				long max = arr[n-1].value;
				if(max>=input ) {
					int idx = LowerBound(arr, input);
					out.print(another[idx]-1+" ");
					continue;
				}
				else {
					long roundsreq = (long)(input-max+sumofone-1)/sumofone;
					long remains = input - roundsreq*sumofone;
					int idx = LowerBound(arr, (int)remains);
					out.print(roundsreq*n + another[idx] - 1 + " ");
					continue;
				}
			}
			out.println();
		}

	}
	
	class Pair implements Comparable<Pair>{
		long value;
		int index;
		
		public Pair(long value, int index) {
			this.value = value;
			this.index = index;
		}

		public int compareTo(Pair x) {
			return Long.compare(value, x.value);
		}
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static void sort(Pair[] a) {
		ArrayList<Pair> l = new ArrayList<>();
		for (Pair i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static long ncr(int n, int r, long p) {
		if (r > n)
			return 0l;
		if (r > n - r)
			r = n - r;

		long C[] = new long[r + 1];

		C[0] = 1;

		for (int i = 1; i <= n; i++) {

			for (int j = Math.min(i, r); j > 0; j--)
				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r] % p;
	}

	void sieveOfEratosthenes(boolean prime[], int size) {
		for (int i = 0; i < size; i++)
			prime[i] = true;

		for (int p = 2; p * p < size; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i < size; i += p)
					prime[i] = false;
			}
		}
	}

	static int LowerBound(Pair a[], int x) { // smallest index having value >= x
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m].value >= x)
				r = m;
			else
				l = m;
		}
		return r;
	}

	static int UpperBound(int a[], int x) {// biggest index having value <= x
		int l = -1, r = a.length;
		while (l + 1 < r) {
			int m = (l + r) >>> 1;
			if (a[m] <= x)
				l = m;
			else
				r = m;
		}
		return l + 1;
	}

	public long power(long x, long y, long p) {
		long res = 1;
		// out.println(x+" "+y);
		x = x % p;
		if (x == 0)
			return 0;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	static Throwable uncaught;

	BufferedReader in;
	FastScanner sc;
	PrintWriter out;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable uncaught) {
			Solution.uncaught = uncaught;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		if (Solution.uncaught != null) {
			throw Solution.uncaught;
		}
	}

}

class FastScanner {

	BufferedReader in;
	StringTokenizer st;

	public FastScanner(BufferedReader in) {
		this.in = in;
	}

	public String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	public int[] readArray(int n) throws Exception {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}

}