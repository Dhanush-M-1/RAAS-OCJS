
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pttrung
 */
public class B {

    public static int r1, r2, c1, c2, d1, d2;

    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        r1 = in.nextInt();
        r2 = in.nextInt();
        c1 = in.nextInt();
        c2 = in.nextInt();
        d1 = in.nextInt();
        d2 = in.nextInt();
        //   System.out.println(r1 + " " + r2 + " " + c1 + " " + c2 + " " +  d1 + " " + d2);
        int[][] result = new int[2][2];
        if (cal(0, new boolean[10], result)) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    out.print(result[i][j] + " ");
                }
                out.println();
            }
        } else {
            out.println(-1);
        }

        out.close();
    }

    public static boolean cal(int index, boolean[] check, int[][] cur) {
        if (index == 4) {
            //System.out.println("FIRST");
            //System.out.println((cur[0][0] + cur[0][1]) + " " + (cur[1][0] + cur[1][1]));
           // System.out.println((cur[0][0] + cur[0][1]) + " " + (cur[1][0] + cur[1][1]));
            if (r1 == cur[0][0] + cur[0][1] && r2 == cur[1][0] + cur[1][1] && c1 == cur[0][0] + cur[1][0] && c2 == cur[0][1] + cur[1][1]) {

                if (d1 == cur[0][0] + cur[1][1] && d2 == cur[0][1] + cur[1][0]) {

                    return true;
                }
            }
            return false;
        }
        int i = index / 2;
        int j = index % 2;
        for (int k = 1; k < check.length; k++) {
            if (!check[k]) {
                check[k] = true;
                cur[i][j] = k;
                if (cal(index + 1, check, cur)) {
                    return true;
                }
                check[k] = false;
            }
        }
        return false;

    }

    public static double dist(Point a, Point b) {
        double val = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        return Math.sqrt(val);
    }

    public static class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean nextPer(int[] data) {
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }

    public double pow(double a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        double val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * val * a;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
