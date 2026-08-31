import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        int cntOne = 0;
        int cntTwo = 0;
        char s[] = scan.next().toCharArray();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i] + "");
            if (a[i] == 1) cntOne++;
            else cntTwo++;
        }

        if (cntOne != cntTwo) {
            System.out.println(1);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
            }
        } else {
            System.out.println(2);
            System.out.print(a[0] + " ");
            for (int i = 1; i < n; i++) {
                System.out.print(a[i]);
            }
        }
    }
}