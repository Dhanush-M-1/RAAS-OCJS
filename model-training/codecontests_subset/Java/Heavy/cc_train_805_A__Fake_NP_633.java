import java.util.*;
import java.lang.*;
import java.io.*;



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
	

// SHIVAM GUPTA :



// ASCII = 48 + i ;

// SHIVAM GUPTA :





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
 
 
static int sieve =  1000000 ;

 
static boolean[] prime =  new boolean[sieve + 1] ;

 
public static void sieveOfEratosthenes() 
    { 
        // TRUE == prime
        
        // FALSE ==  COMPOSITE
        
        // FALSE== 1
       
        for(int i=0;i< sieve + 1;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <= sieve; p++) 
        { 
           
            if(prime[p] == true) 
            { 
                
                for(int i = p*p; i <= sieve; i += p) 
                    prime[i] = false; 
            } 
        } 
          
       
       
    
    } 
 
 
public static String reverse(String input)
{
    String op = "" ;
    
    for(int i = 0; i < input.length() ; i++ )
    {
        op = input.charAt(i)+  op ; 
    }
    
return op ;
}




public static int[] sortI(int[] arr)
{
      Arrays.sort(arr) ;
      return arr ;
}

public static int[] sortD(int[] arr)
{
      Arrays.sort(arr) ;
      
      int i =0 ; int j = arr.length -1  ;
      
      while( i < j)
      {
            int temp = arr[i] ;
            arr[i] =arr[j] ;
            arr[j] = temp ;
            i++ ; j-- ;
      }
      
      
      
      return arr ;
}



public static boolean isPossibleTriangle(int a  ,int b , int c)
{
      if( a + b > c && c+b > a && a +c > b)
      {
            return true  ;
      }
      
      return false  ;
      
      
}
    
public static int gcd(int a, int b )
{

if(b==0)return a ;

else return gcd(b,a%b) ; 


}


public static int lcm(int a, int b ,int c , int d )
{

int temp = lcm(a,b , c) ;


 
 int ans = lcm(temp ,d ) ;

return ans  ;


}



public static int lcm(int a, int b ,int c )
{

int temp = lcm(a,b) ;

int ans =  lcm(temp ,c) ;

return ans  ;


}


    
public static int lcm(int a , int b )
{

int gc = gcd(a,b);

return (a*b)/gc ;




}

   
    public static int countDigit(long n) 
    { 
        return (int)Math.floor(Math.log10(n) + 1); 
    } 
    
  
  
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
       
   
    
public static void main (String[] args) throws java.lang.Exception
{
  FastReader scn = new FastReader() ;

//  int t = scn.nextInt() ;
//  for(int i1 = 1; i1<= t ; i1++)
// {



// }
 
 
 int l = scn.nextInt() ; int r = scn.nextInt() ;

 
 if(l==r)out.println(l) ;
 
 else out.println(2) ;
 
 
 
 

 // out.println(ans) ;

out.flush() ;  
  
}


}
  
 