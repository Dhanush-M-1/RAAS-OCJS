/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author ElchinF
 */
public class ReachMedian {


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            long s = sc.nextLong();
            long median = 0;
            long res = 0;
            long temp = 0;
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            median=arr[arr.length/2];

            if (s > median) {
                for (int i = arr.length / 2; i < arr.length; i++) {
                    if ((s - arr[i]) > 0) {
                        res = res + (s - arr[i]);
                    }
                }
                System.out.println(res);

            } else if (s < median) {
                for (int i = 0; i <= arr.length / 2; i++) {
                    if ((arr[i] - s) > 0) {
                        res = res + (arr[i] - s);
                    }
                }
                System.out.println(res);

            } else {
                System.out.println("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
