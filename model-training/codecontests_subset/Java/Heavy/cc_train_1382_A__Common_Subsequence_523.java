import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

  


public class Pro8 {
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
	public static void main (String[] args) 
	{
		 FastReader sc=new FastReader(); 
	    int t = sc.nextInt(); 
	     for(int l =0;l<t;l++)
	       {
	    	   int n=sc.nextInt();
	    	   int m =sc.nextInt();
	    	   int [] a = new int [n];
	    	   int [] b  = new int [m];
	    	   for(int i =0;i<n;i++)
	    		   a[i]=sc.nextInt();
	    	   for(int i=0;i<m;i++)
	    		   b[i]=sc.nextInt();
	    	    int flag =0;
	    	    int res= 0;
	    	     for(int i =0;i<n;i++)
	    	     {
	    	    	 for(int j =0;j<m;j++)
	    	    	 {
	    	    		 
	    	    		 if(a[i]==b[j])
	    	    		 {
	    	    			flag =1;
	    	    			res =a[i];
	    	    			break;
	    	    		 }
	    	    	 }
	    	     }
	    		   if(flag==1){
	    			   System.out.println("YES");
	    			   System.out.println("1 "+res);
	    	 
	    		   }
	    		   else
	    			   System.out.println("NO");
	    		   
	    	 
	    	  
            }
                
	      
	 }
	
	
	
}

