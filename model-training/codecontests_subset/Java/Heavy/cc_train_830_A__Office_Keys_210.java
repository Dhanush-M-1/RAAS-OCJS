import java.io.*;
import java.util.Arrays;

public class Main {

    private static myScanner sc;
    private static PrintWriter pw;

    private static final boolean defaultInAndOutPut = true;

    private static final int numberOfTests = 1;

    private static final String nameOfInAndOutFile = "";
    private static final String fullNameInputFile = nameOfInAndOutFile + ".in";
    private static final String fullNameOutputFile = nameOfInAndOutFile + ".out";

    public static void main(String[] args) throws IOException {
        if (defaultInAndOutPut) {
            setDefaultInAndOutPut();
        } else {
            setInAndOutPutFromFile();
        }
        for (int test = 1; test <= numberOfTests; test++) {
            solve();
            pw.flush();
        }

        pw.close();
    }

    private static void setDefaultInAndOutPut() {
        sc = new myScanner(new BufferedReader(new InputStreamReader(System.in)));
        pw = new PrintWriter(System.out);
    }

    private static void setInAndOutPutFromFile() throws IOException {
        sc = new myScanner(new BufferedReader(new FileReader(new File(fullNameInputFile))));
        pw = new PrintWriter(new File(fullNameOutputFile));
    }

    private static final int intINF = Integer.MAX_VALUE;
    private static final long longINF = Long.MAX_VALUE;

    private static void solve() {
        int n=sc.nextInt(),k=sc.nextInt();
        long p = sc.nextLong();
        long[] a = sc.nextArrayLongs(n);
        long[] b = sc.nextArrayLongs(k);
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = longINF;
        for (int i=0;i<=k-n;i++){
            ans=Math.min(ans,check(i,a,b,p));
        }
        pw.print(ans);
    }

    private static long check(int ind, long[] a, long[] b, long p) {
       long c = 0;
       for (int i=0;i<a.length;i++){
           c=Math.max(c,distance(a[i],b[i+ind],p));
       }
       return c;
    }
    private static long distance(long a,long b,long c){
        return Math.abs(a-b)+Math.abs(b-c);
    }
}

class myScanner {
    private char[] buffer = new char[1 << 8];
    private int pos = 1;

    private BufferedReader reader;

    public myScanner(BufferedReader reader) {
        this.reader = reader;
    }

    public boolean hasNext() {
        return pos > 0;
    }

    private void loadBuffer() {
        pos = 0;
        try {
            for (int i; (i = reader.read()) != -1; ) {
                char c = (char) i;
                if (c != ' ' && c != '\n' && c != '\t' && c != '\r' && c != '\f') {
                    if (pos == buffer.length) buffer = Arrays.copyOf(buffer, 2 * pos);
                    buffer[pos++] = c;
                } else if (pos != 0) break;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String current() {
        return String.copyValueOf(buffer, 0, pos);
    }


    public String next() {
        loadBuffer();
        return current();
    }


    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    public int nextInt() {
        return nextInt(10);
    }

    public long nextLong() {
        return nextLong(10);
    }

    public int nextInt(int radix) {
        loadBuffer();
        int result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber(0 <= digit && digit <= radix - 1);
            result = result * radix + digit;
        }
        return buffer[0] == '-' ? -result : result;
    }

    public long nextLong(int radix) {
        loadBuffer();
        long result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber(0 <= digit && digit <= radix - 1);
            result = result * radix + digit;
        }
        return buffer[0] == '-' ? -result : result;
    }

    public int[] nextArrayInts(int size){
        int[] input = new int[size];
        for (int i=0;i<size;i++)input[i]=nextInt();
        return input;
    }

    public long[] nextArrayLongs(int size){
        long[] input = new long[size];
        for (int i=0;i<size;i++)input[i]=nextLong();
        return input;
    }

    public double nextDouble() {
        loadBuffer();
        long result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        long round = 1;
        final int radix = 10;
        boolean hasPoint = false;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber((0 <= digit && digit <= radix - 1) || (!hasPoint && digit == -2));
            if (digit == -2) hasPoint = true;
            else {
                if (hasPoint) round *= radix;
                result = result * radix + digit;
            }

        }
        return buffer[0] == '-' ? -result / (1.0 * round) : result / (1.0 * round);
    }

    private void checkValidNumber(boolean condition) {
        if (!condition) throw new NumberFormatException(current());
    }
}