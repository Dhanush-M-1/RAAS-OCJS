import java.io.*;
import java.util.*;


public class Main{
    static long MOD = 1000000007;
    static long dp[] = new long[1 << 21];
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------
        long MOD = 1000000007;
        int t = sc.nextInt();
        //int t = 1;
        while(t -- > 0)
        {
            boolean mod = false;
            long n = sc.nextInt();
            long l = sc.nextLong(), r = sc.nextLong();
            if(l == n * (n - 1) + 1) {
                out.println(1);
            }
            else {
                if (r == n * (n - 1) + 1) {
                    r--;
                    mod = true;
                }
                long[] res = solve(n, l, r);
                for (int i = 0; i < res.length; i++)
                    out.print(res[i] + " ");
                if (mod) out.print(1);
                out.println("");
            }
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }


    private static long[] solve(long n, long l, long r) {
        long [] res = new long[(int)(r - l + 1)];
        long sum = 0l, ind = 0l;
        while(sum < l)
        {
            sum += 2 * (n - ind - 1);
            ind++;
        }
        sum -= 2 * (n - ind);
        l -= sum + 1;
        r -= sum + 1;
        sum = 0;
        ArrayList <Long> list = new ArrayList();
        for(; ind < n && sum <= r; ind++)
        {
            for(long j = ind + 1; j <= n; j++)
            {
                list.add(ind);
                list.add(j);
            }
            sum += 2 * (n - ind - 1);
        }

        int ll = (int) l;
        //System.out.println(l + " " + r + " " + sum + " " +  list);
        for(int x = 0; x <= r - l; x++)
        {
            res[x] = list.get(x + ll);
        }
        return res;
    }
    private static int dfs(int[][] dp, int x, int st, boolean op, char[] c) {
        if (x >= c.length) return st == 11 ? 0 : 1;
        if (!op && dp[x][st] != -1) return dp[x][st];
        int maxx = op ? c[x] - '0' : 9, res = 0;
        for(int i = 0; i <= maxx; i++)
        {
            if(st != 11 && Math.abs(st - i) >= 2) continue;
            if(st == 11 && i == 0)
                res += dfs(dp, x - 1, 11, op && (i == maxx), c);
            else
                res += dfs(dp, x - 1, i, op && (i == maxx), c);
        }
        if(!op) dp[x][st] = res;
        return res;
    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    //-----------MyScanner class for faster input----------
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
    //--------------------------------------------------------
}