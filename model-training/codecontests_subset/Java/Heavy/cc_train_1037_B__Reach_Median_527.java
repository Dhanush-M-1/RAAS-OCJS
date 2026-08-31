import java.util.*;
import java.lang.*;
import java.io.*;

// SHIVAM GUPTA :
//NSIT
//decoder_1671
//BEING PERFECTIONIST IS NOT AN OPTION



// ASCII = 48 + i ;

// SHIVAM GUPTA :


/* Name of the class has to be "Main" only if the class is public. */



public class Main
{
     
     
     
    static PrintWriter out;
    
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
			out=new PrintWriter(System.out);
		}
		String next(){
			while(st==null || !st.hasMoreElements()){
				try{
					st= new StringTokenizer(br.readLine());
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
		String nextLine(){
			String str = "";
			try{
				str=br.readLine();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}
	





/////////////////////////////////////////////////////////////////////////////////////

public static int  min(int a ,int b , int c, int d)
{
       
       
       int[] arr = new int[4] ;
       arr[0] = a;
       arr[1] = b ;
       arr[2] = c;
       arr[3] = d;
       Arrays.sort(arr) ;
       
       return arr[0];
       
}
 
 /////////////////////////////////////////////////////////////////////////////
 
 
public static int  max(int a ,int b , int c, int d)
{
       
       
       int[] arr = new int[4] ;
       arr[0] = a;
       arr[1] = b ;
       arr[2] = c;
       arr[3] = d;
       Arrays.sort(arr) ;
       
       return arr[3];
       
}
 
/////////////////////////////////////////////////////////////////////////////////// 
static int sieve =  1000000 ;

 
static boolean[] prime =  new boolean[sieve + 1] ;

static int[] dp =  new int[10000001] ;

 
public static void sieveOfEratosthenes() 
    { 
        // FALSE == prime
        
        // TRUE ==  COMPOSITE
        
        // FALSE== 1
       
        for(int i=0;i< sieve + 1;i++) 
            prime[i] = false; 
          
        for(int p = 2; p*p <= sieve; p++) 
        { 
           
            if(prime[p] == false) 
            { 
                
                for(int i = p*p; i <= sieve; i += p) 
                    prime[i] = true; 
            } 
        } 
          
       
       
    
    } 
 
///////////////////////////////////////////////////////////////////////////////////


public static String reverse(String input)
{
    String op = "" ;
    
    for(int i = 0; i < input.length() ; i++ )
    {
        op = input.charAt(i)+  op ; 
    }
    
return op ;
}


///////////////////////////////////////////////////////////////////////////////////////


public static void sortD(int[] arr)
{
      sort(arr ,0 , arr.length-1) ;
      
      int i =0 ; int j = arr.length -1  ;
      
      while( i < j)
      {
            int temp = arr[i] ;
            arr[i] =arr[j] ;
            arr[j] = temp ;
            i++ ; j-- ;
      }
      
      
      
      return ;
}

///////////////////////////////////////////////////////////////////////////////////////

public static boolean sameParity(long a  ,long b )
{
      
      if(a%2 == b %2)
      {
            return true  ;
      }
      else{
            return false  ;
      }
}


///////////////////////////////////////////////////////////////////////////////////////

public static boolean sameParity(int a  ,int b )
{
      
      if(a%2 == b %2)
      {
            return true  ;
      }
      else{
            return false  ;
      }
}

////////////////////////////////////////////////////////////////////////////////////

public static boolean isPossibleTriangle(int a  ,int b , int c)
{
      if( a + b > c && c+b > a && a +c > b)
      {
            return true  ;
      }
      
      return false  ;
      
      
}

/////////////////////////////////////////////////////////////////////
    
public static int gcd(int a, int b )
{

if(b==0)return a ;

else return gcd(b,a%b) ; 


}

////////////////////////////////////////////////////////////////////////////////////

public static int lcm(int a, int b ,int c , int d )
{

int temp = lcm(a,b , c) ;


 
 int ans = lcm(temp ,d ) ;

return ans  ;


}

//////////////////////////////////////////////////////////////////////////////////////

public static int lcm(int a, int b ,int c )
{

int temp = lcm(a,b) ;

int ans =  lcm(temp ,c) ;

return ans  ;


}

////////////////////////////////////////////////////////////////////////////////////////
    
public static int lcm(int a , int b )
{

int gc = gcd(a,b);

return (a*b)/gc ;




}

/////////////////////////////////////////////////////////////////////////////////////////////

static boolean isPrime(int n)
{
      if(n==1)
      {
            return false  ;
      }
      
      boolean ans =  true  ;
      
      for(int i = 2; i*i <= n ;i++)
      {
            if(n% i ==0)
            {
                  ans = false  ;break ;
            }
      }
      
      
      return ans  ;
      
      
}
//////////////////////////////////////////////////////////////////////////////////////////
public static long nCr(int n,int k)
{
    long ans=1;
    k=k>n-k?n-k:k;
    int j=1;
    for(;j<=k;j++,n--)
    {
        if(n%j==0)
        {
            ans*=n/j;
        }else
        if(ans%j==0)
        {
            ans=ans/j*n;
        }else
        {
            ans=(ans*n)/j;
        }
    }
    return ans;
}
///////////////////////////////////////////////////////////////////////////////////////////

public static ArrayList<Integer> allFactors(int n)
{   
      ArrayList<Integer> list = new ArrayList<>() ;
      
    for(int i = 1; i*i <= n ;i++)
    {
          if( n % i == 0)
          {
              if(i*i == n)
              {
                    list.add(i) ;
              }
              else{
                    list.add(i) ;
                    list.add(n/i) ;
                    
              }
          }
    }
      
     return list ; 
      
      
}



/////////////////////////////////////////////////////////////////////////////

public static int mod(int x)
{
    if(x < 0)x=-x ;
    
    return x ;
    
}



////////////////////////////////////////////////////////////////////////////////

public static long mod(long x)
{
    if(x < 0)x=-x ;
    
    return x ;
    
}

//////////////////////////////////////////////////////////////////////////////////


public static boolean isPowerOfTwo(int n) 
{ 
    if(n==0) 
    return false; 
  
if(((n ) & (n-1)) == 0 ) return true ;
else return false  ;

} 
   
////////////////////////////////////////////////////////////////////////////////////   
   
    public static int countDigit(long n) 
    { 
        return (int)Math.floor(Math.log10(n) + 1); 
    } 
    
 ///////////////////////////////////////////////////////////////////////////////////////// 
  
   static final int MAXN = 100001; 
       
    
    static int spf[] = new int[MAXN]; 
   
    static void sieve() 
    { 
        spf[1] = 1; 
        for (int i=2; i<MAXN; i++) 
       
           
            spf[i] = i; 
       
       
        for (int i=4; i<MAXN; i+=2) 
            spf[i] = 2; 
       
        for (int i=3; i*i<MAXN; i++) 
        { 
           
            if (spf[i] == i) 
            { 
               
                for (int j=i*i; j<MAXN; j+=i) 
       
                    if (spf[j]==j) 
                        spf[j] = i; 
            } 
        } 
    } 
       
// The above code works well for n upto the order of 10^7.
// Beyond this we will face memory issues.

// Time Complexity: The precomputation for smallest prime factor is done in O(n log log n)
// using sieve.
// Where as in the calculation step we are dividing the number every time by 
// the smallest prime number till it becomes 1.
// So, let’s consider a worst case in which every time the SPF is 2 .
// Therefore will have log n division steps.


// Hence, We can say that our Time Complexity will be O(log n) in worst case.


    static Vector<Integer> getFactorization(int x) 
    { 
        Vector<Integer> ret = new Vector<>(); 
        while (x != 1) 
        { 
            ret.add(spf[x]); 
            x = x / spf[x]; 
        } 
        return ret; 
    } 
       
  //////////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////
   
public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
  public static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

 /////////////////////////////////////////////////////////////////////////////////////////
 
	public static int knapsack(int[] weight,int value[],int maxWeight){

        
        int n=  value.length ;
        
	
	//dp[i] stores the profit with KnapSack capacity "i" 
    int []dp = new int[maxWeight+1]; 
      
    //initially profit with 0 to W KnapSack capacity is 0 
    Arrays.fill(dp, 0); 
  
    // iterate through all items 
    for(int i=0; i < n; i++)  
      
        //traverse dp array from right to left 
        for(int j = maxWeight; j >= weight[i]; j--) 
            dp[j] = Math.max(dp[j] , value[i] + dp[j - weight[i]]); 
              
    /*above line finds out maximum of dp[j](excluding ith element value) 
    and val[i] + dp[j-wt[i]] (including ith element value and the 
    profit with "KnapSack capacity - ith element weight") */
    return dp[maxWeight]; 
	}

///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////


// to return max sum of any subarray in given array
public static long kadanesAlgorithm(long[] arr)
{
      long[] dp = new long[arr.length] ;
      
      dp[0] = arr[0] ;
      long max =  dp[0] ;
      
      
      for(int i = 1; i <  arr.length ; i++)
      {
            if(dp[i-1] > 0)
            {
                  dp[i] = dp[i-1] + arr[i] ;
            }
            else{
                  dp[i] = arr[i] ;
            }
            
            if(dp[i] >  max)max = dp[i] ;
            
      }
      
      return max  ;
      
}
/////////////////////////////////////////////////////////////////////////////////////////////
public static long kadanesAlgorithm(int[] arr)
{
      long[] dp = new long[arr.length] ;
      
      dp[0] = arr[0] ;
      long max =  dp[0] ;
      
      
      for(int i = 1; i <  arr.length ; i++)
      {
            if(dp[i-1] > 0)
            {
                  dp[i] = dp[i-1] + arr[i] ;
            }
            else{
                  dp[i] = arr[i] ;
            }
            
            if(dp[i] >  max)max = dp[i] ;
            
      }
      
      return max  ;
      
}

      
///////////////////////////////////////////////////////////////////////////////////////

// Arrays.sort(arr, new Comparator<Pair>() {
// 			@Override
// 			public int compare(Pair first, Pa second) {
// 				if (first.getAge() != second.getAge()) {
// 					return first.getAge() - second.getAge();
// 				}
// 				return first.getName().compareTo(second.getName());
// 			}
// 		});

/////////////////////////////////////////////////////////////////////////////////////////

public static long binarySerachGreater(int[] arr , int start , int end , int val)
{
      
      // fing total no of elements strictly grater than val in sorted array arr 
      
      
      if(start >  end)return  0 ; //Base case
      
      
      int mid = (start + end)/2  ;
      
      if(arr[mid] <=val)
      {
           return binarySerachGreater(arr,mid+1, end ,val) ; 
            
      }
      else{
            
         return binarySerachGreater(arr,start , mid -1,val) + end-mid+1 ;    
            
      }
      
      
}



//////////////////////////////////////////////////////////////////////////////////

public static long arraySum(int[] arr , int start , int end)
{
    long ans = 0 ;
    
    for(int i = start ; i <= end  ; i++)ans += arr[i] ;
    
    return ans  ;
}

/////////////////////////////////////////////////////////////////////////////////

public static void swapArray(int[] arr , int start , int end)
{
    while(start < end)
    {
        int temp = arr[start] ;
        arr[start] = arr[end];
        arr[end] = temp;
        start++ ;end-- ;
    }
}


//////////////////////////////////////////////////////////////////////////////////

public static int count(String s ,int n , char c1 ,char c2 )
{
    boolean b= false ;
    
    int ans = 0 ;
    
    for(int i = 0 ;  i  < n ; i++)
    {
        if(b== false && s.charAt(i) == c1)
        {
            b=true ;
        }
        else if(b== true  && s.charAt(i) == c2 )
        {
            ans += 2 ;
            b= false ;
        }
    }
    
    
   return n-ans  ; 
    
    
}






/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

public static void solve()
{
FastReader scn = new FastReader() ;
ArrayList<Integer> list = new ArrayList<>() ;
//ArrayList<Integer> listb = new ArrayList<>() ;

HashMap<Character,Integer> map = new HashMap<>() ;
HashMap<Character,Integer> map1 = new HashMap<>() ;
HashMap<Character,Integer> map2 = new HashMap<>() ;
//HashMap<Integer,Integer> mapy = new HashMap<>() ;

//if(map.containsKey(arr[i]))map.put(arr[i] , map.get(arr[i]) +1 ) ;
//else map.put(arr[i],1) ;

Set<Integer> set = new HashSet<>() ;

// int t = scn.nextInt() ;
// while(t-- > 0)
// {
    
// }

  int n = scn.nextInt() ;
  int m = scn.nextInt() ;
  //int d = scn.nextInt() ;
  //int k = scn.nextInt() ;
  //int a = scn.nextInt() ;
 // int b = scn.nextInt() ;
  
int[] arr = new int[n] ;

for(int i = 0; i < n ; i++)arr[i] = scn.nextInt() ;


sort(arr, 0 , n-1) ;

long sum = (long)0 ;


   sum += mod(m- arr[n/2]);
   
   
   
   for(int i = 0 ; i < n/2 ; i++)
   {
       if(arr[i] > m)sum += ( arr[i] - m);
       
   }


for(int i = n/2+1  ; i< n ;i++)
{
    if(arr[i] < m)sum += (m-arr[i]) ;
    
}


out.println(sum) ;


  
  
  map.clear() ;
  
   

out.flush() ;  
out.close() ;
}


public static void main (String[] args) throws java.lang.Exception
{
  

solve() ;
      
}


}
  
 class Pair 
{
  int first ;
  
  int second  ;
      
@Override
	public String toString() {
	
	String ans = "" ;
	ans  += this.first ;
	ans += " ";
	ans += this.second ;
	
	return ans  ;
	}



}

 