import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[][] fss;
    int[][] pss;

    public static void main(String args[]) {
        new Main().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        fss = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                fss[i][j] = sc.nextInt();
            }
        }
        pss = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10; j++) {
                pss[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        int[] states = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                states[i] <<= 1;
                states[i] |= fss[i][j];
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < 1 << 10; i++) {
            int profit = 0;
            for (int j = 0; j < n; j++) {
                int overlap = Integer.bitCount(i & states[j]);
                profit += pss[j][overlap];
            }
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        System.out.println(maxProfit);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
