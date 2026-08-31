	import java.util.*;


import java.io.*;
	import java.math.*;
	import java.awt.geom.*;
	 
	import static java.lang.Math.*;
	 
	public class Solution implements Runnable {
		
		
	    public void solve() throws Exception {
	    	
//	    	int t=sc.nextInt();
//	    	long mod=(long)1e9+7;
//	    	
//	    	while(t-->0)
//	    	{
	    		int a=sc.nextInt();
	    		int b=sc.nextInt();
	    		int c=sc.nextInt();
	    		int totaldata=a*c;
	    		if((a*c)%b==0)
	    		{
	    			out.println(Math.max(0, a*c/b-c));
	    		}
	    		else out.println( Math.max(0, a*c/b-c)+1);
	    }
	    
	    
	    static long power(long x, long y, long p) 
	    { 
	       
	        long res = 1;      
	       
	        x = x % p;  
	  
	       if (x == 0) return 0;    
	  
	        while (y > 0) 
	        { 
	            if((y & 1)==1) 
	                res = (res * x) % p; 
	            y = y >> 1;  
	            x = (x * x) % p;  
	        } 
	        return res; 
	    } 
	    
	    		
	    
	    
	    
	    
	    
	    static Throwable uncaught;
	 
	    BufferedReader in;
	    FastScanner sc;
	    PrintWriter out;
	 
	    @Override
	    public void run() {
	        try {
	            in = new BufferedReader(new InputStreamReader(System.in));
	            out = new PrintWriter(System.out);
	            sc = new FastScanner(in);
	            solve();
	        } catch (Throwable uncaught) {
	            Solution.uncaught = uncaught;
	        } finally {
	            out.close();
	        }
	    }
	 
	    public static void main(String[] args) throws Throwable {
	        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
	        thread.start();
	        thread.join();
	        if (Solution.uncaught != null) {
	            throw Solution.uncaught;
	        }
	    }
	 
	}
	 
	class FastScanner {
	 
	    BufferedReader in;
	    StringTokenizer st;
	 
	    public FastScanner(BufferedReader in) {
	        this.in = in;
	    }
	 
	    public String nextToken() throws Exception {
	        while (st == null || !st.hasMoreTokens()) {
	            st = new StringTokenizer(in.readLine());
	        }
	        return st.nextToken();
	    }
	 
	    public int nextInt() throws Exception {
	        return Integer.parseInt(nextToken());
	    }
	    
	    public int[] readArray(int n) throws Exception {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
	 
	    public long nextLong() throws Exception {
	        return Long.parseLong(nextToken());
	    }
	 
	    public double nextDouble() throws Exception {
	        return Double.parseDouble(nextToken());
	    }
	 
	}