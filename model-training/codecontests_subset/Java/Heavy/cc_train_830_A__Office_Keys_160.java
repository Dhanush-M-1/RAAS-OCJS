import java.io.*;
import java.util.*;

/**
 * Road to 1st div
 */
public class Main {


    static class Task {
        PrintWriter out;



        public void solve(MyScanner in, PrintWriter out) {
            long ans = Long.MAX_VALUE;

            int n = in.nextInt();
            int k = in.nextInt();

            int p = in.nextInt();
            long a[] = new long[n];
            long b[] = new long[k];
            for (int i = 0; i< n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < k; i++) {
                b[i] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);


            for (int startingKey = 0; startingKey <= k - n; startingKey++) {
                long localAns = Long.MIN_VALUE;

                for (int i = 0; i < n; i++) {
                    //System.out.println(a[i] + " " + b[startingKey + i] + " " + p);
                    //System.out.println("Local test " + (startingKey + 1) + " " + (i + 1) + " " + calc(a[i], b[startingKey + i], p));
                    localAns = Math.max(localAns, calc(a[i], b[startingKey + i], p));
                }

                //System.out.println("Ans for start = " + (startingKey + 1) + " = " + localAns);
                ans = Math.min(localAns, ans);
            }

            System.out.println(ans);
        }

        long calc(long pp, long kp, long op) {
            return Math.abs(pp - kp) + Math.abs(op - kp);
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

