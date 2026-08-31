import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
 
public class Solution{
    
    ///////////////////////////////////////////////////////////////////////////
    static class FastScanner{
        BufferedReader s;
        StringTokenizer st;
        
        public FastScanner(InputStream InputStream){
            st = new StringTokenizer("");
            s = new BufferedReader(new InputStreamReader(InputStream));
        }
        
        public FastScanner(File f) throws FileNotFoundException{
            st = new StringTokenizer("");
            s = new BufferedReader (new FileReader(f));
        }
        
        public int nextInt() throws IOException{
            if(st.hasMoreTokens())
                return Integer.parseInt(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextInt();
            }
        }
        
        public double nextDouble() throws IOException{
            if(st.hasMoreTokens())
                return Double.parseDouble(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextDouble();
            }
        }
      
        public long nextLong() throws IOException{
            if(st.hasMoreTokens())
                return Long.parseLong(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextLong();
            }
        }
        
        public String nextString() throws IOException{
            if(st.hasMoreTokens())
                return st.nextToken();
            else{
                st = new StringTokenizer(s.readLine());
                return nextString();
            }
            
        }
        public String readLine() throws IOException{
            return s.readLine();
        }
        
        public void close() throws IOException{
            s.close();
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////
    //      Number Theory
    
    long pow(long a,long b,long mod){
        long x = 1; long y = a;
        while(b > 0){
            if(b % 2 == 1){
                x = (x*y);
                x %= mod;
            }
            y = (y*y);
            y %= mod;
            b /= 2;         
        }
        return x;
    }
    
    int divisor(long x,long[] a){
        long limit = x;
        int numberOfDivisors = 0;
 
        for (int i=1; i < limit; ++i) {
            if (x % i == 0) {
                limit = x / i;
                if (limit != i) {
                    numberOfDivisors++;
                }
                numberOfDivisors++;
            }
        }
        return numberOfDivisors;
    }
    
    void findSubsets(int array[]){
        long numOfSubsets = 1 << array.length; 
        for(int i = 0; i < numOfSubsets; i++){    
            int pos = array.length - 1;
            int bitmask = i;
            while(bitmask > 0){     
                if((bitmask & 1) == 1)
                    ww.print(array[pos]+" ");
                bitmask >>= 1;
                pos--;
            }
            ww.println();
        }
    }
    
    
    public static long gcd(long a, long b){
        return b == 0 ? a : gcd(b,a%b);
    }
    
  
    public static int lcm(int a,int b, int c){
        return lcm(lcm(a,b),c);
    }
    
    public static int lcm(int a, int b){
        return (int) (a*b/gcd(a,b));
    }
    
    public static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }
    
    ////////////////////////////////////////////////////////////////////
    
    
//    private static    FastScanner s = new FastScanner(new File("input.txt"));
//    private static PrintWriter ww = new PrintWriter(new FileWriter("output.txt"));
    static InputStream inputStream = System.in;
    static FastScanner s = new FastScanner(inputStream); 
    static OutputStream outputStream = System.out;
    static PrintWriter ww = new PrintWriter(new OutputStreamWriter(outputStream));
//      private static Scanner s = new Scanner(System.in);
    @SuppressWarnings("unused")
    private static int[][] states = { {-1,0} , {1,0} , {0,-1} , {0,1} };
    
      
    //////////////////////////////////////////////////////////////////// 
      
     
    public static void main(String[] args) throws IOException{
        new Solution().solve();
        s.close();
        ww.close();
    }
    
    
    ////////////////////////////////////////////////////////////////////
    
    
    void solve() throws IOException{
        
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[1010];
        int cn = 0;
        
        Set<Integer> st = new HashSet<Integer>();
        for(int i=0;i<n;i++)
            a[i] = s.nextInt();
        
        for(int i=0;i<m;i++){
            int xx = s.nextInt()-1;
            b[i] = xx;
            if(!st.contains(xx)){
                c[cn++] = xx;
                st.add(xx);
            }
        }
        
        Set<Integer> mk = new HashSet<Integer>();
        int cnt = st.size();
        
        int[] index = new int[10000];
        int[] dp = new int[cnt];
        
        for(int i=0;i<cnt;i++){
            if(i == 0) dp[i] = a[c[i]];
            else dp[i] = a[c[i]]+dp[i-1];
            index[c[i]] = i;
        }
        
        int get = 0;
        mk = new HashSet<Integer>();
        
        for(int i=0;i<m;i++){
            Set<Integer> mm = new HashSet<Integer>();
            int gum = 0;
            int xx = b[i];
            if(mk.contains(xx)) continue;
            mk.add(xx);
            get += dp[index[xx]]-a[xx];
            for(int j=i+1;j<m;j++){
                if(b[j] == xx){
                    mm = new HashSet<Integer>();
                    get += gum;
                    gum = 0;
                }
                else if(!mm.contains(b[j])){
                    gum += a[b[j]];
                    mm.add(b[j]);
                }
            }
        }
        
        ww.println(get);
        
    }
}


