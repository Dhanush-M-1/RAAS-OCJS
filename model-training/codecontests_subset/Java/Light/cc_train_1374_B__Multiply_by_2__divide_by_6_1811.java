import java.util.*;
import java.io.*;

public class mult2 {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int count3 = 0;
        int count2 = 0;
        int n = 0;
        for(int i=1;i<=t;i++) {
            count3 = 0;
            count2 = 0;
            n = scan.nextInt();
            while (n % 3 == 0) {
                count3++;
                n = n / 3;
            }
            while (n % 2 == 0) {
                count2++;
                n = n / 2;
            }
            if (n != 1 || (count2>count3)) {
                System.out.println(-1);
            }else {
                System.out.println((2*count3)-count2);
            }
        }
    }
}