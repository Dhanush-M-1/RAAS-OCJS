import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;

public class TestClass {
	
    public static void main(String args[] ) throws Exception {
		//Scanner hb=new Scanner(System.in);
		InputReader hb=new InputReader(System.in);
		PrintWriter w=new PrintWriter(System.out);
		
		boolean visited[]=new boolean[1000001];
		visited[0]=true;
		visited[1]=true;
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=2;i<=1000;i++)
		{
			if(!visited[i])
			{
				list.add(i);
				for(int j=i*i;j<=1000000;j+=i)
				{
					visited[j]=true;
				}
			}
		}
		
		int l=hb.nextInt();
		int r=hb.nextInt();
		int count=0;
		int ans=l;
		int max=1;
		
		/*
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		*/
		
		for(int i=0;i<list.size() && list.get(i)<=r;i++)
		{
			count= r/list.get(i) - (l-1)/list.get(i);
			if(count>max)
			{
				max=count;
				ans=list.get(i);
			}
		}
		System.out.println(ans);
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
}