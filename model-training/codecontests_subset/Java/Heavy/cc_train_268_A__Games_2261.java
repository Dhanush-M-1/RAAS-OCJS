
import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class abc {
	static PrintWriter pw;

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
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

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static boolean isPrime(long n) {
		if (n == 2)
			return true;
		long i = 2;
		while (i * i <= n) {
			if (n % i == 0)
				return false;
			i++;
		}
		return true;
	}

	public static long[] remove(long n) {
		long res[] = new long[1000000000];
		long rese = 0;
		int i = 0;
		while (n > 0) {
			long dig = n % 10;
			n = n / 10;
			if (dig > 0) {
				rese = dig;
				res[i++] = rese;
			}
		}
		return res;
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

	static int abs(int x) {
		return Math.abs(x);
	}

	static long abs(long x) {
		return Math.abs(x);
	}

	static int log2(int N) {
		int result = (int) (Math.log(N) / Math.log(2));
		return result;
	}

	static long max(long x, long y) {
		return Math.max(x, y);
	}

	static long min(long x, long y) {
		return Math.min(x, y);
	}

	public static class pair {
		int x;
		int y;

		public pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static class Comp implements Comparator<pair> {
		public int compare(pair a, pair b) {
			if (a.x != b.x) {
				return a.x - b.x;
			} else {
				return a.y - b.y;
			}
		}
	}

	public static void extract(ArrayList<Integer> ar, int k, int d) {
		int c = 0;
		for (int i = 1; i < k; i++) {
			int x = 0;
			boolean dm = false;
			while (x > 0) {
				long dig = x % 10;
				x = x / 10;
				if (dig == d) {
					dm = true;
					break;
				}
			}
			if (dm)
				ar.add(i);
		}
	}

	public static void dfs(int index, boolean vis[], int a[], int b[], int n) {
		vis[index] = true;
		for (int i = 0; i < n; i++) {
			if (!vis[i] && (a[i] == a[index] || b[i] == b[index]))
				dfs(i, vis, a, b, n);
		}
	}

	public static int countSetBitsUtil(int x) {
		if (x <= 0)
			return 0;
		return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
	}

	public static double decimalPlaces(double sum) {
		DecimalFormat df = new DecimalFormat("#.00");
		String angleFormated = df.format(sum);
		double fin = Double.parseDouble(angleFormated);
		return fin;
	}

	static boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;

		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == m);
	}

	public static void main(String[] args) throws Exception {

		FastReader sc = new FastReader();
		pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		
			int a[]=new int[t];
			int b[]=new int[t];
			for(int i=0;i<t;i++)
			{
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
			}
			int c=0;
			for(int i=0;i<t;i++)
			{
				int k=a[i];
				for(int j=0;j<t;j++)
				{
					if(k==b[j])
						c++;
				}
			}
			pw.println(c);
		pw.flush();
	}
}
