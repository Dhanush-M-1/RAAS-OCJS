import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Prac {
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
        { return Integer.parseInt(next()); 
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
	
    public static void main(String args[] ) throws Exception {
    	FastReader ip=new FastReader();
  	    int n=ip.nextInt();
  	    String s=ip.nextLine();
  	    int l=-1;
  	    int r=-1;
  	    int v=0;
  	    for(int i=0;i<n-1;i++) {
  	    	if(s.charAt(i+1)<s.charAt(i)) {
  	    		v=1;
  	    		l=i+1;
  	    		r=i+2;
  	    		break;
  	    	}
  	    }
  	    if(v==1) {
  	    System.out.println("YES");
  	    System.out.println(l+" "+r);
  	    }else {
  	    	System.out.println("NO");
  	    }
    }
}

