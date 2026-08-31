import java.util.*;
import java.io.*;
import java.math.*;
public class Main{
    static final long MOD = (long)1e9+7;
    static FastReader in;
    static int MAX = (int)1e6;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args){
        in = new FastReader();
        int N = ni();
        long D = nl();
        boolean valid = true;
        long[] a = new long[N+1],prefix = new long[N+1];
        for(int i = 1; i<= N; i++){
            a[i] = nl();
            prefix[i] = prefix[i-1]+a[i];
            if(prefix[i] > D)valid = false;
        }
        int count = 0;
        if(valid){
            long amount =0;
            long minAmount = 0, maxAmount = 0;
            for(int i = 1; i<= N; i++){
                if(a[i] == 0){
                    if(prefix[i]+amount+minAmount >D){
                        valid = false;
                    }else if(prefix[i]+amount+maxAmount< 0){
                        count++;
                        amount += minAmount;
                        minAmount = -(prefix[i]+amount);
                        maxAmount = D-(prefix[i]+amount);
                    }else{
                        minAmount = Math.max(-(prefix[i]+amount), minAmount);
                        maxAmount = Math.min(maxAmount, D-prefix[i]-amount);
                    }
                }else if(a[i]> 0){
                    if(prefix[i]+amount+minAmount>D)valid = false;
                    maxAmount = Math.min(maxAmount, D-prefix[i]-amount);
                }
            }
        }
        pn((valid)?count:-1);
    }
    
    static long gcd(long a, long b){
        return (b==0)?a:gcd(b,a%b);
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