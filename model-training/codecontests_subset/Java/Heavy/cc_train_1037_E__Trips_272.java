import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Stack;
import java.util.HashSet;
import java.io.FilterInputStream;
import java.util.Vector;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author nirav
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scan in = new Scan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ETrips solver = new ETrips();
        solver.solve(1, in, out);
        out.close();
    }

    static class ETrips {
        public void solve(int testNumber, Scan in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int k = in.scanInt();
            int degree[] = new int[n + 1];
            Set<Integer>[] graph = new Set[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new HashSet<>();
            TreeSet<ETrips.pair> queue = new TreeSet<>();
            int array[][] = new int[m + 1][2];
            for (int i = 0; i < m; i++) {
                int a = in.scanInt();
                int b = in.scanInt();
                degree[a]++;
                degree[b]++;
                graph[a].add(b);
                graph[b].add(a);
                array[i + 1][0] = a;
                array[i + 1][1] = b;
            }
            Stack<Integer> ans = new Stack<>();
            for (int i = 1; i <= n; i++) {
                queue.add(new ETrips.pair(degree[i], i));
            }
            for (int i = m; i > 0; i--) {
                while (!queue.isEmpty() && queue.first().a < k) {
                    ETrips.pair g = queue.first();
                    queue.remove(queue.first());
                    Iterator<Integer> it = graph[g.b].iterator();
                    while (it.hasNext()) {
                        int f = it.next();
                        graph[f].remove(g.b);
                        queue.remove(new ETrips.pair(degree[f], f));
                        degree[f]--;
                        queue.add(new ETrips.pair(degree[f], f));
                    }
                    degree[g.b] = 0;
                    graph[g.b] = new HashSet<>();
                }

                ans.add(queue.size());
                if (!graph[array[i][0]].isEmpty() && graph[array[i][0]].contains(array[i][1])) {
                    queue.remove(new ETrips.pair(degree[array[i][0]], array[i][0]));
                    degree[array[i][0]]--;
                    queue.add(new ETrips.pair(degree[array[i][0]], array[i][0]));
                }
                graph[array[i][0]].remove(array[i][1]);
                if (!graph[array[i][1]].isEmpty() && graph[array[i][1]].contains(array[i][0])) {
                    queue.remove(new ETrips.pair(degree[array[i][1]], array[i][1]));
                    degree[array[i][1]]--;
                    queue.add(new ETrips.pair(degree[array[i][1]], array[i][1]));
                }

                graph[array[i][1]].remove(array[i][0]);
            }
            while (!ans.isEmpty()) {
                out.println(ans.pop());
            }
        }

        static class pair implements Comparable<ETrips.pair> {
            int a;
            int b;

            pair(int x, int y) {
                a = x;
                b = y;
            }

            public int compareTo(ETrips.pair o) {
                if (this.a != o.a) {
                    return this.a - o.a;
                } else {
                    return this.b - o.b;
                }
            }

        }

    }

    static class Scan {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public Scan(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

