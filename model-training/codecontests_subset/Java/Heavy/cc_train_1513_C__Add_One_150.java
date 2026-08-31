//   package com.anesthesia.analyze;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[2*(int)1e5 + 10];
    static int mod = (int)1e9 + 7;
    public static void main(String[] args) throws IOException {
        for(int i= 0;i<dp.length;i++){
            if(i < 10)
                dp[i] = 1;
            else
                dp[i] = (dp[i-10]+dp[i-9])%mod;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(reader.readLine());
        while(T -- != 0) {
            String[] str = reader.readLine().split(" ");
            int n = Integer.valueOf(str[0]), k = Integer.valueOf(str[1]);
            int res = 0;
            while(n != 0) {
                res = (dp[n%10 + k] + res) % mod;
                n /= 10;
            }
            log.write(res + "\n");
            log.flush();
        }


    }
}