import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;
 
public class Solution
{
	
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
    
    public static int[] SOE()
        {
        int n=(int)(1e5);         //till which digit
		
		int ip[]=new int[n];
		
		for(int i=2;i<(int)Math.sqrt(n);i++)
		{
			if(ip[i]==0)
			{
				for(int j=i*i;j<n;j=j+i)
				{
					ip[j]++;
				}
			}
		}
		
		ip[1]++;      //counts 1 and 0 as primes
		ip[0]++;
        
        return ip;
    }
    
    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
    return a;
}

    private static long gcd(long[] input)
    {
        long result = input[0];
        
        for(int i = 1; i < input.length; i++) 
            result = gcd(result, input[i]);
        
        return result;
    }
    
    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input)
    {
        long result = input[0];
        
        for(int i = 1; i < input.length; i++) 
            result = lcm(result, input[i]);
        
        return result;
    }
    
    public static void Array_2dsort(Integer[][] a)
        {
        
        Arrays.sort(a, new Comparator<Integer[]>() {
        public int compare(Integer[] int1, Integer[] int2) {
        Integer numOfKeys1 = int1[1];       //about which column u want to sort
        Integer numOfKeys2 = int2[1];
        return numOfKeys1.compareTo(numOfKeys2);
    }
    });
    
    }
    
    
	public static void main(String args[]) throws Exception
	{
		InputReader in=new InputReader(System.in);		
		PrintWriter w=new PrintWriter(System.out);
        
        ArrayList<String> al=new ArrayList<String>();
        al.add(in.next());
        al.add(in.next());
        
        System.out.println(al.get(0)+" "+al.get(1));
            
        int n=in.nextInt();
        
        while(n-->0)
            {
            String s1=in.next();
            String s2=in.next();
            
            if(al.get(0).equals(s1))
                {
                al.remove(0);
                al.add(s2);
            }
            
            else
                {
                al.remove(1);
                al.add(s2);
            }
            
            System.out.println(al.get(0)+" "+al.get(1));
        }
        
		w.close();	
	}
}
//Language: Java 8