import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class E {

	public static void main(String[] args) throws IOException {

		FastScanner sc = new FastScanner();
		int t = sc.nextInt();
		int k = sc.nextInt();
		int n = t;
		PriorityQueue<Integer> both = new PriorityQueue<Integer>();
		PriorityQueue<Integer> bob = new PriorityQueue<Integer>();
		PriorityQueue<Integer> alice = new PriorityQueue<Integer>();
		first: while (t-- != 0) {			
			int c = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 1 && b == 1)
				both.add(c);
			else if(a == 1) {
				alice.add(c);
			}
			else if(b == 1) {
				bob.add(c);
			}
		}
		long total = 0;
		long book = 0;
		while((!both.isEmpty() || (!alice.isEmpty() && !bob.isEmpty()))) {
			int one = -1;
			if(!both.isEmpty())
			 one = both.peek();
			
			int a = -1,b = -1;
			if((!alice.isEmpty() && !bob.isEmpty())){
				a = alice.peek();
				b = bob.peek();
			}
			if(one == -1) {
				total+=a+b;
				alice.poll();
				bob.poll();
			}
			else if(a == -1) {
				total+=one;
				both.poll();
			}
			else {
				if(one<=a+b) {
					total+=one;
					both.poll();
				}
				else {
					total+=a+b;
					alice.poll();
					bob.poll();
				}
			}
			book+=1;
			if(book >= k)
				break;
			
		}
		if(book < k) {
			System.out.println(-1);
		}
		else
			System.out.println(total);

	}

	static void shuffleSort(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] readArrayLong(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static int ceil(int x, int y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static long ceil(long x, long y) {
		return (x % y == 0 ? x / y : (x / y + 1));
	}

	static int max(int x, int y) {
		return Math.max(x, y);
	}

	static int min(int x, int y) {
		return Math.min(x, y);
	}

	static long max(long x, long y) {
		return Math.max(x, y);
	}

	static long min(long x, long y) {
		return Math.min(x, y);
	}

	static int min(int a[]) {
		int x = 1_000_000_00_9;
		for (int i = 0; i < a.length; i++)
			x = min(x, a[i]);
		return x;
	}

	static int max(int a[]) {
		int x = -1_000_000_00_9;
		for (int i = 0; i < a.length; i++)
			x = max(x, a[i]);
		return x;
	}

	static long min(long a[]) {
		long x = (long) 3e18;
		for (int i = 0; i < a.length; i++)
			x = min(x, a[i]);
		return x;
	}

	static long max(long a[]) {
		long x = -(long) 3e18;
		for (int i = 0; i < a.length; i++)
			x = max(x, a[i]);
		return x;
	}

	static int power(int x, int y) {
		int res = 1;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x);
			y >>= 1;
			x = (x * x);
		}
		return res;
	}

	static long power(long x, long y) {
		long res = 1;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x);
			y >>= 1;
			x = (x * x);
		}
		return res;
	}

	static long power(long x, long y, long mod) {
		long res = 1;
		x %= mod;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % mod;
			y >>= 1;
			x = (x * x) % mod;
		}
		return res;
	}

	static void intsort(int[] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			temp.add(a[i]);
		Collections.sort(temp);
		for (int i = 0; i < a.length; i++)
			a[i] = temp.get(i);
	}

	static void longsort(long[] a) {
		List<Long> temp = new ArrayList<Long>();
		for (int i = 0; i < a.length; i++)
			temp.add(a[i]);
		Collections.sort(temp);
		for (int i = 0; i < a.length; i++)
			a[i] = temp.get(i);
	}

	static void reverseintsort(int[] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverseOrder();
		for (int i = 0; i < a.length; i++)
			a[i] = temp.get(i);
	}

	static void reverselongsort(long[] a) {
		List<Long> temp = new ArrayList<Long>();
		for (int i = 0; i < a.length; i++)
			temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverseOrder();
		for (int i = 0; i < a.length; i++)
			a[i] = temp.get(i);
	}

	static class longpair implements Comparable<longpair> {
		long x, y;

		longpair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(longpair p) {
			return Long.compare(this.x, p.x);
		}
	}

	static class intpair implements Comparable<intpair> {
		int x, y;

		intpair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(intpair o) {
			return Integer.compare(this.x, o.x);
		}

		//		a = new pair [n];
		//		a[i] = new pair(coo,cost);

	}

	public static int gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	public static long gcd(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.longValue();
	}
}
