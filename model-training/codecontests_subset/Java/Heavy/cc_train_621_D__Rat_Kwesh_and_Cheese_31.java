import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A {
    static MyScanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws Throwable {
        sc = new MyScanner();
        pw = new PrintWriter(System.out);

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();

        boolean greater = x > 1 || y > 1 || z > 1;
        String[] exp =
                {"x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y",
                        "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x",
                        "z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x",};


        double[] vals = new double[12];

        if (greater) {
            Arrays.fill(vals, -1e18);
            if (x > 1) {
                vals[0] = z * Math.log(y) + Math.log(Math.log(x));
                vals[1] = y * Math.log(z) + Math.log(Math.log(x));
                vals[2] = Math.log(y) + Math.log(z) + Math.log(Math.log(x));
            }
            if (y > 1) {
                vals[4] = z * Math.log(x) + Math.log(Math.log(y));
                vals[5] = x * Math.log(z) + Math.log(Math.log(y));
                vals[6] = Math.log(x) + Math.log(z) + Math.log(Math.log(y));
            }
            if (z > 1) {
                vals[8] = y * Math.log(x) + Math.log(Math.log(z));
                vals[9] = x * Math.log(y) + Math.log(Math.log(z));
                vals[10] = Math.log(x) + Math.log(y) + Math.log(Math.log(z));
            }
            String ans = "";
            double mx = -2e18;
            for (int i = 0; i < 12; i++)
                if (vals[i] > mx) {
                    mx = vals[i];
                    ans = exp[i];
                }
            pw.println(ans);

        } else {
            Arrays.fill(vals, 1e18);

            vals[0] = z * Math.log(y) + Math.log(Math.log(1 / x));
            vals[1] = y * Math.log(z) + Math.log(Math.log(1 / x));
            vals[2] = Math.log(y) + Math.log(z) + Math.log(Math.log(1 / x));
            vals[4] = z * Math.log(x) + Math.log(Math.log(1 / y));
            vals[5] = x * Math.log(z) + Math.log(Math.log(1 / y));
            vals[6] = Math.log(x) + Math.log(z) + Math.log(Math.log(1 / y));
            vals[8] = y * Math.log(x) + Math.log(Math.log(1 / z));
            vals[9] = x * Math.log(y) + Math.log(Math.log(1 / z));
            vals[10] = Math.log(x) + Math.log(y) + Math.log(Math.log(1 / z));

            String ans = "";
            double mn = 2e18;
            for (int i = 0; i < 12; i++)
                if (vals[i] < mn) {
                    mn = vals[i];
                    ans = exp[i];
                }
            pw.println(ans);

        }


        pw.flush();
        pw.close();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}