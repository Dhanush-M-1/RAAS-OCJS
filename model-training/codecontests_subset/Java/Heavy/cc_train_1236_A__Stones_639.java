import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;
 
public class Cf182 implements Runnable 
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
		new Thread(null, new Cf182(),"Main",1<<27).start();
	}	
	
	public static long gcd(long a, long b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b % a, a); 
	} 
	//  array sorting by colm
public static void sortbyColumn(int arr[][], int col) 
    { 
        
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
           
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
	
	// gcd
  
	public static long findGCD(long arr[], int n) 
	{ 
		long result = arr[0]; 
		for (int i = 1; i < n; i++) 
			result = gcd(arr[i], result); 
		return result; 
	}
	// fibonaci
	static int fib(int n) 
    { 
        int a = 0, b = 1, c; 
        if (n == 0) 
            return a; 
        for (int i = 2; i <= n; i++) 
        { 
            c = a + b; 
            a = b; 
            b = c; 
        } 
        return b; 
    } 
    
// sort a string
    public static String sortString(String inputString) 
    { 
        
        char tempArray[] = inputString.toCharArray(); 
          
         
        Arrays.sort(tempArray); 
          
         
        return new String(tempArray); 
    } 
    // pair function
    
    // list.add(new Pair<>(sc.nextInt(), i + 1));
    //     Collections.sort(list, (a, b) -> Integer.compare(b.first, a.first));
    private static class Pair<F, S> {
 
        private F first;
 
        private S second;
 
        public Pair() {}
 
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
   static long binaryToDecimal(String n) 
    { 
        String num = n; 
        long dec_value = 0; 
  
        // Initializing base value to 1, 
        // i.e 2^0 
        int base = 1; 
  
        int len = num.length(); 
        for (int i = len - 1; i >= 0; i--) { 
            if (num.charAt(i) == '1') 
                dec_value += base; 
            base = base * 2; 
        } 
  
        return dec_value; 
    } 
  
  static int isPowerOfFour(long n) 
    { 
        if(n == 0) 
        return 0; 
        while(n != 1) 
        {  
            if(n % 4 != 0) 
            return 0; 
            n = n / 4;      
        } 
        return 1; 
    }  
    
	public void run()
	{
		InputReader sc = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
	    int t = sc.nextInt();
	    while(t--!=0)
	    {
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        int c = sc.nextInt();
	        
	        int f = a;
	        int g = b;
	        int h = c;
	        
	        int x1 = Math.min(b/2,a);
	        int ans1 = x1*2 + x1;
	        b -= x1*2;
	        
	        int xx1 = Math.min(c/2,b);
	        ans1 += xx1*2 + xx1;
	        
	        
	        
	        a = f;
	        b = g;
	        c = h;
	        
	        x1 = Math.min(c/2,b);
	        int ans2 = x1*2 + x1;
	        b -= x1;
	        
	        xx1 = Math.min(b/2,a);
	        ans2 += xx1*2 + xx1;
	        
	        
	        w.println(Math.max(ans1,ans2));
	    }
        w.flush();
	    w.close();
	}
}