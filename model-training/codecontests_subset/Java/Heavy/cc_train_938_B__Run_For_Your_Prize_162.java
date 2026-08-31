///package com.company;

import java.util.*;

public class Main {
    public enum Size {
        SMALL, MEDIUM,
        LARGE, EXTRA_LARGE
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();

        int[] a = new int[1000005];

        for(int i = 0; i < n; i++) {
            int d = in.nextInt();
            a[d] = 1;
        }

        int x = 1;
        int y = 1000000;
        int ans = 0;

        while(x < 1000000 && y > 0) {
            ans++;
            x++;
            y--;
            if(a[x] == 1) {
                n--;
            }
            if(a[y] == 1) {
                n--;
            }
            if(n <= 0) {
                break;
            }
        }

        cout(ans);

    }

    private static boolean vowels(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
            return true;
        } else {
            return false;
        }
    }

    /*
        Если a большое число типа long, тогда после a ставьте L(15231562315621L).
    */
    private static void cout(Object a) {
        System.out.print(a);
    }
}