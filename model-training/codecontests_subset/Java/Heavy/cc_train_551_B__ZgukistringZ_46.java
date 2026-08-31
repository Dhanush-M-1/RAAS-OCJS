/**
 * Created by brzezinsky on 08/06/15.
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Solution extends Thread{
    public Solution(String inputFileName, String outputFileName) {
        try {
            if (inputFileName != null) {
                this.input = new BufferedReader(new FileReader(inputFileName));
            } else {
                this.input = new BufferedReader(new InputStreamReader(System.in));
            }
            if (outputFileName != null) {
                this.output = new PrintWriter(outputFileName);
            } else {
                this.output = new PrintWriter(System.out);
            }
            this.setPriority(Thread.MAX_PRIORITY);
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        }
    }

    private static boolean check(int []a, int []b, int times) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < b[i] * times) {
                return false;
            }
        }
        return true;
    }

    private static void doit(int []a, int []b, int times) {
        for (int i = 0; i < a.length; ++i) {
            a[i] -= b[i] * times;
        }
    }

    private void solve() throws Throwable {
        String a = next(), b = next(), c = next();
        int []cntA = new int[26], cntB = new int[26], cntC = new int[26];
        for (char x : a.toCharArray()) {
            ++cntA[x - 'a'];
        }
        for (char x : b.toCharArray()) {
            ++cntB[x - 'a'];
        }
        for (char x : c.toCharArray()) {
            ++cntC[x - 'a'];
        }

        int B = 0, C = 0, total = 0;
        for (int i = 0; i <= a.length() / b.length(); ++i) {
            int []tmp = cntA.clone();
            if (check(tmp, cntB, i)) {
                doit(tmp, cntB, i);
                int curC = Integer.MAX_VALUE;
                for (int j = 0; j < 26; ++j) {
                    if (cntC[j] != 0) {
                        curC = Math.min(curC, tmp[j] / cntC[j]);
                    }
                }
                if (i + curC > total) {
                    total = i + curC;
                    B = i;
                    C = curC;
                }
            }
        }
        doit(cntA, cntB, B);
        doit(cntA, cntC, C);
        for (int i = 0; i < B; ++i) output.print(b);
        for (int i = 0; i < C; ++i) output.print(c);
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < cntA[i]; ++j) {
                output.print((char)('a' + i));
            }
        }

    }

    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.close();
        }
    }

    public static void main(String... args) {
        new Solution(null, null).start();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private String next() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    private StringTokenizer tokens;
    private BufferedReader input;
    private PrintWriter output;
}