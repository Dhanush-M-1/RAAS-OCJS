

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.math.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.abs;
/* docstring*/
public class test  {
    static FastScanner fs = new FastScanner();
    static PrintWriter fop = new PrintWriter(System.out);
     static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try {
            int n =fs.nextInt();
            int[] a = fs.readArray(n);
            int[] b = fs.readArray(n-1);
            int c[] = fs.readArray(n-2);
            int sa=0,sb=0,sc=0;
            for (int i : a) {
                sa+=i;
            }
            for (int i : b) {
                sb+=i;
            }
            for (int i : c) {
                sc+=i;
            }
            fop.println((sa-sb )+" \n"+( sb-sc));
        } catch (Exception e) {
            fop.println(e);
        }
        fop.flush();
        fop.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
