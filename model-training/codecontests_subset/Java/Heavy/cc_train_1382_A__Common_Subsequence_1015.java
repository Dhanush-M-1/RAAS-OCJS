


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

	  public static void main(String[] args) 
    {
		  FastReader sc=new FastReader(); 
		  
    	int t = sc.nextInt(); 
        while (t-- > 0) 
		{ 
			int n = sc.nextInt();
			int m=sc.nextInt();
			int A[]=new int[n];
			int B[]=new int[m];
			HashMap<Integer,Boolean> map=new HashMap<>();
			for(int i=0;i<n;i++) {
	    		A[i]=sc.nextInt();
	    		if(map.containsKey(A[i])) {
	    			continue;
	    		}
	    		else
	    			map.put(A[i],true);
	    	}
			int res=0,f=0;
			for(int i=0;i<m;i++) {
	    		B[i]=sc.nextInt();
	    		
	    	}
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
    static boolean isPalindrome(String str) 
    { 
  
        // Pointers pointing to the beginning 
        // and the end of the string 
        int i = 0, j = str.length() - 1; 
  
        // While there are characters toc compare 
        while (i < j) { 
  
            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) 
                return false; 
  
            // Increment first pointer and 
            // decrement the other 
            i++; 
            j--; 
        } 
  
        // Given string is a palindrome 
        return true; 
    } 
    static int binarySearch(int arr[], int l, 
            int r, int x) 
{ 
if (r < l) 
return -1; 

int mid = l + (r - l) / 2; 

if (arr[mid] == x) 
return mid; 

if (arr[mid] > x) 
return binarySearch(arr, l,  
                mid - 1, x); 

return binarySearch(arr, mid + 1, r, x); 
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







