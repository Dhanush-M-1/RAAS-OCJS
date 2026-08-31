//package codeforces._658;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _658_A {

    public static void main (String[] args) throws Exception {

        String s = "5\n" +
                "4 5\n" +
                "10 8 6 4\n" +
                "1 2 3 4 5\n" +
                "1 1\n" +
                "3\n" +
                "3\n" +
                "1 1\n" +
                "3\n" +
                "2\n" +
                "5 3\n" +
                "1000 2 2 2 3\n" +
                "3 1 5\n" +
                "5 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5";

//        br = new BufferedReader(new StringReader(s));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rl(); int T = nin();
        next_test:
        for (int t=1; t<=T; ++t) {
            rl(); int n=nin(), m=nin();
            rl();HashSet<Integer> set = new HashSet<>();
            for (int i=0; i<n; ++i) set.add(nin());
            rl();
            for (int i=0; i<m; ++i) {
                int v=nin();
                if (set.contains(v)) {
                    bw.write("YES\n");
                    bw.write("1 " + v +"\n");
                    continue next_test;
                }
            }

            bw.write("NO\n");
        }
        bw.flush();
    }

    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;
    static void rl() throws Exception{ st = new StringTokenizer(br.readLine()); }
    static long nlo(){ return Long.parseLong(st.nextToken()); }
    static int nin(){ return Integer.parseInt(st.nextToken()); }
    /*private static void te(){}*/
    static double ndo(){ return Double.parseDouble(st.nextToken()); }
    static char[] nca(){ return st.nextToken().toCharArray(); }
}
