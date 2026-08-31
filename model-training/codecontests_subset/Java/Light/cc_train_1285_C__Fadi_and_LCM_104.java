    import java.util.*;
    import java.io.*;
     
    public class albaaaai{
    	
    	 public static long gcd(long a, long b) 
    	    { 
    	      if (b == 0) 
    	        return a; 
    	      return gcd(b, a % b);  
    	    } 
     
    
    	public static void main(String[]args)throws IOException{
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		PrintWriter out = new PrintWriter(System.out);
    		
    		long x = Long.parseLong(br.readLine());
    		
    		long a = 0;
    		long b = 0;
    		long max = Long.MAX_VALUE;
    		for(long i = 1 ; i*i <= x ; i++)
    		{
    			if(x%i == 0)
    			{
    				long aa = i;
    				long bb = x/i;
    				if(gcd(aa,bb) == 1)
    				{
    					if(Math.max(aa, bb) < max)
    					{
    						max = Math.max(aa, bb);
    						a = aa;
    						b = bb;
    					}
    				}
    			}
    		}
    		out.print(a + " " + b);
    		
    		out.flush();
    		out.close();
    	}
    	
    }