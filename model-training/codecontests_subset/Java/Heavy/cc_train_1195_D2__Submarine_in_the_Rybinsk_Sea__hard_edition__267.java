//package codeforces574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D2 {
    public static void main(String[] args) throws IOException {
//        fac(1_000_000_000, 10, true);
//        fac(1_000_000_000, 10, false);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] as = br.readLine().split(" ");
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int l = as[i].length();
            map.put(l, 1+map.getOrDefault(l,0));
        }

        long sum = 0;

        for(int i=0; i<n; i++) {
            long a = Integer.parseInt(as[i]);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                long fac1 = fac(a, entry.getKey(), true);
                sum += fac1 * entry.getValue();

                long fac2 = fac(a, entry.getKey(), false);
                sum += fac2 * entry.getValue();

                sum %= 998244353;
            }
        }

        System.out.println(sum);
    }

    static long fac(long a, int bl, boolean type) {
        long sum=a;
        long pow10=type?10:1;
        for(int i=0; i<bl; i++) {
            long mod = Long.remainderUnsigned(sum, pow10);
            sum = (sum - mod) * 10 + mod;
            pow10 *= 100;
        }
        return Long.remainderUnsigned(sum, 998244353);
    }

}