import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        init();
        String stringN = next();
        int K = nextInt();
        int length = stringN.length();
        if (K > length) {
            System.out.println(0);
            return;
        }
        long ans = 0;
        for (int n = K; n < length; n++) {
            int mul = (int) Math.pow(9, K - 1);
            ans += 9 * choose(n - 1, K - 1) * mul;
        }
        int rem = K - 1;
        for (int i = 1; i < 10; i++) {
            if (i > stringN.charAt(0) - '0') break;
            boolean less = i < stringN.charAt(0) - '0';
            if (rem == 0) ans++;
            else if (rem == 1) {
                for (int j = 1; j < length; j++) {
                    int jUp = 9;
                    if (!less) jUp = stringN.charAt(j) - '0';
                    ans += jUp;
                    less = less || (stringN.charAt(j) - '0' > 0);
                }
            } else {
                for (int j = 1; j < length; j++) {
                    int jUp = 9;
                    if (!less) jUp = stringN.charAt(j) - '0';
                    for (int jj = 1; jj <= jUp; jj++) {
                        boolean nowLess = less || jj < stringN.charAt(j) - '0';
                        for (int k = j + 1; k < length; k++) {
                            int kUp = 9;
                            if (!nowLess) kUp = stringN.charAt(k) - '0';
                            ans += kUp;
                            nowLess = nowLess || (stringN.charAt(k) - '0' > 0);
                        }
                    }
                    less = less || (stringN.charAt(j) - '0' > 0);
                    // 117857916
                }
            }
        }

        System.out.println(ans);
    }

    private static long choose(int n, int k) {
        long ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= (n - i);
        }
        long fac = 1;
        for (int i = 1; i <= k; i++) {
            fac *= i;
        }
        ans /= fac;
        return ans;
    }

    //Input Reader
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}