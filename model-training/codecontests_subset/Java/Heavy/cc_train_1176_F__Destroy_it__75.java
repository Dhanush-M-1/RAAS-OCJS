import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static final int UNCALC = -1;
    static long[][] memo;
    static Turn[] turns;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        turns = new Turn[n];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            turns[i] = new Turn();
            while (k-- > 0) {
                int c = sc.nextInt();
                if (c == 1) turns[i].addOne(sc.nextInt());
                else if (c == 2) turns[i].addTwo(sc.nextInt());
                else turns[i].addThree(sc.nextInt());
            }
            turns[i].sortOnes();
        }
        memo = new long[10][n];
        for (long[] a : memo)
            Arrays.fill(a, UNCALC);
        out.println(dp(0, 0));
        out.flush();
        out.close();
    }

    static long dp(int p, int turn) {
        if (turn == n)
            return 0;
        p %= 10;
        if (memo[p][turn] != UNCALC)
            return memo[p][turn];
        //Play zero cards
        long best = dp(p, turn + 1);
        int three = turns[turn].three;
        int two = turns[turn].two;
        int[] ones = turns[turn].ones;
        int c = 0;
        //play one card only
        best = Math.max(best, Math.max(three, Math.max(two, ones[0])) * (p == 9 ? 2l : 1) + dp(p + 1, turn + 1));
        //Play two cards
        if (two != 0 && ones[0] != 0)
            best = Math.max(best, Math.max(two, ones[0]) * (p >= 8 ? 2l : 1) + Math.min(two, ones[0]) + dp(p + 2, turn + 1));
        if (ones[1] != 0)
            best = Math.max(best, ones[0] * (p >= 8 ? 2l : 1) + ones[1] + dp(p + 2, turn + 1));
        //play three cards
        if (ones[2] != 0)
            best = Math.max(best, ones[0] * (p >= 7 ? 2l : 1) + ones[1] + ones[2] + dp(p + 3, turn + 1));
        return memo[p][turn] = best;
    }

    static class Turn {
        ArrayList<Integer> one;
        int three, two, ones[];

        public Turn() {
            one = new ArrayList<>();
            ones = new int[3];
        }

        void addThree(int x) {
            three = Math.max(three, x);
        }

        void addTwo(int x) {
            two = Math.max(two, x);
        }

        void addOne(int x) {
            one.add(x);
        }

        void sortOnes() {
            Collections.sort(one);
            int j = 0;
            for (int i = one.size() - 1; i >= 0 && j < 3; i--)
                ones[j++] = one.get(i);

        }

        @Override
        public String toString() {
            return "Turn{" +
                    "three=" + three +
                    ", two=" + two +
                    ", ones=" + Arrays.toString(ones) +
                    '}';
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }


        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }

}