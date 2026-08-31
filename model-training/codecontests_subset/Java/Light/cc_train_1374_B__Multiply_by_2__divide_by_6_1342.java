import java.util.Scanner;

public class sixTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t != 0) {
            t--;
            long n;
            n = sc.nextLong();
            long tws, ths;
            tws = 0;
            ths = 0;
            boolean breakpoint = false;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                    tws += 1;
                } else if (n % 3 == 0) {
                    n = n / 3;
                    ths += 1;
                } else {
                    breakpoint = true;
                    break;
                }
            }
            if (breakpoint) {
                System.out.println(-1);
            } else {
                if (tws > ths) {
                    System.out.println(-1);
                } else {
                    long op = tws + 2 * (ths - tws);
                    System.out.println(op);
                }
            }
        }
        sc.close();
    }
}