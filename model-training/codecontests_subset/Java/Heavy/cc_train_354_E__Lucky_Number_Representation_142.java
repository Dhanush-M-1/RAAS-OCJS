import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    static int[][] dp;
    static int[][] step;
    static char[] digits;

    public static int f(int i, int c) {
        if (i == -1)
            return c == 0 ? 1 : 0;
        if (dp[i][c] != -1)
            return dp[i][c];
        int ret = 0;
        for (int a = 0; a <= 6 && ret == 0; a++) {
            for (int b = 0; a + b <= 6 && ret == 0; b++) {
                int have = a * 4 + b * 7 + c;
                if (have % 10 + '0' == digits[i]) {
                    ret |= f(i - 1, have / 10);
                    if (ret == 1)
                        step[i][c] = a << 4 | b;
                }
            }
        }
        return dp[i][c] = ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strtok;
        strtok = new StringTokenizer(in.readLine());
        int tc = Integer.parseInt(strtok.nextToken());
        while (tc-- > 0) {
            long v = Long.parseLong(in.readLine());
            digits = (v + "").toCharArray();
            dp = new int[digits.length][5];
            step = new int[digits.length][5];
            for (int[] a : dp)
                Arrays.fill(a, -1);
            if (f(digits.length - 1, 0) == 0) {
                System.out.println(-1);
            } else {
                char[][] results = new char[6][digits.length];
                int c = 0;
                for (int i = digits.length - 1; i >= 0; i--) {
                    int a = step[i][c] >> 4;
                    int b = step[i][c] & 0xF;
                    for (int j = 0; j < a; j++)
                        results[j][i] = '4';
                    for (int j = a; j < a + b; j++)
                        results[j][i] = '7';
                    for (int j = a + b; j < 6; j++)
                        results[j][i] = '0';
                    c = (c + a * 4 + b * 7) / 10;
                }
                for (int i = 0; i < results.length; i++)
                    System.out.print(Long.parseLong(new String(results[i]))
                            + " ");
                System.out.println();
            }
        }
    }
}
