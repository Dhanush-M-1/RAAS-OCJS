//package codeforces_464_div2;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int p = 0;
            while(n%2 == 0) {
                p++;
                n = n/2;
            }

            int q = 0;
            while(n%3 == 0) {
                q++;
                n = n/3;
            }

            if(n != 1 || p>q) {
                System.out.println(-1);
                continue;
            }

            System.out.println(2*q - p);
        }
    }
}
