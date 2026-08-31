import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sarthakmanna
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        FastWriter out = new FastWriter(outputStream);
        D1SubmarineInTheRybinskSeaEasyEdition solver = new D1SubmarineInTheRybinskSeaEasyEdition();
        solver.solve(1, in, out);
        out.close();
    }

    static class D1SubmarineInTheRybinskSeaEasyEdition {
        final long MOD = 998244353l;

        public void solve(int testNumber, FastReader in, FastWriter out) {
            int i, j, k;

            int N = in.nextInt();
            String[] A = new String[N];
            for (i = 0; i < N; ++i) A[i] = in.next();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (String itr : A) map.put(itr.length(), map.getOrDefault(itr.length(), 0) + 1);


            long[] ans = new long[30];
            for (String s : A) {
                for (i = s.length() - 1; i >= 0; --i) {
                    long digi = s.charAt(i) - '0';
                    for (j = 1; j < 15; ++j) {
                        int p1 = ans.length - pos1(s.length() - i, j);
                        ans[p1] = (ans[p1] + digi * map.getOrDefault(j, 0)) % MOD;

                        int p2 = ans.length - pos2(j, s.length() - i);
                        ans[p2] = (ans[p2] + digi * map.getOrDefault(j, 0)) % MOD;

                        //int l1 = s.length() - i, l2 = j;
                        //System.out.println(l1 + " " + l2 + " = " + pos1(l1, l2) + " " + pos2(l1, l2));
                    }
                }
            }

            long ret = 0;

            long offset = 1;
            for (i = ans.length - 1; i >= 0; --i) {
                ret += ans[i] * offset % MOD;
                ret %= MOD;

                offset = offset * 10 % MOD;
            }
            out.println(ret);

            out.flush();
        }

        int pos1(int len1, int len2) {
            boolean indi = true;
            for (int i = 1; ; ++i) {
                if (indi) {
                    if (len2 > 0) --len2;
                    else if (--len1 <= 0) return i;
                } else {
                    if (--len1 <= 0) return i;
                }
                indi = !indi;
            }
        }

        int pos2(int len1, int len2) {
            boolean indi = true;
            for (int i = 1; ; ++i) {
                if (indi) {
                    if (--len2 <= 0) return i;
                } else {
                    if (len1 > 0) --len1;
                    else if (--len2 <= 0) return i;
                }
                indi = !indi;
            }
        }

    }

    static class FastWriter {
        static private BufferedWriter bw;

        public FastWriter(OutputStream os) {
            bw = new BufferedWriter(new OutputStreamWriter(os));
        }

        public FastWriter(Writer w) {
            bw = new BufferedWriter(w);
        }

        public void print(Object a) {
            try {
                bw.write(a.toString());
            } catch (Exception e) {
            }
        }

        public void println(Object a) {
            print(a);
            print("\n");
        }

        public void flush() {
            try {
                bw.flush();
            } catch (Exception e) {
            }
        }

        public void close() {
            try {
                bw.close();
            } catch (Exception e) {
            }
        }

    }

    static class FastReader {
        static private byte[] buf = new byte[2048];
        static private int index;
        static private int total;
        static private InputStream in;

        public FastReader(InputStream is) {
            try {
                in = is;
            } catch (Exception e) {
            }
        }

        private int scan() {
            try {
                if (index >= total) {
                    index = 0;
                    total = in.read(buf);
                    if (total <= 0)
                        return -1;
                }
                return buf[index++];
            } catch (Exception e) {
                return 7 / 0;
            }
        }

        public String next() {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan())
                sb.append((char) c);
            return sb.toString();
        }

        public int nextInt() {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
                c = scan();
            for (; c >= '0' && c <= '9'; c = scan())
                val = (val << 3) + (val << 1) + (c & 15);
            return neg ? -val : val;
        }

    }
}

