import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean canBeK(int i, int k) {
        while (i > k) {
            i = i >> 1;
        }
        return i == k;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scn.nextInt();
        scn.close();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (x > 0) {
                list.add(x);
                x = x >> 1;
            }
        }

        int ans = -1;
        for (int res : list) {
            ArrayList<Integer> cnt = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = a[i];
                int cur = 0;
                while (x > res) {
                    x = x >> 1;
                    cur++;
                }
                if (x == res) cnt.add(cur);
            }
            if (cnt.size() >= k) {
                int sum = 0;
                cnt.sort(Integer::compareTo);
                for (int c = 0; c < k; c++) sum += cnt.get(c);
                if (ans == -1 || sum < ans) ans = sum;
            }
        }
        System.out.println(ans);
    }
}