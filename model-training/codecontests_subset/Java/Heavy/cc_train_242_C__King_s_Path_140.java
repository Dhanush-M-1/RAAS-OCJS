import java.util.*;
import static java.lang.System.*;

public class Main {

    Scanner sc = new Scanner(in);
    
    class Point {
        int x, y, count;
        Point (int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        @Override
        public boolean equals(Object o) {
            return this.x == ((Point)o).x && this.y == ((Point)o).y;
        }
        @Override
        public int hashCode() {
            return ((x + y)^x)|(y << 16);
        }
    }
    
    void quickSort_ascend(int[] a, int[] b, int[] c, int l, int r) {
        if (l < r) {
            int w = a[(l+r)/2];
            int i = l, j = r, temp;
            while (i < j) {
                while (a[i] < w) i++;
                while (a[j] > w) j--;
                if (i <= j) {
                    temp = a[i];
                    a[i] = a[j]; a[j] = temp;
                    temp = b[i];
                    b[i] = b[j]; b[j] = temp;
                    temp = c[i];
                    c[i] = c[j]; c[j] = temp;
                    i++; j--;
                }
            }
            quickSort_ascend(a, b, c, l, j);
            quickSort_ascend(a, b, c, i, r);
        }
    }
    
    int[] r, a, b;
    
    boolean allowed(int x, int y) {
        int lb = 0, ub = r.length;
        while (ub - lb > 1) {
            int mid = (ub + lb) /2;
            if (r[mid] > x) {
                ub = mid;
            } else if (r[mid] < x) {
                lb = mid;
            } else {
                lb = mid;
                break;
            }
        }
        
        for (int i = 0; lb+i < r.length && r[lb+i] == x; i++) {
            if (a[lb+i] <= y && y <= b[lb+i]) 
                return true;
        }
        for (int i = -1; lb+i >= 0 && r[lb+i] == x; i--) {
            if (a[lb+i] <= y && y <= b[lb+i]) 
                return true;
        }
        
        return false;
    }
    
    void run() {
        int x0 = sc.nextInt(), y0 = sc.nextInt();
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int n = sc.nextInt();
        r = new int[n];
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        quickSort_ascend(r, a, b, 0, r.length-1);
        Queue<Point> queue = new LinkedList<Point>();
        Set<Point> set = new HashSet<Point>();
        queue.add(new Point(x0, y0, 0));
        set.add(new Point(x0, y0, 0));
        boolean flag = false;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == x1 && p.y == y1) {
                out.println(p.count);
                flag = true;
                break;
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int X = p.x + dx, Y = p.y + dy;
                    if (allowed(X, Y) && !set.contains(new Point(X,Y,0))) {
//                      out.printf("%d %d %d\n", X, Y, p.count+1);
                        Point q = new Point(X,Y,p.count+1);
                        queue.add(q);
                        set.add(q);
                    }
                }
            }
        }
        if (!flag)
            out.println(-1);
    }
    
    public static void main(String[] args) {
        new Main().run();
    }

}