import javafx.collections.transformation.SortedList;
import sun.font.FontRunIterator;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            Long num = sc.nextLong();
            array[i] = num;
        }
        Arrays.sort(array);

        long[] array2 = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            Long num = sc.nextLong();
            array2[i] = num;
        }
        Arrays.sort(array2);

        long[] array3 = new long[n - 2];
        for (int i = 0; i < n - 2; i++) {
            Long num = sc.nextLong();
            array3[i] = num;
        }
        Arrays.sort(array3);

        boolean find = false;
        for (int j = 0; j < n - 1; j++) {
            if (array[j] != array2[j]) {
                System.out.println(array[j]);
                find = true;
                break;
            }
        }
        if (!find)
            System.out.println(array[n - 1]);

        find = false;
        for (int j = 0; j < n - 2; j++) {
            if (array2[j] != array3[j]) {
                System.out.println(array2[j]);
                find = true;
                break;
            }
        }
        if (!find)
            System.out.println(array2[n - 2]);

    }
}

