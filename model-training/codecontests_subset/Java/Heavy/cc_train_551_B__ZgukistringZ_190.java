import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main
{
	public int getMaxTimes(int[] a, int[] b, int[] c, int k)
	{
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i < 26;++i)
		{
			if(b[i] != 0)
			{
				ans = Math.min(ans, (a[i] - k * c[i]) / b[i]);
			}
		}
		return ans;
	}
	
	public void repeateAppend(StringBuilder str, Object o, int k)
	{
		for(int i = 0;i < k;++i)
		{
			str.append(o);
		}
	}
	
	public void foo()
	{
		MyScanner scan = new MyScanner();
		String s1 = scan.next();
		String s2 = scan.next();
		String s3 = scan.next();
		int[] a = new int[26];
		int[] b = new int[26];
		int[] c = new int[26];
		for(int i = 0;i < s1.length();++i)
		{
			++a[s1.charAt(i) - 'a'];
		}
		for(int i = 0;i < s2.length();++i)
		{
			++b[s2.charAt(i) - 'a'];
		}
		for(int i = 0;i < s3.length();++i)
		{
			++c[s3.charAt(i) - 'a'];
		}
		int maxTimes = 0;
		int k1 = 0, k2 = 0;
		int t = getMaxTimes(a, b, c, 0);
		for(int i = t;i >= 0;--i)
		{
			int j = getMaxTimes(a, c, b, i);
			if(i + j > maxTimes)
			{
				maxTimes = i + j;
				k1 = i;
				k2 = j;
			}
		}
		StringBuilder str = new StringBuilder();
		repeateAppend(str, s2, k1);
		repeateAppend(str, s3, k2);
		for(int i = 0;i < 26;++i)
		{
			repeateAppend(str, (char)(i + 'a'), a[i] - k1 * b[i] - k2 * c[i]);
		}
		System.out.println(str);
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