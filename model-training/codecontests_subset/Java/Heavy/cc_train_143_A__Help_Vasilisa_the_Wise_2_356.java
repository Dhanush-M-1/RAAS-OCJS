import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
        	boolean env=System.getProperty("ONLINE_JUDGE") != null;
        	if(!env) {
        		try {
					br=new BufferedReader(new FileReader("src\\input.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        	}
        	else {
        		br = new BufferedReader(new
                        InputStreamReader(System.in)); 
        	}
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
    static int MOD=1000000000+7;
    
    //Radix Sort
    public static int[] radixSort(int[] f){ return radixSort(f, f.length); }
    public static int[] radixSort(int[] f, int n)
    {
        int[] to = new int[n];
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
    }
    //Brian Kernighan’s Algorithm
    static long countSetBits(long n){
        if(n==0) return 0;
        return 1+countSetBits(n&(n-1));
    }
    //Euclidean Algorithm
    static long gcd(long A,long B){
        if(B==0) return A;
        return gcd(B,A%B);
    }
    //Modular Exponentiation
    static long fastExpo(long x,long n){
        if(n==0) return 1;
        if((n&1)==0) return fastExpo((x*x)%MOD,n/2)%MOD;
        return ((x%MOD)*fastExpo((x*x)%MOD,(n-1)/2))%MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6)
            if(n%i==0 || n%(i+2)==0) return false;
        return true;
    }
    //Sieve of eratosthenes
    static int[] findPrimes(int n){
        boolean isPrime[]=new boolean[n+1];
        ArrayList<Integer> a=new ArrayList<>();
        int result[];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;++i){
            if(isPrime[i]==true){
                for(int j=i*i;j<=n;j+=i) isPrime[j]=false;
            }
        }
        for(int i=0;i<=n;i++) if(isPrime[i]==true) a.add(i);
        result=new int[a.size()];
        for(int i=0;i<a.size();i++) result[i]=a.get(i);
        return result;
        
    }
    //Lower Bound
    static int lowerBound(ArrayList<Long> a, int low, int high, long element){
        while(low < high){
            int middle = low + (high - low)/2;
            if(element > a.get(middle))
                low = middle + 1;
            else 
                high = middle;
        }
        return low;
    }
    //Upper Bound
    static int upperBound(ArrayList<Long> a, int low, int high, long element){
        while(low < high){
            int middle = low + (high - low)/2;
            if(a.get(middle) > element)
                high = middle;
            else 
                low = middle + 1;
        }
        return low;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader sc=new FastReader();
        int test=1;
        while(test-->0) {
        	int r1=sc.nextInt(),r2=sc.nextInt(),c1=sc.nextInt(),c2=sc.nextInt(),d1=sc.nextInt(),d2=sc.nextInt();
        	for(int i=1;i<=9;i++) {
        		for(int j=1;j<=9;j++) {
        			for(int k=1;k<=9;k++) {
        				for(int l=1;l<=9;l++) {
        					if(i+j==r1 && k+l==r2 && i+k==c1 && j+l==c2 && i+l==d1 && j+k==d2 && i!=j && j!=k && k!=l && i!=k && j!=l && i!=l) {
        						System.out.println(i+" "+j);
        						System.out.println(k+" "+l);
        						return;
        					}
        				}
        			}
        		}
        	}
        	System.out.println(-1);
        }	
    }
}
    