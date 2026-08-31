/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */
 
import java.io.*;
import java.math.*;
import java.util.*;
 
 
public class Codeforces429D
{
	
	InputStream in;
	PrintWriter out;
	
	int MAXBIT=32;
	void solve() 
	{
		int n=ni();
		int a[]=na(n);
		
		int num[][]=new int[n+1][MAXBIT];
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<MAXBIT;j++)
				num[i+1][j]=((a[i]>>j)&1);
		}
		
		for (int i=1;i<=n;i++)
			for (int j=0;j<MAXBIT;j++)
				num[i][j]+=num[i-1][j];
		
		int left[],right[];
		left=new int[n];
		right=new int[n];
		
		Stack<Integer> st=new Stack<>();
		st.push(-1);
		for (int i=0;i<n;i++)
		{
			while (st.peek()!=-1&&a[st.peek()]<a[i])
			{
				int idx=st.pop();
				left[idx]=st.peek();
			}
			st.push(i);
		}
		while (st.peek()!=-1)
		{
			int idx=st.pop();
			left[idx]=st.peek();
		}
		
		st.clear();
		st.push(n);
		for (int i=n-1;i>=0;i--)
		{
			while (st.peek()<n&&a[st.peek()]<=a[i])
			{
				int idx=st.pop();
				right[idx]=st.peek();
			}
			st.push(i);
		}
		while (st.peek()<n)
		{
			int idx=st.pop();
			right[idx]=st.peek();
		}
		
		long ans=0;
		int l,r,result;
		int or1,or2;
		for (int i=0;i<n;i++)
		{	
			l=left[i]+1;r=i;result=-1;
			while (l<=r)
			{
				int mid=((l+r)>>1);
				int or=0;
				for (int j=0;j<MAXBIT;j++)
					or|=(((num[i+1][j]-num[mid][j])>0?1:0)<<j);
				
				if (a[i]<or)
				{
					result=mid;
					l=mid+1;
				}
				else
				{
					r=mid-1;
				}
			}
			or1=result;
			
			r=right[i]-1;l=i;result=-1;
			while (l<=r)
			{
				int mid=((l+r)>>1);
				int or=0;
				for (int j=0;j<MAXBIT;j++)
					or|=(((-num[i][j]+num[mid+1][j])>0?1:0)<<j);
				
				if (a[i]<or)
				{
					result=mid;
					r=mid-1;
				}
				else
				{
					l=mid+1;
				}
			}
			or2=result;
			
			if (or1!=-1&&or2!=-1)
			{
				ans+=l(or1-left[i])*l(right[i]-i);
				ans+=l(right[i]-or2)*l(i-left[i]);
				ans-=l(or1-left[i])*l(right[i]-or2);
			}
			else if (or1!=-1)
			{
				ans+=l(or1-left[i])*l(right[i]-i);
			}
			else if (or2!=-1)
			{
				ans+=l(right[i]-or2)*l(i-left[i]);
			}
		}
		
		out.println(ans);
	}
	
	long l(int i){return i;}
		
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
		new Codeforces429D().run();
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