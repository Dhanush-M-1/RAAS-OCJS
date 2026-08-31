import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class WeaknessAndPoorness {
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    private static double weakness(int[] a, double x) {

        // find segment such that its sum gives the max value
        double max = 0;
        double curr = 0;
        for (int el: a) {
            if (el - x >= 0) {
                curr = curr + el - x;
                max = Math.max(curr, max);
            }
            else {
                curr = curr + el - x;
                if (curr <= 0) {
                    curr = 0;
                }
            }
        }

        // find segment such that its sum gives the min value
        double min = 0;
        curr = 0;
        for (int el: a) {
            if (el - x <= 0) {
                curr = curr + el - x;
                min = Math.min(curr, min);
            }
            else {
                curr = curr + el - x;
                if (curr >= 0) {
                    curr = 0;
                }
            }
        }

        return Math.max(-min, max);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = fs.nextInt();
        }


        double l = -10 * 1001;
        double r = 10 * 1001;


        double result = 0.0;
        for (int it = 0; it < 100; ++it) {
            double dis = r - l;
            double m1 = l + (dis) / 3;
            double m2 = l + (2 * dis) / 3;

            double m1Weakness = weakness(a, m1);
            double m2Weakness = weakness(a, m2);

            if (m1Weakness < m2Weakness) {
                r = m2;
            } else {
                l = m1;
            }
            result = m1Weakness;
        }
        System.out.println(result);
    }
}
