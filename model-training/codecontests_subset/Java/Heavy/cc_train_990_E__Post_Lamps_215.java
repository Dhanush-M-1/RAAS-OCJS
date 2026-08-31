import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;
public class Main {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	private PrintWriter pw;
	private long mod = 1000000000 + 7;

	private StringBuilder ans_sb;
	
	private void soln() {	
		int n = nextInt();
		int m = nextInt();
		int k = nextInt();
		int[] blo = new int[n];
		boolean f = true;
		for(int i=0;i<m;i++) {
			int x = nextInt();
			blo[x]++;
			f = false;
		}
		//debug(blo);
		if(blo[0] == 1) {
			pw.println(-1);
		}else {
			int prev = 0;
			int diff = 0;
			for(int i=1;i<n;i++) {
				if(blo[i] == 1) {
					blo[i] = prev;
					diff = Math.max(diff, i - prev);
				}else {
					blo[i] = i;
					prev = i;
				}
			}
			//debug(diff);
			long pow = Long.MAX_VALUE;
			for(int i=0;i<k;i++) {
				long x = nextInt();
				int step  = i+1;
				if(step <= diff)
					continue;
				if(step == 1 && !f) {
					continue;
				}
				//debug(step+" "+x);
				long cc = 0;
				for(int j=0;j<=n;) {
					if(j+step < n) {
						j = blo[j+step];
					}else {
						j = n+1;
					}
					cc++;
				}
				pow = Math.min(cc*x, pow);
			}
			if(pow == Long.MAX_VALUE)
				pow = -1;
			pw.println(pow);
		}
	}


public class Segment{
		private int[][] tree;
		private int[] base;
		private int[] lazy;
		private int size;
		private int n;

		private class Node
		{
			private int l;
			private int r;
			private long ans;
		}

		public Segment(int n, int[] arr)
		{
			this.base=arr;
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
			size = 2 * (int) Math.pow(2, x) - 1;
			tree = new int[size][17];
			lazy = new int[size];
			this.n = n;
			//this.set = set1;
			build(0, 0, n - 1);
		}

		public void build(int id, int l, int r)
		{
			if (l == r)
			{
				for(int i=0;i<17;i++)
					tree[id][i] = ((base[l]>>i)&1);
				return;
			}
			int mid = ((l + r)>>1);
			build((id<<1)|1, l, mid);
			build((id<<1)+2, mid + 1, r);
			tree[id] = merge(tree[(id<<1)|1], tree[(id<<1)+2]);
			//System.out.println(l+" "+r+" "+tree[id].l+" "+tree[id].r+" "+tree[id].ans);
		}
		public int[] merge(int[] n1, int[] n2) {
			int[] ret = new int[17];
			for(int i=0;i<17;i++)
				ret[i] = n1[i]+n2[i];
			return ret;
		}
		public int[] merge(int[] n1, int c, int len) {
			if(c == 0)
				return n1;
			int[] ret = new int[17];
			//int num = 0;
			for(int i=0;i<17;i++)
				if(((c>>i)&1) != 0)
					ret[i] = len - n1[i];
				else
					ret[i] = n1[i];
			return ret;
		}
		public int[] query(int l, int r)
		{
			int[] ret = queryUtil(l, r, 0, 0, n - 1);
			return ret;
		}

		private int[] queryUtil(int x, int y, int id, int l, int r)
		{
			if (l > y || x > r)
				return new int[17];
			if (x <= l && r <= y)
			{
				return tree[id];
			}
			int mid = ((l + r)>>1);
			shift(id, l ,mid, r);
			int[] q1 = queryUtil(x, y, (id<<1)|1, l, mid);
			int[] q2 = queryUtil(x, y, (id<<1)+2, mid + 1, r);
			return merge(q1, q2);
		}
		
		public void update(int x, int y, int c) {
			update1(x, y, c, 0, 0, n-1);
		}
		
		private void update1(int x, int y, int colour, int id, int l, int r)
		{
			//System.out.println(l+" "+r+" "+x);
			if (x > r || y < l)
				return;
			if (x <= l && r <= y)
			{
				lazy[id] ^= colour;
				int len = r-l+1;
				tree[id] = merge(tree[id], colour, len);
				return;
			}
			int mid = ((l + r)>>1);
			shift(id, l, mid, r);
			if(y<=mid)
				update1(x, y, colour, (id<<1)|1, l, mid);
			else if(x>mid)
				update1(x, y, colour, (id<<1)+2, mid + 1, r);
			else {
				update1(x, y, colour, (id<<1)|1, l, mid);
				update1(x, y, colour, (id<<1)+2, mid + 1, r);
			}
			tree[id] = merge(tree[(id<<1)|1],tree[(id<<1)+2]);			
		}
		public void print(int id, int l, int r) {
			if(l == r) {
				int num = 0;
				for(int i=0;i<17;i++)
					num += (1<<i)*tree[id][i];
				debug(l+" "+num);
				return;
			}
			int mid = ((l+r)>>1);
			int num = 0;
			for(int i=0;i<17;i++)
				num += (1<<i)*tree[id][i];
			System.out.println(l+" "+r+" "+lazy[id]+" "+num);
			print(2*id+1,l,mid);
			print(2*id+2,mid+1,r);
		}
		public void shift(int id, int l, int mid, int r)
		{	
			if(lazy[id] == 0)
				return;
			//debug(id);
			lazy[(id<<1)|1] ^= lazy[id];
			tree[(id<<1)|1] = merge(tree[(id<<1)|1], lazy[id], mid - l + 1);
			
			lazy[(id<<1)+2] ^= lazy[id];
			tree[(id<<1)+2] = merge(tree[(id<<1)+2], lazy[id], r - mid);
			
			lazy[id] = 0;
		}
	}

	private class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int c, int d){
			a = c;
			b = d;
		}
		@Override
		public int compareTo(
				Pair o)
		{
			return this.a - o.a;
		}
	}
	private String solveEqn(long a, long b) {
		long x = 0, y = 1, lastx = 1, lasty = 0, temp;
		while (b != 0) {
			long q = a / b;
			long r = a % b;
			a = b;
			b = r;
			temp = x;
			x = lastx - q * x;
			lastx = temp;
			temp = y;
			y = lasty - q * y;
			lasty = temp;
		}
		return lastx + " " + lasty;
	}

	private void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	private long pow(long a, long b, long c) {
		if (b == 0)
			return 1;
		long p = pow(a, b / 2, c);
		p = (p * p) % c;
		return (b % 2 == 0) ? p : (a * p) % c;
	}

	private long gcd(long n, long l) {
		if (l == 0)
			return n;
		return gcd(l, n % l);
	}

	public static void main(String[] args) throws Exception {
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				new Main().solve();
			}
		}, "1", 1 << 26).start();
		//new Main().solve();
	}

	public StringBuilder solve() {
		InputReader(System.in);
		/*
		 * try { InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\in.txt"));
		 * } catch(FileNotFoundException e) {}
		 */
		pw = new PrintWriter(System.out);
		// ans_sb = new StringBuilder();
		soln();

		pw.close();
		// System.out.println(ans_sb);
		return ans_sb;
	}

	public void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	private int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private String nextToken() {
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

	private String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	private int[] nextIntArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		return arr;
	}

	private long[] nextLongArray(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextLong();
		}
		return arr;
	}

	private void pArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private void pArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private char nextChar() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		char c1 = (char) c;
		while (!isSpaceChar(c))
			c = read();
		return c1;
	}

	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}