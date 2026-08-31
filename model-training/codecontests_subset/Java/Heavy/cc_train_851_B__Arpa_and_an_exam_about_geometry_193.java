import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        Point(Point a, Point b) {
            x = b.x - a.x;
            y = b.y - a.y;
        }

        public long Len() {
            return x * x + y * y;
        }

    }

    public class Line {
        long A, B, C;

        public Line(Point first, Point second) {
            A = first.y - second.y;
            B = second.x - first.x;
            C = first.x * second.y - second.x * first.y;
        }

        public long sign(Point p) {
            long res = A * p.x + B * p.y + C;
            if (res > 0) {
                return 1;
            } else if (res == 0) {
                return 0;
            } else {
                return -1;
            }

        }
    }

    public void solve() throws IOException {
        Point A = new Point(nextInt(), nextInt());
        Point B = new Point(nextInt(), nextInt());
        Point C = new Point(nextInt(), nextInt());
        Point ab = new Point(A, B);
        Point bc = new Point(B, C);
        if(ab.Len() != bc.Len()){
            out.print("No");
            return;
        }
        Line AB = new Line(A, B);
        if(AB.sign(C) == 0){
            out.print("No");
        }else{
            out.print("Yes");
        }
    }


    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Main().run();
    }

    void run() throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return sc.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

}
