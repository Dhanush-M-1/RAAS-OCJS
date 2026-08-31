//package codeforces;

import java.util.*;

/**
 * Project Name: wlhelp
 * Created by HaoqiWu on 4/11/21.
 */
public class G173 {
    static Scanner scanner = new Scanner(System.in);
    static int N = (int)1e7 + 5;
//    static List<Integer> divisors = new ArrayList<>(N);
    static int[] divisors = new int[N+1];
    static int[] index = new int[N+1];
    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                divisors[j] += i;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (divisors[i] > N) continue;
            if (index[divisors[i]] == 0)// 最小
                index[divisors[i]] = i;
        }

        while (n-->0) {
            int num = scanner.nextInt();
            System.out.println(index[num] == 0 ? -1 : index[num]);
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        System.out.println(index[n] == 0 ? -1 : index[n]);
    }
}
