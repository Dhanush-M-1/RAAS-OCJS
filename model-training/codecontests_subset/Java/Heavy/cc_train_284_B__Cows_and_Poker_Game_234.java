
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 6
 * 1 0
 * 0 0
 * 0 0
 * 1 1
 * 0 1
 * 1 1
 *
 * @author pttrung
 */
public class B {

    public static boolean circle;
    public static int a, b;

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out;

        Scanner in = new Scanner();
        //out = new PrintWriter(new FileOutputStream(new File("output.txt")));
        out = new PrintWriter(System.out);
        int n = in.nextInt();
        String val = in.next();
        int A = 0;
        int F = 0;
        int I = 0;
        for (int i = 0; i < n; i++) {
            if (val.charAt(i) == 'A') {
                A++;
            } else if (val.charAt(i) == 'F') {
                F++;
            } else {
                I++;
            }
        }

        if (I == 0) {
            out.println(A + I);
        } else if (I == 1) {
            out.println(1);
        } else {
            out.println(0);
        }

        //out.println();
        out.close();

    }

    public static Line getLine(Point a, Point b) {
        int c = (a.x - b.x);
        int d = (a.y - b.y);
        if (c == 0) {
            return new Line(1, 0, -a.x);
        } else if (d == 0) {
            return new Line(0, 1, -a.y);
        } else {
            double rate = (double) (-d) / c;

            double other = ((double) rate * a.x) + a.y;
            //System.out.println(a + "|" + b + ": " + rate + " " + other);
            return new Line(rate, 1, -other);
        }
    }

    public static class Line {

        double a, b, c;

        public Line(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 47 * hash + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
            hash = 47 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
            hash = 47 * hash + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Line other = (Line) obj;
            if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
                return false;
            }
            if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
                return false;
            }
            if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(other.c)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return a + " " + b + " " + c;
        }
    }

    static class FT {

        int[] data;

        FT(int n) {
            data = new int[n];
        }

        void update(int index, int val) {
            // System.out.println("UPDATE INDEX " + index);
            while (index < data.length) {
                data[index] += val;
                index += index & (-index);

                //    System.out.println("NEXT " +index);
            }
        }

        int get(int index) {
            //  System.out.println("GET INDEX " + index);
            int result = 0;
            while (index > 0) {
                result += data[index];
                index -= index & (-index);
                // System.out.println("BACK " + index);
            }
            return result;
        }
    }

    public static double dist(Point a, Point b) {
        double val = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        return Math.sqrt(val);
    }

    public static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
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

    public static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long val = pow(a, b / 2);
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

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //  br = new BufferedReader(new FileReader(new File("output.txt")));
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
