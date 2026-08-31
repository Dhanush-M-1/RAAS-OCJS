import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class SolutionD extends Thread {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                                            InputStreamReader(in));
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
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
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

    private static final FastReader scanner = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Thread(null, new SolutionD(), "Main", 1 << 28).start();
    }

    public void run() {
        solve();
        out.close();
    }

    static final int MODULO = 998_244_353;

    private static void solve() {
        long[] pow10 = new long[22];
        pow10[0] = 1;
        for (int i = 1; i < 22; i++) {
            pow10[i] = (10 * pow10[i-1]) % MODULO;
        }

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] lengths = new int[11];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            lengths[String.valueOf(a[i]).length()]++;
        }

        long result = 0;
        for (int ai: a) {
            String s = String.valueOf(ai);
            int length = s.length();
            for (int lengthOfOtherNumber = 1; lengthOfOtherNumber <= 10; lengthOfOtherNumber++) {
                long tmp = 0;

                int pointer = 0;
                for (int i = 0; i < length; i++) {
                    tmp += (s.charAt(length - 1 - i) - '0') * pow10[pointer];
                    if (pointer / 2 >= lengthOfOtherNumber) {
                        pointer++;
                    } else {
                        pointer += 2;
                    }
                }

                pointer = 1;
                for (int i = 0; i < length; i++) {
                    tmp += (s.charAt(length - 1 - i) - '0') * pow10[pointer];
                    if ((pointer + 1) / 2 >= lengthOfOtherNumber) {
                        pointer++;
                    } else {
                        pointer += 2;
                    }
                }

                tmp *= lengths[lengthOfOtherNumber];
                tmp %= MODULO;
                result += tmp;
                result %= MODULO;


            }
        }

        out.println(result);
    }
}
