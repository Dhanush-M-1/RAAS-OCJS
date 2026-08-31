import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        new C().solve();
    }

    BufferedReader br;
    StringTokenizer st = new StringTokenizer("");

    private void solve() throws IOException {
//        doit();
        br = new BufferedReader(new InputStreamReader(System.in));
        int maxX = nextInt();
        int maxY = nextInt();
        int w = nextInt();
        br.close();
        int[] ans = find(maxX, maxY, w);
        PrintWriter pw = new PrintWriter(System.out);
        if (ans == null) {
            pw.println(-1);
        } else {
            pw.println(ans[0] + " " + ans[1]);
        }
        pw.close();
    }

    void doit() {
        int cnt = 0;
        for (int x = 1; x <= 12; x++) {
            for (int y = 1; y <= 132; y++) {
                if (y * x == rev(y) * rev(x)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.exit(1);
    }
    int[] find(int maxX, int maxY, int w) {
        Rev[] xrevs = createRevnum(maxX, false);
        Rev[] yrevs = createRevnum(maxY, true);
        Map<Frac, List<Integer>> mapX = createMap(xrevs);
        Map<Frac, List<Integer>> mapY = createMap(yrevs);
        int curW = 0;
        int y = maxY;
        int bestX = maxX, bestY = maxY;
        for (int x = 1; x <= maxX; x++) {
            Rev xr = xrevs[x];
            List<Integer> list = safe(mapY.get(xr.frac));
            checkList(xr.n, list);
            int a = countLessOrEqual(safe(mapY.get(xr.frac)), y);
            curW += a;
            while (y >= 1) {
                Rev yr = yrevs[y];
                int cnt = countLessOrEqual(safe(mapX.get(yr.frac)), x);
                if (curW - cnt >= w) {
                    curW -= cnt;
                    y--;
                } else {
                    break;
                }
            }
            if (curW >= w && ((long)x) * y < ((long)bestX) * bestY) {
                bestX = x;
                bestY = y;
            }
        }
        if (curW < w) {
            return null;
        }
        return new int[] {bestX, bestY};
    }

    private void checkList(int x, List<Integer> list) {
        for (int y : list) {
            if (x * y != rev(x) * rev(y)) {
                System.err.println("Botva at " + x + ", " + y);
            }
        }
    }

    int countLessOrEqual(List<Integer> list, int max) {
        int low = 0, high = list.size();
        if (list.isEmpty() || max < list.get(low)) {
            return 0;
        }
        while (high - low > 1) {
            int m = (low + high) / 2;
            if (list.get(m) > max) {
                high = m;
            } else {
                low = m;
            }
        }
        return low + 1;
    }

    Map<Frac, List<Integer>> createMap(Rev[] revs) {
        Map<Frac, List<Integer>> map = new HashMap<Frac, List<Integer>>();
        for (int i = 1; i < revs.length; i++) {
            Rev r = revs[i];
            List<Integer> l = map.get(r.frac);
            if (l == null) {
                map.put(r.frac, l = new ArrayList<Integer>());
            }
            l.add(r.n);
        }
        return map;
    }

    List<Integer> safe(List<Integer> l) {
        if (l == null) {
            return Collections.emptyList();
        }
        return l;
    }

    Rev[] createRevnum(int n, boolean swap) {
        Rev[] r = new Rev[n + 1];
        for (int i = 1; i <= n; i++) {
            r[i] = new Rev(i, swap);
        }
        return r;
    }

    static class Frac {
        int num;
        int denum;

        Frac(int up, int down) {
            int gcd = gcd(up, down);
            this.num = up / gcd;
            this.denum = down / gcd;
        }

        int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Frac that = (Frac) o;

            return this.num * that.denum == this.denum * that.num;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + denum;
            return result;
        }
    }

    static class Rev {
        int n;
        Frac frac;

        Rev(int n, boolean swap) {
            this.n = n;
            int revn = rev(n);
            int up = swap ? revn : n;
            int down = swap ? n : revn;
            this.frac = new Frac(up, down);
        }
    }

    static int rev(int a) {
        int rev = 0;
        while (a != 0) {
            rev = rev * 10 + a % 10;
            a /= 10;
        }
        return rev;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
}
