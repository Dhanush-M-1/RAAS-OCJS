

import java.util.ArrayList;
import java.util.Scanner;

public class Bai2_extra_thebestgift {
    public static void main(String[] args) {
        /*http://codeforces.com/problemset/problem/609/B*/
        int nBooks, mGenres;

        Scanner sc = new Scanner(System.in);
        nBooks = sc.nextInt();
        mGenres = sc.nextInt();
        int[] arrBooks = new int[nBooks];
        int[] timeAppear = new int[mGenres];
        for (int i = 0; i < nBooks; i++) {
            arrBooks[i] = sc.nextInt(); // add book with genre number represent
        }
        for (int i = 0; i < mGenres; i++) {
            timeAppear[i] = 0;
        }

        //group and count the time appear of element has same value
        for (int x : arrBooks) {
            timeAppear[x - 1] = timeAppear[x - 1] + 1;
        }

        long rs = 0;
        // combination time appear of all element
        for (int x : timeAppear) {
            rs += (long) (nBooks - x) * x;
        }
        System.out.println(rs/2);
    }
}
