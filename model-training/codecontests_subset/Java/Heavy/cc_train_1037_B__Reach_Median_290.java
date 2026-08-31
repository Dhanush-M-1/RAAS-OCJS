//package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] a = new int[n];
        for (int i =0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        long k = 0;
        if (a[n / 2] < s) {
            for (int i = n / 2; i < n; i++) {
                if (a[i] < s) {
                    k += s - a[i];
                } else {
                    break;
                }
            }
        } else {
            for (int i = n / 2; i >= 0; i--) {
                if (a[i] > s) {
                    k += a[i] - s;
                } else {
                    break;
                }
            }
        }
        System.out.println(k);
    }
}
