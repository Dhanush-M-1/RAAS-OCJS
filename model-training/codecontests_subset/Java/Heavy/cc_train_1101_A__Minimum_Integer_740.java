import java.io.*;
import java.util.*;

/**
 * Road to div 3
 */
public class Main {

    static class Task {
        PrintWriter out;
        MyScanner in;

        long l, r, d;

        public void solve(MyScanner in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {

                l = in.nextInt();
                r = in.nextInt();
                d = in.nextInt();

                if (d < l) {
                    System.out.println(d);
                } else {
                    long x = r / d;
                    long dd = x * d;
                    if (dd > r) {
                        System.out.println(dd);
                    } else {
                        System.out.println(dd + d);
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    public static class MyScanner {
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