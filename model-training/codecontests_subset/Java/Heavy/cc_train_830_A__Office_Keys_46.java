import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class CodeForcesBase {
    static boolean usefile = false;
    static OutputStream outfile;

    static {
        try {
            outfile = new FileOutputStream(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static InputStream inputfile;

    static {
        try {
            inputfile = new FileInputStream(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = usefile ? new PrintWriter(outfile) : new PrintWriter(System.out);
        Scanner sc = usefile ? new Scanner(inputfile) : new Scanner(System.in);
        if (usefile) {
            while (sc.ready()) {
                handle(sc, out);
            }
        } else {
            handle(sc, out);
        }
        out.flush();
        out.close();
    }

    private static void handle(Scanner sc, PrintWriter out) throws IOException {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int office = sc.nextInt();
        long[] ps = new long[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }
        Arrays.sort(ps);
        long[] ks = new long[k];
        for (int i = 0; i < k; i++) {
            ks[i] = sc.nextInt();
        }
        Arrays.sort(ks);
        dp = new Long[ps.length][ks.length];
        long rt = solve(ps, ks, 0, 0, office);
        out.println(rt);
    }

    static long Max = 1000000000000000l;
    static Long[][] dp;

    private static long solve(long[] ps, long[] ks, int i, int j, int office) {
        if (i == ps.length) {
            return 0;
        }
        if (j == ks.length) {
            return Max;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        long take = Math.abs(ps[i] - ks[j]) + Math.abs(ks[j] - office);
        long rt = Math.min(solve(ps, ks, i, j + 1, office), Math.max(take, solve(ps, ks, i + 1, j + 1, office)));
        dp[i][j] = rt;
        return rt;
    }

    private static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}
