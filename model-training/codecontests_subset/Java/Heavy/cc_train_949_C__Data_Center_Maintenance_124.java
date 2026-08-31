import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;
    int[][] dc;

    void run(FastScanner in, PrintWriter out) {

        int N = in.nextInt(); // num data centers
        int M = in.nextInt(); // num edges
        int H = in.nextInt(); // day length

        dc = new int[N][2];
        for (int i = 0; i < N; i++) {
            dc[i][0] = in.nextInt();
            dc[i][1] = i;
        }

        Arrays.sort(dc, (a, b) -> a[0]-b[0]);

        Map<Integer, Integer> reverseIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            reverseIndex.put(dc[i][1], i);
        }

        adj = new Set[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new HashSet<>();

        while (M-- > 0) {

            int u = reverseIndex.get(in.nextInt()-1);
            int v = reverseIndex.get(in.nextInt()-1);
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            // changing u requires channging v
            if (dc[u][0] == dc[v][0]-1) {
                adj[u].add(v);
            }
            if (dc[u][0] == 0 && dc[v][0] == H-1) {
                adj[v].add(u);
            }
        }


        pre = new int[N];
        link = new int[N];
        sz = new int[N];
        Arrays.fill(pre, -1);
        for (int u = 0; u < N; u++) {
            if (pre[u] != -1) continue;
            dfs(u);
        }

        // System.out.println(minsz);
        // System.out.println(minu);

        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(link));
        // System.out.println(Arrays.toString(sz));

        dfs2(minu);
        System.out.println(minsz);
        for (int x : l) out.print(x + " ");
        out.println();

    }


    LinkedList<Integer> l = new LinkedList<>();
    void dfs2(int u) {
        if (pre[u] == Integer.MAX_VALUE) return;
        pre[u] = Integer.MAX_VALUE;
        l.add(dc[u][1]+1);
        for (int v : adj[u]) {
            dfs2(v);
        }
    }

    int minsz = Integer.MAX_VALUE;
    int minu = 0;
    void dfs(int u) {
        if (pre[u] != -1) return;
        pre[u] = link[u] = prenum++;

        int minLink = pre[u];
        for (int v : adj[u]) {
            if (pre[v] == -1) {
                dfs(v);
                sz[u] += sz[v];
            }
            minLink = Math.min(minLink, link[v]);
        }

        link[u] = minLink;
        sz[u]++;

        if (pre[u] == link[u]) {
            // valid
            if (sz[u] < minsz) {
                minsz = sz[u];
                minu = u;
            }
        }
    }


    int[] pre;
    int[] link;
    int[] sz;
    int prenum;

    Set<Integer>[] adj;

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
