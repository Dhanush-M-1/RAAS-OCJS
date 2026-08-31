import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int xi = Integer.parseInt(st.nextToken());
        int yi = Integer.parseInt(st.nextToken());
        int xf = Integer.parseInt(st.nextToken());
        int yf = Integer.parseInt(st.nextToken());
        HashSet<Point> points = new HashSet<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= b; j++) {
                points.add(new Point(r, j));
            }
        }
        Queue<Point> queue = new LinkedList<>();
        HashMap<Point, Integer> dist = new HashMap<>();
        queue.offer(new Point(xi, yi));
        dist.put(new Point(xi, yi), 0);
        int[] dx = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                Point v = new Point(p.x+dx[i], p.y+dy[i]);
                if (points.contains(v) && !dist.containsKey(v)) {
                    dist.put(v, dist.get(p) + 1);
                    queue.offer(v);
                }
            }
        }
        Point f = new Point(xf, yf);
        if (dist.containsKey(f)) {
            System.out.println(dist.get(f));
        } else {
            System.out.println("-1");
        }
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
/*


 */