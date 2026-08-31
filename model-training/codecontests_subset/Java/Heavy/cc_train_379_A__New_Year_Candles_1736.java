/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import javafx.util.Pair;
/**
 *
 * @author MR
 */
public class Code {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        LetsDoIt in = new LetsDoIt();
//        Scanner in = new Scanner(System.in) ;
//        FastReaderFile in = new FastReaderFile(new FileInputStream("good.in")) ;
//        out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")), true) ;
        out = new PrintWriter(new BufferedOutputStream(System.out), true) ;
//        StringBuilder r = new StringBuilder();
//        for (Map.Entry<Long,Integer> get : map.entrySet())
        long n = in.nextInt() , m = in.nextLong() , x = n ,y = 1;
        while ( y > 0 )
        {
            y = n / m ;
            x += y ;
            n = y + n % m ;
        }
        out.println(x);
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
}