



/* JAI HIND */

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Random;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main 
{ 

	 static FastReader sc=new FastReader(); 
	  public static void main(String[] args) 
    {
		 
		  
    	int t = sc.nextInt(); 
        while (t-- > 0) 
		{ 
        	int n = sc.nextInt();
			int m=sc.nextInt();
			int A[]=new int[n];
			int B[]=new int[m];
			input(A);
			input(B);
			HashMap<Integer,Boolean> map=new HashMap<>();
			for(int i=0;i<n;i++) {
	    		if(map.containsKey(A[i])) {
	    			continue;
	    		}
	    		else
	    			map.put(A[i],true);
	    	}
			int res=0,f=0;
			
			for(int i=0;i<m;i++) {
				if(map.containsKey(B[i])) {
	    			res=B[i];
	    			f=1;
	    			break;
	    		}
			}
			if(f==0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			System.out.print("1"+" "+res);
			System.out.println();
			}
		}    	
		}
    	
    	
    	
   		
        		
    
        		
        	
   static void input(int A[]) {
	   for(int i=0;i<A.length;i++) {
		   A[i]=sc.nextInt();
	   }
   }
    static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                    .filter(n -> n % 2 != 0)
                    .noneMatch(n -> (number % n == 0));
    }
    
        static void shuffleArray(int[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
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

