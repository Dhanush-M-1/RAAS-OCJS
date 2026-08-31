import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main implements Runnable {
    static final int MOD = (int) 1e9 + 7;
    static final int MI = (int) 1e9;
    static final long ML = (long) 1e18;
    static final Reader in = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        new Thread(null, new Main(), "persefone", 1 << 32).start();
    }

    @Override
    public void run() {
        solve();
        printf();
        flush();
    }


    void solve() {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = Math.max(x, y);
        int w = in.nextInt();
        // a / rev(a) = rev(b) / b
        Pair[] a = new Pair[z + 1];
        Pair[] b = new Pair[z + 1];
        for (int i = 1; i <= z; i++) {
            int j = Utils.reverse(i);
            int g = Utils.gcd(i, j);
            a[i] = new Pair(i / g, j / g);
            b[i] = new Pair(j / g, i / g);
        }

        Map<Pair, Integer> up = new HashMap<>();
        for (int i = 1; i <= x; i++) {
            up.put(a[i], up.getOrDefault(a[i], 0) + 1);
        }
        Map<Pair, Integer> down = new HashMap<>();
        down.put(b[1], 1);
        long[] ans = new long[] {ML, 0, 0};
        int state = 0;

        for (int i = x, j = 1, res = up.get(b[1]); i > 0 && j <= y;) {
            if (res >= w) {
                long cur = 1l * i * j;
                if (cur < ans[0]) {
                    ans = new long[] {cur, i, j};
                }
                Integer v = up.get(a[i]);
                if (v == 1) {
                    up.remove(a[i]);
                } else {
                    up.put(a[i], v - 1);
                }
                res -= down.getOrDefault(a[i], 0);
                i--;
                state = 1;
            } else {
                j++;
                if (j <= y) {
                    down.put(b[j], down.getOrDefault(b[j], 0) + 1);
                    res += up.getOrDefault(b[j], 0);
                }
            }

        }
        printf(ans[0] == ML ? -1 : ans[1] + " " + ans[2]);
    }

    static class Pair {
        private int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + first;
            hash = hash * 59 + second;
            return hash;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    static class Utils {
        public static int reverse(int x) {
            return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
        }
        public static int gcd(int x, int y) {
            return y == 0 ? x : gcd(y, x % y);
        }
    }

    void printf() {
        out.print(answer);
    }

    void close() {
        out.close();
    }

    void flush() {
        out.flush();
    }

    void printf(Stream<?> str) {
        str.forEach(o -> add(o, " "));
        add("\n");
    }


    void printf(Object... obj) {
        printf(false, obj);
    }

    void printfWithDescription(Object... obj) {
        printf(true, obj);
    }


    private void printf(boolean b, Object... obj) {

        if (obj.length > 1) {
            for (int i = 0; i < obj.length; i++) {
                if (b) add(obj[i].getClass().getSimpleName(), " - ");
                if (obj[i] instanceof Collection<?>) {
                    printf((Collection<?>) obj[i]);
                } else if (obj[i] instanceof int[][]) {
                    printf((int[][]) obj[i]);
                } else if (obj[i] instanceof long[][]) {
                    printf((long[][]) obj[i]);
                } else if (obj[i] instanceof double[][]) {
                    printf((double[][]) obj[i]);
                } else printf(obj[i]);
            }
            return;
        }

        if (b) add(obj[0].getClass().getSimpleName(), " - ");
        printf(obj[0]);
    }

    void printf(Object o) {
        if (o instanceof int[])
            printf(Arrays.stream((int[]) o).boxed());
        else if (o instanceof char[])
            printf(new String((char[]) o));
        else if (o instanceof long[])
            printf(Arrays.stream((long[]) o).boxed());
        else if (o instanceof double[])
            printf(Arrays.stream((double[]) o).boxed());
        else if (o instanceof boolean[]) {
            for (boolean b : (boolean[]) o) add(b, " ");
            add("\n");
        } else
            add(o, "\n");
    }

    void printf(int[]... obj) {
        for (int i = 0; i < obj.length; i++) printf(obj[i]);
    }

    void printf(long[]... obj) {
        for (int i = 0; i < obj.length; i++) printf(obj[i]);
    }

    void printf(double[]... obj) {
        for (int i = 0; i < obj.length; i++) printf(obj[i]);
    }

    void printf(boolean[]... obj) {
        for (int i = 0; i < obj.length; i++) printf(obj[i]);
    }

    void printf(Collection<?> col) {
        printf(col.stream());
    }

    <T, K> void add(T t, K k) {
        if (t instanceof Collection<?>) {
            ((Collection<?>) t).forEach(i -> add(i, " "));
        } else if (t instanceof Object[]) {
            Arrays.stream((Object[]) t).forEach(i -> add(i, " "));
        } else
            add(t);
        add(k);
    }


    <T> void add(T t) {
        answer.append(t);
    }

    static class Reader {
        private BufferedReader br;
        private StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        boolean isReady() throws IOException {
            return br.ready();
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}