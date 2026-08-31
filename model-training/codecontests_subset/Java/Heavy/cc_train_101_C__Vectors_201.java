import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E {

    public void solve() throws Exception {
        
        long x1=nextInt(), y1=nextInt(), x2=nextInt(), y2=nextInt(), x3=nextInt(), y3=nextInt();
        long z = x3*x3+y3*y3;
        boolean res = false;
        for (int i=0; i<4; ++i) {
            x1^=y1; y1^=x1; x1^=y1; y1=-y1;
            long difx = x2-x1, dify = y2-y1;
            if (z==0) res = res || (difx==0 && dify==0);
            else res = res || ((difx*x3+dify*y3)%z==0 && (dify*x3-difx*y3)%z==0);
        }
        
        println(res?"YES":"NO");
        
        
    }

    

    ////////////////////////////////////////////////////////////////////////////

    boolean showDebug = true;

    double EPS = 1e-7;
    int INF = Integer.MAX_VALUE;
    long INFL = Long.MAX_VALUE;
    double INFD = Double.MAX_VALUE;

    
    int absPos(int i) {
        return i<0 ? 0:i;
    }
    long absPos(long i) {
        return i<0 ? 0:i;
    }
    double absPos(double i) {
        return i<0 ? 0:i;
    }
    
    int min(int... nums) {
        int r = INF;
        for (int i: nums)
            if (i<r) r=i;
        return r;
    }
    int max(int... nums) {
        int r = -INF;
        for (int i: nums)
            if (i>r) r=i;
        return r;
    }
    long minL(long... nums) {
        long r = INFL;
        for (long i: nums)
            if (i<r) r=i;
        return r;
    }
    long maxL(long... nums) {
        long r = -INFL;
        for (long i: nums)
            if (i>r) r=i;
        return r;
    }
    double minD(double... nums) {
        double r = INFD;
        for (double i: nums)
            if (i<r) r=i;
        return r;
    }
    double maxD(double... nums) {
        double r = -INFD;
        for (double i: nums)
            if (i>r) r=i;
        return r;
    }
    long sumArr(int[] arr) {
        long res = 0;
        for (int i: arr)
            res+=i;
        return res;
    }
    long sumArr(long[] arr) {
        long res = 0;
        for (long i: arr)
            res+=i;
        return res;
    }
    double sumArr(double[] arr) {
        double res = 0;
        for (double i: arr)
            res+=i;
        return res;
    }

    long partsFitCnt(long partSize, long wholeSize) {
        return (partSize+wholeSize-1)/partSize;
    }

    boolean odd(long i) {
        return (i&1)==1;
    }

    long binpow(int x, int n) {
        long r = 1;
        while (n>0) {
            if ((n&1)!=0) r*=x;
            x*=x;
            n>>=1;
        }
        return r;
    }

    boolean isLetter(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
    boolean isLowercase(char c) {
        return (c>='a' && c<='z');
    }
    boolean isUppercase(char c) {
        return (c>='A' && c<='Z');
    }
    boolean isDigit(char c) {
        return (c>='0' && c<='9');
    }
    
    String stringn(String s, int n) {
        if (n<1) return "";
        StringBuilder sb = new StringBuilder(s.length()*n);
        for (int i=0; i<n; ++i) sb.append(s);
        return sb.toString();
    }
    String str(Object o) {
        return o.toString();
    }


    long timer = System.currentTimeMillis();
    void startTimer() {
        timer = System.currentTimeMillis();
    }
    void stopTimer() {
        System.err.println("time: "+(System.currentTimeMillis()-timer)/1000.0);
    }


    class InputReader {
        private byte[] buf;
        private int bufPos = 0, bufLim = -1;
        public InputReader(int size) {
            buf = new byte[size];
            try {
                fillBuf();
            } catch (IOException e) {}
        }
        private void fillBuf() throws IOException {
            bufLim = System.in.read(buf);
            bufPos = 0;
        }
        char read() throws IOException {
            if (bufPos>=bufLim) fillBuf(); 
            return (char)buf[bufPos++];
        }
        boolean hasInput() throws IOException {
            if (bufPos>=bufLim) fillBuf();
            return bufPos<bufLim;
        }
    }

    InputReader in = new InputReader(1<<16);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 1<<16);
    Formatter formatter = new Formatter(out);

    char nextChar() throws IOException {
        return in.read();
    }
    char nextNonWhitespaceChar() throws IOException {
        char c = in.read();
        while (c<=' ') c=in.read();
        return c;
    }
    String nextWord() throws IOException {
        StringBuilder sb = new StringBuilder();
        char c = in.read();
        while (c<=' ') c=in.read();
        while (c>' ') {
            sb.append(c);
            c = in.read();
        }
        return new String(sb);
    }
    String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        char c = in.read();
        while (c<=' ') c=in.read();
        while (c!='\n' && c!='\r') {
            sb.append(c);
            c = in.read();
        }
        return new String(sb);
    }
    int nextInt() throws IOException {
        int r = 0;
        char c = nextNonWhitespaceChar();
        boolean neg = false;
        if (c=='-') neg=true;
        else r=c-48;
        c = nextChar();
        while (c>='0' && c<='9') {
            r*=10;
            r+=c-48;
            c=nextChar();
        }
        return neg ? -r:r;
    }
    long nextLong() throws IOException {
        long r = 0;
        char c = nextNonWhitespaceChar();
        boolean neg = false;
        if (c=='-') neg=true;
        else r = c-48;
        c = nextChar();
        while (c>='0' && c<='9') {
            r*=10L;
            r+=c-48L;
            c=nextChar();
        }
        return neg ? -r:r;
    }
    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextWord());
    }
    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i=0; i<size; i++)
            arr[i] = nextInt();
        return arr;
    }
    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i=0; i<size; i++)
            arr[i] = nextLong();
        return arr;
    }
    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i=0; i<size; i++)
            arr[i] = nextDouble();
        return arr;
    }
    String[] nextArrS(int size) throws NumberFormatException, IOException {
        String[] arr = new String[size];
        for (int i=0; i<size; i++)
            arr[i] = nextWord();
        return arr;
    }
    char[] nextArrCh(int size) throws IOException {
        char[] arr = new char[size];
        for (int i=0; i<size; i++)
            arr[i] = nextNonWhitespaceChar();
        return arr;
    }
    char[][] nextArrCh(int rows, int columns) throws IOException {
        char[][] arr = new char[rows][columns];
        for (int i=0; i<rows; i++)
            for (int j=0; j<columns; j++)
                arr[i][j] = nextNonWhitespaceChar();
        return arr;
    }

    void printf(String s, Object... o) {
        formatter.format(s, o);
    }
    void print(Object o) throws IOException {
        out.write(o.toString());
    }
    void println(Object o) throws IOException {
        out.write(o.toString());
        out.newLine();
    }
    void print(Object... o) throws IOException {
        for (int i=0; i<o.length; i++) {
            if (i!=0) out.write(' ');
            out.write(o[i].toString());
        }
    }
    void println(Object... o) throws IOException {
        print(o);
        out.newLine();
    }
    void printn(Object o, int n) throws IOException {
        String s = o.toString();
        for (int i=0; i<n; i++) {
            out.write(s);
            if (i!=n-1) out.write(' ');
        }
    }
    void printnln(Object o, int n) throws IOException {
        printn(o, n);
        out.newLine();
    }
    void printArr(int[] arr) throws IOException {
        for (int i=0; i<arr.length; i++) {
            if (i!=0) out.write(' ');
            out.write(Integer.toString(arr[i]));
        }
    }
    void printArr(long[] arr) throws IOException {
        for (int i=0; i<arr.length; i++) {
            if (i!=0) out.write(' ');
            out.write(Long.toString(arr[i]));
        }
    }
    void printArr(double[] arr) throws IOException {
        for (int i=0; i<arr.length; i++) {
            if (i!=0) out.write(' ');
            out.write(Double.toString(arr[i]));
        }
    }
    void printArr(String[] arr) throws IOException {
        for (int i=0; i<arr.length; i++) {
            if (i!=0) out.write(' ');
            out.write(arr[i]);
        }
    }
    void printArr(char[] arr) throws IOException {
        for (char c: arr) out.write(c);
    }
    void printlnArr(int[] arr) throws IOException {
        printArr(arr);
        out.newLine();
    }
    void printlnArr(long[] arr) throws IOException {
        printArr(arr);
        out.newLine();
    }
    void printlnArr(double[] arr) throws IOException {
        printArr(arr);
        out.newLine();
    }
    void printlnArr(String[] arr) throws IOException {
        printArr(arr);
        out.newLine();
    }
    void printlnArr(char[] arr) throws IOException {
        printArr(arr);
        out.newLine();
    }

    void debug(Object... o) {
        if (showDebug) System.err.println(Arrays.deepToString(o));
    }


    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        new E().solve();
        out.flush(); out.close();
    }
}
