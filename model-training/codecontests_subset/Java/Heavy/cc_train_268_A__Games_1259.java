import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
 
public class M
{	
	public static int prime[] = new int[5000007];
 
	public static void main(String args[])
	{	
		InputReader In = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		
		int n = In.nextInt();
				
		int home[] = new int[n];
		int guest[] = new int[101];
				
		for(int i = 0 ; i < n ; i++)
		{
			home[i] = In.nextInt();
			guest[In.nextInt()]++;
		}
		
		int ans = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			ans += guest[home[i]];
		}
				
		w.println(ans);
			
		w.close();
	}
	
	public static void sieve()
	{
		Arrays.fill(prime , 1);
		
		prime[0] = 0;
		prime[1] = 1;
		
		for(int i = 2 ; i*i < 5000007 ; i++)
		{
			if(prime[i] == 1)
			{
				for(int j = i+i ; j < 5000007 ; j+=i)
				{
					if(prime[j] == 1)
						prime[j] = i;
				}
			}
		}
	}
	
	public static long pow(int a , int b)
	{
		long ans = 1;
		
		while(b > 0)
		{
			if(b%2 == 1)
			{
				ans = (ans*a)%1000000007;
			}
			
			a = (a*a)%1000000007;
			
			b = b/2;
		}
		
		return ans;
	}
	
	static class Trip
	{
		int l;
		int r;
		int c;
		
		public Trip(int l , int r , int c)
		{
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}
	
	public static int GCD(int a , int b)
	{
		if(b == 0)
			return a;
		else
			return GCD(b , a%b);
	}
 
	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
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
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
	
	static class Node implements Comparable<Node>
	{
		int value;
		int id;
		
		public Node(int value,int id)
		{
			this.value=value;
			this.id=id;
		}
		
		public int compareTo(Node node)
		{
			if(value<node.value)
				return 1;
			
			if(value>node.value)
				return -1;
			
			if(id<node.id)
				return 1;
			
			return -1;
		}
	}
}