import java.io.*;
import java.util.*;

/*
polyakoff
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int oo = (int) 1e9 + 10;
    static final long OO = (long) 2e18 + 20;
    static final int MOD = (int) 1e9 + 7;

    static void print(int x, int y) {
        out.println((x + 1) + " " + (y + 1));
    }

    static void solve() {
        int n = in.nextInt();

        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.next().toCharArray();
        }

        int x1 = a[0][1] - '0';
        int x2 = a[1][0] - '0';
        int y1 = a[n - 2][n - 1] - '0';
        int y2 = a[n - 1][n - 2] - '0';

        if (x1 != x2 && y1 != y2) {
            if (x1 == y1) {
                out.println(2);
                print(1, 0);
                print(n - 2, n - 1);
            } else if (x1 == y2) {
                out.println(2);
                print(1, 0);
                print(n - 1, n - 2);
            }
        } else if (x1 != x2) {
            if (y1 == 0) {
                if (x1 == 0) {
                    out.println(1);
                    print(0, 1);
                } else {
                    out.println(1);
                    print(1, 0);
                }
            } else {
                if (x1 == 0) {
                    out.println(1);
                    print(1, 0);
                } else {
                    out.println(1);
                    print(0, 1);
                }
            }
        } else if (y1 != y2) {
            if (x1 == 0) {
                if (y1 == 0) {
                    out.println(1);
                    print(n - 2, n - 1);
                } else {
                    out.println(1);
                    print(n - 1, n - 2);
                }
            } else {
                if (y1 == 0) {
                    out.println(1);
                    print(n - 1, n - 2);
                } else {
                    out.println(1);
                    print(n - 2, n - 1);
                }
            }
        } else {
            if (x1 == y1) {
                out.println(2);
                print(0, 1);
                print(1, 0);
            } else {
                out.println(0);
            }
        }





    }


    public static void main(String[] args) {
        in = new FastReader();
        out = new PrintWriter(System.out);
//        fileInputOutput();

        int T = 1;
        T = in.nextInt();
        while (T-- > 0)
            solve();

        out.flush();
        out.close();
    }

    static void fileInputOutput() {
        try {
            in = new FastReader("input.txt");
            out = new PrintWriter(new FileOutputStream("output.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void runInThread() {
        Thread thread = new Thread(null, () -> {
            int T = 1;
//            T = in.nextInt();
            while (T-- > 0)
                solve();
        }, "thread1", 1 << 28);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            this(System.in);
        }
        FastReader(String file) throws FileNotFoundException {
            this(new FileInputStream(file));
        }
        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }
        String nextLine() {
            String line;
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
    }
}