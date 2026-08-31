//package div3._1374;

import java.io.*;
import java.util.*;

public class ReadingBooksEasyVersion {

    private final FastReader fr = new FastReader();

    public static void main(String[] args) {
        new ReadingBooksEasyVersion().solve();
    }

    private void solve() {
        int n = fr.nextInt();
        int k = fr.nextInt();
        List<Integer>[] times = new ArrayList[3];
        List<Integer>[] sums = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            times[i] = new ArrayList<>();
            sums[i] = new ArrayList<>();
        }
        while (n-- > 0) {
            int ti = fr.nextInt();
            int a = fr.nextInt();
            int b = fr.nextInt();

            if (a==b && b==0) continue;
            times[a * 2 + b - 1].add(ti);
        }

        for (int i = 0; i < 3; i++) {
            Collections.sort(times[i]);
            sums[i].add(0);
            for (int item : times[i]) {
                sums[i].add(sums[i].get(sums[i].size() - 1) + item);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int count = 0; count < Math.min(k + 1, sums[2].size()); count++) {
            if (k - count < sums[0].size() && k - count < sums[1].size()) {
                ans = Math.min(ans, sums[2].get(count) + sums[0].get(k - count) + sums[1].get(k - count));
            }
        }

        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    class FastReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
