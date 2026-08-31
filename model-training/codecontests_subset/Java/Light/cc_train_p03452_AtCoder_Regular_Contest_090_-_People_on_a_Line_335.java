import java.io.*;
import java.util.*;

public class Main {
    static MyScanner sc;
    private static PrintWriter out;
    static long M2 = 1_000_000_000L + 7;

    public static void main(String[] s) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

//
//        stringBuilder.append("1000000 10000 ");
//        for (int l = 0 ; l < 10000 ; l++) {
//            stringBuilder.append(( l + 1)  +"   " + (l + 2) + " 100000 ");
//        }

        if (stringBuilder.length() == 0) {
            sc = new MyScanner(System.in);
        } else {
            sc = new MyScanner(new BufferedReader(new StringReader(stringBuilder.toString())));
        }


        out = new PrintWriter(new OutputStreamWriter(System.out));
        initData();
        solve();
        out.flush();
    }


    private static void initData() {

    }


    private static void solve() throws IOException {

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, Integer>[] ne = new HashMap[n];
        Arrays.setAll(ne, l -> new HashMap<>());
        for (int i = 0; i < m; i++) {
            int l1 = sc.nextInt() - 1;
            int l2 = sc.nextInt() - 1;
            int d = sc.nextInt();
            ne[l1].put(l2, d);
            ne[l2].put(l1, -d);
        }

        int[] tw = new int[n];
        int w = 0;
        boolean[] vis = new boolean[n];
        for (int s = 0; s < n; s++) {
            if (vis[s]) continue;
            Map<Integer, Long> o = new HashMap<>();
            vis[s] = true;
            o.put(s, 0L);
            tw[w++] = s;
            while (w > 0) {
                int cur = tw[--w];
                long d = o.get(cur);
                for (Map.Entry<Integer, Integer> en : ne[cur].entrySet()) {
                    if (vis[en.getKey()]) {
                        if (o.get(en.getKey()) != en.getValue() + d) {
                            out.println("No");
                            return;
                        }
                    } else {
                        vis[en.getKey()] = true;
                        tw[w++] = en.getKey();
                        o.put(en.getKey(), en.getValue() + d);
                    }
                }
            }
            long max = o.values().stream().max(Comparator.naturalOrder()).get();
            long min = o.values().stream().min(Comparator.naturalOrder()).get();
            if (max - min > 1000000000) {
                out.println("No");
                return;
            }

        }
        out.println("Yes");
    }

    static boolean bpm(boolean[][] bpGraph, int u, boolean seen[],
                       int matchR[]) {
        // Try every job one by one
        for (int v = 0; v < bpGraph.length; v++) {
            // If applicant u is interested in job v and v
            // is not visited
            if (bpGraph[u][v] && !seen[v]) {
                seen[v] = true; // Mark v as visited

                // If job 'v' is not assigned to an applicant OR
                // previously assigned applicant for job v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the above line,
                // matchR[v] in the following recursive call will
                // not get job 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number of matching from M to N
    static int[] maxBPM(boolean[][] bpGraph) {
        // An array to keep track of the applicants assigned to
        // jobs. The value of matchR[i] is the applicant number
        // assigned to job i, the value -1 indicates nobody is
        // assigned.
        int matchR[] = new int[bpGraph.length];

        // Initially all jobs are available
        for (int i = 0; i < bpGraph.length; ++i)
            matchR[i] = -1;

        int result = 0; // Count of jobs assigned to applicants
        for (int u = 0; u < bpGraph.length; u++) {
            // Mark all jobs as not seen for next applicant.
            boolean seen[] = new boolean[bpGraph.length];
            for (int i = 0; i < bpGraph.length; ++i)
                seen[i] = false;

            // Find if the applicant 'u' can get a job
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return matchR;
    }

    private static final int[][] mm(int[][] v1, int[][] v2) {
        int[][] res = new int[v1.length][v1.length];
        for (int s = 0; s < v1.length; s++)
            for (int s1 = 0; s1 < v1.length; s1++) {
                for (int k = 0; k < v1.length; k++) {
                    res[s1][s] += v1[k][s] * v2[s1][k];
                }
            }
        return res;
    }


    private static int ccw(int[] i1, int[] i2) {
        return ccw(i1, i2, new int[]{0, 0});
    }

    private static int ccw(int[] s1, int[] s2, int[] right) {
        long xa = s1[0] - right[0];
        long xb = s1[1] - right[1];
        long ya = s2[0] - right[0];
        long yb = s2[1] - right[1];
        return Long.compare(xb * ya, xa * yb);
    }


    private static void solveT() throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static long gcd(long l, long l1) {
        if (l > l1) return gcd(l1, l);
        if (l == 0) return l1;
        return gcd(l1 % l, l);
    }

    private static long pow(long a, long b, long m) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long pp = pow(a, b / 2, m);
        pp *= pp;
        pp %= m;
        return (pp * (b % 2 == 0 ? 1 : a)) % m;
    }


    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(BufferedReader br) {
            this.br = br;
        }

        public MyScanner(InputStream in) {
            this(new BufferedReader(new InputStreamReader(in)));
        }

        void findToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String next() {
            findToken();
            return st.nextToken();
        }

        Integer[] nab(int n) {
            Integer[] k = new Integer[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
            }
            return k;
        }

        int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
            }
            return k;
        }

        long[] nl(int n) {
            long[] k = new long[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextLong();
            }
            return k;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int fi() {
            String t = next();
            int cur = 0;
            boolean n = t.charAt(0) == '-';
            for (int a = n ? 1 : 0; a < t.length(); a++) {
                cur = cur * 10 + t.charAt(a) - '0';
            }
            return n ? -cur : cur;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }


}