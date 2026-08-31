import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BearAndTwoPaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (n == 4 || k < n + 1) {
            System.out.println(-1);
        }
        else {
            StringBuffer res = new StringBuffer();
            StringBuffer res2 = new StringBuffer();
            System.out.print(a + " ");
            System.out.print(c + " ");

            boolean firstime = true;
            for (int i = 1; i <= n; ++i) {
                if (i != a && i != b && i != c && i != d) {
                    if (firstime) {
                        firstime = false;
                    }
                    else {
                        res2.append(i);
                        res2.append(' ');
                    }
                    res.append(i);
                    res.append(' ');
                }
            }
            System.out.print(res);
            System.out.print(d + " ");
            System.out.println(b);

            System.out.print(c + " ");
            System.out.print(a + " ");
            System.out.print(res);
            System.out.print(b + " ");
            System.out.println(d);
        }

    }
}
