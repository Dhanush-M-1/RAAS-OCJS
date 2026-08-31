import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedInputStream;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ETrips solver = new ETrips();
        solver.solve(1, in, out);
        out.close();
    }

    static class ETrips {
        int[] degree;
        ArrayList<Integer>[] arrayList;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int k = in.scanInt();
            degree = new int[n + 1];
            arrayList = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                arrayList[i] = new ArrayList<>();
            }


            int edges[][] = new int[m][2];
            for (int i = 0; i < m; i++) {
                int x = in.scanInt();
                int y = in.scanInt();
                edges[i][0] = x;
                edges[i][1] = y;
                degree[x]++;
                degree[y]++;
                arrayList[x].add(y);
                arrayList[y].add(x);
            }


            TreeSet<pair> treeSet = new TreeSet<>();


            HashSet<Long> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                treeSet.add(new pair(degree[i], i));
            }


            boolean inside[] = new boolean[n + 1];
            Arrays.fill(inside, true);

            while (!treeSet.isEmpty() && treeSet.first().degree < k) {
                pair temp = treeSet.first();

                for (int i = 0; i < arrayList[temp.index].size(); i++) {


                    int adj = arrayList[temp.index].get(i);
                    if (!inside[adj]) continue;
                    if (set.contains(adj * 1000000000l + temp.index) || set.contains(temp.index * 1000000000l + adj))
                        continue;


                    treeSet.remove(new pair(degree[adj], adj));
                    degree[adj]--;
                    degree[temp.index]--;
                    treeSet.add(new pair(degree[adj], adj));
                    set.add(adj * 1000000000l + temp.index);
                }
                inside[temp.index] = false;
                treeSet.remove(temp);
            }

            long ans[] = new long[m];
            ans[m - 1] = treeSet.size();
            for (int i = m - 1; i > 0; i--) {
                int x = edges[i][0];
                int y = edges[i][1];
                if (inside[x] && inside[y]) {
                    treeSet.remove(new pair(degree[x], x));
                    degree[x]--;
                    treeSet.add(new pair(degree[x], x));
                    treeSet.remove(new pair(degree[y], y));
                    degree[y]--;
                    treeSet.add(new pair(degree[y], y));
                    set.add(1000000000l * x + y);
                }


                while (!treeSet.isEmpty() && treeSet.first().degree < k) {
                    pair temp = treeSet.first();

                    for (int j = 0; j < arrayList[temp.index].size(); j++) {


                        int adj = arrayList[temp.index].get(j);
                        if (!inside[adj]) continue;
                        if (set.contains(adj * 1000000000l + temp.index) || set.contains(temp.index * 1000000000l + adj))
                            continue;


                        treeSet.remove(new pair(degree[adj], adj));
                        degree[adj]--;
                        degree[temp.index]--;
                        treeSet.add(new pair(degree[adj], adj));
                        set.add(adj * 1000000000l + temp.index);
                    }
                    inside[temp.index] = false;
                    treeSet.remove(temp);
                }


                ans[i - 1] = treeSet.size();
            }


            for (int i = 0; i < m; i++) {
                out.println(ans[i]);
            }

        }

        class pair implements Comparable<pair> {
            int degree;
            int index;

            public pair(int degree, int index) {
                this.degree = degree;
                this.index = index;
            }

            public int compareTo(pair o) {
                if (this.degree == o.degree) return this.index - o.index;
                return this.degree - o.degree;
            }

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
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

