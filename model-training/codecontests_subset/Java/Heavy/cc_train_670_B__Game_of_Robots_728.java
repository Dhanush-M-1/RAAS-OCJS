import java.util.*;
import java.io.*;
import java.lang.*;

public class Code6
{
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
			while (isSpaceChar(c)) {
				c = snext();
			}
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
			while (isSpaceChar(c)) {
				c = snext();
			}
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
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
 
		public String readString() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public String nextLine() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	
	static class pair implements Comparable<pair>
	{
		Integer x, y;
		pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		public int compareTo(pair o) {
			return x.compareTo(o.x);
		}  
	}
	
	
	public static int binarySearch(long[] a,long key)
	{
		int low = 0;
		int high = a.length-1;
		int mid =(low+high)/2;
		while(1!=0)
		{
			if(low>=high)
			{
				if(key<=a[low])
					return low-1;
				else 
					return low;
			}
			
			 mid = (low+high)/2;
			if(a[mid]==key)
				return mid;
			else if(a[mid]<key)
				low = mid+1;
			else
				high = mid-1;
			//System.out.println(low + " " + high + " " + mid);
		}
	}
	
	
	public static void main(String[] args)
	{
		InputReader in = new InputReader(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] arr = new int[n];
		arr = in.nextIntArray(n);
		long[] a = new long[n];
		
		a[0] = 1;
		for(int i=1;i<n;i++)
			a[i] = (long)a[i-1] + (long)(i+1);
		
		int i = binarySearch(a, k);
		long x;
		if(k==1)
			x = 1;
		else
		{
			if(a[i]==k)
				x = k - a[i-1];
			else
				x = k - a[i];
		}
		pw.println(arr[(int)(x-1)]);
		pw.flush();
		pw.close();
	}
}