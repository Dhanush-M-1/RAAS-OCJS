import java.util.*;
import java.io.*;
import java.math.*;

//=============================================================================
//--------------------------Main-Class---------------------------------
//=============================================================================

public class E {

	private static long INF = 2000000000L, M = 1000000007, MM = 998244353;
	private static int N = 0;
	private static long power(long a, long n,long mod) {
		long res = 1;
		while(n > 0) {
			if(n%2 == 0) {
				a = (a%mod * a%mod)%mod;
				n/=2;
			}
			else {
				res = (res%mod * a%mod)%mod;
				n--;
			}
		}
		return (res%mod);
	}
	public static void process() throws IOException {

		int n = sc.nextInt();
		long arr[] = sc.readArrayLong(n);
		long count[] = new long[20];
		ArrayList<ArrayList<Long>> lis = new ArrayList<ArrayList<Long>>();
		for(int i=0;i<=10; i++) {
			ArrayList<Long> my = new ArrayList<Long>();
			lis.add(my);
		}
		for(long e : arr) {
			int len = (e+"").length();
			ArrayList<Long> my = lis.get(len);
			my.add(e);
			lis.set(len, my);
		}
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(i == j) {
					int size = lis.get(i).size();
					for(long e : lis.get(i)) {
						int digitIndex = 0;
						StringBuilder str = new StringBuilder(e+"");
						for(char my : str.reverse().toString().toCharArray()) {
							count[digitIndex]+=(my-'0')*(size);
							count[digitIndex+1]+=(my-'0')*(size);
							digitIndex+=2;
						}
					}
				}
				else if(i < j) {
					int size1 = lis.get(i).size();
					int size2 = lis.get(j).size();
					for(long e : lis.get(i)) {
						int digitIndex = 1;
						StringBuilder str = new StringBuilder(e+"");
						for(char my : str.reverse().toString().toCharArray()) {
							count[digitIndex]+=(my-'0')*(size2);
							digitIndex+=2;
						}
					}
					for(long e : lis.get(j)) {
						int digitIndex = 0;
						int cc = i;
						StringBuilder str = new StringBuilder(e+"");
						for(char my : str.reverse().toString().toCharArray()) {
							if(cc > 0) {
								count[digitIndex]+=(my-'0')*(size1);
								digitIndex+=2;
							}
							else {
								count[digitIndex]+=(my-'0')*(size1);
								digitIndex+=1;
							}
							cc--;
						}
					}
					
				}
				else {
					int size2 = lis.get(j).size();
					int size1 = lis.get(i).size();
					for(long e : lis.get(j)) {
						int digitIndex = 0;
						StringBuilder str = new StringBuilder(e+"");
						for(char my : str.reverse().toString().toCharArray()) {
							count[digitIndex]+=(my-'0')*(size1);
							digitIndex+=2;
						}
					}
					for(long e : lis.get(i)) {
						int digitIndex = 1;
						int cc = j-1;
						StringBuilder str = new StringBuilder(e+"");
						for(char my : str.reverse().toString().toCharArray()) {
							if(cc > 0) {
								count[digitIndex]+=(my-'0')*(size2);
								digitIndex+=2;
							}
							else {
								count[digitIndex]+=(my-'0')*(size2);
								digitIndex+=1;
							}
							cc--;
						}
					}
				}
			}
		}
		
		
		
		long ans = 0;
		for(int i=0; i<20; i++) {
			
			long val = (count[i]%MM * power(10, i, MM)%MM)%MM;
			ans = (ans + val)%MM;
		}
		System.out.println(ans%MM);

	}

	//=============================================================================
	//--------------------------Dheeraj-Bhagchandani---------------------------------
	//=============================================================================

	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		boolean oj = true;
		if (oj) {
			sc = new FastScanner();
			out = new PrintWriter(System.out);
		} else {
			sc = new FastScanner(100);
			out = new PrintWriter("output.txt");
		}
		int t = 1;
//		t = sc.nextInt();
		while (t-- > 0) {
			process();
		}
		out.flush();
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.x, o.x);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static void println(Object o) {
		out.println(o);
	}

	static void println() {
		out.println();
	}

	static void print(Object o) {
		out.print(o);
	}

	static void pflush(Object o) {
		out.println(o);
		out.flush();
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

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() throws FileNotFoundException {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		FastScanner(int a) throws FileNotFoundException {
			br = new BufferedReader(new FileReader("input.txt"));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readArray(int n) throws IOException {
			int[] A = new int[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextInt();
			}
			return A;
		}

		long[] readArrayLong(int n) throws IOException {
			long[] A = new long[n];
			for (int i = 0; i != n; i++) {
				A[i] = sc.nextLong();
			}
			return A;
		}
	}

	static void ruffleSort(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}

	static void ruffleSort(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		Arrays.sort(a);
	}
}
