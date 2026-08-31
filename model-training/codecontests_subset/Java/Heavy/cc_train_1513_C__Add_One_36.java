import java.io.*;

public class AddOne {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int max_n = 200005;
        int mod = 1000000007;
        int[] dp = new int[max_n];
        for (int i = 0; i < 9; i++) {
            dp[i] = 2;
        }
        dp[9] = 3;
        for (int j = 10; j < max_n; j++) {
            dp[j] = (dp[j - 9] + dp[j - 10]) % mod;
        }

        while (t-- > 0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int cnt = 0;
            while (n > 0) {
                int x = n % 10;
                cnt += ((m + x < 10) ? 1 : dp[m + x - 10]);
                cnt %= mod;
                n /= 10;
            }
            log.write(cnt + "\n");;
            log.flush();
        }
    }

}
