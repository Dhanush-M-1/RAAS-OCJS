/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class A
{
	
	InputStream in;
	PrintWriter out;

	ArrayList<Integer> child[];
	long b[],k[];
	int parent[];
	
	boolean isvalid(double a,double b)
	{
		double max=(double)(1e18);
		if (a*b>=max)
			return false;
		else
			return true;
	}
	
	boolean isvalid2(double a,double b)
	{
		double max=-(double)(1e18);
		if ((a-b)<=max)
			return false;
		else
			return true;
	}
	
	void get(int s)
	{	
		
	}
	
	void solve() 
	{
		int n=ni();
		b=new long[n+1];
		long k[]=new long[n+1];
		parent=new int[n+1];
		
		child=new ArrayList[n+1];
		for (int i=0;i<=n;i++)
			child[i]=new ArrayList<>();
		
		for (int i=1;i<=n;i++)
			b[i]=nl();
		
		for (int i=1;i<=n;i++)
			b[i]-=nl();
		
		parent[1]=0;
		k[1]=Long.MAX_VALUE;
		for (int i=2;i<=n;i++)
		{
			parent[i]=ni();
			k[i]=nl();
			child[parent[i]].add(i);
		}
		
		tr(b);
		for (int i=n;i>=2;i--)
		{
			if (b[i]<0)
			{
				if (!isvalid(-b[i], k[i])||!isvalid2(b[parent[i]], b[i]*k[i]))
				{
					out.println("NO");
					return ;
				}
				b[parent[i]]+=b[i]*k[i];
				b[i]=0;
			}
			else
			{
				b[parent[i]]+=b[i];
				b[i]=0;
			}
		}
		
		if (b[1]<0)
			out.println("NO");
		else
			out.println("YES");
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
		new A().run();
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