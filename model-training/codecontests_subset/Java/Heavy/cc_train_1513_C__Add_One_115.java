import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 11/04/21
public class AddOne {
    BufferedReader in;
    BufferedWriter out;
    StringTokenizer st;
    boolean onlineJudge;
    long mod = 1_000_000_007;

    long[][] fillDp(int M){
        long[][] dp = new long[10][M+1];;
        for (int m = 0; m <= M ; m++) {
            for (int digit = 0; digit < 10; digit++) {
                if(m==0){
                    dp[digit][m] = 1;
                }else {
                    int sub = 10-digit;
                    if(m<sub){
                        dp[digit][m] = 1;
                    }else {
                        dp[digit][m] = (dp[1][m-sub]+dp[0][m-sub])%mod;
                    }
                }
            }
        }
        return dp;
    }
    
    // My Solution
    void solve() throws IOException {
        int t = getInt();
        int maxM = Integer.MIN_VALUE;
        int[][] testCase = new int[t][2];
        for (int i = 0; i < t; i++) {
            int n = getInt();
            int m = getInt();
            testCase[i][0] = n;
            testCase[i][1] = m;
            maxM = Math.max(m, maxM);
        }
        long[][] dp = fillDp(maxM);
        for (int i = 0; i < t; i++) {
            int n = testCase[i][0];
            int m = testCase[i][1];
            long ans = 0;
            int temp = n;
            while (temp!=0){
                int digit = temp%10;
                ans = (ans+dp[digit][m])%mod;
                temp /= 10;
            }
            println(String.valueOf(ans));
        }
    }
    // Handling CodeExecution
    public static void main(String[] args) throws Exception {
        new AddOne().run();
    }
    void run() throws IOException {
        onlineJudge = isOnlineJudge();
        // Defining Input Streams
        if (onlineJudge) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new BufferedWriter(new FileWriter("output.txt"));
        }
        // Running Logic
        solve();
        out.flush();
        // Run example test cases
        if (!onlineJudge) {
            BufferedReader output = new BufferedReader(new FileReader("output.txt"));
            BufferedReader answer = new BufferedReader(new FileReader("answer.txt"));
            StringBuilder outFile = new StringBuilder();
            StringBuilder ansFile = new StringBuilder();
            String temp;
            while ((temp = output.readLine()) != null)
                outFile.append(temp.trim());
            while ((temp = answer.readLine()) != null)
                ansFile.append(temp.trim());
            if (outFile.toString().equals(ansFile.toString()))
                System.out.println("Test Cases Passed!!!");
            else
                System.out.println("Failed...");
        }
    }
    // Checks whether the code is running on OnlineJudge or LocalSystem
    boolean isOnlineJudge() {
        try {
            return System.getProperty("ONLINE_JUDGE")!=null
                    || System.getProperty("LOCAL")==null;
        } catch (Exception e) {
            return true;
        }
    }
    // Some functions
    void print(String... s) throws IOException {
        for (String value : s) out.write(value);
    }
    void println(String... s) throws IOException{
        print(s);
        out.newLine();
    }
    String getLine() throws IOException{
        return in.readLine();
    }
    String getToken() throws IOException{
        if(st==null || !st.hasMoreTokens())
            st = new StringTokenizer(getLine());
        return st.nextToken();
    }
    int getInt() throws IOException {
        return Integer.parseInt(getToken());
    }
    long getLong() throws IOException {
        return Long.parseLong(getToken());
    }
    Integer[] getInts(int n) throws IOException {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++)
            a[i] = getInt();
        return a;
    }
    Long[] getLongs(int n) throws IOException {
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++)
            a[i] = getLong();
        return a;
    }
    int[][] getIntMat(int n, int m) throws IOException {
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] = getInt();
        return mat;
    }
    char[][] getCharMat(int n, int m) throws IOException {
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = getLine();
            for (int j = 0; j < m; j++)
                mat[i][j] = s.charAt(j);
        }
        return mat;
    }
}