

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by ReaL PC on 12/12/2016.
 */
public class BearAndRaspberry {
    public static void main(String[] args) throws java.lang.Exception {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String days = reader.readLine();
        String[] s1 = days.split(" ");*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        //System.out.println(n + " " + c);
        int[] a = new int[n];
        int firstSell = 0;
        Integer maxDiff = Integer.MIN_VALUE;
        int minPrice = 0;
        // System.out.println(s2.length);
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        //minPrice = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i - 1] - a[i] > maxDiff) {
                maxDiff = a[i - 1] - a[i];
                minPrice = a[i];
                firstSell = a[i - 1];
            }
        }
        //System.out.println(minPrice);
        int profit = firstSell - minPrice - c;
        if (profit < 0) {
            System.out.println("0");
        } else {
            System.out.println(profit);
        }


    }
}
