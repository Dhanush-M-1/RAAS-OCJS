//package Codeforces;

import java.util.Scanner;

public class A_MinimumInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            int d = s.nextInt();

            if(d<l)
                System.out.println(d);
            else{
                int rem = r%d;
                if(d>r) {
                    rem = d - r;
                    System.out.println(r+rem);
                }
                else if (rem == 0)
                    System.out.println(r+d);
                else
                    System.out.println(r-rem+d);
            }

        }
    }
}

