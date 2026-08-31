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


    public static void main(String[] args) throws Exception {
        try {
            FastReader sc = new FastReader();
            String a = sc.next();
            String b = sc.next();
            int n = sc.nextInt();
            System.out.println(a+" "+b);
            while(n!=0){
                String c = sc.next();
                String d = sc.next();
                if(c.equals(a)){
                    a=d;
                }
                else{
                    b=d;
                }
                System.out.println(a+" "+b);
            }

        }
        catch (Exception e) {
        }
    }
}