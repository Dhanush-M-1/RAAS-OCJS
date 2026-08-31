	import java.math.BigInteger;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
	import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

	public class Main {
	
		static FastReader sc= new FastReader();
		static List<Integer> C;
		static List<Integer> B;
		
		
		public static void main(String[] args) {
			
				int t=sc.nextInt();					StringBuilder s=new StringBuilder();

				int c=0;
			outer:	while(t-->0) {
					
					int n=sc.nextInt();
					int m=sc.nextInt();
					C=new ArrayList<>();
					for(int i=0;i<n;i++) {
						C.add(sc.nextInt());
					}
					B=new ArrayList<>();
					for(int i=0;i<m;i++) {
						B.add(sc.nextInt());
					}	
					for(int i=0;i<n;i++) {
						if(B.contains(C.get(i))) {
							System.out.println("YES");
							System.out.println("1 "+C.get(i));
					continue outer;}}
					System.out.println("NO");
					
		}
		}
		
		static boolean comp(String a1,String a2,String b1,String b2,int n) {
					
					
					if((a1.equals(b1)&&a2.equals(b2))||(a1.equals(b2)&&a2.equals(b1)))return true;
					if(n==1)return false;
					
					else {
					//	if(a1.length()==1)return false;
						
						return (comp(a1.substring(0,n/2),a1.substring(n/2,n),b1.substring(0,n/2),b1.substring(n/2,n),n/2)&&comp(a2.substring(0,n/2),a2.substring(n/2,n),b2.substring(0,n/2),b2.substring(n/2,n),n/2))
							||
(comp(a1.substring(0,n/2),a1.substring(n/2,n),b2.substring(0,n/2),b2.substring(n/2,n),n/2)&&comp(a2.substring(0,n/2),a2.substring(n/2,n),b1.substring(0,n/2),b1.substring(n/2,n),n/2));

						
					}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		static boolean search(ArrayList<Integer> a,int m,int h) {
			PriorityQueue<Integer> p=new PriorityQueue<Integer>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2-o1;
					}
			});
			
			
			
			for(int i=0;i<m;i++) {
				p.add(a.get(i));
			}
			int c=0;
			//System.out.println(p);
			while(!p.isEmpty()) {
				//System.out.println(p);

				h-=p.poll();
				if(h<0)break;
				
				c++;
				
			//	System.out.println(h+" "+p+" "+c+" "+m);

				if(!p.isEmpty()) {
				p.poll();
				c++;}
				
				
			}
		//	System.out.println(c!=m);
			if(c!=m)return false;
			
			return true;
		}
	//	static int  key=-1;
		
		
		
		
		
		
		static boolean isPowerOfTwo(long n) 
	    { 
	        if (n == 0) 
	            return false; 
	          
	        while (n != 1) 
	        { 
	            if (n % 2 != 0) 
	                return false; 
	            n = n / 2; 
	        } 
	        return true; 
	    } 
		
		 static boolean isPerfectSquare(double x)  
		    { 
		          
		        // Find floating point value of 
		        // square root of x. 
		        double sr = Math.sqrt(x); 
		      
		        // If square root is an integer 
		        return ((sr - Math.floor(sr)) == 0); 
		    } 
		
		
		
		
		
		
	static	int binarySearch(ArrayList<Long> arr, int l, int r, long x,int key) 
	    { 
	        if (r >= l) { 
	            int mid =  (r + l) / 2; 
	//  if(mid>=arr.size())return -1;
	            // If the element is present at the 
	            // middle itself 
	  			
	            if (arr.get(mid) == x) 
	                return mid+1; 
	  
	            // If element is smaller than mid, then 
	            // it can only be present in left subarray 
	            if (arr.get(mid) > x) {
	                return binarySearch(arr, l, mid - 1, x,key); 
	            }
	            // Else the element can only be present 
	            // in right subarray
	            key=mid+1;
	            return binarySearch(arr, mid + 1, r, x,key); 
	        } 
	  
	        // We reach here when element is not present 
	        // in array 
	        return key; 
	    } 
		
		
		
		
		
		
		
		
	    static boolean isPrime(long n) 
	    { 
	        // Corner cases 
	        if (n <= 1) 
	            return false; 
	        if (n <= 3) 
	            return true; 
	  
	        // This is checked so that we can skip 
	        // middle five numbers in below loop 
	        if (n % 2 == 0 || n % 3 == 0) 
	            return false; 
	  
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	                return false; 
	  
	        return true; 
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
