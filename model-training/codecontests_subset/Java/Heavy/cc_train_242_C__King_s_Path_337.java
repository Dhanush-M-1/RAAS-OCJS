import java.awt.*;
import java.util.*;

public class Kings_Path {

    static HashMap<Point, Boolean> hm;
    static int x1,x2,y1,y2,n;
    static int bfs()
    {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x1, y1));

        int size = -1;
        outer:
        while (!q.isEmpty()) {
            int sz = q.size();
            size++;
            while (sz-- > 0) {
                Point tmp = q.poll();
                if (tmp.x == x2 && tmp.y == y2) {
                  return size;
                } else {
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            int x = tmp.x + i;
                            int y = tmp.y + j;
                            Point pp = new Point(x, y);
                            if (hm.containsKey(pp) && !hm.get(pp)) {
                                q.add(pp);
                                hm.put(pp, true);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         x1 = sc.nextInt();
         y1 = sc.nextInt();
         x2 = sc.nextInt();
         y2 = sc.nextInt();
         n = sc.nextInt();
        hm = new HashMap<Point, Boolean>(n);
        hm.put(new Point(x1, y1), true);
        while (n-- > 0) {
            int r = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            for (int i = c1; i <= c2; i++) {
                hm.put(new Point(r, i), false);
            }
        }
        System.out.println(bfs());



    }
}
