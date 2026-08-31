import java.util.*;
import java.io.*;
 
public class Main {
    static boolean[][] used;
    static int[] ans;
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        String s = sc.next();
        int len = s.length();
        int k = sc.nextInt();
        long[][][] dp = new long[len+1][k+1][2];
        dp[0][0][0] = 1;
        for(int i = 1; i <= len; i++){
            int next = s.charAt(i-1) - '0';
            for(int j = 0; j <= k; j++){
                dp[i][j][1] = dp[i-1][j][1];
                if(j > 0){
                    dp[i][j][1] += dp[i-1][j-1][1] * 9;
                }
                if(next == 0){
					dp[i][j][0] = dp[i-1][j][0];
				}else{
					dp[i][j][1] += dp[i-1][j][0];
					if(j > 0) {
						dp[i][j][0] = dp[i-1][j-1][0];
						dp[i][j][1] += dp[i-1][j-1][0] * (next-1);
					}
				}
            }
        }
        System.out.println(dp[len][k][0] + dp[len][k][1]);
    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;
    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
         return Double.parseDouble(next());
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    } 
}
