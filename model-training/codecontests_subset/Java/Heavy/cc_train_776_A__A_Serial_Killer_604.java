import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main
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
    public static int ri() throws IOException
    {
    	return (int)nextInt() ;
    }
    public static long rl() throws IOException
    {
    	return nextInt() ;
    }
    public static double rd() throws NumberFormatException, IOException
    {
    	return Double.parseDouble(next()) ;
    }
    static void print_a(int [] arr)
    {
    	for(int i = 0 ;i<arr.length ; i++)
    	{
    		print(arr[i]+" ") ;
    	}
    	println() ;
    }
    public static int [] ria() throws IOException
    {
    	int n = ri() ;
    	int [] a = new int[n] ;
    	for(int i = 0 ; i<n ; i++)
    	{
    		a[i] = ri() ;
    	}
    	return a ;
    }
    public static long [] rla() throws IOException
    {
    	int n = ri() ;
    	long [] a = new long[n] ;
    	for(int i =0 ; i<n ; i++)
    	{
    		a[i] = rl() ;
    	}
    	return a ;
    }
    public static int p(int i)
    {
    	return (int)Math.pow(2,i) ;
    }
    static PrintWriter writer;
    static void outit(OutputStream outputStream)
    {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
    static void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }
 
    static void println(Object...objects) {
        print(objects);
        writer.println();
    }
 
    static void close() {
        writer.close();
    }
 
    static void flush() {
        writer.flush();
    }
    static ArrayList<ArrayList<Integer>> sieve ;
    static long [] mob ;
    static int len;
    static int[][] up;
    static int[] tin;
    static int[] tout;
    static int time;
    static int n ;
    static int [] a ;
    static int []flat ;
    static int k ;
    static int [] bl_id ;
    static int [] ctr_ver ;
    static int [] ctr_val ;
    static int curr_l ;
    static int curr_r ;
    public static void main(String [] args) throws IOException
    {
        init(System.in) ;
        outit(System.out) ;
//    	int t = (int)nextInt() ;
//    	for(int i =0 ; i<t ; i++)
        output() ;
        flush() ;
        close() ;
    }
    public static void output() throws IOException
    {
    	String a = next() ;
    	String b = next() ;
    	HashSet<String> hs = new HashSet<String>() ;
    	hs.add(a) ;
    	hs.add(b) ;
    	int n = ri() ;
    	for(String s : hs)
		{
			print(s+" ") ;
		}
		println();
    	for(int i = 0 ;i<n ; i++)
    	{
    		String a1 = next() ;
    		String a2 = next() ;
    		hs.remove(a1) ;
    		hs.add(a2) ;
    		for(String s : hs)
    		{
    			print(s+" ") ;
    		}
    		println();
    	}
    }
}