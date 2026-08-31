import java.util.*;
import java.io.*;

public class P1382A {
    // Global Variables
    public static final boolean ENV = false;
    public static final String pathToInputFile = "src/in/P1382A.txt";

    // in and out Variables
    public static final PrintWriter out = new PrintWriter(System.out, true);
    public static final FastReader in;

    static {
        FastReader inTemp;
        try {
            inTemp = !ENV ? new FastReader() :
                    new FastReader(new File(pathToInputFile));
        } catch (Exception e) {
            inTemp = new FastReader();
        }
        in = inTemp;
    }

    // FastReader Class
    public static class FastReader extends BufferedReader {
        StringTokenizer st;

        public FastReader() {
            super(new InputStreamReader(System.in));
        }

        public FastReader(File file) throws FileNotFoundException {
            super(new InputStreamReader(new FileInputStream(file)));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String[] next(int t) {
            String[] r = new String[t];
            for (int i = 0; i < t; i++) {
                r[i] = next();
            }
            return r;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextInt(int t) {
            int[] r = new int[t];
            for (int i = 0; i < t; i++) {
                r[i] = Integer.parseInt(next());
            }
            return r;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLong(int t) {
            long[] r = new long[t];
            for (int i = 0; i < t; i++) {
                r[i] = Long.parseLong(next());
            }
            return r;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public double[] nextDouble(int t) {
            double[] r = new double[t];
            for (int i = 0; i < t; i++) {
                r[i] = Double.parseDouble(next());
            }
            return r;
        }
    }

    // Custom Functions

    // Main
    public static void main(String[] args) {
        int totalCases = in.nextInt();
        mainLoop:
            for (int caseNum = 1; caseNum <= totalCases; caseNum++) {
                // Declaration
                int n = in.nextInt(), m = in.nextInt();
                int[] a = new int[n], b = new int[m];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                for (int i = 0; i < m; i++) {
                    int val = in.nextInt();
                    for (int j = 0; j < n; j++) {
                        if (val == a[j]) {
                            out.println("YES");
                            out.println("1 " + val);
                            for (int x = 0; x < (m - i - 1); x++) {
                                in.nextInt();
                            }
                            continue mainLoop;
                        }
                    }
                }
                out.println("NO");
            }
    }
}