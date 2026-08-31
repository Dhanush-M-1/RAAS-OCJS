import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Prophesy solver = new Prophesy();
        solver.solve(1, in, out);
        out.close();
    }

    static class Prophesy {
        static int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String str = in.next();

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length() - 9; i++) {
                String t = str.substring(i, i + 10);


                if (map.containsKey(t)) {
                    int c = map.get(t);
                    map.put(t, c + 1);
                } else {
                    if (valid(t, i)) {
                        map.put(t, 1);
                    }
                }


            }

            String ans = "";
            int max = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                int count = e.getValue();
                String t = e.getKey();

                if (count > max) {
                    max = count;
                    ans = t;
                }
            }

            out.println(ans);

        }

        private boolean valid(String t, int i) {
            if (t.charAt(2) != '-' || t.charAt(5) != '-') {
                return false;
            }

            String sarr[] = t.split("-");

            if (sarr.length == 3) {
                for (int j = 0; j < sarr.length; j++) {
                    String str = sarr[j];

                    for (int k = 0; k < str.length(); k++) {
                        if (!Character.isDigit(str.charAt(k))) {
                            return false;
                        }
                    }
                }


                int i1 = Integer.parseInt(sarr[0]);
                int i2 = Integer.parseInt(sarr[1]);
                int i3 = Integer.parseInt(sarr[2]);

                if (i3 < 2013 || i3 > 2015) {
                    return false;
                }

                if (i2 < 1 || i2 > 12) {
                    return false;
                }

                if (i1 > days[i2 - 1] || i1 <= 0) {
                    return false;
                }

                return true;
            }

            return false;


        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

