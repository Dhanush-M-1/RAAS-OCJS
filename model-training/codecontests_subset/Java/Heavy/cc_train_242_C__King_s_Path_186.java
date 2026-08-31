
import java.util.*;

public class cf242c {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        pair x = new pair(in.nextInt(), in.nextInt());
        pair y = new pair(in.nextInt(), in.nextInt());

        int n = in.nextInt();

        Set<pair> set = new HashSet<pair>();

        for (int i = 0; i < n; i++) {

            int row = in.nextInt();

            int f = in.nextInt();
            int t = in.nextInt();

            for (int j = f; j <= t; j++) {

                set.add(new pair(row, j));

            }

        }

        Set<pair> marked = new HashSet<pair>();

        Map<pair, Integer> distTo = new HashMap<pair, Integer>();

        Queue<pair> q = new ArrayDeque<pair>();

        for (pair o : set) {

            distTo.put(o, Integer.MAX_VALUE);

        }

        distTo.put(x, 0);
        marked.add(x);
        q.offer(x);

        while (!q.isEmpty()) {

            pair v = q.poll();
            for (int i = 0; i < 8; i++) {

                int newx = v.x + dx[i];
                int newy = v.y + dy[i];

                pair newp = new pair(newx, newy);

                if (set.contains(newp) && !marked.contains(newp)) {

                    distTo.put(newp, distTo.get(v) + 1);
                    marked.add(newp);
                    q.offer(newp);

                }

            }
        }

        int ans = distTo.get(y);
        if (ans == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }

    }

    static class pair {

        int x;
        int y;
        String s;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;

            s = x + "-" + y;

        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return s.equals(((pair) obj).s);
        }

    }

}
