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


public class Mai {

//            for (Map.Entry<Integer, Integer> e : x.entrySet()) 
//                        {
//                            e.getValue() , e.getKey
	
    public static void main(String[] args) throws FileNotFoundException {
//        TODO code application logic here
    	LetsDoIt in = new LetsDoIt();
//        Scanner in = new Scanner(System.in) ;
//        FastReaderFile in = new FastReaderFile(new FileInputStream("shortage.in")) ;
//        out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")), true) ;
        out = new PrintWriter(new BufferedOutputStream(System.out), true) ;
        int n = in.nextInt() ;
        String s = in.next() ;
        int e = 0 ;
        for ( int i = 0 ; i < n ; ++i )
        	if ( s.charAt(i) == '8' )
        		++e ;
        out.println(Math.min(e, n/11));
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

}