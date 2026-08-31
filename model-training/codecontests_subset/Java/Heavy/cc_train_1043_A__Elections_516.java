
import java.util.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.awt.*;
import java.awt.geom.*;


public class Mai {

//            for (Map.Entry<Integer, Integer> e : x.entrySet()) 
//                        {
//                            e.getValue() , e.getKey

    public static void main(String[] args) throws FileNotFoundException 
    {
//        TODO code application logic here
    	LetsDoIt in = new LetsDoIt();
//        Scanner in = new Scanner(System.in) ;
//        FastReaderFile in = new FastReaderFile(new FileInputStream("fun.in")) ;
//        out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")), true) ;
    	out = new PrintWriter(new BufferedOutputStream(System.out), true) ;
//    	StringBuilder s = new StringBuilder() ;
    	int n = in.nextInt() ;
    	int x[] = new int[n] ;
    	int sum = 0 ;
    	for (  int i = 0 ; i < n ; ++i)
    	{
    		x[i] = in.nextInt(); 
    		sum += x[i] ;
    	}
    	Arrays.sort(x);
    	int k = x[n-1];
    	for ( int i = 0 ; i < 10000 ; ++i )
    	{
    		int sum1 = 0 ;
    		for ( int j = 0 ; j < n ; ++j )
    		{
    			sum1 += k - x[j] ;
    		}
//    		out.println(sum + " " + sum1);
    		if ( sum < sum1 )
    		{
    			out.println(k);
    			return ;
    		}
    		++k ;
    	}
    	out.println();
    }
    static long nCk( long n, long k )
    {
	    if (k > n) return 0;
	    if (k * 2 > n) k = n-k;
	    if (k == 0) return 1;
	
	    long result = n;
	    for( long i = 2; i <= k; ++i ) {
	        result *= (n-i+1);
	        result /= i;
	    }
	    return result;
}
    static  boolean isPrime( long n)
    {
        if (n < 2)  return false;
        if (n < 4)  return true;
        
        if (n%2 == 0 || n%3 == 0) return false;

        for (long i = 5 ; i * i <= n ; i = i + 6 )
            if ( n % i == 0 || n % ( i + 2 ) == 0)
                return false ;

        return true;
    }
    static long gcd(long a, long b) 
    {
        return b == 0 ? (a < 0 ? -a : a) : gcd(b, a % b);
    }
    static long lcm(long a, long b)
    {
        long lcm = (a / gcd(a, b)) * b;
        return lcm > 0 ? lcm : -lcm ;
    }
	public static class FastReaderFile
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReaderFile(InputStream in)
        {
            br = new BufferedReader(new
            InputStreamReader(in));
            
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
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
    }
    public static class LetsDoIt
    {
        BufferedReader br;
        StringTokenizer st;

        public LetsDoIt()
        {
            br = new BufferedReader(new
                                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
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
    }
    public static PrintWriter out;
    static void full( long[] x , LetsDoIt in )
    {
    	for ( int i = 0 ; i < x.length ; ++i )
    		x[i] = in.nextLong();
    }
    static void fullint( int n , int[] x , LetsDoIt in )
    {
    	for ( int i = 0 ; i < n ; ++i )
    		x[i] = in.nextInt();
    }
}