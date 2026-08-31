/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class Codeforces429B
{
	
	InputStream in;
	PrintWriter out;
	
	
	void solve() 
	{
		long x1=nl();
		long y1=nl();
		long x2=nl();
		long y2=nl();
		long x3=nl();
		long y3=nl();
		long ab=distance(x1,y1,x2,y2);
		long bc=distance(x3,y3,x2,y2);
		
		if (equal(x1,y1,x2,y2,x3,y3))
		{
			out.println("No");
		}
		else
		{
			//tr(ab+" "+bc);
			if (ab==bc)
				out.println("Yes");
			else
				out.println("No");
		}
	}
	
	
	boolean collinear(double d1,double d2,double d3)
	{
		if ((d1+d2)==d3)
			return true;
		else
			return false;
	}
	
	boolean equal(long x1,long y1,long x2,long y2,long x3,long y3)
	{
		double ab=slope(x1,y1,x2,y2);
		double ac=slope(x1,y1,x3,y3);
		double ba=slope(x2,y2,x1,y1);
		double bc=slope(x2,y2,x3,y3);
		double ca=slope(x3,y3,x1,y1);
		double cb=slope(x3,y3,x2,y2);
		if (ab==bc||ac==cb||ca==ab||cb==ba||ba==ac||bc==ca)
			return true;
		else
			return false;
	}
	
	double slope(double x1,double y1,double x2,double y2)
	{
		return Math.atan((y1-y2)/(x1-x2));
	}
	
	long distance(long x1,long y1,long x2,long y2)
	{
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
	
	void run() throws Exception 
	{
		String INPUT = "C:/Users/ayubs/Desktop/input.txt";
		in = oj ? System.in : new FileInputStream(INPUT);
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
		
	}
	public static void main(String[] args) throws Exception 
	{
		new Codeforces429B().run();
	}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte() 
	{
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) 
		{
			ptrbuf = 0;
			try 
			{
				lenbuf = in.read(inbuf);
			}
			catch (IOException e) 
			{
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean inSpaceChar(int c) 
	{
		return !(c >= 33 && c <= 126);
	}
	
	private int skip() 
	{
		int b;
		while ((b = readByte()) != -1 && inSpaceChar(b))
			;
		return b;
	}
	
	private double nd() 
	{
		return Double.parseDouble(ns());
	}
	
	private char nc() 
	{
		return (char) skip();
	}
	
	private String ns() 
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(inSpaceChar(b))) 
		{ // when nextLine, (inSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n) 
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(inSpaceChar(b))) 
		{
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m) 
	{
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n) 
	{
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private int ni() 
	{
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') 
		{
			minus = true;
			b = readByte();
		}
		
		while (true) 
		{
			if (b >= '0' && b <= '9') 
			{
				num = num * 10 + (b - '0');
			} 
			else 
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl() 
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') 
		{
			minus = true;
			b = readByte();
		}
		
		while (true) 
		{
			if (b >= '0' && b <= '9') 
			{
				num = num * 10 + (b - '0');
			}
			else 
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	private void tr(Object... o) 
	{
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}
	
}