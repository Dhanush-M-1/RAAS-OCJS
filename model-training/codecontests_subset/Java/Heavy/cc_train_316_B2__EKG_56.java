/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ABBYY Cup 3.0
 *
 * B2. EKG
 *
 * @author linwanying
 * @version $Id: B316.java, v 0.1 2020年03月07日 5:07 PM linwanying Exp $
 */
public class B316 {
    public static void main(String[] args) {
        new B316().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cur = scanner.nextInt();
            a[i] = cur;
            if (cur != 0) {
                b[cur-1] = i+1;
                vis[i] = true;
            }
        }

        int xi = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
           if (!vis[i]) {
               int curi = i, len = 1, j = 0;
               boolean xf = i+1 == x;
               while (b[curi] != 0) {
                   len++;
                   j++;
                   if (b[curi] == x) {
                       xi = j + 1;
                       xf = true;
                   }
                   curi = b[curi] - 1;
               }
               if (!xf) {
                   list.add(len);
               }
           }
        }
        //System.out.println(JSON.toJSONString(list));

        boolean[] dp = new boolean[n+1];
        dp[xi] = true;
        for (int i = 0; i < list.size(); ++i) {
            for (int j = n; j >= 0; --j) {
                if (dp[j]) {
                    dp[j+list.get(i)] = true;
                }
            }
        }
        for (int j = 0; j <= n; ++j) {
            if (dp[j]) {
                System.out.println(j);
            }
        }

    }
}