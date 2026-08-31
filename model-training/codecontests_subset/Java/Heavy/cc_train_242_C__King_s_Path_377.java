import java.util.Scanner;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mdonaj
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x0 = in.nextInt(),
            y0 = in.nextInt(),
            x1 = in.nextInt(),
            y1 = in.nextInt();

        int n = in.nextInt();
        HashSet<Point> allowed = new HashSet<Point>();
        HashSet<Point> visited = new HashSet<Point>();
        
        for(int i = 0; i < n; ++i) {
           int r = in.nextInt();
           int a = in.nextInt();
           int b = in.nextInt();

            for(int j = a; j <= b; ++j)
                allowed.add(new Point(r, j));

        }

        LinkedList<Point> q = new LinkedList<Point>();
        Point beg = new Point(x0, y0);
        beg.l = 0;
        q.add(beg);
        visited.add(beg);

        while(!q.isEmpty()) {
            Point p = q.pollFirst();
            if(p.x == x1 && p.y == y1) {
                out.println(p.l);
                return;
            }

            Point p1 = new Point(p.x-1, p.y);
            p1.l = p.l + 1;
            Point p2 = new Point(p.x+1, p.y);
            p2.l = p.l + 1;
            Point p3 = new Point(p.x, p.y-1);
            p3.l = p.l + 1;
            Point p4 = new Point(p.x, p.y+1);
            p4.l = p.l + 1;
            Point p5 = new Point(p.x-1, p.y-1);
            p5.l = p.l + 1;
            Point p6 = new Point(p.x-1, p.y+1);
            p6.l = p.l + 1;
            Point p7 = new Point(p.x+1, p.y+1);
            p7.l = p.l + 1;
            Point p8 = new Point(p.x+1, p.y-1);
            p8.l = p.l + 1;

            if(allowed.contains(p1) && !visited.contains(p1)) {
                q.add(p1);
                visited.add(p1);
            }
            if(allowed.contains(p2) && !visited.contains(p2))
            {
                q.add(p2);
                visited.add(p2);
            }

            if(allowed.contains(p3) && !visited.contains(p3))
            {
                q.add(p3);
                visited.add(p3);
            }

            if(allowed.contains(p4) && !visited.contains(p4))
            {
                q.add(p4);
                visited.add(p4);
            }

            if(allowed.contains(p5) && !visited.contains(p5))
            {
                q.add(p5);
                visited.add(p5);
            }

            if(allowed.contains(p6) && !visited.contains(p6))
            {
                q.add(p6);
                visited.add(p6);
            }

            if(allowed.contains(p7) && !visited.contains(p7))
            {
                q.add(p7);
                visited.add(p7);
            }

            if(allowed.contains(p8) && !visited.contains(p8))
            {
                q.add(p8);
                visited.add(p8);
            }
        }


        out.print("-1");

	}

    private class Point{
        public int x,y;
        public int l;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        public int hashCode() {
            int result = x%10009;

            result = 31 * result + (y%10009);
            return result;
        }
    }
}

