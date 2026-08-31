import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;
 
public class Main implements Runnable 
{
	static class InputReader 
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
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
	public static void main(String args[]) throws Exception 
	{
		new Thread(null, new Main(),"Main",1<<27).start();
	}	
	
 
	public void run(){
        InputReader sc=new InputReader(System.in);
        PrintWriter out=new PrintWriter(System.out);
          int n=sc.nextInt();
          int k=sc.nextInt();
          int t[]=new int[n];
          int a[]=new int[n];
          int b[]=new int[n];
          int cnt=0;
          ArrayList<Integer>arr=new ArrayList<Integer>();
          ArrayList<Integer>a1=new ArrayList<Integer>();
          ArrayList<Integer>b1=new ArrayList<Integer>();
          for(int i=0;i<n;i++){
          t[i]=sc.nextInt();
          a[i]=sc.nextInt();
          b[i]=sc.nextInt();
          if(a[i]==1 && b[i]==1)
          {
              //cnt++;
              arr.add(t[i]);
          }
          if(a[i]==0 && b[i]==1)
          {
              //cnt++;
              b1.add(t[i]);
          }
          if(a[i]==1 && b[i]==0)
          {
              //cnt++;
              a1.add(t[i]);
          }
          }
          ArrayList<Integer>arr1=new ArrayList<Integer>();
          Collections.sort(arr); Collections.sort(a1); Collections.sort(b1);
          for(int i=0;i<Math.min(a1.size(),b1.size());i++)
          {
              arr1.add(a1.get(i)+b1.get(i));
          }
          for(int i=0;i<arr.size();i++)
          {
              arr1.add(arr.get(i));
          }
          Collections.sort(arr1);
          if(arr1.size()<k)
          out.println("-1");
          else
          {
              int sum=0;
              for(int i=0;i<k;i++)
              sum=sum+arr1.get(i);
              out.println(sum);
          }
          
        out.flush();
		out.close();
	}
}