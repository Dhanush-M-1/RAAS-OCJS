//package codeforces.practice.div2c;

import java.io.*;
import java.util.*;

public class Woodcutters {
    public static void main(String[] args) {
//        try {
//            FastScanner in = new FastScanner(new FileInputStream("src/input.in"));
//            PrintWriter out = new PrintWriter(new FileOutputStream("src/output.out"));

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

            solve(1, in, out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void solve(int q, FastScanner in, PrintWriter out) {
        for (int qq = 0; qq < q; qq++) {
            int n = in.nextInt();
            int[] x = new int[n], h = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                h[i] = in.nextInt();
            }

            int ans = 1, prevBound = x[0];
            boolean right = false;
            for(int i = 1; i < n; i++) {
                right = false;
                if(x[i] - h[i] > prevBound) {
                    ans++;
                }
                else if(i < n - 1 && x[i] + h[i] < x[i + 1]) {
                    ans++;
                    right = true;
                }
                else if(i == n - 1) {
                    ans++;
                }
                prevBound = right ? x[i] + h[i] : x[i];
            }
            out.println(ans);
        }
        out.close();
    }

    private static long modularAdd(long a, long b, int mod) {
        long sum = a + b;
        if (sum >= mod) {
            sum -= mod;
        }
        return sum;
    }

    private static long modularSubtract(long a, long b, int mod) {
        long diff = a - b;
        if (diff < 0) {
            diff += mod;
        }
        return diff;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
    }
}


