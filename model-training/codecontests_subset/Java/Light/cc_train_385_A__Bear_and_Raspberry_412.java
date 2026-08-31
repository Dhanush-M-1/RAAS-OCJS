/*   Created by IntelliJ IDEA.
 *   Author: Kunal Srivastav (kunalsrivastav)
 *   Date: 29-06-2021
 *   Time: 17:48
 *   File: BearAndRaspberry.java
 */

import java.util.Scanner;

/**
 * Question - https://codeforces.com/problemset/problem/385/A
 * */

public class BearAndRaspberry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maximum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i+1]) {
                maximum = Math.max(maximum, arr[i] - arr[i+1] - c);
            }
        }
        System.out.println(maximum);
    }
}