import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main 
{
	private final double EPS = 5e-12;
	private int n;
	private int[] a;
	private double[] b;
	
	public double getMaxPoorness()
	{
		double cur = 0;
		double maxSum = 0;
		for(int i = 0;i < n;++i)
		{
			cur = Math.max(0, cur + b[i]);
			maxSum = Math.max(maxSum, cur);
		}
		
		return maxSum;
	}
	
	public double getWeakness(double x)
	{
		for(int i = 0;i < n;++i)
		{
			b[i] = a[i] - x;
		}
		double maxPoorness1 = getMaxPoorness();
		for(int i = 0;i < n;++i)
		{
			b[i] = -b[i];
		}
		double maxPoorness2 = getMaxPoorness();
		
		return Math.max(maxPoorness1, maxPoorness2);
	}
	
	public void foo()
	{
		MyScanner scan = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		n = scan.nextInt();
		a = new int[n];
		b = new double[n];
		for(int i = 0;i < n;++i)
		{
			a[i] = scan.nextInt();
		}
		double left = -1e4, right = 1e4;
		while(right - left > EPS)
		{
			double p1 = (2 * left + right) / 3;
			double p2 = (left + 2 * right) / 3;
			if(getWeakness(p1) < getWeakness(p2))
			{
				right = p2;
			}
			else
			{
				left = p1;
			}
		}
		out.println(getWeakness(left));
		out.close();	
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

	    private boolean isSpaceChar(int c) 
	    {
	        return ' ' == c || '\n' == c || '\r' == c || '\t' == c || -1 == c;
	    }
	}
}
