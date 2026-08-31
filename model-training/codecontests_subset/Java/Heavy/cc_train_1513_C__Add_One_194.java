
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        FastReader sc=new FastReader();
        StringBuilder fout = new StringBuilder();
        int t = sc.nextInt();

        int max_n=200005;
        long dp[]=new long[max_n];
        for(int i=0; i<9; i++)dp[i] = 2;
        dp[9] = 3;
        for(int i=10; i<max_n; i++){
            dp[i] = (dp[i-9] + dp[i-10])%mod;
        }
        for (int l = 1; l <= t; l++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long ans=0;
            while(n > 0){
                int x = n%10;
                ans += ((m + x < 10) ? 1 : dp[m +x-10]);
                ans %= mod;
                n/=10;
            } n/=10;
            fout.append(ans).append("\n");

        }
        System.out.println(fout);
    }


    static void no() {
        System.out.println("No");
    }

    static void yes() {
        System.out.println("Yes");
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

        String nextLine() {
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
