//package codeforces.round593div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stones {
    public static void main(String[] args) {
//        try {
//            FastScanner in = new FastScanner(new FileInputStream("src/input.in"));
//            PrintWriter out = new PrintWriter(new FileOutputStream("src/output.out"));
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int[][] h = new int[t][3];
        for(int i = 0; i < t; i++) {
            h[i][0] = in.nextInt();
            h[i][1] = in.nextInt();
            h[i][2] = in.nextInt();
        }

        for(int i = 0; i < t; i++) {
            out.println(task(h[i]));
        }
        out.close();

//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static int task(int[] h) {
        int[][][] dp = new int[h[0] + 1][h[1] + 1][h[2] + 1];
        for(int i = 0; i < h[0] + 1; i++) {
            for(int j = 0; j < h[1] + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(dp, h[0], h[1], h[2]);
    }

    private static int helper(int[][][] dp, int i, int j, int k) {
        if(dp[i][j][k] < 0) {
            if((i < 1 || j < 2) && (j < 1 || k < 2)) {
                dp[i][j][k] = 0;
            }
            else {
                int c = 0;
                if(i >= 1 && j >= 2) {
                    c = Math.max(c, helper(dp, i - 1, j - 2, k) + 3);
                }
                if(j >= 1 && k >= 2) {
                    c = Math.max(c, helper(dp, i, j - 1, k - 2) + 3);
                }
                dp[i][j][k] = c;
            }
        }

        return dp[i][j][k];
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


