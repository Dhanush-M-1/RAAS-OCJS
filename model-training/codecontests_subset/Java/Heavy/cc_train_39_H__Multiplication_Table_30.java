/**
 * Created by IntelliJ IDEA.
 * User: aircube
 * Date: 11.01.11
 * Time: 4:14
 * To change this template use File | Settings | File Templates.
 */

import sun.nio.cs.ext.Big5;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Template {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Template().run();
    }

    void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
        out = new PrintWriter(System.out);
        solve();
        br.close();
        out.close();
    }


    void solve() throws  IOException {
        int k = nextInt();
        for(int i = 1; i <= k - 1; ++i){
            for(int j = 1; j <= k - 1; ++j) {
                out.print(Integer.toString(i * j, k));
                out.print(" ");
            }
            out.println();
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }
    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
}