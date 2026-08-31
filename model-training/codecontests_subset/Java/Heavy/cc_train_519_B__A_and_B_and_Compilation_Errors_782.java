import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
	public void foo()
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int a = 0, b = 0, c = 0;
		for(int i = 0;i < n;++i)
		{
			a ^= scan.nextInt();
		}
		for(int i = 0;i < n - 1;++i)
		{
			b ^= scan.nextInt();
		}
		for(int i = 0;i < n - 2;++i)
		{
			c ^= scan.nextInt();
		}
		System.out.println((a ^ b) + "\n" + (b ^ c));
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
	    
	    public long nextLong() 
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
	    	long res = 0;
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