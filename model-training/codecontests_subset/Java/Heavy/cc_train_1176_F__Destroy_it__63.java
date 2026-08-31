import java.io.*;
import java.util.StringTokenizer;

public class F {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[][] damage = new int[n][5];
        for(int i = 0; i < n; ++i) {
            int k = sc.nextInt();
            while(k-->0) {
                int x = sc.nextInt(), y = sc.nextInt();
                if (x == 1) {
                    damage[i][0] = Math.max(damage[i][0], y);
                    for(int j = 0; j < 2; ++j)
                        if(damage[i][j] > damage[i][j + 1]) {
                            int tmp = damage[i][j];
                            damage[i][j] = damage[i][j + 1];
                            damage[i][j + 1] = tmp;
                        }
                } else
                    damage[i][x + 1] = Math.max(damage[i][x + 1], y);
            }
        }
        long[][] dp = new long[n + 1][10];
        for(int i = n - 1; i >= 0; --i)
            for(int mod = 0; mod < 10; ++mod) {
                long opt = dp[i + 1][mod];
                // 3 or 2 or 1
                long maxOne = getMax(damage[i][4], damage[i][3], damage[i][2]);
                if(maxOne != 0)
                    opt = Math.max(opt, dp[i + 1][(mod + 1) % 10] + maxOne * (mod == 9 ? 2 : 1));

                // 2 1
                if(damage[i][3] != 0 && damage[i][2] != 0)
                    opt = Math.max(opt, dp[i + 1][(mod + 2) % 10] + damage[i][3] + damage[i][2] + (mod >= 8 ? getMax(damage[i][3], damage[i][2]): 0));

                // 1 1
                if(damage[i][1] != 0 && damage[i][2] != 0)
                    opt = Math.max(opt, dp[i + 1][(mod + 2) % 10] + damage[i][1] + damage[i][2] + (mod >= 8 ? getMax(damage[i][1], damage[i][2]): 0));

                // 1 1 1
                long sumOnes = 0;
                boolean valid = true;
                for(int j = 0; j < 3; ++j) {
                    sumOnes += damage[i][j];
                    valid &= damage[i][j] != 0;
                }
                if(valid)
                    opt = Math.max(opt, dp[i + 1][(mod + 3) % 10] + sumOnes + (mod >= 7 ? getMax(damage[i][0], damage[i][1], damage[i][2]) : 0));
                dp[i][mod] = opt;
            }
        out.println(dp[0][0]);
        out.close();
    }

    static int getMax(int...x) {
        int max = 0;
        for(int y: x)
            max = Math.max(max, y);
        return max;
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException {return br.ready();}


    }
}