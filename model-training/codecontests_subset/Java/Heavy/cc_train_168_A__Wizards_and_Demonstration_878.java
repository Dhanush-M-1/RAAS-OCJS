import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class main {            
    static StringBuilder out=new StringBuilder();
    static FastReader in=new FastReader();
    public static int[] getIntArray(int n){
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        return arr;
    }
 
    static int  mod=(int)1e9 +7;
    static int [][]dp;
    
    public static void solve(){
        int n=in.nextInt(), x=in.nextInt(), y=in.nextInt();
        double ans=y*n;
        ans/=100;
        ans-=x;
        int a=(int)Math.ceil(ans);
        // System.out.println(ans);
        if(a<0){
            out.append(0);
        }else{
            out.append(a);
        }
    }

    public static void main(String args[]){
        int t=1;
        while(t-->0){
            solve();
            out.append('\n');
        }
        System.out.println(out);
    }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(next());
    }
 
    long nextLong() {
        return Long.parseLong(next());
    }
 
    double nextDouble() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
