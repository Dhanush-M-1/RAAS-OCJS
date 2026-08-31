import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;


public class Main {

    public static void main(String[] args) throws Exception {
        MyReader reader = new MyReader(System.in);
        MyWriter writer = new MyWriter(System.out);
        new Main().run(reader, writer);
        writer.close();
    }

    private void run(MyReader reader, MyWriter writer) throws IOException {
        int n = reader.nextInt();
        int k = reader.nextInt();
        long p = reader.nextInt();
        long[] a = reader.nextLongArray(n);
        long[] b = reader.nextLongArray(k);
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= k - n; i++) {
            long c = 0;
            for (int j = 0; j < n; j++) {
                c = Math.max(c, Math.abs(a[j] - b[i + j]) + Math.abs(b[i + j] - p));
            }
            ans = Math.min(ans, c);
        }
        writer.print(ans);
    }

    static class MyReader {

        final BufferedInputStream in;
        final int bufSize = 1 << 16;
        final byte buf[] = new byte[bufSize];
        int i = bufSize;
        int k = bufSize;
        final StringBuilder str = new StringBuilder();

        MyReader(InputStream in) {
            this.in = new BufferedInputStream(in, bufSize);
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        int[] nextIntArray(int n) throws IOException {
            int[] m = new int[n];
            for (int i = 0; i < n; i++) {
                m[i] = nextInt();
            }
            return m;
        }

        int[][] nextIntMatrix(int n, int m) throws IOException {
            int[][] a = new int[n][0];
            for (int j = 0; j < n; j++) {
                a[j] = nextIntArray(m);
            }
            return a;
        }

        long nextLong() throws IOException {
            int c;
            long x = 0;
            boolean sign = true;
            while ((c = nextChar()) <= 32) ;
            if (c == '-') {
                sign = false;
                c = nextChar();
            }
            if (c == '+') {
                c = nextChar();
            }
            while (c >= '0') {
                x = x * 10 + (c - '0');
                c = nextChar();
            }
            return sign ? x : -x;
        }

        long[] nextLongArray(int n) throws IOException {
            long[] m = new long[n];
            for (int i = 0; i < n; i++) {
                m[i] = nextLong();
            }
            return m;
        }

        int nextChar() throws IOException {
            if (i == k) {
                k = in.read(buf, 0, bufSize);
                i = 0;
            }
            return i >= k ? -1 : buf[i++];
        }

        String nextString() throws IOException {
            int c;
            str.setLength(0);
            while ((c = nextChar()) <= 32 && c != -1) ;
            if (c == -1) {
                return null;
            }
            while (c > 32) {
                str.append((char) c);
                c = nextChar();
            }
            return str.toString();
        }

        String nextLine() throws IOException {
            int c;
            str.setLength(0);
            while ((c = nextChar()) <= 32 && c != -1) ;
            if (c == -1) {
                return null;
            }
            while (c != '\n') {
                str.append((char) c);
                c = nextChar();
            }
            return str.toString();
        }

        char[] nextCharArray() throws IOException {
            return nextString().toCharArray();
        }

        char[][] nextCharMatrix(int n) throws IOException {
            char[][] a = new char[n][0];
            for (int i = 0; i < n; i++) {
                a[i] = nextCharArray();
            }
            return a;
        }
    }

    static class MyWriter {

        final BufferedOutputStream out;
        final int bufSize = 1 << 16;
        final byte buf[] = new byte[bufSize];
        int i = 0;
        final byte c[] = new byte[30];
        static final String newLine = System.getProperty("line.separator");

        MyWriter(OutputStream out) {
            this.out = new BufferedOutputStream(out, bufSize);
        }

        void print(long x) throws IOException {
            int j = 0;
            if (i + 30 >= bufSize) {
                flush();
            }
            if (x < 0) {
                buf[i++] = (byte) ('-');
                x = -x;
            }
            while (j == 0 || x != 0) {
                c[j++] = (byte) (x % 10 + '0');
                x /= 10;
            }
            while (j-- > 0)
                buf[i++] = c[j];
        }

        void print(int[] m) throws IOException {
            for (int a : m) {
                print(a);
                print(' ');
            }
        }

        void print(long[] m) throws IOException {
            for (long a : m) {
                print(a);
                print(' ');
            }
        }

        void print(String s) throws IOException {
            for (int i = 0; i < s.length(); i++) {
                print(s.charAt(i));
            }
        }

        void print(char x) throws IOException {
            if (i == bufSize) {
                flush();
            }
            buf[i++] = (byte) x;
        }

        void print(char[] m) throws IOException {
            for (char c : m) {
                print(c);
            }
        }

        void println(String s) throws IOException {
            print(s);
            println();
        }

        void println() throws IOException {
            print(newLine);
        }

        void flush() throws IOException {
            out.write(buf, 0, i);
            out.flush();
            i = 0;
        }

        void close() throws IOException {
            flush();
            out.close();
        }
    }
}