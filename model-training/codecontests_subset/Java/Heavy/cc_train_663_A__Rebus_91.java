import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {
    public static void main(String[] args)
        throws Exception {
        new Solution().start();
    }

    public void start()
        throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        calc(br);
    }
    
    void calc(BufferedReader br) throws Exception {
        String[] split = br.readLine().split(" ");
        
        // for (int i = 0; i <= split.length - 1; i++) P[i] = Integer.parseInt(split[i]);
        
        //System.out.println(solve(new BigInteger(split[0]), new BigInteger(split[1])));
        //System.out.println(solve(split));
        solve(split);
    }
    
    void solve(String[] split) {
        int plus_cnt = 1, neg_cnt = 0;
        for (String s : split) 
            if (s.equals("+")) plus_cnt++;
            else if (s.equals("-")) neg_cnt++;
        
        int n = Integer.parseInt(split[split.length - 1]);
        int t = n;
        //System.out.println(plus_cnt + " " + neg_cnt);
        if (neg_cnt == 0 && plus_cnt <= n) {
            System.out.println("Possible");
            int r = n;
            System.out.print((r / plus_cnt) + " ");
            r -= r / plus_cnt--;
            for (String s : split) {
                    if (s.equals("?") == false) System.out.print(s + " ");
                    if (s.equals("+") == true) {
                        System.out.print(r / plus_cnt);
                        System.out.print(" ");
                        r -= r / plus_cnt--;
                    }
                }
            return;
        } else if (neg_cnt == 0) {
            System.out.println("Impossible");
            return;
        }
        while (t > 0) {
            int a = plus_cnt * t;
            if  (neg_cnt > 0 && (a - n)  <= (n * neg_cnt) && (a -n) >= neg_cnt) {
                //System.out.println(n + " " + a);
                System.out.println("Possible");
                System.out.print(t + " ");
                int r = a - n;
                for (String s : split) {
                    if (s.equals("?") == false) System.out.print(s + " ");
                    if (s.equals("+") == true) System.out.print(t + " ");
                    else if (s.equals("-") == true) {
                        System.out.print(r / neg_cnt);
                        System.out.print(" ");
                        r -= r / neg_cnt--;
                    }
                }
                return;
            }
            t--;
        }
        System.out.println("Impossible");
    }
}