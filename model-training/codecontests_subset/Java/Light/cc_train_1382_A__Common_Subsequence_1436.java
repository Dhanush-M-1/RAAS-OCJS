//package codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CommonSubsequence {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while ( n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();

            while (a > 0) {
                int x = sc.nextInt();
                set.add(x);
                a--;
            }
            boolean flag = false;
            while (b > 0) {
                int x = sc.nextInt();
                if(set.contains(x) && flag == false) {
                    System.out.println("YES");
                    System.out.println(1 + " " + x);
                    flag = true;
                    //break;
                }
                b--;
            }
            if(flag == false) {
                System.out.println("NO");
            }
            n--;
        }
    }
}
