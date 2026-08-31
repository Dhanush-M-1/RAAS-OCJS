import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KingsPath {

    public static ArrayList<Point> rearrange(ArrayList<Point> list) {
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        Point cur = list.get(0);

        ArrayList<Point> ret = new ArrayList<Point>();
        for (int i = 1; i < list.size(); i++) {
            Point it = list.get(i);
            if (cur.y >= it.x) {
                cur.y = Math.max(cur.y, it.y);
            } else {
                ret.add(cur);
                cur = it;
            }
        }
        ret.add(cur);

        return ret;
    }

    public static boolean isValed(int y, int x,
            HashMap<Integer, ArrayList<Point>> hm) {

        ArrayList<Point> row = hm.get(y);
        if (row == null || row.size() == 0)
            return false;

        int l = 0;
        int h = row.size() - 1;
        int mid = 0;
        while (l < h) {
            mid = l + (h - l) / 2;

            Point cur = row.get(mid);
            if (cur.x > x) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        Point after = row.get(l);
        if (after.x <= x && after.y >= x)
            return true;
        if (l > 0) {
            Point cur = row.get(l - 1);
            if (cur.x <= x && cur.y >= x)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String[] st = reader.readLine().split(" ");
        int y1 = Integer.parseInt(st[0]);
        int x1 = Integer.parseInt(st[1]);
        int y2 = Integer.parseInt(st[2]);
        int x2 = Integer.parseInt(st[3]);

        int n = Integer.parseInt(reader.readLine());
        HashMap<Integer, ArrayList<Point>> hm = new HashMap<Integer, ArrayList<Point>>();
        for (int i = 0; i < n; i++) {
            st = reader.readLine().split(" ");
            int row = Integer.parseInt(st[0]);
            Point p = new Point(Integer.parseInt(st[1]),
                    Integer.parseInt(st[2]));
            if (!hm.containsKey(row)) {
                ArrayList<Point> list = new ArrayList<Point>();
                list.add(p);
                hm.put(row, list);
            } else {
                hm.get(row).add(p);
            }
        }

        for (Map.Entry<Integer, ArrayList<Point>> e : hm.entrySet()) {
            e.setValue(rearrange(e.getValue()));
        }
//      System.out.println(hm.toString());

        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<String> set = new HashSet<String>();
        q.add(y1);
        q.add(x1);
        q.add(0);
        set.add(y1 + " " + x1);
        int dx[] = { 1, -1, 0, 0, 1, -1, -1, 1 };
        int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            int depth = q.poll();
//          System.out.println(i + " " + j + " " + depth);
            if (i == y2 && j == x2) {
                System.out.println(depth);
                return;
            }

            for (int k = 0; k < dx.length; k++) {
                int ny = i + dy[k];
                int nx = j + dx[k];

                if (isValed(ny, nx, hm))
                    if (!set.contains(ny + " " + nx)) {
                        q.add(ny);
                        q.add(nx);
                        q.add(depth + 1);
                        set.add(ny + " " + nx);
                    }
            }
        }
        System.out.println(-1);
    }

}
