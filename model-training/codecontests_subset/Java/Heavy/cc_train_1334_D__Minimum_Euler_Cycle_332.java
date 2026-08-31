import java.io.*;
import java.math.BigInteger;
import java.util.*;

import javax.transaction.xa.Xid;

public class tr1 {
	static PrintWriter out;
	static StringBuilder sb;
	static int n, m;
	static long mod = 998244353;
	static int[][] memo;
	static String s;
	static HashSet<Integer> nodes;
	static HashSet<Integer>[] ad, tree;
	static boolean[] vis, taken;
	static int[] a;
	static TreeSet<Long> al;
	static long[] val;
	static ArrayList<String> aa;
	static char[] b;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			long l = sc.nextLong();
			long r = sc.nextLong();
			int[] ar = new int[(int) (r - l + 1)];
			int id = 1;
			int af = 0;
			long ll = l;
			int las = 0;
			while (id<n) {
				long num = (n - id) * 2l;
	//		System.out.println(ll+" "+num);
				if (ll <= num) {
					if (ll % 2 == 0) {
						af = (int) (ll / 2) + id;
					} else {
						af = id;
						las = (int) (ll / 2) + id+1;
					}
					break;
				}
				ll -= num;
				id++;
			}
		//	System.out.println(id+" "+af+" "+las);
			if (af == id) {
				ar[0] = id;
				if(ar.length>1)
				ar[1] = las;
				af = ++las;
				for (int i = 2; i < ar.length; i += 2) {
					if (af > n) {
						id++;
						af = id + 1;
			//			System.out.println(i+" "+id+" "+af);
					}
				//	System.out.println(i+" "+id+" "+af);
					ar[i] = id;
					if (i + 1 < ar.length)
						ar[i + 1] = af;
					af++;
				}
			} else {
				ar[0] = af;
				if (af == n) {
					if(ar.length>1)
					ar[1] = ++id;
					if(ar.length>2)
					ar[2] = id + 1;
					af = id + 1;
					af++;
				} else {
					if(ar.length>1)
					ar[1] = id;
					if(ar.length>2)
					ar[2] = ++af;
					af++;
				}
				for (int i = 3; i < ar.length; i += 2) {
					if (af > n) {
						id++;
						af = id + 1;
					}
					ar[i] = id;
					if (i + 1 < ar.length)
						ar[i + 1] = af;
					af++;
				}
			}
			if (r == n * 1l * (n - 1) + 1)
				ar[ar.length-1] = 1;
			for (int i = 0; i < ar.length; i++)
				out.print(ar[i] + " ");
			out.println();
		}
		out.flush();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextArrInt(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextArrLong(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}