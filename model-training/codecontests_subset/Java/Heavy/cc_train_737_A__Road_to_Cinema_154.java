//package olymp_prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Максим on 26.12.2016.
 */
public class C729 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String raw[] = in.readLine().split(" ");
        int n = Integer.parseInt(raw[0]);
        int k = Integer.parseInt(raw[1]);
        int s = Integer.parseInt(raw[2]);
        int t = Integer.parseInt(raw[3]);
        int c[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            raw = in.readLine().split(" ");
            c[i] = Integer.parseInt(raw[0]);
            v[i] = Integer.parseInt(raw[1]);
        }
        raw = in.readLine().split(" ");
        int g[] = new int[k + 2];
        int len = k + 2;
        g[0] = 0;
        for (int i = 1; i < len - 1; i++) {
            g[i] = Integer.parseInt(raw[i - 1]);
        }
        g[len - 1] = s;
        Arrays.sort(g);
        int dists[] = new int[len];
        dists[0] = 0;
//        System.out.println(Arrays.toString(g));
        for (int i = 1; i < dists.length; i++) {
            dists[i] = g[i] - g[i - 1];
        }
        Arrays.sort(dists);
        int d[] = new int[dists.length];
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += dists[i];
            d[i] = sum;
        }
        int minC = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // det what is fast only
            if (dists[dists.length - 1] > v[i]) continue;
            int fast = 0;
            int slow = 0;
            int first = binarySearch(dists, v[i] / 2);
//            System.out.println("first = " + first);
//            System.out.println("v[i] / 2 = " + v[i] / 2);
//            System.out.println(Arrays.toString(dists));
            fast += d[first];
//            System.out.println("d[first] = " + d[first]);
            // det what is fast and slow
            int second = binarySearch(dists, v[i]);
            int tmp = (second - first) * v[i] - (d[second] - d[first]);
//            System.out.println("(dists[second] - dists[first]) = " + (dists[second] - dists[first]));
//            System.out.println("tmp = " + tmp);
//            System.out.println("second = " + second);
            fast += tmp;
            slow += d[second] - d[first] - tmp;
            slow += dists[dists.length - 1] - dists[second];
//            System.out.println("fast = " + fast);
//            System.out.println("slow = " + slow);
            int curT = slow * 2 + fast;
            if (curT <= t) {
                minC = Math.min(minC, c[i]);
            }
//            System.out.println("curT = " + curT);
            // rest what is slow only
        }
        if (minC != Integer.MAX_VALUE) {
            System.out.println(minC);
        } else {
            System.out.println("-1");
        }
    }
    public static int binarySearch(int a[], int tar) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (tar >= a[m]) {
                l = m;
            } else {
                r = m - 1;
            }
            if (r == l + 1) {
                if (tar >= a[r]) {
                    l = r;
                } else {
                    r = l;
                }
            }
        }
        return l;
    }
}
