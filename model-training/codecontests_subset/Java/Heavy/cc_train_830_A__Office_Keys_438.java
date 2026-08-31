import java.io.*;
import java.util.*;
public class c{ 
static PrintWriter out = new PrintWriter(System.out);
public static void main(String[] args) 
{ 
        int n = ni();
        int k = ni();
        int p = ni();

            int a[] = new int[n];
            int b[] = new int[k];
            for (int i = 0; i < n; ++i) a[i] = ni();
            for (int j = 0; j < k; ++j) b[j] = ni();
            Arrays.sort(a);
            Arrays.sort(b);
            long res = Long.MAX_VALUE;

            for (int delta = 0; delta <= k - n; ++delta) {
                 long cur = 0;
                  for (int i = 0; i < n; ++i) 
                    cur = Math.max(cur, Math.abs(a[i] - b[i + delta]) + Math.abs(b[i + delta] - p));
                
                res = Math.min(res, cur);
            }
            out.println(res);
         out.flush();

}

static long mod = 1000000007;
static void fact(long a[]){
         a[0]=1;
         for(int i=1;i<a.length;i++)
                a[i] = (i*a[i-1])%mod;
}
static int gcd(int a,int b){

  if(b%a==0) return a;
  return gcd(b%a,a);
}
static long pow(long a,long b,long mod){

long ans=1;
while(b>0){
if(b%2==1)
    ans = (ans*a)%mod;
    b=b/2;
    a=(a*a)%mod;
}
   return ans;
}  
    static FastReader sc=new FastReader(); 
 
      static int ni(){
                 int x = sc.nextInt();
                 return(x);
        }
      static long nl(){
              long x = sc.nextLong();
              return(x);
         }
      static String n(){
                 String str = sc.next();
                     return(str);
       }
     static String ns(){
                 String str = sc.nextLine();
                   return(str);
      }
     static double nd(){
               double d = sc.nextDouble();
                 return(d);
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