import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static boolean bigEnough(int w, int t, int[] distance) {
        long time = 0;
        for (int aDistance : distance)
            if (aDistance > w)
                return false;
            else if (w >= 2 * aDistance)
                time += aDistance;
            else
                time += 3 * aDistance - w;
        return time <= t;
    }


    static int binary(int left, int right, int t, int[] distance) {
        while (right - left > 1) {
            int w = (left + right) / 2;
            if (bigEnough(w, t, distance))
                right = w;
            else
                left = w;
        }
        return right;
    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();

        int[] ci = new int[n];
        int[] vi = new int[n];

        int vmax = 0;
        for (int i = 0; i < n; i++) {
            ci[i] = in.nextInt();
            vi[i] = in.nextInt();
            vmax = Math.max(vi[i], vmax);
        }

        int g[] = new int[k];

        for (int i = 0; i < k; i++) {
            g[i] = in.nextInt();
        }
        Arrays.sort(g);
        int distance[] = new int[k + 1];
        distance[0] = g[0];
        for (int i = 1; i < k; i++) {
            distance[i] = g[i] - g[i - 1];
        }
        distance[k] = s - g[k - 1];

        if (!bigEnough(vmax, t, distance)) {
            System.out.println(-1);
            return;
        }
        int w = binary(0, vmax, t, distance);

        int cmin = -1;

        for (int i = 0; i < n; i++) {
            if (vi[i] >= w && (cmin == -1 || cmin > ci[i])) {
                cmin = ci[i];
            }
        }
        System.out.println(cmin);

    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
