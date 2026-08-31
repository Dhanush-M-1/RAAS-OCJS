import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    private BufferedReader in;
    private StringTokenizer tok;
    private PrintWriter out;

    //------------------------------------------------------------------------------
    public static void main(String[] args) {
        new Main().run();
    }

    private void solve() throws IOException {
//        Random rnd = new Random(322);
//        int n = 2000;
//        int k = 1900;
//        int q = 1000;
//        int[] originalA = new int[n];
//        for (int i = 0; i < n; i++) {
//            originalA[i] = rnd.nextInt(1000 * 1000 * 1000);
//        }
        int n = readInt();
        int k = readInt();
        int q = readInt();
        int[] originalA = new int[n];
        for (int i = 0; i < n; i++) {
            originalA[i] = readInt();
        }
        int[] sortedA = originalA.clone();
        Arrays.sort(sortedA);
        int[] a = new int[n];
        int minAns = Integer.MAX_VALUE;
//        System.err.println("originalA = " + Arrays.toString(originalA));
        int[] canDelete = new int[n];
        for (int minDeleted : sortedA) {
//            System.err.println("");
//            System.err.println("minDeleted = " + minDeleted);
            System.arraycopy(originalA, 0, a, 0, n);
            int sz = 0;
            for (int L = 0; L < n; ) {
                if (originalA[L] >= minDeleted) {
                    int R = L;
                    while (R < n && originalA[R] >= minDeleted) {
                        R++;
                    }
                    int length = R - L;
//                    System.err.println("Found segment [" + L + ", " + R + ")");
                    if (length >= k) {
                        Arrays.sort(a, L, R);
                        for (int it = 0, i = L; it < length - k + 1 && i < R; it++, i++) {
                            canDelete[sz++] = a[i];
                        }
                    }
                    L = R;
                } else {
                    L++;
                }
            }
//            System.err.println("canDelete = " + Arrays.toString(Arrays.copyOfRange(canDelete, 0, sz)));
            if (sz >= q) {
                Arrays.sort(canDelete, 0, sz);
                int maxDeleted = canDelete[q - 1];
//                System.err.println("maxDeleted = " + maxDeleted);
                minAns = Math.min(minAns, maxDeleted - minDeleted);
            }
        }
        out.println(minAns);
    }

    private void run() {
        try {
            initIO();
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void initIO() throws IOException {
        try {
            in = new BufferedReader(new FileReader(new File("input.txt")));
            out = new PrintWriter(new File("output.txt"));
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    private String readString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    @SuppressWarnings("unused")
    private int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    @SuppressWarnings("unused")
    private long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    @SuppressWarnings("unused")
    private double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
}
