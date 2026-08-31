import java.util.Scanner;

import static java.lang.Integer.max;

public class MySolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        double perc = n * y / 100.;
        int p = (int) Math.ceil(perc);

        System.out.println(max(0, p - x));

    }
}
