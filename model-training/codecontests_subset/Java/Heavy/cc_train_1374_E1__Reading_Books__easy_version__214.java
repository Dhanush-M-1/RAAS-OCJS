import java.io.*;
import java.util.*;

public class prop {
	static Scanner sc;
	static int n, inf = Integer.MAX_VALUE, mod = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int k = sc.nextInt();

		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			int w = sc.nextInt();
			int e = sc.nextInt();
			if (w == 1 && e == 1)
				c.add(q);
			if (w == 0 && e == 1)
				b.add(q);
			if (w == 1 && e == 0)
				a.add(q);
		}
		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(c);
		int i = 0, j = 0, w = 0;
		int k1 = 0;
		int k2 = 0;
		int g = 0;
		long tt = 0;
		while (g < n) {
			g++;
			int x = inf;
			int y = inf;
			int z = inf;
			if (i < a.size())
				x = a.get(i);
			if (j < b.size())
				y = b.get(j);
			if (w < c.size())
				z = c.get(w);
			if ((z <= x + y && z != inf && x != inf && y != inf ) || ((x == inf && k1 < k && z != inf))
					|| ((y == inf && k2 < k && z != inf))) {
				k1++;
				k2++;
				tt += z;
				w++;
			} else {
				if (x != inf && k1 < k) {
					k1++;
					i++;
					tt += x;
				}
				if (y != inf && k2 < k) {
					k2++;
					j++;
					tt += y;
				}
				
			}
			if(k1>=k && k2>=k)
				break;
		}
		pw.print(k1 < k || k2 < k ? -1 : tt);

		pw.flush();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static int log(int n, int base) {
		int ans = 0;
		while (n + 1 > base) {
			ans++;
			n /= base;
		}
		return ans;
	}

	static int pow(int b, long e) {
		int ans = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				ans = (int) ((ans * 1l * b));
			e >>= 1;
			{

			}
			b = (int) ((b * 1l * b));
		}
		return ans;
	}

	static int powmod(int b, long e, int mod) {
		int ans = 1;
		b %= mod;
		while (e > 0) {
			if ((e & 1) == 1)
				ans = (int) ((ans * 1l * b) % mod);
			e >>= 1;
			b = (int) ((b * 1l * b) % mod);
		}
		return ans;
	}

	static class pair implements Comparable<pair> {
		int x, y;

		pair(int s, int d) {
			x = s;
			y = d;
		}

		@Override
		public int compareTo(pair p) {
			return (int) (x - p.x);
		}

		@Override
		public String toString() {
			return x + " " + y;

		}
	}

	static int ceil(int a, int b) {
		int ans = a / b;
		return a % b == 0 ? ans : ans + 1;
	}

	static long ceil(long a, long b) {
		long ans = a / b;
		return a % b == 0 ? ans : ans + 1;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public int[] intArr(int n) throws IOException {
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public long[] longArr(int n) throws IOException {
			long a[] = new long[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
			}
			return a;
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

	public static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

}