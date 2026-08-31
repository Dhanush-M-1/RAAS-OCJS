
import java.util.*;
import java.io.*;

/**
 *
 * @author umang
 */

public class C545 {
    
    public static int mod = 1000000007;
    
    public static void main(String[] args) {
 
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        int[][] dp = new int[n][2];
        
        for(int i=0;i<n;i++){
            x[i]=in.nextInt();
            h[i]=in.nextInt();
        }
        dp[0][0]=1;
        dp[n-1][1]=1;
        int count=1;
        if(n>1) count++;
        for(int i=1;i<n-1;i++){
            if(x[i]-h[i]>x[i-1]){
                if(dp[i-1][1]==0){
                    dp[i][0]=1;
                    count++;
                }
                else if(x[i]-h[i]>x[i-1]+h[i-1]){
                    dp[i][0]=1;
                    count++;
                }
            }
            if(dp[i][0]==0){
                if(x[i]+h[i]<x[i+1]){
                    dp[i][1]=1;
                    count++;
                }
            }
        }
        w.println(count);
        w.close();
    }
    
    static class Pair{
        int i;
        int x;
        
        public Pair(int i,int x){
            this.x=x;
            this.i=i;
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

