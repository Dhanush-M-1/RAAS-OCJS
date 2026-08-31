//package Round_174;

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class b {

    void solve() throws Exception {
        int n = in.nextInt();
        String s = in.next();
        int A = 0;
        int F = 0;
        int I = 0;
        for (int i = 0; i<s.length(); i++)
            if (s.charAt(i) == 'A') A++;
            else if (s.charAt(i) == 'F') F++;
            else I++;
        if (I == 1){
            out.println(1);
        }else if (I == 0){
            out.println(A);
        }else if (I > 1){
            out.println(0);
        }

    }

    FastScanner in;
    PrintWriter out;

    String input = "";
    String output = "";

    void run() {
        try {
            if (input.length() > 0) {
                in = new FastScanner(new BufferedReader(new FileReader(input)));
            } else
                in = new FastScanner(new BufferedReader(new InputStreamReader(
                        System.in)));
            if (output.length() > 0)
                out = new PrintWriter(new FileWriter(output));
            else
                out = new PrintWriter(System.out);

            solve();

            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            out.flush();
            out.close();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new b().run();
    }

    class FastScanner {
        BufferedReader bf;
        StringTokenizer st;

        public FastScanner(BufferedReader bf) {
            this.bf = bf;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(bf.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] readIntArray(int n) throws IOException {
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = this.nextInt();
            return array;
        }

        public long[] readLongArray(int n) throws IOException {
            long[] array = new long[n];
            for (int i = 0; i < n; i++)
                array[i] = this.nextLong();
            return array;
        }

    }

}
