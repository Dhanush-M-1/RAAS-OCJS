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
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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
        
        public BigInteger big() throws IOException{
            if(st.hasMoreTokens())
                return new BigInteger(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return big();
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
            @SuppressWarnings("unused")
            int pos = array.length - 1;
            int bitmask = i;
            while(bitmask > 0){     
                if((bitmask & 1) == 1)
//                    ww.print(array[pos]+" ");
                bitmask >>= 1;
                pos--;
            }
//            ww.println();
        }
    }
    
    
    public static long gcd(long a, long b){
        return b == 0 ? a : gcd(b,a%b);
    }
    
  
    public static long lcm(int a,int b, int c){
        return lcm(lcm(a,b),c);
    }
    
    public static long lcm(long a, long b){
        return (a*b/gcd(a,b));
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
    
    
//     FastScanner s = new FastScanner(new File("a.pdf"));
//   PrintWriter ww = new PrintWriter(new FileWriter("output.txt")); 
    static InputStream inputStream = System.in;
    static FastScanner s = new FastScanner(inputStream); 
    static OutputStream outputStream = System.out;
    static PrintWriter ww = new PrintWriter(new OutputStreamWriter(outputStream));
//      private static Scanner s = new Scanner(System.in);
    @SuppressWarnings("unused")
    private static int[][] states = { {-1,0} , {1,0} , {0,-1} , {0,1} };
    
      
    //////////////////////////////////////////////////////////////////// 
     
    
     
    public static void main(String[] args) throws Exception{
        new Solution().solve();
        s.close();
        ww.close();
    }
    

    ////////////////////////////////////////////////////////////////////
    
   
    
    void solve() throws IOException  {
        
        char[] a = s.nextString().toCharArray();
        char[] b = s.nextString().toCharArray();
        char[] c = s.nextString().toCharArray();
        
        Map<Character,Integer> mm = new HashMap<Character,Integer>();
        Map<Character,Integer> one = new HashMap<Character,Integer>();
        Map<Character,Integer> tw = new HashMap<Character,Integer>();
        Set<Character> st1 = new HashSet<Character>();
        Set<Character> st2 = new HashSet<Character>();
        
        for(int i=0;i<a.length;i++){
            if(mm.containsKey(a[i])) mm.put(a[i], mm.get(a[i])+1);
            else mm.put(a[i], 1);
        }
        
        for(int i=0;i<b.length;i++){
            if(one.containsKey(b[i])) one.put(b[i], one.get(b[i])+1);
            else{
                one.put(b[i], 1);
                st1.add(b[i]);
            }
        }
        
        for(int i=0;i<c.length;i++){
            if(tw.containsKey(c[i])) tw.put(c[i], tw.get(c[i])+1);
            else{
                tw.put(c[i], 1);
                st2.add(c[i]);
            }
        }
        
        
        while(true){
            
            Iterator<Character> it = st1.iterator();
            Iterator<Character> ti = st2.iterator();
            int cnt1 = Integer.MAX_VALUE; int cnt2 = Integer.MAX_VALUE;
            
            while(it.hasNext()){
                char xx = it.next();
                if(mm.get(xx) == null) cnt1 = 0;
                else cnt1 = Math.min(cnt1, mm.get(xx)/one.get(xx));
            }
            
            while(ti.hasNext()){
                 char xx = ti.next();
                 if(mm.get(xx) == null) cnt2 = 0;
                 else cnt2 = Math.min(cnt2, mm.get(xx)/tw.get(xx));
            }
            
            if(cnt1+cnt2 == 0) break;
            
            if(cnt1 > cnt2){
                for(int i=0;i<b.length;i++) ww.print(b[i]);
                for(Character xx : st1) mm.put(xx, mm.get(xx)-one.get(xx));
            }else{
                for(int i=0;i<c.length;i++) ww.print(c[i]);
                for(Character xx : st2) mm.put(xx, mm.get(xx)-tw.get(xx));
            }
            
        }
        
        for(int i=0;i<26;i++){
            char xx = (char) ('a'+i);
            if(mm.get(xx) != null){
                for(int j=0;j<mm.get(xx);j++) ww.print(xx);
            }
        }
        
        ww.println();
            
    }
   
}   
    


