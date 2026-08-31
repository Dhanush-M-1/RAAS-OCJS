import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.StringTokenizer;
public class garden {
    static PrintStream p = System.out;
    static ArrayList<String> obj = new ArrayList<String>();
    public static void main(String args[] ) throws Exception {
        FastReader scan=new FastReader();
        long n = scan.nextLong();
        long m = scan.nextLong();
        long val=0,best=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long num = scan.nextLong();
            if(m%num==0){
                best = Math.min(m/num,best);
            }
            
        }
        p.println(best);
    }
    static long findMinDiff(long[] arr, long n){
        Arrays.sort(arr);
        long diff = Integer.MAX_VALUE;
        for (int i=0; i<n-1; i++)                
            if (arr[i+1] - arr[i] < diff){
                diff = arr[i+1] - arr[i];
            }
        return diff;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        private long[] la(long n){
        long[] a = new long[(int)n];
        for(int i = 0;i < n;i++)a[i] = nextLong();
            return a;
        }
        private void pla(long[] a){
            for(int i = 0;i <a.length;i++)
                p.print(a[i]+" ");
        }
        private void pia(int[] a){
            for(int i = 0;i <a.length;i++)
                p.print(a[i]+" ");
        }

        public FastReader(){
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
} 