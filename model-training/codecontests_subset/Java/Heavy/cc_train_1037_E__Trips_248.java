import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class E {

    static final long MODULO = (long) (1e9 + 7);

    public static void main(String[] args) {
        BufferedScanner scanner = new BufferedScanner();
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int t = 1;//scanner.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] edges = new int[m][];
            SetInt[] adj = new SetInt[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new SetInt();
            }
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                adj[a].add(b);
                adj[b].add(a);
                edges[i] = new int[]{a, b};
            }
            TreeSet<Item> s = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                s.add(new Item(i, adj[i].size()));
            }
//            adjust(k, adj, s, deg);
//            System.err.println("s.size=" + s.size());
            int[] ans = new int[m];
            for (int i = m - 1; i >= 0; i--) {
                adjust(k, adj, s);
                ans[i] = s.size();
//                for (Item item : s) {
//                    System.err.print((item.node + 1) + " ");
//                }
//                System.err.println();
//                System.err.println("s[0]=(node=" + s.first().node + ",deg=" + s.first().deg + ")");
                Item a = new Item(edges[i][0], adj[edges[i][0]].size());
                if (!s.contains(a)) {
                    continue;
                }
                Item b = new Item(edges[i][1], adj[edges[i][1]].size());
                if (!s.contains(b)) {
                    continue;
                }

                s.remove(a);
                adj[a.node].remove(b.node);
                a.deg = adj[a.node].size();
                if (a.deg >= k) {
                    s.add(a);
                } else {
                    adjustDeg(s, adj, a.node);
                }

                b = new Item(edges[i][1], adj[edges[i][1]].size());
                s.remove(b);
                adj[b.node].remove(a.node);
                b.deg = adj[b.node].size();
                if (b.deg >= k) {
                    s.add(b);
                } else {
                    adjustDeg(s, adj, b.node);
                }
            }
            for (int each : ans) {
                writer.println(each);
            }
        }

        scanner.close();
        writer.flush();
        writer.close();
    }

    private static void adjust(int k, SetInt[] adj, TreeSet<Item> s) {
        while (!s.isEmpty() && adj[s.first().node].size() < k) {
            int node = s.pollFirst().node;
            adjustDeg(s, adj, node);
//            System.err.println((node + 1) + " removed, deg=" + adj[node].size());
        }
    }

    private static void adjustDeg(TreeSet<Item> s, SetInt[] adj, int node) {
        for (int friend : adj[node]) {
            Item target = new Item(friend, adj[friend].size());
            if (s.remove(target)) {
                adj[friend].remove(node);
                target.deg = adj[friend].size();
                s.add(target);
            }
        }
    }

    static class Item implements Comparable<Item> {
        int node, deg;

        Item(int node, int deg) {
            this.node = node;
            this.deg = deg;
        }

        @Override
        public int compareTo(Item o) {
            if (deg != o.deg) {
                return deg - o.deg;
            } else {
                return node - o.node;
            }
        }
    }

    static class SetInt extends HashSet<Integer> {}

    static class ListInt extends ArrayList<Integer> {}

    public static class BufferedScanner {
        BufferedReader br;
        StringTokenizer st;

        public BufferedScanner(Reader reader) {
            br = new BufferedReader(reader);
        }

        public BufferedScanner() {
            this(new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        while (b > 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    static long inverse(long a, long m) {
        long[] ans = extgcd(a, m);
        return ans[0] == 1 ? (ans[1] + m) % m : -1;
    }

    private static long[] extgcd(long a, long m) {
        if (m == 0) {
            return new long[]{a, 1, 0};
        } else {
            long[] ans = extgcd(m, a % m);
            long tmp = ans[1];
            ans[1] = ans[2];
            ans[2] = tmp;
            ans[2] -= ans[1] * (a / m);
            return ans;
        }
    }

    static long add(long a, long b) {
        a += b;
        if (a >= MODULO) {
            a -= MODULO;
        }
        return a;
    }

    static long sub(long a, long b) {
        a -= b;
        if (a < 0) {
            a += MODULO;
        }
        return a;
    }

    static long mul(long a, long b) {
        return a * b % MODULO;
    }

    static long div(long a, long b) {
        return a * inverse(b, MODULO) % MODULO;
    }

    static class Comb {
        final long modulo;
        final long[] fac, fnv;

        Comb(int limit, long modulo) {
            fac = new long[limit + 1];
            fnv = new long[limit + 1];
            fac[0] = 1;
            fnv[0] = 1;
            for (int i = 1; i <= limit; i++) {
                fac[i] = mul(fac[i - 1], i);
                fnv[i] = div(fnv[i - 1], i);
            }
            this.modulo = modulo;
        }

        long c(int total, int choose) {
            if (total < choose) {
                return 0;
            }
            if (total == 0 || total == choose) {
                return 1;
            }
            return mul(mul(fac[total], fnv[choose]), fnv[total - choose]);
        }
    }

}
