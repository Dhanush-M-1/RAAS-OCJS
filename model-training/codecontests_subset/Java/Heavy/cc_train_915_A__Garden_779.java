import java.util.*;
import java.io.*;
import java.math.*;
public class Main{
    static final long MOD = (long)1e9+7;
    static FastReader in;
    public static void main(String[] args){
        in = new FastReader();
        StringBuilder out = new StringBuilder("");
        int N = ni(), K = ni();
        int[] val = new int[N];
        long ans = 0;
        for(int i = 0; i< N; i++){
            int x = ni();
            if(K%x==0)ans = Math.max(ans, x);
        }
        pn(K/ans);
    }
    
    static void p(Object o){
        System.out.print(o);
    }
    
    static void pn(Object o){
        System.out.println(o);
    }
    
    static String n(){
        return in.next();
    }
    
    static String nln(){
        return in.nextLine();
    }
    
    static int ni(){
        return Integer.parseInt(in.next());
    }
    
    static int[] ia(int N){
        int[] a = new int[N];
        for(int i = 0; i<N; i++)a[i] = ni();
        return a;
    }
    
    static long[] la(int N){
        long[] a = new long[N];
        for(int i = 0; i<N; i++)a[i] = nl();
        return a;
    }
    
    static long nl(){
        return Long.parseLong(in.next());
    }
    
    static double nd(){
        return Double.parseDouble(in.next());
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}       