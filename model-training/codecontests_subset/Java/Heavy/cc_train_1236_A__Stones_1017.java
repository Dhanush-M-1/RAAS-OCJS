import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;
public class Main{
	static long mod = 1000000007;
	static InputReader in = new InputReader(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {
		 int t=in.readInt();
		 while(t-->0){
			int a=in.readInt();
			int b=in.readInt();
			int c=in.readInt();
			int count=0;
			while(b>0&&c>1) {
				b--;
				c-=2;
				count+=3;
			}
			while(a>0&&b>1) {
				a--;
				b-=2;
				count+=3;
			}
			System.out.println(count);
			//long n=in.readLong();
			// String a=in.readString();
		}
	}
	static String removeChar(String s,int a,int b) {
		return s.substring(0,a)+s.substring(b,s.length());
	}
	static int[]  nextIntArray(int n){
		int[] arr= new int[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static long[] nextLongArray(int n){
		long[]arr= new long[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readLong();
		}
		return arr;
	}	
	static int[]  nextIntArray1(int n) {
		int[] arr= new int[n+1]; 
		int i=1;
		while(i<=n){
			arr[i++]=in.readInt();
		}
		return arr;
	}	    	
	static long[] nextLongArray1(int n){
		long[]arr= new long[n+1];
		int i=1;
		while(i<=n) {
			arr[i++]=in.readLong();
		}
		return arr;
	}	  
	static long gcd(long x, long y) {
		if (x % y == 0)
			return y;
		else
			return gcd(y, x % y);
	}
	static long pow(long n, long m) {
		if(m==0)
			return 1;
		else if(m==1)
			return n;
		else {
			long r=pow(n,m/2);
			if(m%2==0)
				return r*r;
			else
				return r*r*n;
		}
	}
	static long max(long a,long b,long c) {
		return Math.max(Math.max(a, b),c);
	}
	static long min(long a,long b,long c) {
		return Math.min(Math.min(a, b), c);
	}
	static class Pair implements Comparable<Pair> {
		int a, b;
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair o) {
			if (this.a != o.a)
				return Integer.compare(this.a, o.a);
			else
				return Integer.compare(this.b, o.b);
			// return 0;
		}
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.a == a && p.b == b;
			}
			return false;
		}
		public int hashCode() {
			return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
		}
	}
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		public int read() {
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
		public int readInt() {
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
		public String readString() {
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
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, readInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		public long readLong() {
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
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		public String next() {
			return readString();
		}
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
