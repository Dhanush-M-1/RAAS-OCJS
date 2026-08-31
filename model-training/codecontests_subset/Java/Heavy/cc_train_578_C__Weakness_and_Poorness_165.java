import java.io.*;
import java.math.*;
import java.security.KeyStore.Entry;
import java.util.*;

public class TestClass {
	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	private static PrintWriter pw;
	
	private static void soln() {
		int n = nI();
		double arr[] = new double[n];
		double min = Double.MAX_VALUE,max = Double.MIN_VALUE;
		for(int i=0;i<n;i++){
			arr[i] = nI();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		double sum[] = new double[n];
		sum[0] = arr[0];
		for(int i=1;i<n;i++)
			sum[i] = sum[i-1]+arr[i];
		double ans = Double.MAX_VALUE;
		int temp = 100;
		while(temp-->0){
			double l = min + (max-min)/3.0,r = max - (max-min)/3.0;
			double tmax=0,tmin=0;
			double ans1 = 0,ans2 = 0;
			for(int i=0;i<n;i++){
				if(i==0){
					tmax = arr[i]-l;
					tmin = arr[i]-l;
					ans1 = Math.abs(arr[i]-l);
					continue;
				}
				ans1 = Math.max(ans1,Math.max(Math.abs(sum[i]-l*(i+1)), Math.max(Math.abs(sum[i]-l*(i+1)-tmax), Math.abs(sum[i]-l*(i+1)-tmin))));
				if(sum[i]-l*(i+1)>tmax)
					tmax = sum[i]-l*(i+1);
				if(sum[i]-l*(i+1)<tmin)
					tmin = sum[i]-l*(i+1);
			}
			for(int i=0;i<n;i++){
				if(i==0){
					ans2 = Math.abs(sum[i]-r);
					tmax = arr[i]-r;
					tmin = arr[i]-r;
					continue;
				}
				ans2 = Math.max(ans2,Math.max(Math.abs(sum[i]-r*(i+1)), Math.max(Math.abs(sum[i]-r*(i+1)-tmax), Math.abs(sum[i]-r*(i+1)-tmin))));
				if(sum[i]-r*(i+1)>tmax)
					tmax = sum[i]-r*(i+1);
				if(sum[i]-r*(i+1)<tmin)
					tmin = sum[i]-r*(i+1);
			}
			ans = Math.min(ans, Math.min(ans1, ans2));
			if(ans1>ans2)
				min = l;
			else
				max = r;
		}
		pw.println(ans);
	}

	public static void main(String[] args) {
		InputReader(System.in);
		pw = new PrintWriter(System.out);
		soln();
		pw.close();
	}

	// To Get Input
	// Some Buffer Methods
	public static void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private static boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private static int read() {
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

	private static int nI() {
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

	private static long nL() {
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

	private static String nextToken() {
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

	private static String nLi() {
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

	private static boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}