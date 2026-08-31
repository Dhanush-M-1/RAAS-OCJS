
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CReducingFractions solver = new CReducingFractions();
        solver.solve(1, in, out);
        out.close();
    }

    static class CReducingFractions {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            long dp[][] = new long[n + 1][10];
            for (long ar[] : dp) Arrays.fill(ar, Long.MIN_VALUE / 2);

            for (int i = 0; i < n; i++) {
                ArrayList<Long>[] arrayList = new ArrayList[3];
                for (int j = 0; j < 3; j++) arrayList[j] = new ArrayList<>();

                int k = in.scanInt();
                for (int j = 0; j < k; j++) {
                    int c = in.scanInt() - 1;
                    long p = in.scanInt();
                    arrayList[c].add(p);
                }

                ArrayList<Pair> arrayList1 = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Collections.sort(arrayList[j], new Comparator<Long>() {
                        @Override
                        public int compare(Long o1, Long o2) {
                            return Long.compare(o2.longValue(), o1.longValue());
                        }
                    });
                    if (j == 0) {
                        for (int l = 0; l < arrayList[j].size() && l < 3; l++) {
                            arrayList1.add(new Pair(j + 1, arrayList[j].get(l)));
                        }
                    } else if (j == 1) {
                        for (int l = 0; l < arrayList[j].size() && l < 1; l++) {
                            arrayList1.add(new Pair(j + 1, arrayList[j].get(l)));
                        }
                    } else {
                        for (int l = 0; l < arrayList[j].size() && l < 1; l++) {
                            arrayList1.add(new Pair(j + 1, arrayList[j].get(l)));
                        }
                    }
                }


                for (int j = 0; j < (1 << arrayList1.size()); j++) {
                    long sum = 0;
                    long max = 0;
                    long cost = 0;
                    int count = 0;
                    for (int l = 0; l < arrayList1.size(); l++) {
                        if ((j & (1 << l)) != 0) {
                            sum += arrayList1.get(l).p;
                            max = Math.max(arrayList1.get(l).p, max);
                            cost += arrayList1.get(l).c;
                            count++;
                        }
                    }
                    if (cost > 3) continue;


                    if (i == 0) {
                        dp[0][count] = Math.max(dp[0][count], sum);
                    } else {
                        for (int l = 0; l < 10; l++) {
                            if (l + count >= 10) {
                                dp[i][(l + count) % 10] = Math.max(dp[i][(l + count) % 10], dp[i - 1][l] + max + sum);
                            } else {
                                dp[i][(l + count)] = Math.max(dp[i][(l + count)], dp[i - 1][l] + sum);
                            }
                        }
                    }

                }
            }


            long ans = 0;
            for (int i = 0; i < 10; i++) ans = Math.max(ans, dp[n - 1][i]);
            out.println(ans);
        }

        public class Pair {
            int c;
            long p;

            public Pair(int c, long p) {
                this.c = c;
                this.p = p;
            }
        }


    }

    static class CodeX {
        public static long power(long x, long y) {
            long res = 1;
            while (y > 0) {
                if ((y & 1) != 0)
                    res = (res * x);
                y = y >> 1;
                x = (x * x);
            }
            return res;
        }

        public static int[] SPF(int MAXN) {
            int[] spf = new int[MAXN + 5];
            spf[1] = 1;
            for (int i = 2; i < MAXN; i++) spf[i] = i;
            for (int i = 4; i < MAXN; i += 2) spf[i] = 2;
            for (int i = 3; i * i < MAXN; i++) {
                if (spf[i] == i) {
                    for (int j = i * i; j < MAXN; j += i)
                        if (spf[j] == j)
                            spf[j] = i;
                }
            }
            return spf;
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public void scanInt(int[] A) {
            for (int i = 0; i < A.length; i++) A[i] = scanInt();
        }

    }
}
