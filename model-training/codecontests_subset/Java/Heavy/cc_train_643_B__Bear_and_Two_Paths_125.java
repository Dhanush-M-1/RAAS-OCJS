//package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nitin.s on 08/10/16.
 */
public class BearAndTwoPaths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int a = in.nextInt() - 1, b = in.nextInt() - 1, c = in.nextInt() - 1, d = in.nextInt() - 1;
        if(n == 4 || k <= n) {
            System.out.println(-1);
        } else {
            List<Integer> others = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                if(i == a || i == b || i == c || i == d) continue;
                others.add(i + 1);
            }
            System.out.print((a + 1) + " " + (c + 1) + " ");
            for(int x : others) System.out.print(x + " ");
            System.out.println((d + 1) + " " + (b + 1));
            System.out.print((c + 1) + " " + (a + 1) + " ");
            for(int x : others) System.out.print(x + " ");
            System.out.println((b + 1) + " " + (d + 1));
        }
    }
}
