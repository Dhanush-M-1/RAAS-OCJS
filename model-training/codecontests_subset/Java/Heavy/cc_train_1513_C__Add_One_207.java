import java.io.*; 
import java.util.*; 
//import javafx.util.*; 
import java.math.*;
//import java.lang.*;
public class Main 
{ 
     static long mod=1000000007;
     static HashSet<Integer> adj[];
   //  static boolean vis[];
  //   static int n[];
  //   static ArrayList<Integer> arr[];
  // //  static long ans=0;
  //   static boolean vis[][];
  //   static final long oo=(long)1e18;
    // static int par[];
    // static long child[];
    // static HashMap<String,Long> hm=new HashMap<>();
    static Long dp[]=new Long[200020];
    public static void main(String[] args) throws IOException {  
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        br = new BufferedReader(new InputStreamReader(System.in));

        int test=nextInt();
        //int test=1;
        for(int step=0;step<=9;step++){
            dp[step]=1l;
        }
        //long a=func(200000);
        for(int step=10;step<=200019;step++){
            dp[step]=(dp[step-10]+dp[step-9])%mod;
        }
        // for(int i=0;i<40;i++){
        //     System.out.println(i+" "+dp[i]);
        // }
        outer: while(test--!=0){
            int n=nextInt();
            int k=nextInt();

            long ans=0;
            while(n!=0){
                int d=n%10;
                if(k<(9-d)){
                    ans=(ans+1)%mod;
                    
                }
                else{
                    ans=(ans+dp[k-(9-d)+9])%mod;
                }
                n=n/10;

            }
            pw.println(ans);
        

         }

        pw.close();
        
                
    }
    // static Long func(int steps){
    //     System.out.println(steps);
    //     if(steps<=0)
    //         return 1l;
    //     if(dp[steps]!=null){
    //         return dp[steps];
    //     }
    //     dp[steps]=(func(steps-10)+func(steps-9))%mod;
    //     return dp[steps];
    // }
    static int test(int idx,int arr[],int n){
        if(idx<=0||idx>=n-1)
            return 0;
        if(arr[idx]>arr[idx-1]&&arr[idx]>arr[idx+1]){
            return 1;
        }
        if(arr[idx]<arr[idx-1]&&arr[idx]<arr[idx+1]){
            return 1;
        }
        return 0;
    }
    
    static class Pair{
        int a;int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        } 

    }
   static void update(long tree[],int idx,long val){
        //println(idx);
        while(idx<1000006){
            
            tree[idx]+=val;
            idx+=(idx)&(-idx);
        }
    }   

    static long sum(long tree[],int idx){
        long sum=0;
        while(idx>0){
           
            sum+=tree[idx];
            idx-=(idx)&(-idx);
        }
        return sum;
    }
    public static BufferedReader br;
    public static StringTokenizer st;
    public static String next() {
        while (st == null || !st.hasMoreTokens()) {
       try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
 
    public static Integer nextInt() {
        return Integer.parseInt(next());
    }
    public static Long nextLong() {
        return Long.parseLong(next());
    }
 
    public static Double nextDouble() {
        return Double.parseDouble(next());
    }
    // static class Pair{
    //     int x;int y;
    //     Pair(int x,int y,int z){
    //         this.x=x;
    //         this.y=y;
    //        // this.z=z;
    //      //   this.z=z;
    //       //  this.i=i;
    //     }
    // }
    // static class sorting implements Comparator<Pair>{
    //     public int compare(Pair a,Pair b){
    //         //return (a.y)-(b.y);
    //         if(a.y==b.y){
    //             return -1*(a.z-b.z);
    //         }
    //         return (a.y-b.y);
    //     }
   // }

    static long ncr(long n,long r){
        
        if(r==0)
            return 1l;
        long val=ncr(n-1,r-1);
        val=(n*val);
        val=(val/r);
        return val;
    }

    public static int[] na(int n)throws IOException{
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
    }
    static class query implements Comparable<query>{
        int l,r,idx,block;
        static int len;
        query(int l,int r,int i){
            this.l=l;
            this.r=r;
            this.idx=i;
            this.block=l/len;
        }   
        public int compareTo(query a){
            return block==a.block?r-a.r:block-a.block;
        }
    }
    
    // static class sorting implements Comparator<Pair>{  
    //     public int compare(Pair a1,Pair a2){  
    //         if(o1.a==o2.a)
    //             return (o1.b>o2.b)?1:-1;  
    //         else if(o1.a>o2.a)  
    //             return 1;  
    //         else  
    //             return -1;  
    //     }
    // }  
    static boolean isPrime(int n) { 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
        if (n % 2 == 0 ||  
            n % 3 == 0) 
            return false; 
      
        for (int i = 5; 
                 i * i <= n; i = i + 6) 
            if (n % i == 0 || 
                n % (i + 2) == 0) 
                return false; 
      
        return true; 
    } 
    static long gcd(long a, long b) { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    }  
    // To compute x^y under modulo m 
    static long power(long x, long y, long m){ 
        if (y == 0) 
            return 1;      
        long p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    }
    static long fast_pow(long base,long n,long M){
        if(n==0)
           return 1;
        if(n==1)
        return base;
        long halfn=fast_pow(base,n/2,M);
        if(n%2==0)
            return ( halfn * halfn ) % M;
        else
            return ( ( ( halfn * halfn ) % M ) * base ) % M;
    }
       static long modInverse(long n,long M){
        return fast_pow(n,M-2,M);
    }
    // (1,1)   

    //     (3,2)   (3,5)

} 