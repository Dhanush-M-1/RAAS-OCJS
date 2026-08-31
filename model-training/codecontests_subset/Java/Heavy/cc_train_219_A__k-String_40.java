
import java.io.*;
import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[33m";

    public static void main(String[] args) throws IOException {
        //FastScanner in = new FastScanner(new File("input.txt"));
        //PrintStream out = new PrintStream(new File("output.txt"));
        FastScanner in = new FastScanner(System.in);
        int k = in.nextInt();
        String ch = in.next();
        String ch1 = "";
        StringBuilder sb = new StringBuilder();
        int[] t = new int[26];
        int count = 0;
        if (k == 1) {
            System.out.println(ch);
            return;
        }
        for (int i = 0; i < ch.length(); i++) {
            t[ch.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i] % k != 0) {
                System.out.println("-1");
                return;
            } else {
                if (t[i] != 0) {
                    for (int j = 0; j < t[i] / k; j++) {
                        sb.append((char) ('a' + i));
                    }
                }
            }
        }
        String ch2="";
        for (int i = 0; i < k; i++) {
            ch2+=sb.toString();
        }
        System.out.println(ch2);

    }

    public static int[] radixSort(int[] f) {
        return radixSort(f, f.length);
    }

    public static int[] radixSort(int[] f, int n) {
        int[] to = new int[n];
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) {
                b[1 + (f[i] & 0xffff)]++;
            }
            for (int i = 1; i <= 65536; i++) {
                b[i] += b[i - 1];
            }
            for (int i = 0; i < n; i++) {
                to[b[f[i] & 0xffff]++] = f[i];
            }
            int[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < n; i++) {
                b[1 + (f[i] >>> 16)]++;
            }
            for (int i = 1; i <= 65536; i++) {
                b[i] += b[i - 1];
            }
            for (int i = 0; i < n; i++) {
                to[b[f[i] >>> 16]++] = f[i];
            }
            int[] d = f;
            f = to;
            to = d;
        }
        return f;

    }

    private static class FastScanner {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        public FastScanner(File file) throws FileNotFoundException {
            this.stream = new FileInputStream(file);
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextArrayInt(int n) {
            int tab[] = new int[n];
            for (int i = 0; i < n; i++) {
                tab[i] = nextInt();
            }
            return tab;
        }

        public String[] nextArrayString(int n) {
            String tab[] = new String[n];
            for (int i = 0; i < n; i++) {
                tab[i] = next();
            }
            return tab;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
    /* int h = in.nextInt();
        int a[] = new int[h + 1];
        boolean t = true;
        int l = 0;
        int index = 0;
        for (int i = 1; i < h+1; i++) {
            a[i] = in.nextInt();
            l += a[i];
            if (a[i - 1] == 1 && a[i] >= 1) {
            } else {
                index = i;
                t = false;
                break;
            }
        }
        System.out.println(index);
        if (t == true) {
            System.out.println("perfect");
        } else {
            int tab1[] = new int[l];
            int tab2[] = new int[l];
            int k = 0;
            for (int i = 0; i < tab1.length; i++) {
                tab1[i] = k;
                k += a[i];
            }
        }*/
}
