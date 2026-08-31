import java.util.*;
import java.io.*;

public class test {
public static void main(String args[]){
	InputReader in = new InputReader(System.in);
	long n = in.nextLong();
	long k = in.nextLong();
	long arr[] = new long[(int) n];
	for(int i=0;i<n;i++){
		arr[i] = in.nextLong();
	}
	long ans = (long) Math.floor((-1+Math.sqrt(1+4*2*k))/2);
	if((int) (k-(ans*(ans+1))/2 -1)<0)
		System.out.println(arr[(int) ans-1]);
	else
	System.out.println(arr[(int) (k-(ans*(ans+1))/2 -1)]);
}
public static long expo(long a, long b){
    if (b==1)
        return a%1000000007;
    if (b==2)
        return a*a%1000000007;

    if (b%2==0){
            return expo(expo(a,b/2)%1000000007,2)%1000000007;
    }
    else{
        return a*expo(expo(a,(b-1)/2)%1000000007,2)%1000000007;
    }
}
static class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[8192];
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
