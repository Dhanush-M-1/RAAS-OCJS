import java.util.Arrays;
import java.util.Scanner;

public class Substitute {
    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n / 4; i++) {
            a += s.nextInt();
            b += s.nextInt();
            c += s.nextInt();
            d += s.nextInt();
        }
        if (n % 4 >= 1) a += s.nextInt();
        if (n % 4 >= 2) b += s.nextInt();
        if (n % 4 >= 3) c += s.nextInt();
        if (d>b&&d>a&&d>c) System.out.println("D");
        else if (c>b&&c>a) System.out.println("C");
        else if (b>a) System.out.println("B");
        else  System.out.println("A");
    }*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int start = s.nextInt();
        int end = s.nextInt();
        int inc = s.nextInt();
        int back = s.nextInt();
        int i = 1;
        int curr = start;
        while (curr < length) {
            i++;
            if (start + (i-1) * inc <= end) {
                curr += start + (i-1) * inc-back;

            } else {
                curr += end-back;

            }

        }
        System.out.println(i);
    }
}