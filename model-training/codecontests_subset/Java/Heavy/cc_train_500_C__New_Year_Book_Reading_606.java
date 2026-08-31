import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class Main
{
	public void foo()
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] w = new int[n + 1];
		for(int i = 1;i <= n;++i)
		{
			w[i] = scan.nextInt();
		}
		int[] b = new int[m];
		int[] seq = new int[n];
		int cnt = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i < m;++i)
		{
			b[i] = scan.nextInt();
			if(cnt < n && !set.contains(b[i]))
			{
				set.add(b[i]);
				seq[cnt++] = b[i];
			}
		}
		int ans = 0;
		for(int i = 0;i < m;++i)
		{
			int sum = 0;
			int k = 0;
			for(int j = 0;j < n;++j)
			{
				if(seq[j] == b[i])
				{
					k = j;
					break;
				}
				sum += w[seq[j]];
			}
			ans += sum;
			for(int j = k;j > 0;--j)
			{
				seq[j] = seq[j - 1];
			}
			seq[0] = b[i];
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args)
	{
		new Main().foo();
	}
	
	class MyScanner
	{
	    private byte[] buf = new byte[1024];
	    private int curChar;
	    private int numChars;
	    BufferedInputStream bis = new BufferedInputStream(System.in);

	    public int read() 
	    {
	        if (-1 == numChars)
	        {
	        	throw new InputMismatchException();
	        }
	        if (curChar >= numChars)
	        {
	            curChar = 0;
	            try 
	            {
	                numChars = bis.read(buf);
	            }
	            catch (IOException e)
	            {
	                throw new InputMismatchException();
	            }
	            if (numChars <= 0)
	            {
	            	return -1;
	            }
	        }
	        return buf[curChar++];
	    }

	    public int nextInt() 
	    {
	        int c = read();
	        while (isSpaceChar(c))
	        {
	        	c = read();
	        }
	        int sgn = 1;
	        if (c == '-') 
	        {
	            sgn = -1;
	            c = read();
	        }
	        int res = 0;
	        do 
	        {
	            if (c < '0' || c > '9')
	            {
	            	throw new InputMismatchException();
	            }
	            res *= 10;
	            res += c - '0';
	            c = read();
	        } while (!isSpaceChar(c));
	        return res * sgn;
	    }
	    
	    public String next()
	    {
	        int c = read();
	        while (isSpaceChar(c))
	        {
	        	c = read();
	        }
	        StringBuilder res = new StringBuilder();
	        do 
	        {
	            res.appendCodePoint(c);
	            c = read();
	        } while (!isSpaceChar(c));
	        return res.toString();
	    }

	    private boolean isSpaceChar(int c) 
	    {
	        return ' ' == c || '\n' == c || '\r' == c || '\t' == c || -1 == c;
	    }
	}
}