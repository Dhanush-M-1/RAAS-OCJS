import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.lang.Math.*;

public class reading_books_hard_version {
	
	public static void main(String[] args) throws Exception {new reading_books_hard_version().run();}
	public FastIO file = new FastIO();
	public int ntc, ctc;
	public final long MOD = 1000000007L; //998244353L; 
	public final int M0D = 1000000007; //998244353
	public final int N = 200005, dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 };
	
	public void run() throws Exception {
		ntc = 1; //nextInt();
		for (ctc = 1; ctc <= ntc; ++ctc) solve();
		file.out.flush(); file.out.close();
	}
	
	int n, m, k, a[], b[];
	
	void add(int index, int value) {
		for(++index;index<=n;index+=index&-index) {
			a[index] += value;
			++b[index];
		}
	}
	
	void remove(int index, int value) {
		for(++index;index<=n;index+=index&-index) {
			a[index] -= value;
			--b[index];
		}
	}
	
	int get(int index) {
		int ind = 0, x = 0, y = 0;
		for (int j = 1 << 21; j > 0; j >>= 1) {
			if (ind + j <= n && x + b[ind + j] <= index) {
				ind += j;
				x += b[ind];
				y += a[ind];
			}
		}
		return y;
	}
	
	class Pair implements Comparable<Pair> {
		int fi, se;
		Pair(int x, int y) {
			fi = x; se = y;
		}
		public int compareTo(Pair o) {
			if (fi == o.fi) return se - o.se;
			return fi - o.fi;
		}
	}
	
	void solve() {
		n = nextInt();
		m = nextInt();
		k = nextInt();
		a = new int[n+1];
		b = new int[n+1];
		ArrayList<Pair> XX = new ArrayList<>(), XY = new ArrayList<>(), YX = new ArrayList<>(), YY = new ArrayList<>();
		Pair[] books = new Pair[n]; int[] mp = new int[n];
		for (int i = 0; i < n; ++i) {
			int t = nextInt(), a = nextInt(), b = nextInt();
			books[i] = new Pair(t, i);
			if (a == 1 && b == 1)
				XX.add(new Pair(t, i));
			if (a == 0 && b == 1)
				YX.add(new Pair(t, i));
			if (a == 1 && b == 0)
				XY.add(new Pair(t, i));
			if (a == 0 && b == 0)
				YY.add(new Pair(t, i));
		}
		if (XX.size() + min(YX.size(), XY.size()) < k) {
			println(-1); return;
		}
		Arrays.sort(books);
		for (int i = 0; i < n; ++i)
			mp[books[i].se] = i;
		Collections.sort(XX);
		Collections.sort(XY);
		Collections.sort(YX);
		Collections.sort(YY);
		for (Pair p : XX) 
			add(mp[p.se], p.fi);
		for (Pair p : XY) 
			add(mp[p.se], p.fi);
		for (Pair p : YX) 
			add(mp[p.se], p.fi);
		for (Pair p : YY) 
			add(mp[p.se], p.fi);
		int ans = Integer.MAX_VALUE, sum = 0, num = 0, bi = XX.size();
		for (Pair p : XX) {
			++num; sum += p.fi;
			remove(mp[p.se], p.fi);
		}
		for (int i = 0; i < k - XX.size(); ++i) {
			num += 2; sum += XY.get(i).fi + YX.get(i).fi;
			remove(mp[XY.get(i).se], XY.get(i).fi);
			remove(mp[YX.get(i).se], YX.get(i).fi);
		}
		if (num <= m)
			ans = sum + get(m - num);
		for (int i = XX.size() - 1; i >= 0; --i) {
			--num; sum -= XX.get(i).fi;
			add(mp[XX.get(i).se], XX.get(i).fi);
			if (i < k) {
				if (k - i > min(XY.size(), YX.size()))
					break;
				num += 2; sum += XY.get(k - i - 1).fi + YX.get(k - i - 1).fi;
				remove(mp[XY.get(k - i - 1).se], XY.get(k - i - 1).fi);
				remove(mp[YX.get(k - i - 1).se], YX.get(k - i - 1).fi);
			}
			int cur = sum + get(m - num);
			if (cur < ans && m >= num) {
				ans = cur;
				bi = i;
			}
		}
		num = m;
		if (ans == Integer.MAX_VALUE) {
			println(-1); return;
		}
		println(ans);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < XX.size(); ++i)
			if (i < bi) {
				--num;
				print((1+XX.get(i).se) + " ");
			}
			else
				pq.add(XX.get(i));
		for (int i = 0; i < XY.size(); ++i)
			if (i < k - bi) {
				--num;
				print((1+XY.get(i).se) + " ");
			}
			else
				pq.add(XY.get(i));
		for (int i = 0; i < YX.size(); ++i)
			if (i < k - bi) {
				--num;
				print((1+YX.get(i).se) + " ");
			}
			else
				pq.add(YX.get(i));
		for (Pair p : YY)
			pq.add(p);
		while (num-- > 0)
			print((1+pq.poll().se) + " ");
		println("");
	}
	
	void sort(long[] a) { shuffle(a); Arrays.sort(a); }
	void sort(int[] a) { shuffle(a); Arrays.sort(a); }
	void shuffle(long[] a) {
		for (int i = a.length - 1; i >= 0; i--) { int j = (int) (Math.random() * (i + 1)); a[i] ^= a[j] ^ (a[j] = a[i]); } }
	void shuffle(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) { int j = (int) (Math.random() * (i + 1)); a[i] ^= a[j] ^ (a[j] = a[i]); } }
	long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
	long lcm(long x, long y) { return x / gcd(x, y) * y; }
	long mod(long n, long mod) { return (n % mod + mod) % mod; }
	long max(long a, long b) { return Math.max(a, b); }
	int max(int a, int b) { return Math.max(a, b); }
	long min(long a, long b) { return Math.min(a, b); }
	int min(int a, int b) { return Math.min(a, b); }
	long pow(long n, long p, long mod) { long ret = 1L;
	while (p > 0) { if (p % 2 != 0L) ret = mod(ret * n, mod); n = mod(n * n, mod); p >>= 1L; } return ret; }
	long pow(long n, long p) { long ret = 1L;
	while (p > 0) { if (p % 2 != 0L) ret *= n; n *= n; p >>= 1L; } return ret; }
	boolean isPrime(int n) { 
		if (n <= 1) return false; if (n <= 3) return true; if (n % 2 == 0 || n % 3 == 0) return false;
		for (int i = 5; i * i <= n; i = i + 6) if (n % i == 0 || n % (i + 2) == 0) return false; return true; }
	String next() {return file.next();}
	int nextInt() {return file.nextInt();}
	long nextLong() {return file.nextLong();}
	double nextDouble() {return file.nextDouble();}
	String nextLine() {return file.nextLine();}
	void print(Object o) {file.out.print(o);}
	void println(Object o) {file.out.println(o);}
	void printf(String s, Object... o) {file.out.printf(s, o);}
	class FastIO {
		BufferedReader br;
		StringTokenizer st;
		PrintWriter out;
		public FastIO() {br = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);}
		String next() {while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();}}return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine() {String str = "";try {str = br.readLine();} catch (IOException e) {e.printStackTrace();} return str;}
		void print(Object o) {out.print(o);}
		void println(Object o) {out.println(o);}
		void printf(String s, Object... o) {out.printf(s, o);} } }