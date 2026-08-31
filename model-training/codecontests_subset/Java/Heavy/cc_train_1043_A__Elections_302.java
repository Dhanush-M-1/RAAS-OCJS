/*
Written by Kabir Kanha Arora
@kabirkanha
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        // Find smallest k that satisfies the conditions.
        for (int k = max; ; ++k) {
            // Check if Team A wins.
            if (((n * k) - sum) > sum) {
                System.out.println(k);
                break;
            }
        }
    }
}
