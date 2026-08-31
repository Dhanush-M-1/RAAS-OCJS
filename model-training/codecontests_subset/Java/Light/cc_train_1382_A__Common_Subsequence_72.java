//package round685;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] a = new int[m];
            int[] b = new int[n];

            ArrayList<Integer> c = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }



            Arrays.sort(a);
            Arrays.sort(b);

            int i = 0, j = 0 , count = 0;
            while (i < m && j < n) {
                if (a[i] < b[j])
                    i++;
                else if (b[j] < a[i])
                    j++;
                else {
                    c.add(b[j]);
                    count++;
                    break;
                }
            }

            if (count > 0) {
                System.out.println("YES");

                System.out.print(count + " ");

                for (int element :
                        c) {
                    System.out.print(element + " ");
                }
            }
            else
                System.out.println("NO");
        }
    }
}
