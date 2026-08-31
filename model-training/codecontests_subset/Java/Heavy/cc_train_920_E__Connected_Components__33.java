import java.io.*;
import java.util.*;

public class E {
    /**********************************************************************************************
     *                                            DEBUG                                           *
     **********************************************************************************************/
    private final static boolean DEBUG = false;
    private final static String[] DEBUG_INPUT = {
            "5 5\n" +
                    "1 2\n" +
                    "3 4\n" +
                    "3 2\n" +
                    "4 2\n" +
                    "2 5",
    };



    /**********************************************************************************************
     *                                             MAIN                                           *
     **********************************************************************************************/
    private static class Solver {
        Set<Integer>[] map;
        Set<Integer> all;
        List<Integer> res;
        int count;
        int n;

        public void solve(Reader in, PrintWriter out) throws IOException {
            n = in.nextInt();
            int m = in.nextInt();
            map = new Set[n + 1];
            for (int i = 0; i < m; i++) {
                int v = in.nextInt();
                int w = in.nextInt();
                if (map[v] == null) map[v] = new HashSet<>();
                map[v].add(w);
                if (map[w] == null) map[w] = new HashSet<>();
                map[w].add(v);
            }

            all = new LinkedHashSet<>();
            for (int i = 1; i <= n; i++) all.add(i);

            res = new ArrayList<>();
            while (!all.isEmpty()) {
                count = 0;
                dfs(all.iterator().next());
                res.add(count);
            }

            Collections.sort(res);
            out.println(res.size());
            for (int i : res) out.print(i + " ");
        }

        private void dfs(int idx) {
            Set<Integer> set = map[idx];
            List<Integer> next = new ArrayList<>();
            if (set == null) {
                count += all.size();
                next.addAll(all);
                all.clear();
            } else {
                for (int i : all) {
                    if (!set.contains(i)) {
                        next.add(i);
                        count++;
                    }
                }
                all.removeAll(next);
            }
            for (int i : next) {
                dfs(i);
            }
        }
    }



    /**********************************************************************************************
     *                                           TEMPLATE                                         *
     **********************************************************************************************/
    public static void main(String[] args) throws IOException {
        PrintWriter out;
        Reader in;
        if (DEBUG) {
            for (String s : DEBUG_INPUT) {
                in = new Reader(new ByteArrayInputStream(s.getBytes()));
                out = new PrintWriter(System.out);
                out.println("===>>> INPUT");
                out.println(s + "\n");
                out.println("===>>> OUTPUT");
                long start = System.currentTimeMillis();
                new Solver().solve(in, out);
                long end = System.currentTimeMillis();
                out.println("\n");
                out.println("===========");
                out.println("Took: " + (end - start) + "ms");
                out.println("====================================================================");
                out.println();
                out.println();
                out.flush();
            }
        } else {
            in = new Reader(System.in);
            out = new PrintWriter(System.out);
            new Solver().solve(in, out);
            out.flush();
        }
    }

    /** Reader **/
    private static class Reader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        private String nextWord() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        private int nextInt() throws IOException {
            return Integer.parseInt(nextWord());
        }

        private long nextLong() throws IOException {
            return Long.parseLong(nextWord());
        }

        private double nextDouble() throws IOException {
            return Double.parseDouble(nextWord());
        }
    }
}
