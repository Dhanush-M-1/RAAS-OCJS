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
        String[] str = (br.readLine()).trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        long[] arr = new long[n];
       	str = (br.readLine()).trim().split(" ");
       	for(int i=0;i<n;i++)
       		arr[i] = Long.parseLong(str[i]);
        Arrays.sort(arr);
        long mid = arr[n/2];
        long count = 0;
        long pos = 0,neg = 0;
        for(int i=0;i<n/2;i++)
        {
            if(arr[i] > m)
            {
                pos += arr[i] - m;
            }
            else if(arr[n-i-1] < m)
            {
                neg += m - arr[n-i-1];
            }
                
        }
        count = count + pos + neg + Math.abs(arr[n/2] - m);
        System.out.println(count);
	}
} 