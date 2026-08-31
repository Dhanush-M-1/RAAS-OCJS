import java.util.*;
import java.lang.*;
import java.io.*;

public class R7B {
    static int[] alot;
    static int n;
    static int id = 0;
    static PrintWriter w = new PrintWriter(System.out);
    public static void main (String[] args) throws java.lang.Exception {
        InputReader in = new InputReader(System.in);
        int op = in.nextInt(); n = in.nextInt();
        alot = new int[n];
        while (op-- > 0) {
            String q = in.next();
            if (q.equals("alloc")) {
                w.println(alloc(in.nextInt()));
            } else if (q.equals("erase")) {
                erase(in.nextInt());
            } else {
                defragment();
            }
        }

        w.close();

    }
    static String alloc(int x) {
        int taken = 0;
        for (int i = 0; i < n; i++) {
            if (alot[i] == 0) {
                taken++;
                if (taken >= x) {
                    id++;
                    // w.println("id is : " + id);
                    for (int j = i; j > i - x; j--)
                        alot[j] = id;
                    break;
                }
            } else {
                taken = 0;
            }
        }
        //w.println("alot is : " + Arrays.toString(alot));
        if (taken < x)
            return "NULL";
        return Integer.toString(id);
    }
    static void erase(int x) {
        //w.println("alot is : " + Arrays.toString(alot));
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (alot[i] == x) {
                found = true;
                alot[i] = 0;
            }
        }
        if (x == 0)
            found = false;
        if (!found)
            w.println("ILLEGAL_ERASE_ARGUMENT");
    }
    static void defragment() {
        int emt = 0;
        //w.println("alot is : " + Arrays.toString(alot));
        for (int i = 0; i < n; i++) {
            if (alot[i] == 0)
                emt++;
            else {
                alot[i - emt] = alot[i];
                if (emt != 0)
                    alot[i] = 0;
            }
        }
        //w.println("alot is : " + Arrays.toString(alot));
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }

        public void skip(int x) {
            while (x-- > 0)
                read();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextString() {
            return next();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}