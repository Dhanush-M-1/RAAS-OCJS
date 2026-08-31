import java.io.*; 
import java.util.*; 
//import javafx.util.*; 
import java.math.*;
//import java.lang.*;
 
public class untitled 
{ 
    public static void main(String[] args) throws IOException { 
        Scanner sc=new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        br = new BufferedReader(new InputStreamReader(System.in));
        int n=nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            char cc[]=next().toCharArray();
            for(int j=0;j<n/4;j++){
                char ch=cc[j];
                int num=ch>='A'?ch-'A'+10:ch-'0';
                for(int k=0;k<4;k++){
                    arr[i][j*4+k]=(num>>(3-k))&1;
                } 
            }    
        }
        int sum[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i-1][j-1];
            }
        }
        //boolean good=true;
        outer: for(int x=n;x>=1;x--){
            if(n%x==0){
                boolean good=true;
                for(int i=1;i<=n;i+=x){
                    for(int j=1;j<=n;j+=x){
                     //   System.out.println(i+" "+j+" "+x);
                        int ans=sum[i+x-1][j+x-1]-sum[i-1][j+x-1]-sum[i+x-1][j-1]+sum[i-1][j-1];
                      //  System.out.println(i+" "+j+" "+x+" "+ans);
                        if(ans!=x*x&&ans!=0){
                            good=false;
                            continue outer;
                        }
                    }
                }
                if(good){
                    pw.println(x);
                    break outer;
                }
            }
        }
        pw.close();
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
    static class Pair{
        int x;int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
          //  this.i=i;
        }
    }
    static class sorting implements Comparator<Pair>{
        public int compare(Pair a,Pair b){
            //return (a.y)-(b.y);
            return (a.x-b.x);
        }
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
    static long modInverse(long a, long m) { 
        long g = gcd(a, m); 
        if (g != 1) 
            return -1; 
        else{ 
            // If a and m are relatively prime, then modulo inverse 
            // is a^(m-2) mode m 
            return (power(a, m - 2, m)); 
        } 
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
       static long modInverse(long n,int M){
        return fast_pow(n,M-2,M);
    }
    
} 