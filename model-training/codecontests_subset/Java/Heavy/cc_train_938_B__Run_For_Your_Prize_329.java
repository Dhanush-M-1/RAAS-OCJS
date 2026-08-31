import java.util.*;
import java.io.*;

public class q8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet set = new DisjointSet(26);
		
		InputReader sc1 = new InputReader(System.in);
		PrintWriter sc2 = new PrintWriter(System.out);
		int n = sc1.nextInt();
		int a[] = new int[1000001];
		Arrays.fill(a, 0);
		for(int i=0;i<n;i++) {
			a[sc1.nextInt()]++;
		}
		int count1 = 0, count2 = 0;
		for(int i=1000000/2;i>=0;i--) {
			if(a[i]!=0) {
				count1 = i-1;
				break;
			}
		}
		for(int i=1000000/2+1;i<1000001;i++) {
			if(a[i]!=0) {
				count2 = 1000000-i;
				break;
			}
		}
		System.out.println(Math.max(count1, count2));
		
	}
	/*
	 * 	DIVISORS
	 * */
	public static void divsors(int n) {
		for(int i=1;i<=Math.sqrt(n)+1;i++) {
			if(n%i==0) {
				if(n/i==i) {
					System.out.print(i+" ");
				}
				else {
					System.out.print	(i+" "+n/i);
				}
			}
		}
	}
	
	/*
	 * 	GCD 
	 * */
	
	public static int GCD(int x, int y) {
		if(x==0) {
			return y;
		}
		return GCD(y%x, x);
	}
	
	/*
	 * 	GCD EXTENDED
	 * */
	
	public static int gcdExtended(int a, int b, int x, int y) {
		if(a==0) {
			x = 0;
			y = 1;
			return b;
		}
		
		int x1 = 1, y1 = 1;
		int gcd = gcdExtended(b%a, a, x1, y1);
		x = y1 - (b/a)*x1;
		y = x1;
		
		return gcd;
	}
	
	/*
	 * 	DISJOINT SET
	 * */
	static class DisjointSet{
		static StringBuilder str = new StringBuilder();
		static int count = 0;
		int rank[];
		int parent[];
		int n;
		DisjointSet(int n){
			this.n = n;
			rank = new int[n];
			Arrays.fill(rank, 0);
			parent = new int[n];
			makeSet();
			
		}
		void makeSet() {
			for(int i=0;i<n;i++) {
				parent[i] = i;
			}
		}
		
		int find(int x) {
			if(parent[x]!=x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}
		
		void union(int x, int y) {
			int xRoot = find(x);
			int yRoot = find(y);
			
			if(xRoot==yRoot) {
				return;
			}
			
			if(rank[xRoot]>rank[yRoot]) {
				parent[yRoot] = xRoot;
				Append(x,y);
				count++;
			}
			else if(rank[xRoot]<rank[yRoot]) {
				parent[xRoot] = yRoot;
				Append(x,y);
				count++;
			}
			else {
				parent[yRoot] = xRoot;
				rank[xRoot] = rank[xRoot] + 1;
				count++;
				Append(x,y);
			}
		}
		
		void Append(int x, int y) {
			str.append((char)(x+97)+" "+(char)(y+97)+"\n");
		}
	}
	static class InputReader {
		 
		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}	
}

