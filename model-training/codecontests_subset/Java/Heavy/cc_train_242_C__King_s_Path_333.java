import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class C {
    
    static StringTokenizer st;
    static BufferedReader in;
    static class Sort implements Comparable<Sort> {
        int L, R;
        public int compareTo(Sort o) {
            if (this.L==o.L)
                return this.R-o.R;
            return this.L-o.L;
        }
        public Sort(int L, int R) {
            this.L = L;
            this.R = R;
        }
    }
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int y1 = nextInt();
        int x1 = nextInt();
        int y2 = nextInt();
        int x2 = nextInt();
        int n = nextInt();
        ArrayList<Sort>[] L = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            L[i] = new ArrayList<Sort>();
        }
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[]row = new int[n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int r = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (!map.containsKey(r)) {
                map.put(r, ++cnt);
                row[cnt] = r;
            }
            L[map.get(r)].add(new Sort(a, b));
        }
        for (int i = 1; i <= cnt; i++) {
            Collections.sort(L[i]);
        }
        Set<Point> set = new HashSet<Point>();
        for (int i = 1; i <= cnt; i++) {
            int max = 1;
            for (Sort p : L[i]) {
                for (int j = Math.max(p.L, max); j <= p.R; j++) {
                    set.add(new Point(j, row[i]));
                }
                max = Math.max(max, p.R);
            }
        }
        Queue<Point> q = new LinkedList<Point>();
        Queue<Integer> xod = new LinkedList<Integer>();
        q.add(new Point(x1, y1));
        int[]dx = {1, 1, -1, -1, 1, 0, -1, 0};
        int[]dy = {-1, 1, 1, -1, 0, 1, 0, -1};
        xod.add(0);
        Set<Point> used = new HashSet<Point>();
        used.add(new Point(x1, y1));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int num = xod.poll();
            if (p.x==x2 && p.y==y2) {
                System.out.println(num);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int x = p.x+dx[i], y = p.y+dy[i];
                Point pp = new Point(x, y);
                if (x >= 1 && x <= 1e9 && y >= 1 && y <= 1e9 && !used.contains(pp) && set.contains(pp)) {
                    used.add(pp);
                    q.add(pp);
                    xod.add(num+1);
                }
            }
        }
        System.out.println(-1);
        pw.close();
    }
    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
