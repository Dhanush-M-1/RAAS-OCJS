import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class E {

    boolean showDebug = true;

    public void solve() throws Exception {

        int rows=nextInt(), cols=nextInt();

        char[][] c = nextArrCh(rows, cols);
        int[][] l = new int[rows][cols];
        int[][] r = new int[rows][cols];
        int[][] u = new int[rows][cols];
        int[][] d = new int[rows][cols];

        for (int i=0; i<rows; i++) for (int j=0; j<cols; j++) {
            
            l[i][j]=r[i][j]=u[i][j]=d[i][j]=-1;

            for (int k=j-1; k>=0; k--) if (c[i][k]!='.') {
                l[i][j] = k; break;
            }
            for (int k=j+1; k<cols; k++) if (c[i][k]!='.') {
                r[i][j] = k; break;
            }
            for (int k=i-1; k>=0; k--) if (c[k][j]!='.') {
                u[i][j] = k; break;
            }
            for (int k=i+1; k<rows; k++) if (c[k][j]!='.') {
                d[i][j] = k; break;
            }
        }

        int best=0,cnt=0;
        int[][] ll = new int[rows][cols];
        int[][] rr = new int[rows][cols];
        int[][] uu = new int[rows][cols];
        int[][] dd = new int[rows][cols];

        for (int i=0; i<rows; i++) for (int j=0; j<cols; j++) if (c[i][j]!='.') {

            for (int ii=0; ii<rows; ii++) for (int jj=0; jj<cols; jj++) {
                ll[ii][jj]=l[ii][jj];
                rr[ii][jj]=r[ii][jj];
                uu[ii][jj]=u[ii][jj];
                dd[ii][jj]=d[ii][jj];
            }

            int score = 1;
            int x=j, y=i;

            while (true) {

                char w = c[y][x];
                if (w=='.' || (w=='L' && ll[y][x]==-1) || (w=='R' && rr[y][x]==-1) ||
                        (w=='U' && uu[y][x]==-1) || (w=='D' && dd[y][x]==-1)) break;

                score++;

                if (ll[y][x]!=-1) rr[y][ll[y][x]]=rr[y][x];
                if (rr[y][x]!=-1) ll[y][rr[y][x]]=ll[y][x];
                if (uu[y][x]!=-1) dd[uu[y][x]][x]=dd[y][x];
                if (dd[y][x]!=-1) uu[dd[y][x]][x]=uu[y][x];

                if (w=='L') x = ll[y][x];
                if (w=='R') x = rr[y][x];
                if (w=='U') y = uu[y][x];
                if (w=='D') y = dd[y][x];
            }

            if (score>best) {
                best=score;
                cnt=1;
            } else if (score==best) {
                cnt++;
            }
        }

        println(best,cnt);

    }


    ////////////////////////////////////////////////////////////////////////////    

    double EPS = 1e-7;
    int INF = Integer.MAX_VALUE;
    long INFL = Long.MAX_VALUE;
    double INFD = Double.MAX_VALUE;

    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    int[] dx8 = {0,1,1,1,0,-1,-1,-1};
    int[] dy8 = {-1,-1,0,1,1,1,0,-1};
    int[] knightMovesX = {1,2,2,1,-1,-2,-2,-1};
    int[] knightMovesY = {-2,-1,1,2,2,1,-1,-2};


    @SuppressWarnings("serial")
    class IncMap extends HashMap<Object, Integer> {
        boolean add(Object key, int amount) {
            Integer i = get(key);
            if (i!=null) {
                put(key, i+amount);
                return false;
            } else {
                put(key, amount);
                return true;
            }
        }
        boolean add(Object key) {
            return add(key, 1);
        }
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

    int digitSum(long i) {
        i = abs(i);
        int r = 0;
        while (i>0) {
            r+=i%10;
            i/=10;
        }
        return r;
    }
    long digitProd(long i) {
        if (i==0) return 0;
        i = abs(i);
        long r = 1;
        while (i>0) {
            r*=i%10;
            i/=10;
        }
        return r;
    }

    long gcd (long a, long b) {
        while (b>0) {
            a%=b;
            a^=b; b^=a; a^=b;
        }
        return a;
    }
    long lcm(long a, long b) {
        return (a*b)/gcd(a,b);
    }

    double log_2 = log(2);
    double log2(double i) {
        return log(i)/log_2;
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
    long fac(int i) {
        if (i>20) throw new IllegalArgumentException();
        return i<=1 ?  1:fac(i-1)*i;
    }


    double dist(double x, double y, double xx, double yy) {
        return sqrt((xx-x)*(xx-x)+(yy-y)*(yy-y));
    }


    boolean isPalindrome(String s) {
        for (int i=0; i<s.length()/2; i++)
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        return true;
    }
    int occurenciesCnt(String s, String pattern) {
        int res = 0;
        for (int i=0; i<s.length()-pattern.length()+1; i++)
            if (s.substring(i, i+pattern.length()).equals(pattern)) res++;
        return res;
    }
    int occurenciesCnt(String s, char pattern) {
        int res = 0;
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i)==pattern) res++;
        return res;
    }


    int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    boolean isLeapYear(int y) {
        return y%4==0 && (y%400==0 || y%100!=0);
    }
    boolean isValidDate(int d, int m, int y) {
        if (isLeapYear(y) && m==2 && d==29) return true;
        return m>0 && m<=12 && d>0 && d<=months[d];
    }
    int[] nextDay(int d, int m, int y) {
        if (d>=months[m])
            if (m==2 && d==28 && isLeapYear(y)) d++;
            else {d=1; m++;}
        else
            d++;
        if (m==13) {d=1; m=1; y++;}
        return new int[] {d,m,y};
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


    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String nextLine() throws IOException {
        return in.readLine();
    }
    char nextChar() throws IOException {
        int c = 0;
        while (c<=' ') c=in.read();
        return (char)c;
    }
    String nextWord() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (c<=' ') c=in.read();
        while (c>' ') {
            sb.append((char)c);
            c = in.read();
        }
        return sb.toString();
    }
    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextWord());
    }
    long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextWord());
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
    char[][] nextArrCh(int rows, int columns) throws IOException {
        char[][] arr = new char[rows][columns];
        for (int i=0; i<rows; i++)
            for (int j=0; j<columns; j++)
                arr[i][j] = nextChar();
        return arr;
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
        out.flush();
        out.close(); in.close();
    }
}
