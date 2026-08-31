import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static long sum(int l, int r, int[] mas)
    {
        return mas[r] - mas[l-1];
    }

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(/*new InputStreamReader(new FileInputStream(new File("dijkstra.in")))); */ System.in);
        FastPrinter out = new FastPrinter(/*new OutputStreamWriter(new FileOutputStream(new File("dijkstra.out")))); */  System.out);
        int n = in.nextInt(), d = in.nextInt();
        int[] mas = new int[n];
        int sum = 0;
        int k = 0;
        int ost = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            if(a != 0) sum += a;
            if(a == 0) {
                if(sum < 0) {
                    if(ost + sum >= 0) {
                        ost += sum;
                        sum = 0;
                    }
                    else {
                        k++;
                        sum = 0;
                        ost = d;
                    }
                }
            }
            if(sum > d){
                System.out.println("-1");
                flag = false;
                break;
            }
            ost = Math.min(ost, d - sum);
        }
        if(flag)
            System.out.println(k);
        out.close();
    }
}

class FastPrinter {
    private final PrintWriter writer;

    public FastPrinter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public FastPrinter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void close() {
        writer.close();
    }

    public void println(long i) {
        writer.println(i);
    }

    public void println(double d) {
        writer.println(d);
    }

    public void println(String s) {
        writer.println(s);
    }

    public void println(String format, Object... args) {
        println(String.format(format, args));
    }

    public void println() {
        writer.println();
    }

    public void print(long i) {
        writer.print(i);
    }

    public void print(char c) {
        writer.print(c);
    }

    public void print(double d) {
        writer.print(d);
    }

    public void print(String s) {
        writer.print(s);
    }

    public void print(String format, Object... args) {
        print(String.format(format, args));
    }

    public void flush() {
        writer.flush();
    }
}

class FastScanner {

    private BufferedReader reader;
    private StringTokenizer st;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public FastScanner(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
        this.st = new StringTokenizer("");
    }

    public FastScanner(InputStreamReader stream) {
        this.reader = new BufferedReader(stream);
        this.st = new StringTokenizer("");
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String next() {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(readLine());
        }
        return st.nextToken();
    }

    public String nextLine() {
        st = new StringTokenizer("");
        return readLine();
    }

    public String tryNextLine() {
        st = new StringTokenizer("");
        return tryReadLine();
    }

    private String readLine() {
        String line = tryReadLine();
        if (line == null) throw new InputMismatchException();
        return line;
    }

    private String tryReadLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public int[] nextIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = nextInt();
        return array;
    }

    public int[][] nextIntTable(int rowCount, int columnCount) {
        int[][] table = new int[rowCount][];
        for (int i = 0; i < rowCount; i++)
            table[i] = nextIntArray(columnCount);
        return table;
    }

    public long[] nextLongArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++)
            array[i] = nextLong();
        return array;
    }

    public long[][] nextLongTable(int rowCount, int columnCount) {
        long[][] table = new long[rowCount][];
        for (int i = 0; i < rowCount; i++)
            table[i] = nextLongArray(columnCount);
        return table;
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\t' || isEOL(c);
    }

    public static boolean isEOL(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}