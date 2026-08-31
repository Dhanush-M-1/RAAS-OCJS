import java.io.*;
import java.util.*;

public class Main {
    static final String fileName = "LLIAMA3OB";

    static void solutionA() {
        int n = fs.nextInt(), k = fs.nextInt(), t = fs.nextInt();
        if (t < k) {pw.print(t);
        return;}
        if (t < n) {
            pw.print(k);
            return;
        }
        pw.print(n + k - t);
    }

    static void solutionB() {
        long ax = fs.nextInt(), ay = fs.nextInt(),bx = fs.nextInt(),by = fs.nextInt(), cx = fs.nextInt(), cy = fs.nextInt(), x1 = ax - bx, x2 = bx - cx, y1 = ay - by, y2 = by - cy;
        if (((x1*x1 + y1*y1) == (x2*x2 + y2*y2)) && (x1*y2 != x2*y1)){
            pw.print("Yes");
        } else {
            pw.print("No");
        }
    }

    public static void main(String[] args) {
        try {
            fs = new FastScanner(new FileInputStream(fileName + ".in"));
            pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName + ".out")));
        } catch (IOException e) {
            fs = new FastScanner(System.in);
            pw = new PrintWriter(new BufferedOutputStream(System.out));
        }
        solutionB();
        pw.close();
    }

    static PrintWriter pw;
    static FastScanner fs;

    static class FastScanner {
        BufferedReader br;
        StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        private String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public byte nextByte() {
            return Byte.parseByte(nextToken());
        }

        public short nextShort() {
            return Short.parseShort(nextToken());
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public boolean hasMoreTokens() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String s = readLine();
                if (s == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.hasMoreTokens();
        }
    }
}
