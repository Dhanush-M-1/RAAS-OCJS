import java.io.*; 
import java.util.*; 
//import javafx.util.*; 
import java.math.*;
//import java.lang.*;
public class Main 
{ 
    
   // static int n;
//  static HashSet<Integer> adj[];

   // static int dist[];
   // static int remove[];
//    static boolean isLeaf[];
  //   static Long dp[][];
   // static int arr[];
  //  static boolean ok;
    // static long arr[];
    // static long sum[];
  //  static boolean ok;
    static long mod=1000000007;
 //   static HashSet<Integer> adjacency[];
    static final long oo=(long)1e18;
    public static void main(String[] args) throws IOException { 
    //    Scanner sc=new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        br = new BufferedReader(new InputStreamReader(System.in));
     //   int test=nextInt();
     int test=1;
        
        outer: while(test--!=0){
            
           // String s=next();
            int n=nextInt();
            int val=nextInt();
            int a1[]=new int[n];
            int a2[]=new int[n];
            int a3[]=new int[n];
            int n1=0;int n2=0;int n3=0;
            for(int i=0;i<n;i++){
                int a=nextInt();
                int t1=nextInt();
                int t2=nextInt();
                if(t1==1&&t2==1){
                    a1[n1++]=a;
                }
                else if(t1==1){
                    a2[n2++]=a;
                }
                else if(t2==1){
                    a3[n3++]=a;
                }
            }
            Arrays.sort(a1,0,n1);
            Arrays.sort(a2,0,n2);
            Arrays.sort(a3,0,n3);
            boolean ok=false;int i=0;int j=0;int k=0;long ans=0;
            while(val--!=0){
                int a=i<n1?a1[i]:100000;
                int b=j<n2?a2[j]:100000;
                int c=k<n3?a3[k]:100000;
                c=c+b;

                if(a>=100000&&c>=100000){
                    ok=true;
                    break;
                }
                else if(a<=c){
                    ans+=a;
                    i++;
                    
                }
                else{
                    ans+=c;
                    j++;k++;
                }
            }
            if(ok)
                pw.println("-1");
            else    
                pw.println(ans);

        }
           
        pw.close();
    }

    static class Pair implements Comparable<Pair>{
        double g,ai,bi,sa,sb;
        Pair(double g,double ai,double bi){
          //  this.index=index;
            this.g=g;
            this.ai=ai;
            this.bi=bi;
            sa=g/ai;
            sb=g/bi;
            //this.z=z;
        }   
        public int compareTo(Pair p){
            double a=Math.abs(sa-sb);
            double b=Math.abs(p.sa-p.sb);
            if(a>b){
                return 1;
            }
            else if(a==b){
                return 0;

            }
            else{
                return -1;
            }
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
    static int gcd(int a, int b) { 
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