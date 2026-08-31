import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] errors1 = new int[n];
        int[] errors2 = new int[n-1];
        int[] errors3 = new int[n-2];

        for (int i=0; i<n; i++) {
            errors1[i] = in.nextInt();
        }
        for (int i=0; i<n-1; i++) {
            errors2[i] = in.nextInt();
        }
        for (int i=0; i<n-2; i++) {
            errors3[i] = in.nextInt();
        }

        Arrays.sort(errors1);
        Arrays.sort(errors2);
        Arrays.sort(errors3);

        int i1 = -1;
        int i2 = -1;
        for (int i=0; i<n-1; i++) {
            if (i1 < 0) {
                if (errors1[i] != errors2[i]) {
                    i1 = i;
                }
            }

            if (i2 < 0  && i < n-2) {
                if (errors2[i] != errors3[i]) {
                    i2 = i;
                }
            }
        }

        if (i1 < 0) i1 = errors1.length-1;
        if (i2 < 0) i2 = errors2.length-1;

        System.out.println(errors1[i1]);
        System.out.println(errors2[i2]);

        in.close();
    }
}