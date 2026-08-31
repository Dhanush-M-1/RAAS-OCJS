import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        D solver = new D();
        solver.solve();
    }

    private void solve() throws IOException {
        FastScanner sc = new FastScanner(System.in);
//        sc = new FastScanner("7 11\n" +
//                "2 4 7 3\n");
//        sc = new FastScanner("1000 999\n" +
//                "10 20 30 40\n");

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] nodes = new int[n];
        nodes[0] = a;
        nodes[1] = b;
        nodes[2] = c;
        nodes[3] = d;

        int next = 1;
        for (int i = 4; i < n; i++) {
            while (next == a || next == b || next == c || next == d) ++next;
            nodes[i] = next++;
        }

//        System.out.println(Arrays.toString(nodes));

        if (n > 4 && k > n) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(nodes[0]);
            sb1.append(' ');
            sb1.append(nodes[2]);
            for (int i = 4; i < n; i++) {
                sb1.append(' ');
                sb1.append(nodes[i]);
            }
            sb1.append(' ');
            sb1.append(nodes[3]);
            sb1.append(' ');
            sb1.append(nodes[1]);
            System.out.println(sb1.toString());

            StringBuilder sb2 = new StringBuilder();
            sb2.append(nodes[2]);
            sb2.append(' ');
            sb2.append(nodes[0]);
            for (int i = 4; i < n; i++) {
                sb2.append(' ');
                sb2.append(nodes[i]);
            }
            sb2.append(' ');
            sb2.append(nodes[1]);
            sb2.append(' ');
            sb2.append(nodes[3]);
            System.out.println(sb2.toString());
        } else {
            System.out.println(-1);
        }


    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream in) throws IOException {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(File file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public FastScanner(String s) {
            br = new BufferedReader(new StringReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
