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

		public Character charAt(int i) {
			// TODO Auto-generated method stub
			return null;
		} 
    } 

  

	  // Complete the hurdleRace function below.
//    public static void solve(String[] ar,String n1,String n2,int n) {
//    	
//    	for(int i=0;i<n*2+1;i+=2) {
//    		if(ar[i]==ar[i+2] || ar[i+3]==ar[i]) {
//    			System.out.println(ar[i+3]+" "+ar[i+1]);
//    		}
//    		else if(ar[i+1]==ar[i+2] || ar[i+3]==ar[i+1]) {
//    			System.out.println(ar[i+3]+" "+ar[i]);
//    		}
//    		
//    	}
//    	
//    	
//    }
    public static void main(String[] args) throws IOException {
    	FastReader s=new FastReader(); 
    	String n1=  s.next();
    	
    	String n2=  s.next();
    	int n = s.nextInt();
//    	
//    	String[] ar= new String[n*2+2];
//    	
    	System.out.println(n1+" "+n2);
    	for(int j=0;j<n;j++) {
    		
    		String c=s.next();
        	String d=s.next();
//        	System.out.println("d="+d);
        	if(n1.contentEquals(c)) n1=d;
        	else n2=d;
        	System.out.println(n1+" "+n2);
        				
        }
    	
    	
        	
    	
    	
    	
   	
}
}
