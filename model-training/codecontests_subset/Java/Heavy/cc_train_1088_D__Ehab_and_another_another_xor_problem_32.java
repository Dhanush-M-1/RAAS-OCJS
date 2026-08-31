import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
	static class InputReader
	{
	    private final InputStream stream;
	    private final byte[] buf = new byte[8192];
	    private int curChar, snumChars;

	    public InputReader(InputStream st) {
	      this.stream = st;
	    }

	    public int read() {
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
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      int sgn = 1;
	      if (c == '-') {
	        sgn = -1;
	        c = read();
	      }
	      int res = 0;
	      do {
	        res *= 10;
	        res += c - '0';
	        c = read();
	      } while (!isSpaceChar(c));
	      return res * sgn;
	    }

	    public long nextLong() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      int sgn = 1;
	      if (c == '-') {
	        sgn = -1;
	        c = read();
	      }
	      long res = 0;
	      do {
	        res *= 10;
	        res += c - '0';
	        c = read();
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
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      StringBuilder res = new StringBuilder();
	      do {
	        res.appendCodePoint(c);
	        c = read();
	      } while (!isSpaceChar(c));
	      return res.toString();
	    }

	    public String nextLine() {
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

	    public boolean isSpaceChar(int c) {
	      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	    }

	    private boolean isEndOfLine(int c) {
	      return c == '\n' || c == '\r' || c == -1;
	    }
	}
 	public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int a = 0,b = 0;
        System.out.println("? 0 0");
        System.out.flush();
        int big = in.nextInt();
        for(int i=29;i>=0;i--)
        {
            int c = a^(1<<i);
            int d = b^(1<<i);
            System.out.println("? " + c + " " + b);
            System.out.flush();
            int x = in.nextInt();
            System.out.println("? " + a + " " + d);
            System.out.flush();
            int y = in.nextInt();
            if(x == y)
            {
                if(big == 1)
                    a = a^(1<<i);
                else
                    b = b^(1<<i);
                big = x;
            }
            else if(x == -1)
            {
                a = a^(1<<i);
                b = b^(1<<i);
            }
        }
        System.out.println("! " + a + " " + b);
    }
}
