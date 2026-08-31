import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SolutionB extends Thread {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                                            InputStreamReader(System.in));
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

    private static final FastReader scanner = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Thread(null, new SolutionB(), "Main", 1 << 26).start();
    }

    public void run() {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        out.close();
    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }


    private static void solve() {
        int n = scanner.nextInt();

        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            grid[i] = s.toCharArray();
        }
        List<Pair> changes = new ArrayList<>();
        if (grid[0][1] == grid[1][0]) {
            if (grid[n-1][n-2] == grid[0][1]) {
                changes.add(new Pair(n, n-1));
            }

            if (grid[n-2][n-1] == grid[0][1]) {
                changes.add(new Pair(n-1, n));
            }
        } else {
            if (grid[n-1][n-2] == grid[n-2][n-1]) {
                if (grid[0][1] == grid[n-1][n-2]) {
                    changes.add(new Pair(1, 2));
                } else {
                    changes.add(new Pair(2, 1));
                }
            } else {
                changes.add(new Pair(1, 2));
                if (grid[0][1] == grid[n-1][n-2]) {
                    changes.add(new Pair(n-1, n));
                } else {
                    changes.add(new Pair(n, n-1));
                }
            }
        }

        out.println(changes.size());
        changes.forEach(out::println);
    }

    //WARNINGS:
    //- CHECK FOR INTEGER-OVERFLOW BEFORE SUBMITTING
}