import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Pair {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String[] args) throws Exception{
        FastReader sc = new FastReader();
        try{
            int n = sc.nextInt();
            while(n!=0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                int d= sc.nextInt();
                if(d<l || d>r){
                    System.out.println(d);
                }
                else{
                    System.out.println((r/d)*d+d);
                }
            }
            
        }
        catch(Exception e){
            
        }
    }
}