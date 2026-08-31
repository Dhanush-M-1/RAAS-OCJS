//package ninetythree;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (arr[n-1] >= arr[1] + arr[0]) {
                System.out.printf("%d %d %d\n", 1, 2, n);
            } else {
                System.out.println("-1");
            }
        }
    }
}
