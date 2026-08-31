import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
procrastinating
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int INF = (int) (1e9 + 10);
    static final int MOD = (int) (998244353);

    static class Pair {
        long max, sum;

        Pair(long max, long sum) {
            this.max = max;
            this.sum = sum;
        }
    }

    static Pair poll(long[][] arr, int k) {
        if (k == 1) {
            if (arr[1].length + arr[2].length + arr[3].length >= 1) {
                long max = 0;
                long sum = 0;
                if (arr[1].length >= 1) {
                    max = arr[1][0];
                    sum = arr[1][0];
                }
                if (arr[2].length >= 1 && arr[2][0] > max) {
                    max = arr[2][0];
                    sum = arr[2][0];
                }
                if (arr[3].length >= 1 && arr[3][0] > max) {
                    max = arr[3][0];
                    sum = arr[3][0];
                }
                return new Pair(max, sum);
            }

        } else if (k == 2) {
            if (arr[1].length >= 1 && arr[1].length + arr[2].length >= 2) {
                long max = arr[1][0];
                long sum = arr[1][0];
                if (arr[2].length == 0 || (arr[1].length >= 2 && arr[1][1] >= arr[2][0])) {
                    sum += arr[1][1];
                } else {
                    max = Math.max(max, arr[2][0]);
                    sum += arr[2][0];
                }
                return new Pair(max, sum);
            }

        } else if (k == 3) {
            if (arr[1].length >= 3) {
                long max = Math.max(arr[1][0], Math.max(arr[1][1], arr[1][2]));
                long sum = arr[1][0] + arr[1][1] + arr[1][2];
                return new Pair(max, sum);
            }
        }
        return null;
    }

    static void reverse(long[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int j = arr.length - 1 - i;
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static void solve() {
        int n = in.nextInt();

        long[][][] data = new long[n + 1][4][];
        for (int i = 1; i <= n; i++) {
            int k = in.nextInt();
            int[] cnt = new int[4];
            int[][] arr = new int[k][2];
            for (int j = 0; j < k; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
                cnt[arr[j][0]]++;
            }
            data[i][1] = new long[cnt[1]];
            data[i][2] = new long[cnt[2]];
            data[i][3] = new long[cnt[3]];
            cnt[1] = cnt[2] = cnt[3] = 0;
            for (int j = 0; j < k; j++) {
                data[i][arr[j][0]][cnt[arr[j][0]]++] = arr[j][1];
            }
            Arrays.sort(data[i][1]);
            reverse(data[i][1]);
            Arrays.sort(data[i][2]);
            reverse(data[i][2]);
            Arrays.sort(data[i][3]);
            reverse(data[i][3]);
        }

        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i - 1][j] != -1)
                    dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= 3; k++) {
                    Pair best = poll(data[i], k);
                    if (dp[i - 1][(j - k + 10) % 10] != -1 && best != null) {
                        long val = dp[i - 1][(j - k + 10) % 10] + best.sum;
                        if ((j - k + 10) % 10 > j)
                            val += best.max;
                        dp[i][j] = Math.max(dp[i][j], val);
                    }
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = Math.max(ans, dp[n][j]);
        }

        out.println(ans);

    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        in = new FastReader(System.in);
//        in = new FastReader(new FileInputStream("sometext.txt"));
        out = new PrintWriter(System.out);
//        out = new PrintWriter(new FileOutputStream("output.txt"));


        Thread thread = new Thread(null, () -> {
            int tests = 1;
//            tests = in.nextInt();

            while (tests-- > 0) {
                solve();
            }
        }, "Go", 1 << 28);
        thread.start();
        thread.join();


//        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}