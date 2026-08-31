import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by vlad on 22.03.16.
 */
public class problemB {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] id = new int[n + 1];
        for (int i = 0; i < n; i++) {
            id[i] = in.nextInt();
        }

        int count = 0;
        int i;
        for (i = 1; i <= n; i++) {
            if (count + i > k)
                break;
            count += i;
        }
        if (k == count)
            System.out.println(id[i - 2]);
        else
            System.out.println(id[k - count - 1]);
    }
}