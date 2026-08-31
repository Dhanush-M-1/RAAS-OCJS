import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div1A {

    public static void main(String[] args) throws IOException {
        Div1A solver = new Div1A();
        solver.solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new StringReader("? + ? - ? + ? + ? = 42"));
//        BufferedReader reader = new BufferedReader(new StringReader("? + ? - ? = 3"));
//        BufferedReader reader = new BufferedReader(new StringReader("? = 1000000"));
//        BufferedReader reader = new BufferedReader(new StringReader("? - ? = 1"));

        String line = reader.readLine();

        FastScanner sc = new FastScanner(line);

        int N = 1;
        int M = 0;
        int X = 0;
        while (true) {
            String token = sc.next();

            char c = token.charAt(0);

            if (c == '+') ++N;
            if (c == '-') ++M;
            if (c == '=') {
                X = sc.nextInt();
                break;
            }
        }

//        System.out.println(N);
//        System.out.println(M);
//        System.out.println(X);

        int lo = 1;
        int hi = 2000000000;
        int S = -1;
        while (lo + 1 < hi) {
            int mid = (lo + hi + 1) / 2;
            int ac = check(X, N, mid);
            int bc = check(X, M, mid - X);

            if (ac > 0) {
                if (bc >= 0) {
                    hi = mid;
                } else {
                    break;
                }
            } else if (ac < 0) {
                if (bc <= 0) {
                    lo = mid;
                } else {
                    break;
                }
            } else { // == 0
                if (bc > 0) {
                    hi = mid;
                } else if (bc < 0) {
                    lo = mid;
                } else {
                    S = mid;
                    break;
                }
            }
        }

        if (S >= 0) {
            // Possible
            System.out.println("Possible");

            int[] a = find(N, X, S);
            int[] b = find(M, X, S - X);

//            System.out.println(S);
//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(b));

            FastScanner sc2 = new FastScanner(line);
            int ap = 0;
            int bp = 0;
            System.out.print(a[ap++]);
            while (true) {
                String token = sc2.next();

                char c = token.charAt(0);

                if (c == '+') System.out.print(" + " + a[ap++]);
                if (c == '-') System.out.print(" - " + b[bp++]);
                if (c == '=') {
                    System.out.println(" = " + X);
                    break;
                }
            }

        } else {
            // Impossible
            System.out.println("Impossible");
        }

    }

    private int[] find(int N, int X, int S) {
        int[] a = new int[N];

        int rest = S;
        for (int i = 0; i < N; i++) {
            int d = Math.min(X, rest - (N - (i + 1)));
            a[i] = d;
            rest -= d;
        }

        return a;
    }

    private int check(int X, int N, int S) {
        if (N > S) return -1;
        if (X * N < S) return 1;
        return 0;
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
