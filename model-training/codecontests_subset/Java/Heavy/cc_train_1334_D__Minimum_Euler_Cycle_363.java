import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Ribhav
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DMinimumEulerCycle solver = new DMinimumEulerCycle();
        solver.solve(1, in, out);
        out.close();
    }

    static class DMinimumEulerCycle {
        public void solve(int testNumber, FastReader s, PrintWriter out) {
            int t = s.nextInt();
            while (t-- > 0) {
                int n = s.nextInt();
                long l = s.nextLong();
                long r = s.nextLong();
                TreeMap<Long, Long> oddMap = new TreeMap<>();
                TreeMap<Long, Long> evenMap = new TreeMap<>();
                long from = 0l;
                long curr = (long) (n - 1l);
                long to = 2l * (curr);
                long num = 1l;
                while (curr > 0) {
                    oddMap.put(from + 1, num);
                    from = to;
                    curr--;
                    to += 2 * (curr);
                    num++;
                }
                oddMap.put(n * (n - 1l) + 1l, (long) 1);

                from = 2l;
                curr = (long) (n - 1l);
                num = 2l;
                while (curr > 0) {
                    evenMap.put(from, num);
                    from += 2 * (curr);
                    curr--;
                    num++;
                }

//            out.println(oddMap);
//            out.println(evenMap);

                ArrayList<Long> oddAns = new ArrayList<>();
                ArrayList<Long> evenAns = new ArrayList<>();

                for (long i = l; i <= r; i++) {
                    if (i % 2l != 0l) {
                        oddAns.add(oddMap.get(oddMap.floorKey(i)));
                    } else {
                        if (evenMap.containsKey(i)) {
                            evenAns.add(evenMap.get(i));
                        } else {
                            evenAns.add((i - evenMap.lowerKey(i)) / 2 + evenMap.get(evenMap.lowerKey(i)));
                        }
                    }
                }


                int currO = 0;
                int currE = 0;
                for (long i = l; i <= r; i++) {
                    if (i % 2l == 0l) {
                        out.println(evenAns.get(currE++));
                    } else {
                        out.println(oddAns.get(currO++));
                    }
                }
            }
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

