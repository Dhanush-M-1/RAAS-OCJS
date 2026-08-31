/*
Written by Kabir Kanha Arora
@kabirkanha
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            char[] arr = scanner.next().toCharArray();
            int ans = 0;
            int n = arr.length;
            boolean[] available = new boolean[n];
            Arrays.fill(available, true);
            if (n > 1) {
                if (arr[0] == arr[1]) {
                    ans++;
                    available[1] = false;
                }
            }
            for (int i = 2; i < n; ++i) {
                if (arr[i] == arr[i - 1] && available[i - 1]) {
                    available[i] = false;
                    ans++;
                }
                if (arr[i] == arr[i - 2] && available[i - 2]) {
                    available[i] = false;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
