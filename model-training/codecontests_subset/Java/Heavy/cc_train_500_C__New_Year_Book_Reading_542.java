
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 *
 * @author pttrung
 */
public class C {

    //   public static long x, y, gcd;
    public static PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner();

        out = new PrintWriter(System.out);
        //   System.out.println(Integer.MAX_VALUE);
        //PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")));
        int n = in.nextInt();
        int m = in.nextInt();
        int[]data = new int[n];
        for(int i = 0; i < n; i++){
            data[i] = in.nextInt();
        }
        int[]order = new int[m];
        int[]start = new int[n];
        int index = 0;
        boolean[]check = new boolean[n];
        
        for(int i = 0; i < m; i++){
            order[i] = in.nextInt() - 1;
            if(!check[order[i]]){
                check[order[i]] = true;
                start[index++] = order[i];
            }
        }
        LinkedList<Integer> stack = new LinkedList();
        for(int i = 0; i < index; i++){
            stack.add(start[i]);
        }
        int total = 0;
        
        for(int i = 0; i < m; i++){
            LinkedList<Integer> q = new LinkedList();
            //System.out.println(stack);
            while(stack.getFirst() != order[i]){
                int v = stack.removeFirst();
                total += data[v];
                q.add(v);
            }
            stack.removeFirst();
            stack.addAll(0, q);
            
            stack.add(0,order[i]);
            
        }
        out.println(total);
        
        
        out.close();
    }

    public static class Name {

        String first, last;

        public Name(String first, String last) {
            this.first = first;
            this.last = last;
        }
    }

  
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long update(int node, long val, ArrayList<Edge>[] map, boolean[] check, long[] data) {
        data[node] = val;
        check[node] = true;
        for (Edge e : map[node]) {
            int nxt = e.a == node ? e.b : e.a;
            long mul = e.l * e.g;
            if (mul % val != 0) {
                return -1;
            }
            long other = (mul / val);
            if (gcd(other, val) != e.g) {
                return -1;
            }
            if (!check[nxt]) {


                long v = update(nxt, other, map, check, data);
                if (v == -1) {
                    return -1;
                }

            }
        }
        return val;
    }

    static class Edge {

        int a, b;
        long g, l;

        public Edge(int a, int b, int g, int l) {
            this.a = a;
            this.b = b;
            this.g = g;
            this.l = l;
        }
    }

    public static int dist(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static Point clock(Point p, int n, int m) {
        Point result = new Point(p.y, n - p.x + 1);
        return result;
    }

    public static Point anti_clock(Point p, int n, int m) {
        Point result = new Point(m - p.y + 1, p.x);
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

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);










    }

    public static class Point implements Comparable<Point> {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) {
                return x - o.x;
            } else {
                return y - o.y;
            }
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + this.x;
            hash = 59 * hash + this.y;
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
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
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

    public static class FT {

        int[] data;

        FT(int n) {
            data = new int[n];
        }

        public void update(int index, int value) {
            while (index < data.length) {
                data[index] += value;
                index += (index & (-index));
            }
        }

        public int get(int index) {
            int result = 0;
            while (index > 0) {
                result += data[index];
                index -= (index & (-index));
            }
            return result;

        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C-small-attempt0.in"))));
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
