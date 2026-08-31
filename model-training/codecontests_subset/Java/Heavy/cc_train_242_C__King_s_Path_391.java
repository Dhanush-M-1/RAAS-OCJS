
/* 
Keep solving problems. 
*/
import java.util.*;
import java.io.*;

public class CF149C {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long mod = 1000L * 1000L * 1000L + 7;
    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    void solve() throws IOException {
        long x0 = nextLong();
        long y0 = nextLong();
        long x1 = nextLong();
        long y1 = nextLong();

        Set<Long> hs = new HashSet<>();
        int n = nextInt();
        for(int i = 0; i < n; i++) {
            long row = nextLong();
            long low = nextLong();
            long high = nextLong();
            for(long l = low; l <= high; l++) {
                long val = row * mod + l;
                hs.add(val);
            }
        }
        Map<Long, Long> hm = new HashMap<>();
        LinkedList<Point> list = new LinkedList<>();
        list.add(new Point(x0, y0, 0));
        hm.put(mod * x0 + y0, 0L);
        while(!list.isEmpty()) {
            Point cur = list.poll();
            for(int i = 0; i < dx.length; i++) {
                long nextX = cur.x + dx[i];
                long nextY = cur.y + dy[i];
                long nextLoc = nextX * mod + nextY;
                if(hs.contains(nextLoc) && !hm.containsKey(nextLoc)) {
                    list.add(new Point(nextX, nextY, cur.dist + 1));
                    hm.put(nextLoc, cur.dist + 1);
                }
            }
        }
        long dest = x1 * mod + y1;
        if(hm.containsKey(dest)) {
            out(hm.get(dest));
        }
        else {
            out(-1);
        }
    }
    class Point {
        long x;
        long y;
        long dist;
        public Point(long x, long y, long dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private void outln(Object o) {
        System.out.println(o);
    }
    private void out(Object o) {
        System.out.print(o);
    }
    public CF149C() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CF149C();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}

