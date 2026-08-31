

import java.util.Scanner;

public class one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int t = (int) Math.ceil(c * (a - b) / (1.0 * b));
        if (t<0)
            t=0;
        System.out.println(t);
    }
}
