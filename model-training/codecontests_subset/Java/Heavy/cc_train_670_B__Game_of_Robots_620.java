import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class RUNNING {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
			
		InputStream inputStream = System.in;
       
        InputReader in = new InputReader(inputStream);
  Scanner sc= new Scanner(System.in);
        
       int n=sc.nextInt();
       
       long k=sc.nextLong();
      
       long []a= new long[n];
       
       
       for(int i=0;i<n;i++){
    	   a[i]=sc.nextLong();
       }
       
       long l=0;
       long r=1000000000;
     long mid=0;
       while(r-l>1){
    	    mid=(l+r)/2;	
    	   if(mid*(mid+1)/2<k){
    		 l=mid;  
    	   }
    	   else 
    		   r=mid;

          
         
       }
       mid=(l+r)/2;
       
     k-=(mid*(mid+1))/2;
       
     
       System.out.println(a[(int) (k-1)]);
       
       
       
       
       
       
       
       
       
       
       
       
        
        
        
     
       
	}

	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
	


}