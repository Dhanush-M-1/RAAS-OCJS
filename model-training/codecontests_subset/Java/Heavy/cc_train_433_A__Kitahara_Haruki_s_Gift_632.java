import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    InputReader ir = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    final long kmod = 993960000099397l;
    void solve() {
        int n = ir.readInt();
        int c = 0;
        int b = 0;
        for(int i = 0; i < n; i++) {
            int temp = ir.readInt();
            if(temp != 100)
                c++;
            else
                b++;
        }
        for(int i = 0; i <= c; i++) {
            for(int j = 0; j <= b; j++) {
                int bn = b - j;
                int cn = c - i;
                int A = i*200 + j*100;
                int B = cn*200 + bn*100;
                if(A == B) {
                    out.println("YES");
                    return;
                }

            }
        }
        out.println("NO");
    }
    
    void run() {
        solve();
        out.close();
    }

    public static void main(String args[]){
        new Main().run();
    }
}

class InputReader {
 
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
    public final int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
    }
    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }
        public double readDouble() {
        return Double.parseDouble(readString());
    }
 
    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}