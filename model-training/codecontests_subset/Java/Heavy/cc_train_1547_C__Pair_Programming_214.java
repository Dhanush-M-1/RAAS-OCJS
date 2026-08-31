//package codeforces.round731div3;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

//Think through the entire logic before jump into coding!
//If you are out of ideas, take a guess! It is better than doing nothing!
//Read both C and D, it is possible that D is easier than C for you!

//Be aware of integer overflow!
//If you find an answer and want to return immediately, don't forget to flush before return!

public class C {
    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        //initReaderPrinter(true);
        initReaderPrinter(false);
        solve(in.nextInt());
        //solve(1);        
    }

    static void solve(int testCnt) {
        for (int testNumber = 0; testNumber < testCnt; testNumber++) {
            int k = in.nextInt(), n = in.nextInt(), m = in.nextInt();
            int[] a = in.nextIntArrayPrimitive(n);
            int[] b = in.nextIntArrayPrimitive(m);
            int[] ans = new int[n + m];
            int i = 0, j = 0, idx = 0, lines = k;
            while(idx < n + m) {
                while(i < n && a[i] == 0) {
                    ans[idx] = 0;
                    idx++;
                    lines++;
                    i++;
                }
                while(j < m && b[j] == 0) {
                    ans[idx] = 0;
                    idx++;
                    lines++;
                    j++;
                }
                if(idx == n + m) break;
                int p1 = i < n ? a[i] : 10000;
                int p2 = j < m ? b[j] : 10000;
                if(p1 <= p2) {
                    if(p1 > lines) break;
                    ans[idx] = a[i];
                    i++;
                }
                else {
                    if(p2 > lines) break;
                    ans[idx] = b[j];
                    j++;
                }
                idx++;
            }
            if(idx < n + m) {
                out.println(-1);
            }
            else {
                for(int v : ans) {
                    out.print(v + " ");
                }
                out.println();
            }
        }
        out.close();
    }

    static void initReaderPrinter(boolean test) {
        if (test) {
            try {
                in = new InputReader(new FileInputStream("src/input.in"));
                out = new PrintWriter(new FileOutputStream("src/output.out"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            in = new InputReader(System.in);
            out = new PrintWriter(System.out);
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream), 32768);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        Integer[] nextIntArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[] nextIntArrayPrimitive(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[] nextIntArrayPrimitiveOneIndexed(int n) {
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = nextInt();
            return a;
        }

        Long[] nextLongArray(int n) {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long[] nextLongArrayPrimitive(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long[] nextLongArrayPrimitiveOneIndexed(int n) {
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) a[i] = nextLong();
            return a;
        }

        String[] nextStringArray(int n) {
            String[] g = new String[n];
            for (int i = 0; i < n; i++) g[i] = next();
            return g;
        }
    }
}