import java.io.*;
import java.util.*;
import java.math.*;

public class F {
    static final boolean RUN_TIMING = false;
    static PushbackReader in = new PushbackReader(new BufferedReader(new InputStreamReader(System.in)), 1024);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public void go() throws IOException {
        // in = new PushbackReader(new BufferedReader(new FileReader(new File("test.txt"))), 1024);
        // out = new PrintWriter(new FileWriter(new File("output.txt")));
        int zzz = ipar();
        for (int zz = 0; zz < zzz; zz++) {
            int n = ipar();
            int k = ipar();
            Minion[] arr = new Minion[n];
            for (int i = 0; i < n; i++) {
                int a = ipar();
                int b = ipar();
                arr[i] = new Minion(a, b, i);
            }
            Arrays.sort(arr, (a, b) -> a.b - b.b);
            int[][] dp = new int[n+1][k+1];
            int[][] index = new int[n+1][k+1];
            for (int i = 0; i < k; i++) {
                dp[n][i] = Integer.MIN_VALUE;
            }
            for (int i = n-1; i >= 0; i--) {
                for (int e = 0; e <= k; e++) {
                    dp[i][e] = dp[i+1][e] + arr[i].getDestroy(k-1);
                    index[i][e] = -arr[i].i-1;
                }
                for (int e = 0; e < k; e++) {
                    if (dp[i+1][e+1] + arr[i].getAdd(e) > dp[i][e]) {
                        dp[i][e] = dp[i+1][e+1] + arr[i].getAdd(e);
                        index[i][e] = arr[i].i+1;
                    }
                }
            }
            ArrayList<Integer> adds = new ArrayList<>();
            ArrayList<Integer> destroys = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (index[i][adds.size()] > 0) {
                    adds.add(index[i][adds.size()]);
                } else {
                    destroys.add(-index[i][adds.size()]);
                }
            }
            // for (int[] a : dp) {
            //     out.println(Arrays.toString(a));
            // }
            out.println(adds.size() + destroys.size()*2);
            for (int i = 0; i < k-1; i++) {
                out.print(adds.get(i));
                out.print(" ");
            }
            for (int i = 0; i < n-k; i++) {
                out.print(destroys.get(i));
                out.print(" ");
                out.print(-destroys.get(i));
                out.print(" ");
            }
            out.println(adds.get(k-1));
        }

        out.flush();
        in.close();
    }

    private class Minion {
        int a, b, i;

        public Minion(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i = i;
        }

        public int getAdd(int t) {
            return a + b*t;
        }

        public int getDestroy(int t) {
            return b*t;
        }

        public String toString() {
            return String.format("%d=(%d,%d)", i, a, b);
        }
    }

    public int ipar() throws IOException {
        return Integer.parseInt(spar());
    }

    public int[] iapar(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ipar();
        }
        return arr;
    }

    public long lpar() throws IOException {
        return Long.parseLong(spar());
    }

    public long[] lapar(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = lpar();
        }
        return arr;
    }

    public double dpar() throws IOException {
        return Double.parseDouble(spar());
    }

    public String spar() throws IOException {
        StringBuilder sb = new StringBuilder(1024);
        int c;
        do {
            c = in.read();
        } while (Character.isWhitespace(c) && c != -1);
        if (c == -1) {
            throw new NoSuchElementException("Reached EOF");
        }
        do {
            sb.append((char)c);
            c = in.read();
        } while (!Character.isWhitespace(c) && c != -1);
        while (c != '\n' && Character.isWhitespace(c) && c != -1) {
            c = in.read();
        }
        if (c != -1 && c != '\n') {
            in.unread(c);
        }
        return sb.toString();
    }

    public String linepar() throws IOException {
        StringBuilder sb = new StringBuilder(1024);
        int c;
        while ((c = in.read()) != '\n' && c != -1) {
            if (c == '\r') {
                continue;
            }
            sb.append((char)c);
        }
        return sb.toString();
    }

    public boolean haspar() throws IOException {
        String line = linepar();
        if (line.isEmpty()) {
            return false;
        }
        in.unread('\n');
        in.unread(line.toCharArray());
        return true;
    }

    public static void main(String[] args) throws IOException {
        long time = 0;
        time -= System.nanoTime();
        new F().go();
        time += System.nanoTime();
        if (RUN_TIMING) {
            System.out.printf("%.3f ms%n", time/1000000.0);
        }
        out.flush();
        in.close();
    }
}
