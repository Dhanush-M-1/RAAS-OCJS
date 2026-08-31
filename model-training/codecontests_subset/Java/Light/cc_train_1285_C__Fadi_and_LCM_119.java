import java.util.*;
import java.io.*;
public class Test{

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out);
	    Scanner sc=new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long x=sc.nextLong();
	    long min=Long.MAX_VALUE; long max=0;
	    int end=(int)Math.sqrt(x)+1;
	    for(long i=1; i<=end; i++) {
	    	if(x%i==0 && lcm(i, x/i)==x) {
	    		max=Math.max(i, x/i);
	    		min=Math.min(min,max );
	    	}
	    }
	    out.println(x/min+" "+min);
	    out.flush();
	}
	static long gcd(long a, long b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    // method to return LCM of two numbers 
    static long lcm(long a, long b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
    
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
 
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}
 
		public String nextLine() throws IOException {return br.readLine();}
 
		public boolean ready() throws IOException {return br.ready();}
 
 
	}
}