//package talas.edu.codeforces.com;

import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                System.out.println("YES");
                System.out.println(String.format("%d %d", i + 1, i+2));
                return;
            }
        }
        System.out.println("NO");
    }
}


/*
7
abcdcba
7
dcbabcd
7
aaabcde
7
bbbbbba
7
aabacdd
7
aaabaaa
7
aaabacd
7
aadbcbb
 */