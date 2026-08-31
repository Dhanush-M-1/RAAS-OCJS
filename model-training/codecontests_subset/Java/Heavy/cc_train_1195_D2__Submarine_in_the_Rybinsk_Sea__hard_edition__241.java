import java.util.*;

import java.io.*;
import java.math.*;

public class round574d2d2 {

	public static void main(String args[]) {
		
		FastScanner in = new FastScanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		int[] count = new int[11];
		for (int i=0; i < n; i++) {
			arr[i] = in.next();
			count[arr[i].length()]++;
		}
		long[] modtens = new long[21];
		long tracker = 1;
		for (int i = 0; i < 21; i++) {
			modtens[i] = tracker;
			tracker = tracker * 10;
			tracker %= 998244353;
		}
		long[][] topRecord = new long[11][n];
		long[][] botRecord = new long[11][n];
		long[] sumOrigs = new long[n];
		for (int i = 0; i < n; i++) {
			String num = arr[i];
			int len = num.length();
			for (int j = 1; j <= len; j++) {
				
				long tempSum = 0;
				long tempSum2 = 0;
				for (int k = 0; k < len; k++) {
					int digit = Integer.parseInt(num.substring(k, k+1));
					int digitIndex = len-1-k;
					if (digitIndex < j) {
						tempSum += digit*modtens[2*(digitIndex)+1];
						tempSum2 += digit*modtens[2*(digitIndex)];
					}
					else {
						tempSum += digit*modtens[j*2+(digitIndex-j)];
						tempSum2 += digit*modtens[j*2+(digitIndex-j)];
					}
					
					tempSum %= 998244353;
					tempSum2 %= 998244353;
					
				}
				topRecord[j][i] = tempSum;
				botRecord[j][i] = tempSum2;
			}
			long sumOrig = 0;
			for (int j = 0; j < len; j++) {
				int digit = Integer.parseInt(num.substring(j, j+1));
				sumOrig += digit * modtens[2*(len-j-1) + 1];
				sumOrig += digit * modtens[2*(len-j-1)];
				sumOrig %= 998244353;
			}
			sumOrigs[i] = sumOrig;
		}
		long sum = 0;
		//System.out.println(Arrays.toString(count));
		//System.out.println(Arrays.deepToString(topRecord));
		//System.out.println(Arrays.deepToString(botRecord));
		//System.out.println(Arrays.toString(sumOrigs));
		for (int i = 0; i < n; i++) {
			String num = arr[i];
			int len = num.length();
			int lessers = 0;
			for (int j = 1; j < len; j++) {
				lessers += count[j];
				sum += count[j]*topRecord[j][i];
				sum += count[j]*botRecord[j][i];
				sum %= 998244353;
			}
			int greateq = n - lessers;
			//System.out.println(greateq);
			sum += greateq*sumOrigs[i];
			sum %= 998244353;
		}
		System.out.println(sum);
		
		/*int len = arr[0].length();
		long sum = 0;
		for (int i =0; i < n; i++) {
			String num = arr[i];
			
			for (int j = 0; j < len; j++) {
				int digit = Integer.parseInt(num.substring(j, j+1));
				sum += digit * modtens[2*(len-j-1) + 1];
				sum += digit * modtens[2*(len-j-1)];
				sum %= 998244353;
			}
		}
		sum = sum*n;
		sum %= 998244353;
		System.out.println(sum);*/

	}

	// ======================================================================================
	// =============================== Reference Code =======================================
	// ======================================================================================

	static int greatestDivisor(int n) {
		int limit = (int) Math.sqrt(n);
		int max = 1;
		for (int i = 2; i <= limit; i++) {
			if (n % i == 0) {
				max = Integer.max(max, i);
				max = Integer.max(max, n / i);
			}
		}
		return max;
	}

	// Method to return all primes smaller than or equal to 
	// n using Sieve of Eratosthenes 
	static boolean[] sieveOfEratosthenes(int n) {
		// Create a boolean array "prime[0..n]" and initialize 
		// all entries it as true. A value in prime[i] will 
		// finally be false if i is Not a prime, else true. 
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		prime[0] = false;
		prime[1] = false;

		for (int p = 2; p * p <= n; p++) {
			// If prime[p] is not changed, then it is a prime 
			if (prime[p] == true) {
				// Update all multiples of p 
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		return prime;
	}

	// Binary search for number greater than or equal to target
	// returns -1 if number not found
	private static int bin_gteq(int[] a, int key) {
		int low = 0;
		int high = a.length;
		int max_limit = high;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (a[mid] < key) {
				low = mid + 1;
			} else
				high = mid;
		}

		return high == max_limit ? -1 : high;
	}

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

	static class Tuple<X, Y> {
		public final X x;
		public final Y y;

		public Tuple(X x, Y y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	static class Tuple3<X, Y, Z> {
		public final X x;
		public final Y y;
		public final Z z;

		public Tuple3(X x, Y y, Z z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return "(" + x + "," + y + "," + z + ")";
		}
	}

	static Tuple3<Integer, Integer, Integer> gcdExtended(int a, int b, int x, int y) {
		// Base Case 
		if (a == 0) {
			x = 0;
			y = 1;
			return new Tuple3(0, 1, b);
		}

		int x1 = 1, y1 = 1; // To store results of recursive call 
		Tuple3<Integer, Integer, Integer> tuple = gcdExtended(b % a, a, x1, y1);
		int gcd = tuple.z;
		x1 = tuple.x;
		y1 = tuple.y;

		// Update x and y using results of recursive 
		// call 
		x = y1 - (b / a) * x1;
		y = x1;

		return new Tuple3(x, y, gcd);
	}

	// Returns modulo inverse of a  
	// with respect to m using extended 
	// Euclid Algorithm. Refer below post for details: 
	// https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/ 
	static int inv(int a, int m) {
		int m0 = m, t, q;
		int x0 = 0, x1 = 1;

		if (m == 1)
			return 0;

		// Apply extended Euclid Algorithm 
		while (a > 1) {
			// q is quotient 
			q = a / m;

			t = m;

			// m is remainder now, process 
			// same as euclid's algo 
			m = a % m;
			a = t;

			t = x0;

			x0 = x1 - q * x0;

			x1 = t;
		}

		// Make x1 positive 
		if (x1 < 0)
			x1 += m0;

		return x1;
	}

	// k is size of num[] and rem[]. 
	// Returns the smallest number 
	// x such that: 
	// x % num[0] = rem[0], 
	// x % num[1] = rem[1], 
	// .................. 
	// x % num[k-2] = rem[k-1] 
	// Assumption: Numbers in num[] are pairwise  
	// coprime (gcd for every pair is 1) 
	static int findMinX(int num[], int rem[], int k) {
		// Compute product of all numbers 
		int prod = 1;
		for (int i = 0; i < k; i++)
			prod *= num[i];

		// Initialize result 
		int result = 0;

		// Apply above formula 
		for (int i = 0; i < k; i++) {
			int pp = prod / num[i];
			result += rem[i] * inv(pp, num[i]) * pp;
		}

		return result % prod;
	}

	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}