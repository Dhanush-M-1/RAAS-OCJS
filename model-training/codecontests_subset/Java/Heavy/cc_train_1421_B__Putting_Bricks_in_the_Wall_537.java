

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author is2ac
 */
public class B_CF {

    public static void main(String[] args) {
        FastScanner56 fs = new FastScanner56();
        PrintWriter pw = new PrintWriter(System.out);
        int t = fs.ni();
        for (int tc = 0; tc < t; tc++) {
           int n = fs.ni();
           char[][] matrix = new char[n][];
           for (int i = 0; i < n; i++) {
               String s = fs.next();
               matrix[i] = s.toCharArray();
           }
           char a = matrix[0][1];
           char b = matrix[1][0];
           char c = matrix[n-1][n-2];
           char d = matrix[n-2][n-1];
           int k = 0;
           StringBuilder sb = new StringBuilder();
           if (a==b) {
               if (c==a) {
                   sb.append(n + " " + (n-1));
                   sb.append("\n");
                   k++;
               }
               if (d==a) {
                   sb.append((n-1) + " " + n);
                   sb.append("\n");
                   k++;
               }
           } else if (c==d) {
               if (a==d) {
                   sb.append(1 + " " + 2);
                   sb.append("\n");
                   k++;
               }
               if (b==d) {
                   sb.append(2 + " " + 1);
                   sb.append("\n");
                   k++;
               }
           } else {
               if (a=='0') {
                   sb.append(1 + " " + 2);
                   sb.append("\n");
                   k++;
               }
               if (b=='0') {
                   k++;
                   sb.append(2 + " " + 1);
                   sb.append("\n");
               }
               if (c=='1') {
                   sb.append(n + " " + (n-1));
                   sb.append("\n");
                   k++;
               }
               if (d=='1') {
                   sb.append((n-1) + " " + n);
                   sb.append("\n");
                   k++;
               }
           }
           pw.println(k);
           if (sb.length()>0) {
               pw.println(sb);
           }
        }
        pw.close();
    }
}

class FastScanner56 {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner56() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int ni() {
        return Integer.parseInt(next());
    }

    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = ni();
        }
        return ret;
    }

    long nl() {
        return Long.parseLong(next());
    }

    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++) {
            ret[i] = nl();
        }
        return ret;
    }

    double nd() {
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

