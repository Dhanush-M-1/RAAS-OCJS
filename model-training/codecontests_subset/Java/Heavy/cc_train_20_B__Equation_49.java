import java.util.*;
import java.io.*;

public class B0020 {

    public static void main(String args[]) throws Exception {
        new B0020();
    }

    B0020() throws Exception {
        PandaScanner sc = null;
        PrintWriter out = null;
        try {
            sc = new PandaScanner(System.in);
            out = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        //Quadratic case
        if (a != 0) {
            long determinent = b * b - 4 * a * c;
            if (determinent < 0) {
                out.println(0);
            }
            else if (determinent == 0) {
                out.println(1);
                out.println(-b / (2.0 * a));
            }
            else {
                double d = Math.sqrt(determinent);
                double[] ans = new double[] {(-b - d) / (2.0 * a), (-b + d) / (2.0 * a)};
                Arrays.sort(ans);

                out.println(2);
                out.println(ans[0]);
                out.println(ans[1]);
            }
        }
        //Non-horizontal linear case
        else if (b != 0) {
            out.println(1);
            out.println((-1.0 * c) / (double) (b));
        }
        //Horizontal linear case
        else {
            if (c == 0) {
                out.println(-1);
            }
            else {
                out.println(0);
            }
        }

        out.close();
        System.exit(0);
    }


    //The PandaScanner class, for Panda fast scanning!
    public class PandaScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream in;

        PandaScanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(this.in = in));
        }

        public String next() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
                return next();
            }
            return st.nextToken();
        }

        public boolean hasNext() throws Exception {
            return (st != null && st.hasMoreTokens()) || in.available() > 0;
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
