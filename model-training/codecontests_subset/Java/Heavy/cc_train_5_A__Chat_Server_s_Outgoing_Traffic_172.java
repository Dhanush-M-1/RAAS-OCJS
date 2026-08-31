import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static PrintWriter out = new PrintWriter(System.out);
    private static FastScanner sc;

    public static void main(String[] args) throws Exception {
        InputStream is = Main.class.getResourceAsStream("in.txt");
        boolean testMode = is != null;
        sc = new FastScanner(testMode ? is : System.in);

        long start = System.currentTimeMillis();
        main();

        if (testMode) {
            out.println();
            out.print(System.currentTimeMillis() - start + " ms");
        }

        out.close();
    }

    private static void main() throws Exception {
        Set<String> online = new HashSet<>();
        String line;
        long total = 0;
        while ((line = sc.nextLine()) != null) {
            if (line.charAt(0) == '+') {
                String name = line.substring(1);
                online.add(name);
            } else if (line.charAt(0) == '-') {
                String name = line.substring(1);
                online.remove(name);
            } else {
                String[] arr = line.split(":");
                total += online.size() * (arr.length == 2 ? arr[1].length() : 0);
            }
        }
        System.out.println(total);
    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}