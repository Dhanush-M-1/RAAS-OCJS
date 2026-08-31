import java.io.*;
import java.util.*;

public class Solve
{
    public static void main(String[] args)
    {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        new Solve(in, out);
        out.close();
    }



    Solve(FastScanner in, PrintWriter w)
    {
        int n = in.nextInt();
        int k = in.nextInt();

        int[]a = new int[n];

        for (int i=0; i<a.length; i++) a[i] = in.nextInt();


        Arrays.sort(a);

        int c = Integer.MAX_VALUE;

        for (int i=n-1; i>=0; i--)
        {
            if (k % a[i] == 0 && k/a[i] < c)
                c = k/a[i];
        }


        w.println(c);
    }
}


class FastScanner
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    FastScanner(InputStream stream) {
        this.stream = stream;
    }

    int read() {
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
    public char nextChar() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String next() {
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

    String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }
}


