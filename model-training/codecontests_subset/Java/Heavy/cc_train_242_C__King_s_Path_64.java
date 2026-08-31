import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KingsPath {
    static int[] xx = {-1, -1, -1, 0, 0, 1, 1, 1},
            yy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) {
        FstScn sc = new FstScn();
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt();
//        if ((x1+1 == x2 && (y1+1 == y2 || y1 == y2)) || (x1-1 == x2 && (y1+1 == y2 || y1 == y2))) {
//            System.out.println(1);
//            System.exit(0);
//        }
        int n = sc.nextInt();
        HashMap<Pair, Integer> hm = new HashMap<>();
        HashMap<Pair, Boolean> visited = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int r = sc.nextInt(), c1 = sc.nextInt(), c2 = sc.nextInt();
            for (int j = c1; j <= c2; ++j) {
                hm.put(new Pair(r, j), 1);
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x1, y1, 0));
        visited.put(new Pair(x1, y1), true);
        int flag = -1;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair it = q.remove();
            int steps = it.ti;
            int x = it.fi;
            int y = it.si;

            for (int i = 0; i < 8; ++i) {
                int newX = x + xx[i];
                int newY = y + yy[i];
                if (newX == x2 && newY == y2) {
                    flag = steps + 1;
                    min = Math.min(min, flag);
                }
                Pair p = new Pair(newX, newY);
                if (!visited.containsKey(p) && hm.get(p) != null) {
                    q.add(new Pair(newX, newY, steps + 1));
                    visited.put(p, true);
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static class Pair {
        int fi, si, ti;
        public Pair(int fi, int si) {
            this.fi = fi;
            this.si = si;
        }
        public Pair(int fi, int si, int ti) {
            this.fi = fi;
            this.si = si;
            this.ti = ti;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return fi == pair.fi && si == pair.si && ti == pair.ti;
        }
        public int hashCode() {
            return Objects.hash(fi, si, ti);
        }
    }
    static class FstScn {
        BufferedReader br;
        StringTokenizer st;
        public FstScn() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
        double nextDouble() {
            return Double.parseDouble(next());
        }
        float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}