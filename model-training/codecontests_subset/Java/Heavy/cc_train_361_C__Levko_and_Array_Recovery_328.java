import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

    PrintWriter out = new PrintWriter(System.out);
    InputReader ir = new InputReader(System.in);
    final long kmod = 993960000099397l;
    
    void solve() throws IOException{
        int n = ir.readInt();
        int m = ir.readInt();
        int type[] = new int[m];
        int from[] = new int[m];
        int to[] = new int[m];
        int val[] = new int[m];

        for(int i = 0; i < m; i++) {
            type[i] = ir.readInt();
            from[i] = ir.readInt() - 1;
            to[i] = ir.readInt() - 1;
            val[i] = ir.readInt();
        }
        long res[] = new long[n];
        Arrays.fill(res, (long)1e9);
        int acc[] = new int[n];
        for(int i = 0; i < m; i++) {
            if(type[i] == 1) {
                for(int j = from[i]; j <= to[i]; j++)
                    acc[j] += val[i];
            } else {
                for(int j = from[i]; j <= to[i]; j++) {
                    res[j] = Math.min(res[j], val[i] - acc[j]);
                }
            }
        }
        long arr[] = Arrays.copyOf(res, n);

        for(int i = 0; i < m; i++) {
            if(type[i] == 1) {
                for(int j = from[i]; j <= to[i]; j++)
                    arr[j] += val[i];
            } else {
                long min = Long.MIN_VALUE;
                for(int j = from[i]; j <= to[i]; j++) {
                    min = Math.max(min, arr[j]);
                }
                if(min != val[i]){
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
        for(long i : res) {
            out.print(i + " ");
        }
        out.println();

    }

    void run() throws IOException{
        solve();
        out.close();
    }
    public static void main(String args[]) throws IOException{
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