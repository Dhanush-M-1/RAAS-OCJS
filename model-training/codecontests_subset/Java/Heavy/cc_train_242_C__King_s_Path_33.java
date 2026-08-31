
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 111118315581
 *
 * -3 3 2 3 2 3 2 3 -3 3 -3 3 -3 3 2 3
 *
 * @author pttrung
 */
public class C {

    //   public static long x, y, gcd;
    //   public static int Mod = 1000000007;
    public static int[] x = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int[] y = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        //   System.out.println(Integer.MAX_VALUE);
        // PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")));
        Point start = new Point(in.nextInt(), in.nextInt(), 0);
        Point end = new Point(in.nextInt(), in.nextInt(), -1);
        HashMap<Integer, TreeSet<Point>> map = new HashMap();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int r = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            Point p = new Point(a, b, -1);
            if (map.containsKey(r)) {
                TreeSet<Point> set = map.get(r);
                Point f = set.floor(p);

                if (f == null || f.y < b) {
                    set.add(p);
                }
                //  System.out.println(r + " " + map.get(r).size());
            } else {
                map.put(r, new TreeSet());
                map.get(r).add(p);
                //     System.out.println(r + " " + map.get(r).size());
            }
        }
        ArrayList<Point> q = new ArrayList();
        q.add(start);
        TreeSet<Point> set = new TreeSet();
        set.add(start);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            Point cur = q.remove(0);
            for (int i = 0; i < x.length; i++) {
                int a = cur.x + x[i];
                int b = cur.y + y[i];
                if (a > 0 && b > 0 && a < 1000000001 && b < 1000000001) {
                    Point p = new Point(a, b, -1);
                    if (!set.contains(p)) {

                        if (map.containsKey(a)) {
                            Point range = new Point(b, b, -1);
                      //      out.println(a + "|" + b);

                            TreeSet<Point> temp = map.get(a);
                            Point f = temp.floor(range);
                            Point c = temp.ceiling(range);
//                            if (f != null) {
//                                out.println(a + " " + b + " " + f.x + "_" + f.y);
//                            }
                            if (f != null && f.y >= b) {

                                p.level = cur.level + 1;

                                set.add(p);
                                q.add(p);
                                if (a == end.x && b == end.y) {
                                    end.level = p.level;
                                    found = true;
                                    break;
                                }
                            } else if (c != null && c.x <= b && c.y >= b) {
                                p.level = cur.level + 1;

                                set.add(p);
                                q.add(p);
                                if (a == end.x && b == end.y) {
                                    end.level = p.level;
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!found) {
            out.println(-1);
        } else {
            out.println(end.level);
        }

        out.close();
    }

    public static double angle(Point a, Point b) {
        int cr = cross(a, b);
//        if (cr == 0) {
//            return 0;
//        }      
        double lA = a.x * a.x + a.y * a.y;

        double lB = b.x * b.x + b.y * b.y;

        double result = Math.asin((double) cr / Math.sqrt(lA * lB));
        result = Math.toDegrees(result);
//        if (result < 0) {
//            result += 360;
//        }
        return result;

    }

    public static int cross(Point a, Point b) {
        int val = a.x * b.y - a.y * b.x;
        return val;
    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val;
        } else {
            return val * val * a;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static class Point implements Comparable<Point> {

        int x, y, level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) {
                return x - o.x;
            } else {
                return y - o.y;
            }
        }
    }
//    public static void extendEuclid(long a, long b) {
//        if (b == 0) {
//            x = 1;
//            y = 0;
//            gcd = a;
//            return;
//        }
//        extendEuclid(b, a % b);
//        long x1 = y;
//        long y1 = x - (a / b) * y;
//        x = x1;
//        y = y1;
//
//    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //  br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
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
