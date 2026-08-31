import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
    private static int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] aa = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] cc = br.readLine().toCharArray();
            for (int j = 0; j < n / 4; j++) {
                char c = cc[j];
                int a = c >= 'A' ? c - 'A' + 10 : c - '0';
                for (int h = 0; h < 4; h++) {
                    aa[i][j * 4 + h] = (a >> (3 - h)) & 1;
                }
            }
        }
        boolean[] mark = new boolean[n];
        for (int i=1; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (aa[i][j]!=aa[i-1][j] || aa[j][i]!=aa[j][i-1]) {
                    mark[i] = true;
                }
            }
        }
        int res = n;
        for (int i=0; i<n; i++) {
            if (mark[i]) res = gcd(i, res);
        }
        System.out.println(res);
    }
}