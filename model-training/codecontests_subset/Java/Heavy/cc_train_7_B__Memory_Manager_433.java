
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Trung Pham
 */
public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner();

        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int m = in.nextInt();
        int[] data = new int[m];
        int start = 1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < t; i++) {
            String val = in.nextLine();
            // System.out.println(val);
            if (val.startsWith("alloc")) {
                String[] temp = val.split(" ");
                int n = Integer.parseInt(temp[1]);
                //System.out.println(n);
//                for (int j = 0; j < m; j++) {
//                    System.out.print(data[j] + " ");
//                }
//                System.out.println();
                int count = 0;
                for (int j = 0; j < m; j++) {
                    if (data[j] == 0) {
                        count++;
                        if (count == n) {
                            // System.out.println(start);
                            out.println((start));
                            //  System.out.println((j - n + 1) + " " + j);
                            map.put(start, j - n + 1);
                            for (int k = j; k >= j - n + 1; k--) {
                                data[k] = start;
                            }
                            break;
                        }
                    } else {
                        count = 0;
                    }
                }
                if (count == n) {
                    start++;
                } else {
                    out.println("NULL");
                }
            } else if (val.startsWith("erase")) {
                String[] temp = val.split(" ");
                int n = Integer.parseInt(temp[1]);
                if (map.containsKey(n)) {
                    int j = map.get(n);
                    for (; j < m; j++) {
                        if (data[j] == n) {
                            data[j] = 0;
                        } else {
                            break;
                        }
                    }
                    map.remove(n);
                } else {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else {
                int[] temp = new int[m];
                HashMap<Integer, Integer> se = new HashMap();
                int index = 0;
                for (int j = 0; j < m; j++) {
                    if (data[j] != 0) {
                        se.put(data[j], index);
                        int k = j;
                        for (; k < m; k++) {
                            if (data[k] == data[j]) {
                                temp[index++] = data[j];
                            } else {
                                break;
                            }
                        }
                        j = k - 1;
                    }
                }
                data = temp;
                map = se;
            }
        }

        out.close();


    }

    static class Node {

        int t, l, r;

        public Node(int t, int l, int r) {
            this.t = t;
            this.l = l;
            this.r = r;
        }
    }

    static double area(Point a, Point b, Point c) {
        double i = distance(a, b);
        double j = distance(b, c);
        double k = distance(a, c);
        double s = (i + j + k) / 2;
        double result = s * (s - j) * (s - i) * (s - k);
        return Math.sqrt(result);

    }

    static class Point {

        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point: " + x + " " + y;
        }
    }

    static double distance(Point a, Point b) {
        return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    static Point intersect(Point a, Point b, Point c) {
        double D = cross(a, b);
        if (D != 0) {
            return new Point(cross(c, b) / D, cross(a, c) / D);
        }
        return null;
    }

    static Point convert(Point a, double angle) {
        double x = a.x * cos(angle) - a.y * sin(angle);
        double y = a.x * sin(angle) + a.y * cos(angle);
        return new Point(x, y);
    }

    static Point minus(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }

    static Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }

    static double cross(Point a, Point b) {
        return a.x * b.y - a.y * b.x;
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            //System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
