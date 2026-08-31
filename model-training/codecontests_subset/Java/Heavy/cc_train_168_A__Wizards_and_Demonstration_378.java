
import java.io.*;
import java.util.*;

public class CF {

    public static void main(String[] args) throws IOException {
        //FastScanner in = new FastScanner(new FileInputStream(new File("input.txt")));
        //PrintWriter out = new PrintWriter(new File("output.txt"));
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int a = (int) Math.ceil((double) y / 100 * n);
        System.out.println((a - x < 0) ? 0 : a - x);
    }

    public static int sumTable(int[] tab, int indx) {
        if (indx == tab.length) {
            return 0;
        }
        return tab[indx] + sumTable(tab, indx + 1);
    }

    public static List<int[]> list = new LinkedList<>();

    public static void Permute(int[] input, int startindex) {
        int size = input.length;
        if (size == startindex + 1) {
            int[] tab = new int[size];
            for (int i = 0; i < tab.length; i++) {
                tab[i] = input[i];
            }
            list.add(tab);
        } else {
            for (int i = startindex; i < size; i++) {
                int temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
                Permute(input, startindex + 1);
                int temp2 = input[i];
                input[i] = input[startindex];
                input[startindex] = temp2;
            }
        }
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
}
