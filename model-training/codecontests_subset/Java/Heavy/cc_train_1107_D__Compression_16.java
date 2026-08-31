import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class D {
    public static void main(String[] args) {
        Scanner input = new Scanner();
        StringBuilder output = new StringBuilder();

        int n = input.nextInt();
        boolean[][] grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = input.next();
            for (int j = 0; j < n/4; j++) {
                char c = s.charAt(j);
                int a = 0;
                if ('0' <= c && c <= '9') {
                    a = c - '0';
                } else {
                    a = 10 + (c - 'A');
                }
                grid[i][j*4 + 0] = (a & 0b1000) != 0;
                grid[i][j*4 + 1] = (a & 0b0100) != 0;
                grid[i][j*4 + 2] = (a & 0b0010) != 0;
                grid[i][j*4 + 3] = (a & 0b0001) != 0;
            }
        }

        int[] factors = getPrimeFactors(n);
        int prod = 1;
        for (int i = 0; i < factors.length; i++) {
            int p = factors[i];
            int pk = (int)pow(p, mult[i]);
            int m = mult(grid, p, pk, 0, 0, n / pk);
            if (m == n) {
                prod = m;
                break;
            }
            prod *= m;
        }
        // System.err.println(Arrays.toString(factors));
        // System.err.println(Arrays.toString(mult));
        // System.err.println(Arrays.deepToString(grid));
        System.out.println(prod);
    }
    private static boolean val;
    private static int mult(boolean[][] grid, int p, int pk, int x, int y, int count) {
        // System.err.println("mult " +p + " " + pk);
        if (pk == 0) {
            return 1;
        }
        // int block = pk / p;
        boolean all = true;
        boolean nany = true;
        int minSize = 5000;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int a = mult(grid, p, pk / p, x + i * pk, y + j * pk, p);
                // System.err.println((x+i*pk) + " " + (y+j*pk) + " " +  pk + " " + a);
                minSize = min(minSize, a);
            }
        }
        if (minSize == pk) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if (grid[x + i * pk][y+j*pk]) {
                        nany = false;
                    } else {
                        all = false;
                    }
                }
            }
            if (nany || all) {
                return pk * count;
            }
        }
        return minSize;
    }
    private static int[] mult;
    public static int[] getPrimeFactors(int num) {
        int divisor = 2;
        int[] primeFactors = new int[100];
        mult = new int[100];
        int primeFactorsIndex = 0;

        while (divisor * divisor <= num && num > 1) {
            if (num % divisor == 0) {
                primeFactors[primeFactorsIndex] = divisor;
                mult[primeFactorsIndex]++;
                primeFactorsIndex++;
                num /= divisor;
            }

            while (num % divisor == 0) {
                mult[primeFactorsIndex-1]++;
                num /= divisor;
            }

            if (divisor == 2) {
                divisor = 3;
            } else {
                divisor += 2;
            }
        }

        if (num > 1) {
            primeFactors[primeFactorsIndex] = num;
            mult[primeFactorsIndex] = 1;
            primeFactorsIndex++;
        }

        return java.util.Arrays.copyOfRange(primeFactors, 0, primeFactorsIndex);
    }


    private static class Scanner {
        BufferedReader br; StringTokenizer st;
        public Scanner(Reader in) { br = new BufferedReader(in); }
        public Scanner() { this(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine());
                } catch (IOException e) { e.printStackTrace(); } }
            return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String readNextLine() {
            String str = "";
            try { str = br.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return str; }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) { a[idx] = nextInt(); }
            return a; }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) { a[idx] = nextLong(); }
            return a; }
    } // end Scanner
}
