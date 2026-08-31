
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

    private void solve() throws IOException {
        try {
            //				solveA();
            //			solveB();
//			solveC();
            //			solveC2();
            solveD();
            //			 solveE();
            //			 solveF();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }

    private void solveA() {
        long numX = nextLong();
        long numT = nextLong();

        out.println(numX - numT > 0 ? numX - numT : 0);
    }

    private void solveB() {
        String wk = next();

        StringBuilder builder = IntStream.range(0, wk.length()).filter(i -> (i % 2 == 0))
                .collect(() -> new StringBuilder(), (t, i) -> {
                    t.append(wk.charAt(i));
                }, (t, u) -> t.append(u));

        out.println(builder.toString());
    }

    private void solveC2() {
        int numN = nextInt();

        long[] wk = LongStream.range(0, numN).map(i -> nextLong()).toArray();

        Map<Long, Long> wkCount = Arrays.stream(wk).mapToObj(i -> new Long(i))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        long res = 0;
        for (long j = 0; j <= 100000; j++) {
            long tmp = wkCount.getOrDefault(j, 0l) + wkCount.getOrDefault(j + 1, 0l) + wkCount.getOrDefault(j - 1, 0l);
            res = Long.max(res, tmp);
        }

        out.println(res);
    }

    private void solveC() {
        int numN = nextInt();

        long[] wk = LongStream.range(0, numN).map(i -> nextLong()).toArray();

        Map<Long, Long> wkCount = Arrays.stream(wk).collect(() -> new HashMap<Long, Long>(),
                (t, i) -> {
                    long constVal = 1;
                    t.merge(i, constVal, (oldV, newV) -> oldV + newV);
                    t.merge(i + 1, constVal, (oldV, newV) -> oldV + newV);
                    t.merge(i - 1, constVal, (oldV, newV) -> oldV + newV);
                },
                (t, u) -> t.putAll(u));

        Entry<Long, Long> entryWk = null;
        for (Entry<Long, Long> entry : wkCount.entrySet()) {
            if (entryWk == null) {
                entryWk = entry;
            } else {
                if (entryWk.getValue() < entry.getValue()) {
                    entryWk = entry;
                }
            }
        }

        out.println(entryWk.getValue());
    }

    private void solveD() {
        int n = nextInt();
        int[] p = IntStream.range(0, n).map(i -> nextInt()).toArray();

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 == p[i]) {
                if (i + 1 < n) {
                    swap(p, i, i + 1);
                } else {
                    swap(p, i, i - 1);
                }
                res++;
            }
        }
        out.println(res);
    }

    private void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }

    private void solveE() {
        int numN = nextInt();

        out.println("");
    }

    private void solveF() {
        int numN = nextInt();

        out.println("");
    }

    private final PrintWriter out = new PrintWriter(System.out);
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte())
            return buffer[ptr++];
        else
            return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr]))
            ptr++;
    }

    public boolean hasNext() {
        skipUnprintable();
        return hasNextByte();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext())
            throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while (true) {
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            } else if (b == -1 || !isPrintableChar(b)) {
                return minus ? -n : n;
            } else {
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
}