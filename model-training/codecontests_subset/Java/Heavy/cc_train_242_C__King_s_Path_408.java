import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
    int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};
    HashMap<Integer, Set<Integer>> m;
    int sx, sy, tx, ty;
    void run(FastScanner in, PrintWriter out) {

        // bfs on allowed paths

        m = new HashMap<>();
        sx = in.nextInt();
        sy = in.nextInt();
        tx = in.nextInt();
        ty = in.nextInt();

        int n = in.nextInt();
        while (n-- > 0) {
            int r = in.nextInt();
            if (!m.containsKey(r)) {
                m.put(r, new HashSet<>());
            }
            Set<Integer> s = m.get(r);
            for (int a = in.nextInt(), b = in.nextInt(); a <= b; a++) {
                s.add(a);
            }
        }

        Set<Long> visited = new HashSet<>();

        // A*
        // {x, y, dist, distFromTarget (diagonal distance)}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2]+a[3]-(b[2]+b[3]);
        });
        pq.offer(new int[] {sx, sy, 0, getDist(sx, sy)});

        boolean found = false;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            int d = top[2];

            if (x == tx && y == ty) {
                out.println(d);
                found = true;
                break;
            }

            long key = getkey(x, y);
            if (visited.contains(key)) continue;
            visited.add(key);

            for (int i = 0; i < 8; i++) {
                int newx = x+dx[i];
                int newy = y+dy[i];
                if (!m.containsKey(newx)
                        || !m.get(newx).contains(newy)
                        || visited.contains(getkey(newx, newy))) continue;
                pq.add(new int[] {newx, newy, d+1, getDist(newx, newy)});
            }
        }
        if (!found) out.println(-1);
    }

    int getDist(int x, int y) {
        int xDiff = Math.abs(x-tx);
        int yDiff = Math.abs(y-ty);
        return xDiff + yDiff - Math.min(xDiff, yDiff);
    }

    long getkey(int x, int y) {
        return ((long)(10e9+1))*x + y;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
