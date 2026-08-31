import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EConnectedComponents solver = new EConnectedComponents();
        solver.solve(1, in, out);
        out.close();
    }

    static class EConnectedComponents {
        boolean[] vis;
        int n;
        HashSet<Integer>[] adjL;
        TreeSet<Integer> left;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            n = sc.nextInt();
            int m = sc.nextInt();
            adjL = new HashSet[n];
            left = new TreeSet<>();
            for (int i = 0; i < n; i++)
                left.add(i);
            for (int i = 0; i < n; i++)
                adjL[i] = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
                adjL[u].add(v);
                adjL[v].add(u);
            }
            vis = new boolean[n];
            int c = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    left.remove(i);
                    list.add(dfs(i));
                }
            }
            pw.println(list.size());
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++)
                pw.print(list.get(i) + " ");
        }

        private int dfs(int u) {
            vis[u] = true;
            int ans = 1;
            Integer temp = left.higher(u);
            while (temp != null) {
                if (adjL[u].contains(temp.intValue())) {
                    temp = left.higher(temp.intValue());
                    continue;
                }
                left.remove(temp.intValue());
                ans += dfs(temp.intValue());
                temp = left.higher(temp.intValue());
            }
            temp = left.lower(u);
            while (temp != null) {
                if (adjL[u].contains(temp.intValue())) {
                    temp = left.lower(temp.intValue());
                    continue;
                }
                left.remove(temp.intValue());
                ans += dfs(temp.intValue());
                temp = left.lower(temp.intValue());
            }
            return ans;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

