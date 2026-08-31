import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        long[] res = new long[2000001];
        boolean[] yellow = new boolean[2000001];
        int mod = 1000000007;
        for (int i=3; i<2000001; i++) {
            res[i] = res[i-2] + res[i-2] + res[i-1];
            if (!yellow[i-1] && !yellow[i-2]) {
                res[i]+=4; yellow[i] = true;
            }
            res[i]%=mod;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder ans = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(reader.readLine());
            ans.append(res[n]).append("\n");
        }
        System.out.println(ans);
    }
}