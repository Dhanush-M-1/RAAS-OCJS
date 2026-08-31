import java.util.Scanner;

import static java.lang.System.in;

public class Round702D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int[] res = new int[n];
            dfs(a, 0, n, res, 0);
            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[] a, int start, int end, int[] res, int d) {
        if (start >= end) return;
        int max = 0, id = 0;
        for (int i = start; i < end; i++) {
            if (a[i] > max) {
                max = a[i];
                id = i;
            }
        }
        res[id] = d;
        dfs(a, start, id, res, d + 1);
        dfs(a, id + 1, end, res, d + 1);
    }

}
