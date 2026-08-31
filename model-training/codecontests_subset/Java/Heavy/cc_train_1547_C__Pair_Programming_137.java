import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class Template {

	static int mod = 1000000007;

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int yo = sc.nextInt();
		outer: while (yo-- > 0) {
			
			int k = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int l = k;
			int max = 0;
			int[] z = new int[max(n,m)];
			List<Integer> list = new ArrayList<>(); 
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				max = max(a[i],max);
				if(a[i] == 0) {
					z[i]++;
				}
			}
			
			int[] b = new int[m];
			for(int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
				max = max(max,b[i]);
				if(b[i] == 0) z[i]++;
			}
			
			int count = 0;
			l = k;
			int i = 0; int j = 0;
			while(i < n || j < m) {
				
				if(j >= m) {
					if(a[i] == 0) {
						l++;
						list.add(a[i]);
					}
					else {
						if(l < a[i]) {
							out.println(-1);
							continue outer;
						}
						list.add(a[i]);
					}
					i++;
				}
				else if(i >= n) {
					if(b[j] == 0) {
						l++;
						list.add(b[j]);
					}
					else {
						if(l < b[j]) {
							out.println(-1);
							continue outer;
						}
						list.add(b[j]);
					}
					j++;
				}
				
				if(i < n && a[i] != 0) {
					if(l < a[i]) {
						while(j < m) {
							if(b[j] != 0) {
								if(l < b[j]) {
									out.println(-1);
									continue outer;
								}
							}
							else {
								l++;
							}
							list.add(b[j]);
							j++;
							if(l >= a[i]) {
								break;
							}
						}
					}
					if(l >= a[i]) {
						list.add(a[i]);
					}
					else {
						out.println(-1);
						continue outer;
					}
					i++;
					
				}
				else if(i < n && a[i] == 0) {
					l++;
					list.add(0);
					i++;
				}
				
				if(j < m && b[j] != 0) {
					if(l < b[j]) {
						while(i < n) {
							if(a[i] != 0) {
								if(l < a[i]) {
									out.println(-1);
									continue outer;
								}
							}
							else {
								l++;
							}
							list.add(a[i]);
							i++;
							if(l >= b[j]) {
								break;
							}
						}
					}
					if(l >= b[j]) {
						list.add(b[j]);
					}
					else {
						out.println(-1);
						continue outer;
					}
					j++;
				}
				else if(j < m && b[j] == 0) {
					l++;
					list.add(0);
					j++;
				}
			}
		
			for(int e : list) {
				out.print(e + " ");
			}
			out.println();
			
		}
		out.close();
	}


	private static boolean valid(List<Integer> list, int k) {
		
		int l = k;
		
		for(int e : list) {
			if(e == 0) {
				l++;
			}
			else if(e > l) {
				return false;
			}
		}
		return true;
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void sort(int[] arr) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		for (int i = 0; i < arr.length; i++)
			arr[i] = ls.get(i);
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static boolean[] sieve(int N) {
		boolean[] sieve = new boolean[N + 1];
		for (int i = 2; i <= N; i++)
			sieve[i] = true;

		for (int i = 2; i <= N; i++) {
			if (sieve[i]) {
				for (int j = 2 * i; j <= N; j += i) {
					sieve[j] = false;
				}
			}
		}
		return sieve;
	}

	public static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y >>= 1;
			x = (x * x) % p;
		}
		return res;
	}

	public static void print(int[] arr) {
		//for debugging only
		for (int x : arr)
			out.print(x + " ");
		out.println();
	}

	static class FastScanner {
		private int BS = 1 << 16;
		private char NC = (char) 0;
		private byte[] buf = new byte[BS];
		private int bId = 0, size = 0;
		private char c = NC;
		private double cnt = 1;
		private BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			} catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		private char getChar() {
			while (bId == size) {
				try {
					size = in.read(buf);
				} catch (Exception e) {
					return NC;
				}
				if (size == -1)
					return NC;
				bId = 0;
			}
			return (char) buf[bId++];
		}

		public int nextInt() {
			return (int) nextLong();
		}

		public int[] readInts(int N) {
			int[] res = new int[N];
			for (int i = 0; i < N; i++) {
				res[i] = (int) nextLong();
			}
			return res;
		}

		public long[] readLongs(int N) {
			long[] res = new long[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextLong();
			}
			return res;
		}

		public long nextLong() {
			cnt = 1;
			boolean neg = false;
			if (c == NC)
				c = getChar();
			for (; (c < '0' || c > '9'); c = getChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = getChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				cnt *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / cnt;
		}

		public double[] readDoubles(int N) {
			double[] res = new double[N];
			for (int i = 0; i < N; i++) {
				res[i] = nextDouble();
			}
			return res;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c > 32) {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c <= 32)
				c = getChar();
			while (c != '\n') {
				res.append(c);
				c = getChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if (c > 32)
				return true;
			while (true) {
				c = getChar();
				if (c == NC)
					return false;
				else if (c > 32)
					return true;
			}
		}
	}

	//	For Input.txt and Output.txt	
	//	FileInputStream in = new FileInputStream("input.txt");
	//	FileOutputStream out = new FileOutputStream("output.txt");
	//	PrintWriter pw = new PrintWriter(out);
	//	Scanner sc = new Scanner(in);
}