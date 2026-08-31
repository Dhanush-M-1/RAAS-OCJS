import java.io.*;
import java.util.*;

public class c {
    public static int k;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        FastReader scanner = new FastReader();

        int T = scanner.nextInt();

        while (T-- > 0) {
            k = scanner.nextInt();
            int n = scanner.nextInt(), m = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = scanner.nextInt();

            int[] b = new int[m];
            for (int i = 0; i < m; i++)
                b[i] = scanner.nextInt();

            int[] aPref = new int[n];
            int[] bPref = new int[m];
            aPref[0] = a[0] == 0 ? 1 : 0;
            bPref[0] = b[0] == 0 ? 1 : 0;

            for (int i = 1; i < n; i++) {
                aPref[i] = aPref[i - 1] + (a[i] == 0 ? 1 : 0);
            }

            for (int i = 1; i < m; i++) {
                bPref[i] = bPref[i - 1] + (b[i] == 0 ? 1 : 0);
            }

            // (integer, integer) -> list
            Map<Integer, Map<Integer, List<Integer>>> dp = new HashMap<Integer, Map<Integer, List<Integer>>>();

            List<Integer> ans = recurse(dp, a, b, aPref, bPref, 0, 0);
            for (Integer t : ans) {
                pw.printf("%d ", t);
            }
            pw.printf("\n");
            // System.out.println(dp.get(0).get(0));
        }

        pw.flush();
    }

    private static List<Integer> recurse(Map<Integer, Map<Integer, List<Integer>>> dp, int[] a, int[] b, int[] aPref,
            int[] bPref, int aInd, int bInd) {
        List<Integer> ans = new ArrayList<Integer>();
        int lines = k + (aInd > 0 ? aPref[aInd - 1] : 0) + (bInd > 0 ? bPref[bInd - 1] : 0);
        dp.putIfAbsent(aInd, new HashMap<Integer, List<Integer>>());

        if (aInd == a.length && bInd == b.length)
            return ans;

        Map<Integer, List<Integer>> cache = dp.get(aInd);

        if (cache.containsKey(bInd)) {
            return cache.get(bInd);
        }

        if (aInd < a.length) {
            boolean invalid = false;

            if (a[aInd] == 0 || a[aInd] <= lines) {
                // System.out.printf("%d, %d, %d,%d\n", lines, a[aInd], aInd, bInd);
                List<Integer> suff = recurse(dp, a, b, aPref, bPref, aInd + 1, bInd);

                if (suff.size() == 0 || (suff.size() > 0 && suff.get(0) != -1)) {
                    ans.add(a[aInd]);

                    for (Integer s : suff) {
                        ans.add(s);
                    }

                    // System.out.println(ans);
                    cache.put(bInd, ans);
                    return ans;
                }
            }
        }

        if (bInd < b.length) {
            if (b[bInd] == 0 || b[bInd] <= lines) {
                // System.out.printf("%d, %d, %d,%d\n", lines, b[bInd], aInd, bInd);
                List<Integer> suff = recurse(dp, a, b, aPref, bPref, aInd, bInd + 1);

                if (suff.size() == 0 || (suff.size() > 0 && suff.get(0) != -1)) {
                    ans.add(b[bInd]);

                    for (Integer s : suff) {
                        ans.add(s);
                    }

                    cache.put(bInd, ans);
                    return ans;
                }
            }
        }

        ans.add(-1);
        cache.put(bInd, ans);
        return ans;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}