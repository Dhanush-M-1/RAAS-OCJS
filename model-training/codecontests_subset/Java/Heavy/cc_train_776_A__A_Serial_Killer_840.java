import java.io.*;
import java.util.*;

//http://codeforces.com/problemset/problem/711/D

public class Main {


    public static void main(String[] args) {

        FastInput in = new FastInput(new InputStreamReader(System.in));

        String n1 = in.nextString();
        String n2 = in.nextString();
        int n = in.nextInt();

        System.out.println(n1 + " " + n2);

        for(int i=1; i<=n; i++) {
            String s1, s2;
            s1 = in.nextString();
            s2 = in.nextString();

            if(s1.equals(n1)) {
                n1=s2;
            }
            else
                n2=s2;

            System.out.println(n1 + " " + n2);

        }

    }


    static class FastInput {

        private Reader in;
        private BufferedReader br;
        private StringTokenizer st;

        public FastInput(Reader in) {
            this.in=in;
            br = new BufferedReader(in);
        }

        public String nextString() {

            if(st==null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }

        public double nextDouble() {

            return Double.parseDouble(nextString());
        }

    }

}
