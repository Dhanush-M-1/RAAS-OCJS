import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static class pair {
        int a, b;

        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        long n=in.nextLong();
        long p=in.nextLong();
        TreeMap<Long,Long>map=new TreeMap<>();
        long c=0;
        if(p%2==0) {
            c = 0;
            while (p % 2 == 0) {
                p = p / 2;
                c++;
            }
            map.put(2L, c);
            c = 0;
        }
        for(long i=3;i*i<=p;i+=2){
            if(p%i==0){
                while(p%i==0){
                    c++;
                    p=p/i;
                }
                map.put(i,c);
                c=0;
            }
        }
        if(p>2){
            map.put(p,map.getOrDefault(p,0L)+1);
        }
        long gcd=1L;
        while(!map.isEmpty()){
            Map.Entry<Long,Long> e=map.pollLastEntry();
            long key=e.getKey();
            long val=e.getValue();
            if(val>=n){
                gcd=(gcd*powe(key,(val/n)));
            }
        }
        System.out.println(gcd);
    }

    private static long powe(long a, long b) {
        long res=1;
        while(b!=0){
            if(b%2!=0){
                res=res*a;
            }
            b>>=1;
            a=a*a;
        }
        return res;
    }
}