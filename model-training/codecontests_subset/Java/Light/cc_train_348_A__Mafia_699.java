import sun.reflect.generics.tree.Tree;

import java.util.*;

public final class Main {


    static Set<Integer>[] set;

    static List<Integer>[] edges;

    static int[] color;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int  n = s.nextInt();

        long max = 0;

        long min = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            int x = s.nextInt();

            arr[i] = x;

            max +=x;

            min = Math.max(min, x);

        }
        min--;

        while (max != min +1) {

            long mid = (max + min)/2;

            long sum = 0;

            for (int i = 0; i < n; i++) {

                sum = sum + (mid - arr[i]);


            }


            if (sum >= mid) max = mid;


            else min = mid;

        }

        System.out.println(max);




    }
}
