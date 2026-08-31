

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by mostafa on 9/4/17.
 */
public class B {
    static class Point {
        long x, y;
        Point(long a, long b) {
            x = a; y = b;
        }
    }
    static long dist2(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static boolean coll(Point p1, Point p2, Point p3) {
        long l = (p2.y - p1.y) * (p3.x - p1.x);
        long r = (p3.y - p1.y) * (p2.x - p1.x);

        return l == r;
    }





    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        Point a = new Point(sc.nextInt(), sc.nextInt());
        Point b = new Point(sc.nextInt(), sc.nextInt());
        Point c = new Point(sc.nextInt(), sc.nextInt());

        long d1 = dist2(a, b), d2 = dist2(b, c);

        if(d1 == d2 && ! coll(a, b, c))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;
        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
