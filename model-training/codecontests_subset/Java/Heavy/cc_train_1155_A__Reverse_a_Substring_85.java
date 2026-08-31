import java.util.*;
import java.lang.Math.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
        FastReader in = new FastReader();
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        
        solve(in, out);
        
        out.close();
	}
	
	static void solve(FastReader in, PrintWriter out) {
	    int l = in.nextInt();
	    String s = in.next();
	    boolean f = false;
	    
	    /*
	    for (int i = 0; i < (s.length() - 1); i++) {
	        for (int j = i + 1; j < s.length(); j++) {
	            if (s.charAt(j) < s.charAt(i)) {
	                f = true;
	                out.println("YES");
	                out.print((i + 1) + " " + (j + 1));
	                break;
	            }
	        }
	        if (f) {
	            break;
	        }
	    }
	    
	    if (!f) {
	        out.print("NO");
	    }
	    */
	    
	    for (int i = 0; i < s.length() - 1; i++) {
	        if (s.charAt(i + 1) < s.charAt(i)) {
	            	f = true;
	                out.println("YES");
	                out.print((i + 1) + " " + (i + 2));
	                break;
	        } 
	    }
	    
	    if (!f) {
	        out.print("NO");
	    }
	    
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
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
    
}