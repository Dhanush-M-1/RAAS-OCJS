import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = nextInt();
        for (int q = 0; q < t; q++) {
            int n = nextInt();
            char[][] m = new char[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = next().toCharArray();
            }
            int firstLevelZeroCnt = 0;
            int firstLevelOneCnt = 0;
            int secondLevelZeroCnt = 0;
            int secondLevelOneCnt = 0;
            if (m[0][1] == '0') firstLevelZeroCnt++;
            else firstLevelOneCnt++;
            if (m[1][0] == '0') firstLevelZeroCnt++;
            else firstLevelOneCnt++;
            if (m[0][2] == '0') secondLevelZeroCnt++;
            else secondLevelOneCnt++;
            if (m[1][1] == '0') secondLevelZeroCnt++;
            else secondLevelOneCnt++;
            if (m[2][0] == '0') secondLevelZeroCnt++;
            else secondLevelOneCnt++;
            int cnt = 0;
            if (secondLevelOneCnt == 3) {
                if (m[0][1] == '1') cnt++;
                if (m[1][0] == '1') cnt++;
                pw.println(cnt);
                if (m[0][1] == '1') pw.println(1 + " " + 2);
                if (m[1][0] == '1') pw.println(2 + " " + 1);
            } else if (secondLevelZeroCnt == 3) {
                if (m[0][1] == '0') cnt++;
                if (m[1][0] == '0') cnt++;
                pw.println(cnt);
                if (m[0][1] == '0') pw.println(1 + " " + 2);
                if (m[1][0] == '0') pw.println(2 + " " + 1);
            } else if (firstLevelZeroCnt == 2) {
                for (int i = 0; i < 3; i++) if (m[i][2 - i] == '0') cnt++;
                pw.println(cnt);
                for (int i = 0; i < 3; i++) if (m[i][2 - i] == '0') pw.println((i + 1) + " " + (3 - i));
            } else if (firstLevelOneCnt == 2) {
                for (int i = 0; i < 3; i++) if (m[i][2 - i] == '1') cnt++;
                pw.println(cnt);
                for (int i = 0; i < 3; i++) if (m[i][2 - i] == '1') pw.println((i + 1) + " " + (3 - i));
            } else {
                if (secondLevelOneCnt > secondLevelZeroCnt) {
                    for (int i = 0; i < 3; i++) if (m[i][2 - i] == '0') cnt++;
                    if (m[0][1] == '1') cnt++;
                    if (m[1][0] == '1') cnt++;
                    pw.println(cnt);
                    if (m[0][1] == '1') pw.println(1 + " " + 2);
                    if (m[1][0] == '1') pw.println(2 + " " + 1);
                    for (int i = 0; i < 3; i++) if (m[i][2 - i] == '0') pw.println((i + 1) + " " + (3 - i));
                } else {
                    for (int i = 0; i < 3; i++) if (m[i][2 - i] == '1') cnt++;
                    if (m[0][1] == '0') cnt++;
                    if (m[1][0] == '0') cnt++;
                    pw.println(cnt);
                    if (m[0][1] == '0') pw.println(1 + " " + 2);
                    if (m[1][0] == '0') pw.println(2 + " " + 1);
                    for (int i = 0; i < 3; i++) if (m[i][2 - i] == '1') pw.println((i + 1) + " " + (3 - i));
                }
            }
        }
        pw.close();
    }

    static long mod = 1_000_000_007;

    static StringTokenizer st = new StringTokenizer("");
    static BufferedReader br;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}