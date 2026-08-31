import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class cfvc15
{
	static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) 
    {
        reader = new BufferedReader( new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException
    {
        while ( ! tokenizer.hasMoreTokens() )
        {
            tokenizer = new StringTokenizer(reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static long nextInt() throws IOException 
    {
        return Long.parseLong( next() );
    }
	static PrintWriter writer;
	static void outit(OutputStream outputStream)
	{
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
	static void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) 
		{
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}
 
	static void println(Object...objects) 
	{
		print(objects);
		writer.println();
	}
 
	static void close()
	{
		writer.close();
	}
 
	static void flush() {
		writer.flush();
	}
	public static void print_a(long [] a)
    {
    	for(long i : a)
    	{
    		print(i+" ") ;
    	}
    	println() ;
    }
	static boolean [] prime ;
	static int [] fac ;
    public static void main(String [] args) throws IOException
    {
    	init(System.in) ;
    	outit(System.out) ;
//    	int t = (int) nextInt() ;
//    	for(int i =0 ; i<t ; i++)
    	output() ;
        flush();
        close();
    }
    static ArrayList<HashSet<Integer>> ar ;
    public static void output() throws IOException
    {
    	int n = (int)nextInt() ;
    	int [] a = new int[n] ;
    	int [] b = new int[n-1] ;
    	int [] c = new int[n-2] ;
    	for(int i = 0 ; i<n ; i++)
    	{
    		a[i] = (int)nextInt() ;
    	}
    	for(int i = 0 ; i<(n-1) ; i++)
    	{
    		b[i] = (int)nextInt() ;
    	}
    	for(int i = 0 ;i<(n-2) ; i++)
    	{
    		c[i] = (int)nextInt() ;
    	}
    	Arrays.sort(a);
    	Arrays.sort(b);
    	Arrays.sort(c);
    	boolean c1 = true  ;
    	for(int i = 0 ; i<(n-1); i++)
    	{
    		if(a[i]!=b[i])
    		{
    			println(a[i]) ;
    			c1 = false ;
    			break ;
    		}
    	}
    	if(c1)
    	{
    		println(a[n-1]) ;
    	}
    	boolean c2 = true ;
    	for(int i = 0 ; i<(n-2); i++)
    	{
    		if(b[i]!=c[i])
    		{
    			println(b[i]) ;
    			c2 = false ;
    			break ;
    		}
    	}
    	if(c2)
    	{
    		println(b[n-2]) ;
    	}
    }
} 