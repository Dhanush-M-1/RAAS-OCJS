import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * @author Nikita Gorokhov <wackloner@yandex-team.ru>
 */
public class D {

    private void solve() {
        long n = nextInt(), l = nextLong() - 1, r = nextLong() - 1;
        long cnt = n;
//        out.println(n);
//        System.out.println(n);
        for (; cnt >= 0; ) {
            long cur = cnt - 1 + cnt - 1;
//            out.println("l=" + l + " cnt=" + cnt + " cur=" + cur);
            if (l >= cur) {
                l -= cur;
                r -= cur;
                cnt--;
            } else {
                break;
            }
        }
        int num = 0;
//        System.out.println("vars = " + l + " " + r + " " + cnt);
        for (long cur = n - cnt; cur < n - 1; cur++) {
            for (long next = cur + 1; next < n; next++) {
                if (l <= num && num <= r) {
                    out.print(" " + (cur + 1));
                } else if (r < num) {
                    break;
                }
                num++;
                if (l <= num && num <= r) {
                    out.print(" " + (next + 1));
                } else if (r < num) {
                    break;
                }
                num++;
            }
        }
        if (num <= r) {
            out.print(" 1");
        }
        out.println();
    }

    private final static String INPUT_FILENAME = "input.txt";
    private final static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    private InputStream inputStream;
    private PrintWriter out;

    private void run() throws FileNotFoundException {
        inputStream = ONLINE_JUDGE ? System.in : new FileInputStream(INPUT_FILENAME);
        out = new PrintWriter(System.out);

        int t = nextInt();

        for (int testNum = 0; testNum < t; testNum++) {
            solve();
        }

        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new D().run();
    }

    private byte[] buffer = new byte[1024];
    private int bufferLen = 0, bufferPtr = 0;

    private int readByte() {
        if (bufferLen == -1) {
            throw new InputMismatchException();
        }
        if (bufferPtr >= bufferLen) {
            bufferPtr = 0;
            try {
                bufferLen = inputStream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (bufferLen <= 0) {
                return -1;
            }
        }
        return buffer[bufferPtr++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    private char nextChar() {
        return (char) skip();
    }

    private String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            ;
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nextLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            ;
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
