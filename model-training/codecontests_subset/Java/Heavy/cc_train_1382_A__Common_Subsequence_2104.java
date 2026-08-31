import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.lang.*;


public class Contest1 {
	//static ArrayList<Integer> prime=new ArrayList();
	
	   public static TreeMap<Long,Integer> t1=new TreeMap();
	   public static void solve()
	    {
	      long m=1;
	      for(int j=2;j<=1000;j++)
	      {
	         
	          if(isprime(j))
	          {
	              m=m*j;
	              if(m>1000000)
	              {
	                  break;
	              }else{
	                  t1.put(m,1);
	              }
	          }
	      }
	    }
	
    public static int gcd(int n1, int n2)
    {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
	
//////////////////	
	public static class trie {
        int x,y,z;
        trie (int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
	
	} 
        
	public static class pair {
        int x,y;
        pair (int x,int y){
            this.x=x;
            this.y=y;
        }
        public boolean equals(Object o) {
        	if(o instanceof pair) {
        		pair p = (pair)o;
        		return (x == p.x && y == p.y);
        	}
        	return false;
        }
        public int hashCode() {
        	return (Integer.hashCode(x) * 3 + Integer.hashCode(y) );
        }
    }
	
//////////////////	
	
	static class Cmp implements Comparator<pair>
	{
		public int compare(pair a,pair b)
		{
			if(a.x==b.x)
			{
				return(a.y-b.y);
			}
			return(a.x-b.x);
		}
	}
	
	
//////////////////
	
	
	
	
//////////////////
	
	
	
	
	
	   static class FastReader
	   {
		   BufferedReader br;
		   StringTokenizer st;
		   public FastReader()
		   {
			   br = new BufferedReader(new InputStreamReader(System.in));
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
	   
////////////////////// 
	//public static ArrayList<Integer> a=new ArrayList();
	   
	  public static ArrayList<Integer> Divisors(int n) 
	  { 
	       // Note that this loop runs till square root 
		  ArrayList<Integer> a=new ArrayList();
		   long sum=0;
	       for (int i=1; i*i<=(n); i++) 
	       { 
	           if (n%i == 0) 
	           { 
	               // If divisors are equal, print only one 
	               if (n/i == i) 
	               {
	                  // printf("%d ", i); 
	            	   sum=sum+1;
	            	   a.add(i);
	               }
	     
	               else // Otherwise print both 
	               {
	                   //printf("%d %d ", i, n/i); 
	            	   sum=sum+2;
	            	   a.add(i);
	            	   a.add(n/i);
	               }
	           } 
	       } 
	       return(a);
	   } 
	   
/////////////////////	  
	  
	  public static long SmallestPrimeDivisor(long n) 
	  { 
	      // if divisible by 2 
	      if (n % 2 == 0) 
	          return 2; 
	    
	      // iterate from 3 to sqrt(n) 
	      for (long i = 3; i * i <= n; i += 2) { 
	          if (n % i == 0) 
	              return i; 
	      } 
	    
	      return n; 
	  } 
	    
////////////////////	  
	   
	   public static boolean isprime(long n)
	    {
	        int count=0;
	     
	        for(long i=2;i*i<=n;i++)
	        {
	            if(n%i==0)
	            {
	                return(false);
	            }
	        }
	        return(true);
	    }
	
	   
//////////////////////
	   
	     //   (x^n)%1000000007
	   public static long modularExponentiation(long x,long n,long M)
	   {
	       if(n==0)
	           return 1;
	       else if(n%2 == 0)        //n is even
	           return modularExponentiation((x*x)%M,n/2,M);
	       else                             //n is odd
	           return (x*modularExponentiation((x*x)%M,(n-1)/2,M))%M;

	   }
	   
	   public static long nCr(int n,int k)
	   {
		  if(k==0)
			  return 1;
		  return(n*nCr(n-1,k-1)/k);
	   }
	   public static long factorial(int n)
	   {
		   if(n==1)
			   return 1;
		   return((n)*factorial(n-1));
	   }
	   
	   public static void debug(Object...o) {
		    System.out.println( Arrays.deepToString(o) );
	   }
	   
	   public static boolean prime[]=new boolean[100005];
	   //prime[j]==false means it's a prime.
	   public static void seive()
	   {
		   prime[0]=false;
		   prime[1]=false;
		   for(int i=2;i*i<=100005;i++)
		   {
			   if(!prime[i])
			   {
				   for(int j=i*i;i<=100005;j+=i)
				   {
					   prime[j]=true;
				   }
			   }
		   }
	   }
	 
	 
	    public static boolean equals(StringBuilder sb1, StringBuilder sb2){
	    
	        if(sb1 == sb2)
	  
	        if(sb1 == null || sb2 == null)
	            return false;
	        
	        boolean isEqual = true;
	  
	        if(sb1.length() == sb2.length()){
	  
	            for(int i = 0 ; i < sb1.length(); i++){
	                
	                if(sb1.charAt(i) != sb2.charAt(i)){
	                    isEqual = false;
	                    break;
	                }
	            }
	            
	        }else{
	            isEqual = false;
	        }
	        
	        return isEqual;
	    }
	   
	    
	    public static boolean IsPalindrome(String s,int n)
	    {
	    	
	    	for(int i=0;i<n/2;i++)
	    	{
	    		if(s.charAt(i)!=s.charAt(n-i-1))
	    		{
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	   
	   
	    
	    static long findSubarraySum(int arr[], int n, long sum)  
	    { 
	        HashMap <Long, Integer> prevSum = new HashMap<>(); 
	        HashMap <Long ,Integer> index=new HashMap();
	        
	        long res = 0;  
	        
	        // Sum of elements so far.  
	        long currsum = 0;  
	        
	        for (int i = 0; i < n; i++) {  
	        
	            // Add current element to sum so far.  
	            currsum += arr[i];  
	            if (currsum == sum)   
	                res++;          
	        
	           
	            if (prevSum.containsKey(currsum - sum))   
	                res += prevSum.get(currsum - sum);  
	                
	         
	            Integer count = prevSum.get(currsum); 
	            if (count == null) 
	            {
	                prevSum.put(currsum, 1); 
	                index.put(currsum,i);
	            }
	                
	            else
	            {
	                prevSum.put(currsum, count+1); 
	            }
	        }  
	        
	        return res;  
	    }  
	      
	  
	     
	    
	    
	  public static void main(String args[])
	  {
		  //Scanner sc=new Scanner(System.in);
		  FastReader in = new FastReader();
		  PrintWriter pw = new PrintWriter(System.out);
		
		 
		   int t = in.nextInt();
		   while(t-->0)
		   {
			   int n = in.nextInt();
			   int m = in.nextInt();
			   int a[]=new int[n];
			   int b[]=new int[m];
			   HashMap<Integer,Integer> h1 = new HashMap();
			   HashMap<Integer,Integer> h2 = new HashMap();

			   for(int i=0;i<n;i++)
			   {
				   int x = in.nextInt();
				   a[i]=x;
				  // h.add(x);
			   }
			   boolean y = false;
			   for(int i=0;i<m;i++)
			   {
				   int x = in.nextInt();
				   b[i]=x;
				   
			   }
			   for(int i=0;i<n;i++)
			   {
				   h1.put(a[i],1);
			   }
			   for(int i=0;i<m;i++)
			   {
				   h2.put(b[i],1);
			   }
			   for(Integer x : h1.keySet())
			   {
				    if(h2.containsKey(x))
				    {
				    	y=true;
				    	pw.println("YES");
				    	pw.println(1+" "+(int)x);
				    	break;
				    }
			   }
			   if(y==false)
			   {
				   pw.println("NO");
			   }
			  

		   }
		  
		      
		 
		  pw.flush();
		  pw.close();
	  }
	    
	    
	
}
			
