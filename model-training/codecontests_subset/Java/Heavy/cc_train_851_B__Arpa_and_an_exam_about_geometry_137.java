/**
 * DA-IICT
 * Author : Savaliya Sagar
 */
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;

public class B851
{
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		long ax = nl();
		long ay = nl();
		long bx = nl();
		long by = nl();
		long cx = nl();
		long cy = nl();
		long d1 = (cx-bx)*(cx-bx)+(cy-by)*(cy-by);
		long d2 = (ax-bx)*(ax-bx)+(ay-by)*(ay-by);
		long d3 = (ax-cx)*(ax-cx)+(ay-cy)*(ay-cy);
		long bax = bx-ax;
		long bay = by-ay;
		long cbx = cx-bx;
		long cby = cy-by;
//		long dot = (bax*cbx)+(bay*cby);
//		long m1 = (bax*bax)+(bay*bay);
//		long m2 = (cbx*cbx)+(cby*cby);
		if(d1!=d2)
			out.println("No");
		else if(bay*cbx==bax*cby)
			out.println("No");
		else
			out.println("Yes");
		
	}
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}
	
	public static void main(String[] args) throws Exception
	{
		new Thread(null, new Runnable()
		{
			public void run()
			{
				try
				{
					new B851().run();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();
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
				lenbuf = is.read(inbuf);
			} catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c)
	{
		return !(c >= 33 && c <= 126);
	}
	
	private int skip()
	{
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
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
		while (!(isSpaceChar(b)))
		{ // when nextLine, (isSpaceChar(b) && b !=
				// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b)))
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
			} else
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
			} else
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private void tr(Object... o)
	{
		System.out.println(Arrays.deepToString(o));
	}
}
