import java.io.*;
import java.util.*;

public class codeforces702_G {
    private static void solve(FastIOAdapter ioAdapter) {
        int n = ioAdapter.nextInt();
        int m = ioAdapter.nextInt();
        int[] a = ioAdapter.readArray(n);

        long sum = 0;
        ArrayList<long[]> prefWithIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (prefWithIndex.isEmpty() || prefWithIndex.get(prefWithIndex.size() - 1)[0] < sum) {
                prefWithIndex.add(new long[] {sum, i});
            }
        }

        int[] x = ioAdapter.readArray(m);
        for (int i = 0; i < m; i++) {
            if (prefWithIndex.get(prefWithIndex.size() - 1)[0] < x[i] && sum <=0) {
                ioAdapter.out.print(-1 + " ");
            } else {
                long needTimes = 0;
                if (prefWithIndex.get(prefWithIndex.size() - 1)[0] < x[i]) {
                    needTimes = (x[i] - prefWithIndex.get(prefWithIndex.size() - 1)[0] + sum - 1) / sum;
                }
                x[i] -= needTimes * sum;
                int i1 = Collections.binarySearch(prefWithIndex, new long[]{x[i], -1}, Comparator.comparingLong(o -> o[0]));
                if (i1 < 0) {
                    i1 = -i1 - 1;
                }
                long res = needTimes * n + prefWithIndex.get(i1)[1];
                ioAdapter.out.print(res + " ");
            }
        }
        ioAdapter.out.println();
    }


    public static void main(String[] args) throws Exception {
        try (FastIOAdapter ioAdapter = new FastIOAdapter()) {
            int count = 1;
            count = ioAdapter.nextInt();
            while (count-- > 0) {
                solve(ioAdapter);
            }
        }
    }

    static class FastIOAdapter implements AutoCloseable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter((System.out))));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        @Override
        public void close() throws Exception {
            out.flush();
            out.close();
            br.close();
        }
    }
}