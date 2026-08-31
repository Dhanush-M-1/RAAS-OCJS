import java.io.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;


public  class FibinacciSeries {

	   
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

  

	  // Complete the hurdleRace function below.
    


    public static void main(String[] args) throws IOException {
    	FastReader s=new FastReader(); 
    	int n = s.nextInt();
    	int k = s.nextInt();
    	int v=0;
    	int[] ar = new int[n];
    	for(int i=0;i<n;i++) {
    		ar[i] = s.nextInt();
    		
    		
    	}
    	Arrays.sort(ar);
    	int flag=0;
    	for(int i=n-1;i>=0;i--) {
    		
    		if(k%ar[i]==0 && flag==0) {
    			flag=1;
    			v=k/ar[i];
    		}
    		
    	}
    	System.out.println(v);

}
}