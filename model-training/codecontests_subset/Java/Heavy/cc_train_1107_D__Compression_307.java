import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class MainS {
    static final long MOD = 1_000_000_007, INF = 1_000_000_000_000_000_000L;
    static final int INf = 1_000_000_000;
    static FastReader reader;
    static PrintWriter writer;
    public static void main(String[] args) {
        Thread t = new Thread(null, new O(), "Integer.MAX_VALUE", 100000000);
        t.start();
    }
    static class O implements Runnable {
        public void run() {
            try {
                magic();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    static int n;
    static int c[][];
    static int dp[][];
    static void magic() throws IOException {
        reader = new FastReader();
        writer = new PrintWriter(System.out, true);
        n = reader.nextInt();
        c = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;++i) {
            Arrays.fill(dp[i], n);
        }
        int l = (n/4);
        for(int i=0;i<n;++i) {
            String s = reader.next();
            int idx = n-1;
            for(int j=l-1;j>=0;--j) {
                char cc = s.charAt(j);
                int val;
                if(Character.isAlphabetic(cc)) {
                    val = 9+(cc-'A'+1);
                }
                else {
                    val = cc-'0';
                }
                c[i][idx--] = (val&1);
                val>>=1;
                c[i][idx--] = (val&1);
                val>>=1;
                c[i][idx--] = (val&1);
                val>>=1;
                c[i][idx--] = (val&1);
            }
        }
        for(int i=0;i<n;++i) {
            int next = 0;
            for(int j=n-1;j>=0;--j) {
                if(j+1<n && c[i][j]==c[i][j+1]) {
                    next++;
                    dp[i][j] = min(dp[i][j], next);
                }
                else {
                    next = 1;
                    dp[i][j] = min(dp[i][j], next);
                }
            }
        }
        for(int col=0;col<n;++col) {
            int next = 0;
            for(int row=n-1;row>=0;--row) {
                if(row+1<n && c[row+1][col]==c[row][col]) {
                    next++;
                    dp[row][col] = min(dp[row][col], next);
                }
                else {
                    next = 1;
                    dp[row][col] = min(dp[row][col], next);
                }
            }
        }
        for(int i=n-1;i>=0;--i) {
            for(int j=n-1;j>=0;--j) {
                if(i+1<n && j+1<n && c[i][j]==c[i+1][j+1]) {
                    dp[i][j] = min(dp[i][j] , 1+dp[i+1][j+1]);
                }
                else {
                    dp[i][j] = 1;
                }
            }
        }
//        for(int i=0;i<n;++i) {
//            for(int j=0;j<n;++j) {
//                writer.print(dp[i][j]+" ");
//            }
//            writer.println();
//        }
        int max = 0;
        for(int i=1;i<=n;++i) {
            if(n%i==0 && possible(i)) {
                max = i;
            }
        }
        writer.println(max);
    }
    static boolean possible(int x) {
        for(int i=0;i<n;i+=x) {
            for(int j=0;j<n;j+=x) {
                if(dp[i][j]<x) {
                    return false;
                }
            }
        }
        return true;
    }
}