import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    //input
    static out op = new out();
    static inp ip = new inp();
    static FastReader sc = new FastReader();
    static BufferedWriter output = new BufferedWriter( 
        new OutputStreamWriter(System.out));
    static long inf = (long)1e9+7;
   
    //HashMap<Integer,Integer> map = new HashMap<>();

    // for(int i=0;i<n;i++){
            
    // }
    static long mod = (long)1e9+7;
    static void sol() throws Exception{
       int k = ip.in();
       int n = ip.in();
       int m = ip.in();
       
      int[] a = new int[n];
      int[] b = new int[m];

      int max = -1;
      
      int z = 0;
      for(int i=0;i<n;i++){
         a[i] = ip.in();
         
         if(a[i] == 0)z++;
         max = Math.max(a[i],max);
      }
      for(int i=0;i<m;i++){
         b[i] = ip.in();
         
         if(b[i] == 0)z++;
         max = Math.max(b[i],max);
      }
      
      if(k+z < max){
         op.sbln(-1);
         return;
      }
      
      int i=0,j=0;
      StringBuffer sb = new StringBuffer();
      
      while(i+j<n+m){
         boolean f1 = false,f2 = false;
         while(i<n){
            if(a[i]>k)break;
            if(a[i] == 0)k++;
            sb.append(a[i]+" ");
            i++;
            f1 = true;
         }
         while(j<m){
            if(b[j]>k)break;
            if(b[j] == 0)k++;
            sb.append(b[j]+" ");
            j++;
            f2 = true;
         }
         if(!f1 && !f2){
            op.sbln(-1);
            return;
         }
      }
      op.sbln(sb);
      
    }
    
    static int gcd(int a,int b){
        if(b==0)
        return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) throws Exception { 
        int t = ip.in();
      //  HashSet<Long> prime = new HashSet<Long>();
      //  ArrayList<Long> prm = new ArrayList<>(); 
      //  for(long i=2;i<=(long)1e9+7;i++){
      //     if(!prime.contains(i)){
      //        prm.add(i);
      //        for(long j = i*i;j<=(long)1e9+7;j+=i){
      //           prime.add(j);
      //        }
      //     }
      //  }
        
        while(t-- > 0){
             sol();
        }
        op.output.flush();
    }
    static class Node /*implements Comparable<Node>*/{
        int data[] = new int[26];
        int val;
        Node left,right;
        Node(){
            left = null;
            right = null;
        }
        Node(char ch){
            left = null;
            right = null;
        }
    
        // @Override
        // // public int compareTo(Node o) {
        // //     if(this.data == o.data)
        // //     return this.ind - o.ind;
        // //     // TODO Auto-generated method stub
        // //     return o.data - this.data;
        // // }
    }
}


class FastReader 
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
class inp{
    FastReader sc = new FastReader();
    int in(){
        int a = sc.nextInt();
        return a;
    }
    long lin(){
        long a = sc.nextLong();
        return a;
    }
    char cin(){
        char c = sc.next().charAt(0);
        return c;
    }
    char[] cain(){
        char[] a = sc.nextLine().toCharArray();
        return a;
    }
    int[] arrin(int n){
        int [] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = in();

        return arr;
    }
    int[] mm_arr(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int ans[] = {max,min};
        return ans;
    }
    int[] srt(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    long pow(long a,long b){
        if(b == 0)return 1;
        long res = pow(a,b/2);
        //System.out.println(res + " " + b + " " + (b&1));
        if((b&1) == 0)return res*res;
        return a*res*res; 
    }

    boolean[] prime(){
        boolean prime[] = new boolean[100000001];
        Arrays.fill(prime,true);
        for (int p = 2; p * p <= 10000000; p++)
        {
            // If prime[p] is not changed,
            // then it is a prime
            if (prime[p] == true)
            {
                // Update all multiples
                // of p greater than or
                // equal to the square of it
                // numbers which are multiple
                // of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= 10000000; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }
}
class out{
    BufferedWriter output = new BufferedWriter( 
        new OutputStreamWriter(System.out)); 

    void sb(String s) throws IOException {
        output.write(s);
    }
    void sbln(Object s) throws IOException {
        output.write(s+"\n");
    }
    void yes() throws IOException{
        output.write("YES\n");
    }
    void no() throws IOException{
        output.write("NO\n");
    }
}
