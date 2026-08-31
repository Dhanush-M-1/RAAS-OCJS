
import java.io.*;

public class C {

    static StreamTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int n = ri();
        String s = rs();
        int[][] dp = new int[n + 1][26];
        for (int i = 1; i <= n; ++i) {
            System.arraycopy(dp[i - 1], 0, dp[i], 0, 26);
            ++dp[i][s.charAt(i - 1) - 'a'];
        }
        int[][] sol = new int[n + 1][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    int len = k - j + 1;
                    int currCharFreq = dp[k][i] - dp[j - 1][i];
                    sol[(len - currCharFreq)][i] = Integer.max(len, sol[(len - currCharFreq)][i]);
                }
            }
        }
        int q = ri();
        while (q-- > 0) {
            int k = ri();
            char c = rs().charAt(0);
            out.println((sol[k][c - 'a']) == 0 ? n : sol[k][c - 'a']);
        }
        out.close();
    }

    static int ri() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static String rs() throws IOException {
        st.nextToken();
        return st.sval;
    }
}
