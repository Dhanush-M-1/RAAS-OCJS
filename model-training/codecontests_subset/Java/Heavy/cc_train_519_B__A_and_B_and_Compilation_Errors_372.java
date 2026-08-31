import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task519B {

    public static void main(String... args) throws NumberFormatException,
            IOException {
        Solution.main(System.in, System.out);
    }

    static class Scanner {

        private final BufferedReader br;
        private String[] cache;
        private int cacheIndex;

        Scanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            cache = new String[0];
            cacheIndex = 0;
        }

        int nextInt() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Integer.parseInt(cache[cacheIndex++]);
        }

        long nextLong() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Long.parseLong(cache[cacheIndex++]);
        }

        String next() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return cache[cacheIndex++];
        }

        void close() throws IOException {
            br.close();
        }

    }

    static class Solution {

        public static void main(InputStream is, OutputStream os)
                throws NumberFormatException, IOException {
            PrintWriter pw = new PrintWriter(os);
            Scanner sc = new Scanner(is);

            int n = sc.nextInt();

            Map<Integer, Integer> a = new HashMap<>();
            Map<Integer, Integer> b = new HashMap<>();
            Map<Integer, Integer> c = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                if (a.containsKey(tmp)) {
                    a.put(tmp, a.get(tmp) + 1);
                } else {
                    a.put(tmp, 1);
                }
            }

            for (int i = 0; i < n - 1; i++) {
                int tmp = sc.nextInt();
                if (b.containsKey(tmp)) {
                    b.put(tmp, b.get(tmp) + 1);
                } else {
                    b.put(tmp, 1);
                }
            }

            for (int i = 0; i < n - 2; i++) {
                int tmp = sc.nextInt();
                if (c.containsKey(tmp)) {
                    c.put(tmp, c.get(tmp) + 1);
                } else {
                    c.put(tmp, 1);
                }
            }


            for (int i : b.keySet()) {
                a.put(i, a.get(i) - b.get(i));
            }

            for (int i : c.keySet()) {
                b.put(i, b.get(i) - c.get(i));
            }

            a.forEach((integer, integer2) -> {
                if (integer2.equals(1)) {
                    pw.println(integer);
                }
            });

            b.forEach((integer, integer2) -> {
                if (integer2.equals(1)) {
                    pw.println(integer);
                }
            });

            pw.flush();
            sc.close();
        }
    }

}