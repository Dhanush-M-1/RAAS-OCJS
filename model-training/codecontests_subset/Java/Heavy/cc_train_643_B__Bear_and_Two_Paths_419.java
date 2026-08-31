import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class BearPath {
    private static final byte[] READ_BUF = new byte[1024];
    private InputStream is;
    private BufferedWriter bw;
    private int bufLen;
    private int bufPtr;

    public static void main(final String[] args) {
        // Instantiate & RUN!!!
        final BearPath instance = new BearPath();
        instance.run(System.in, System.out);
    }

    public void run(final InputStream inputStream, final PrintStream printStream) {
        is = inputStream;
        bw = new BufferedWriter(new PrintWriter(printStream));
        final int n = nextInt();
        final int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();
        int minK = 6 + (n - 5);
        if (k < minK || n == 4) {
            println("-1");
        } else {
            String s1Start = a + " " + c + " ";
            String s2Start = c + " " + a + " ";
            String s2End = b + " " + d;
            String s1End = d + " " + b;
            String middle = "";
            for (int i = 1; i <= n; i++) {
                if ((i == a) || (i == b) || (i == c) || (i == d)) {
                    continue;
                }
                middle += i + " ";
            }
            println(s1Start + middle + s1End);
            println(s2Start + middle + s2End);
        }
        // end of program
        try {
            bw.flush();
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // i/o & data utilities
    private void println() throws IOException {
        bw.newLine();
    }

    private void println(final String str) {
        try {
            bw.write(str);
            bw.newLine();
        } catch (Exception e){}
    }

    private int getNextByte() {
        if (bufLen == -1) {
            throw new RuntimeException();
        }
        try {
            if (bufPtr >= bufLen) {
                bufPtr = 0;
                bufLen = is.read(READ_BUF);
                if (bufLen <= 0) {
                    return -1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return READ_BUF[bufPtr++];
    }

    private boolean isAsciiChar(int c) {
        return (c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = getNextByte()) != -1 && !isAsciiChar(b)) ;
        return b;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (isAsciiChar(b)) {
            sb.appendCodePoint(b);
            b = getNextByte();
        }
        return sb.toString();
    }
}
