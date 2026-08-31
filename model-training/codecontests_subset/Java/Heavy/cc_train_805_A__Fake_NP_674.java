import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;
 
public class Sol
{
    
    static long mod=1000000007;
    
    public static void main(String args[]) throws Exception
    {
        InputReader in;
        PrintWriter w;
        boolean online = false;
        String fileName = "input";

        if (online) 
        {
            in = new InputReader(new FileInputStream(new File(fileName + ".in")));
            w = new PrintWriter(new FileWriter("out.txt"));
        } 
        else 
        {
            in = new InputReader(System.in);
            w = new PrintWriter(System.out);
        }
        
        //nt T = in.nextInt();
        int T=1;
        
        for (int t = 1; t <= T; t++) 
        {
            int l=in.nextInt();
            int r=in.nextInt();
            
            if(l==r)
            {
                if(l%2==0)
                    w.println("2");
                
                else
                {
                    int flag=0;
                    int div=0;
                    
                    for(int i=3;i<sqrt(l);i+=2)
                    {
                        if(l%i==0)
                        {
                            flag=1;
                            div=i;
                            break;
                        }
                    }
                    
                    if(flag==1)
                        w.println(div);
                    
                    else
                        w.println(l);
                }
            }
            
            else
                w.println("2");
        }

        w.close();
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
        Arrays.sort(a, new Comparator<Integer[]>() 
        {
            public int compare(Integer[] int1, Integer[] int2) 
            {
                Integer numOfKeys1 = int1[1];       //about which column u want to sort
                Integer numOfKeys2 = int2[1];
                return numOfKeys1.compareTo(numOfKeys2);
            }
        });
    }
     
    static long powmod(long x,long n,long m)        //(a/b)%mod = (a * (b^(m-2))%mod  here --> x=a, n=mod-2, m=mod  
    {
	if (n == 0)
            return 1;
        else if (n%2==0)
            return powmod(((x%m)*(x%m))%m,n/2,m);
	else if(n%2==1)
            return (((x%m)*powmod(((x%m)*(x%m))%m,(n-1)/2,m))%m);
	else
            return 0;
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