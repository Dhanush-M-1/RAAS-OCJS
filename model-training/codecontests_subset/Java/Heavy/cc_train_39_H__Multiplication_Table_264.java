
import java.io.*;
import java.util.*;

public class NewClass {

    public static int inde(int[] a) {
        int inde = 0, elem = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < elem) {
                elem = a[i];
                inde = i;
            }
        }
        return inde;
    }

    public static int min(int... a) {
        int su = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > su) {
                su = a[i];
            }
        }
        return su;
    }

    public static String Radix(int num,int a){
        StringBuilder ans=new StringBuilder();
        while(num>0){
            ans.append(num%a);
            num/=a;
        }
                return ans.reverse().toString();
    }

    public static int[] fibname(int n, int[] a) {
        long[] b = new long[n + 1];
        a[1] = a[2] = 1;
        b[1] = b[2] = 1;

        for (int i = 3; i <= n; i++) {
            b[i] = b[i - 1] + b[i - 2];
            if (n >= b[i]) {
                a[(int) b[i]] = (int) b[i];
            } else {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int k = 1; k < n; k++) {
                out.print(Radix(i*k, n));
                        if (k!=n-1) out.print(" ");
                        else out.printLine();
            }
        }
        out.flush();
      
    }
}


class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (snumChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

}

class OutputWriter {

    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

}
