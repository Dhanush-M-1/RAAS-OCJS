import java.io.*;
import java.util.*;

public class F_DestroyIt {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
    }

    private static class Solver {
        Comparator<Long> custom = (o1, o2) -> -Long.compare(o1, o2);

        private long sum(ArrayList<Long> array) {
            long res = 0;
            for (long value: array) res += value;
            return res;
        }

        private long[][] dp;

        private long damage(int i, int j, int k, ArrayList<Long> damages) {
            long damage = dp[i-1][j];
            if (j + k >= 10) damage += damages.get(0);
            return damage;
        }

        private void solve(InputReader inp, PrintWriter out) {
            int n = inp.nextInt();
            dp = new long[n][10];
            for (long[] array: dp) Arrays.fill(array, -1);
            for (int i = 0; i < n; i++) {
                ArrayList<Long>[] costs = new ArrayList[] {
                        new ArrayList(),
                        new ArrayList(),
                        new ArrayList(),
                        new ArrayList()
                };
                int k = inp.nextInt();
                for (int j = 0; j < k; j++) {
                    int cost = inp.nextInt();
                    long damage = inp.nextInt();
                    costs[cost].add(damage);
                }
                for (ArrayList<Long> array: costs) Collections.sort(array, custom);

                ArrayList<Long>[] cards = new ArrayList[7];
                for (int j = 0; j < 7; j++) cards[j] = new ArrayList<>();
                // 1
                if (costs[1].size() > 0) {
                    cards[1].add(costs[1].get(0));
                }
                // 1,1
                if (costs[1].size() > 1) {
                    cards[2].add(costs[1].get(0));
                    cards[2].add(costs[1].get(1));
                }
                // 1,1,1
                if (costs[1].size() > 2) {
                    cards[3].add(costs[1].get(0));
                    cards[3].add(costs[1].get(1));
                    cards[3].add(costs[1].get(2));
                }
                // 1,2
                if (costs[1].size() > 0 && costs[2].size() > 0) {
                    cards[4].add(costs[1].get(0));
                    cards[4].add(costs[2].get(0));
                }
                // 2
                if (costs[2].size() > 0) {
                    cards[5].add(costs[2].get(0));
                }
                // 3
                if (costs[3].size() > 0) {
                    cards[6].add(costs[3].get(0));
                }
                for (ArrayList<Long> array: cards) Collections.sort(array, custom);

                if (i == 0) {
                    dp[0][0] = 0;

                    if (!cards[1].isEmpty()) dp[0][1] = Math.max(dp[0][1], sum(cards[1]));
                    if (!cards[5].isEmpty()) dp[0][1] = Math.max(dp[0][1], sum(cards[5]));
                    if (!cards[6].isEmpty()) dp[0][1] = Math.max(dp[0][1], sum(cards[6]));

                    if (!cards[2].isEmpty()) dp[0][2] = Math.max(dp[0][2], sum(cards[2]));
                    if (!cards[4].isEmpty()) dp[0][2] = Math.max(dp[0][2], sum(cards[4]));

                    if (!cards[3].isEmpty()) dp[0][3] = sum(cards[3]);
                    continue;
                }
                for (int j = 0; j < 10; j++) {
                    if (dp[i-1][j] == -1) continue;
                    // -
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                    // 1
                    if (cards[1].size() == 1) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[1]);
                        if (j + 1 >= 10) damage += cards[1].get(0);
                        dp[i][(j+1)%10] = Math.max(dp[i][(j+1)%10], damage);
                    }
                    // 1,1
                    if (cards[2].size() == 2) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[2]);
                        if (j + 2 >= 10) damage += cards[2].get(0);
                        dp[i][(j+2)%10] = Math.max(dp[i][(j+2)%10], damage);
                    }
                    // 1,1,1
                    if (cards[3].size() == 3) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[3]);
                        if (j + 3 >= 10) damage += cards[3].get(0);
                        dp[i][(j+3)%10] = Math.max(dp[i][(j+3)%10], damage);
                    }
                    // 1,2
                    if (cards[4].size() == 2) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[4]);
                        if (j + 2 >= 10) damage += cards[4].get(0);
                        dp[i][(j+2)%10] = Math.max(dp[i][(j+2)%10], damage);
                    }
                    // 2
                    if (cards[5].size() == 1) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[5]);
                        if (j + 1 >= 10) damage += cards[5].get(0);
                        dp[i][(j+1)%10] = Math.max(dp[i][(j+1)%10], damage);
                    }
                    // 3
                    if (cards[6].size() == 1) {
                        long damage = dp[i-1][j];
                        damage += sum(cards[6]);
                        if (j + 1 >= 10) damage += cards[6].get(0);
                        dp[i][(j+1)%10] = Math.max(dp[i][(j+1)%10], damage);
                    }
                }
            }
            long max = -1;
            for (long value: dp[n-1]) max = Math.max(value, max);
            out.println(max);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}