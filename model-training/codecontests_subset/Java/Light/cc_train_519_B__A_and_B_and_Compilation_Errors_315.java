import java.util.Scanner;

/**
 * Created by TuanNM on 9/3/2016.
 */
public class Task519B {

    public static void main (String[] args) {
        final int N = 10 + 100000;
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long sumA = 0, sumB = 0, sumC = 0;
        for (int i = 0; i < n; ++i) sumA += in.nextInt();
        for (int i = 0; i < n - 1; ++i) sumB += in.nextInt();
        for (int i = 0; i < n - 2; ++i) sumC += in.nextInt();
        System.out.println(sumA - sumB);
        System.out.println(sumB - sumC);

    }

}
