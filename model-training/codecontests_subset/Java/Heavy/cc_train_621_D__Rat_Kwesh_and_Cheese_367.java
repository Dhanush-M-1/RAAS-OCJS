import java.io.*;
import java.util.*;

public class Solution {

    static void calc(int type, double[] a, double x, double y, double z) {
        if (x == 1)
            a[0] = a[1] = a[2] = a[3] = -Double.MAX_VALUE;
        else if (x > 1) {
            a[0] = z * Math.log(y) + Math.log(Math.log(x));
            a[1] = y * Math.log(z) + Math.log(Math.log(x));
            a[2] = Math.log(z * y * Math.log(x));
            a[3] = a[2];

        } else {
            if (type == 0) {
                a[0] = a[1] = a[2] = a[3] = -Double.MAX_VALUE;
            } else {
                a[0] = z * Math.log(y) + Math.log(Math.log(1 / x));
                a[1] = y * Math.log(z) + Math.log(Math.log(1 / x));
                a[2] = Math.log(z * y * Math.log(1 / x));
                a[3] = a[2];
            }
        }

        if (y == 1)
            a[4] = a[5] = a[6] = a[7] = -Double.MAX_VALUE;
        else if (y > 1) {
            a[4] = z * Math.log(x) + Math.log(Math.log(y));
            a[5] = x * Math.log(z) + Math.log(Math.log(y));
            a[6] = Math.log(z * x * Math.log(y));
            a[7] = a[6];

        } else {
            if (type == 0) {
                a[4] = a[5] = a[6] = a[7] = -Double.MAX_VALUE;
            } else {
                a[4] = z * Math.log(x) + Math.log(Math.log(1 / y));
                a[5] = x * Math.log(z) + Math.log(Math.log(1 / y));
                a[6] = Math.log(z * x * Math.log(1 / y));
                a[7] = a[6];
            }
        }

        if (z == 1)
            a[8] = a[9] = a[10] = a[11] = -Double.MAX_VALUE;
        else if (z > 1) {
            a[8] = y * Math.log(x) + Math.log(Math.log(z));
            a[9] = x * Math.log(y) + Math.log(Math.log(z));
            a[10] = Math.log(y * x * Math.log(z));
            a[11] = a[10];

        } else {
            if (type == 0) {
                a[8] = a[9] = a[10] = a[11] = -Double.MAX_VALUE;
            } else {
                a[8] = y * Math.log(x) + Math.log(Math.log(1 / z));
                a[9] = x * Math.log(y) + Math.log(Math.log(1 / z));
                a[10] = Math.log(y * x * Math.log(1 / z));
                a[11] = a[10];
            }
        }
    }

    static void solve(InputReader in, OutputWriter out) {
        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();

        String[] ans = {"x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y", "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x", "z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x"};
        double[] a = new double[12];
        if (x <= 1 && y <= 1 && z <= 1) {
            calc(1, a, x, y, z);

            double min = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < a.length; i++)
                if (a[i] < min) {
                    min = a[i];
                    index = i;
                }
            out.print(ans[index]);

        } else {
            calc(0, a, x, y, z);

            double max = -Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < a.length; i++)
                if (a[i] > max) {
                    max = a[i];
                    index = i;
                }
            out.print(ans[index]);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        solve(in, out);
        in.close();
        out.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        String nextLine() {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class OutputWriter {
        BufferedWriter bw;

        OutputWriter(OutputStream os) {
            bw = new BufferedWriter(new OutputStreamWriter(os));
        }

        void print(int i) {
            print(Integer.toString(i));
        }

        void println(int i) {
            println(Integer.toString(i));
        }

        void print(long l) {
            print(Long.toString(l));
        }

        void println(long l) {
            println(Long.toString(l));
        }

        void print(double d) {
            print(Double.toString(d));
        }

        void println(double d) {
            println(Double.toString(d));
        }

        void print(boolean b) {
            print(Boolean.toString(b));
        }

        void println(boolean b) {
            println(Boolean.toString(b));
        }

        void print(char c) {
            try {
                bw.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(char c) {
            println(Character.toString(c));
        }

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            print(s);
            print('\n');
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
