
// import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
    static BufferedReader br;

    static double pre = 1e-9;

    public static void main(String[] args) throws IOException {
        // your code goes here

        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int n = Integer.parseInt(br.readLine());
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            // int n = Integer.parseInt(br.readLine());
            // String s = br.readLine();
            // int n = Integer.parseInt(st.nextToken());
            // long m = Long.parseLong(st.nextToken());
            // long n = Long.parseLong(st.nextToken());
            // long k = Long.parseLong(st.nextToken());
            // long i = Long.parseLong(st.nextToken());
            // long j = Long.parseLong(st.nextToken());

            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int[] ans = new int[n + m];

            int p = 0, i = 0, j = 0;
            int flag = 0;
            for (; p < n + m; p++) {
                if (i < n && a[i] == 0) {
                    ans[p] = a[i];
                    k++;
                    i++;
                } else if (j < m && b[j] == 0) {
                    ans[p] = b[j];
                    k++;
                    j++;
                } else if (i < n && a[i] <= k) {
                    ans[p] = a[i];
                    i++;
                } else if (j < m && b[j] <= k) {
                    ans[p] = b[j];
                    j++;
                } else {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                System.out.println("-1");
            } else {
                for (i = 0; i < n + m; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println("");
            }

        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;

    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }
}

// // StringTokenizer st = new StringTokenizer(br.readLine());
// // int n = Integer.parseInt(st.nextToken());
// // int m = Integer.parseInt(st.nextToken());
// // long w = Long.parseLong(st.nextToken());
// // String str = br.readLine();
// // int a[] = new int[n];
// // st = new StringTokenizer(br.readLine());
// // HashMap<Long, Integer> canBE = new HashMap<>();
