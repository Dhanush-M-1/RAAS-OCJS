
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }

    private static class TaskB {

        static final double eps = 0.000001;

        void solve(InputReader in, PrintWriter out) throws IOException {

            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        out.println(-1);
                    } else {
                        out.println(0);
                    }
                } else {
                    out.println(1);
                    out.printf("%.6f", (-c) / b);
                }
            } else {
                double D = b * b - 4 * a * c;
                if (D < 0) {
                    out.println(0);
                } else if (D == 0) {
                    out.println(1);
                    out.printf("%.6f", (-b + Math.sqrt(D)) / (2 * a));
                } else {
                    out.println(2);
                    double x1 = (-b + Math.sqrt(D)) / (2 * a);
                    double x2 = (-b - Math.sqrt(D)) / (2 * a);
                    if (x1 < x2)
                        out.printf("%.6f\n%.6f\n", x1, x2);
                    else out.printf("%.6f\n%.6f\n", x2, x1);

                }
            }
        }

        static double segment(double x1, double y1, double x2, double y2) {
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }

        static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return (a * b) / gcd(a, b);
        }

    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader br;

        public InputReader(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public InputReader(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public boolean ready() {
            try {
                return br.ready();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
