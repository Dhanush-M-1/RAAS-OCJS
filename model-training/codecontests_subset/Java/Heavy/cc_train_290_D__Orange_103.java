//package Round_FirstApril_2013;

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class D {

    void solve () throws IOException {
        String s = in.next();
        s = s.toLowerCase();
        int n = in.nextInt();
        String ans = "";
        for (int i = 0; i<s.length(); i++)
            if (s.charAt(i) < n + 97){
                ans += (s.charAt(i) + "").toUpperCase();
            }else 
                ans += (s.charAt(i) + "").toLowerCase();
        out.println(ans);
    }

    String input = "";
    String output = "";

    FastScanner in;
    PrintWriter out;

    void run () {
        try {
            BufferedReader bf;
            if (input.length() == 0)
                bf = new BufferedReader(new InputStreamReader(
                        System.in));
            else
                bf = new BufferedReader(new FileReader(input));
            in = new FastScanner(bf);

            if (output.length() == 0)
                out = new PrintWriter(System.out);
            else
                out = new PrintWriter(new File(output));

            solve();

            out.close();
        } catch (Exception ex) {
            out.close();
            ex.printStackTrace();
        }
    }

    public static void main (String[] args) {
        new D().run();
    }

    class FastScanner {
        BufferedReader bf;
        StringTokenizer st;

        FastScanner(BufferedReader bf) {
            this.bf = bf;
        }

        String next () throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(bf.readLine());
            return st.nextToken();
        }

        int nextInt () throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong () throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble () throws IOException {
            return Double.parseDouble(next());
        }

        int[] readIntArray (int n) throws IOException {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readLongArray (int n) throws IOException {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}