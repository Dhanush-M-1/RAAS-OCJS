import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

public class A339A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] il = br.readLine().split("\\+");

        Arrays.sort(il);

        for(int i=0; i<il.length; i++){
            if( i == 0){
                pr(il[i]);
            } else {
                pr("+"+il[i]);
            }
        }

        flush();
        close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    // constants
    static final int IBIG = 1000000007;
    static final int IMAX = 2147483647;
    static final int IMIN = -2147483648;
    static final long LMAX = 9223372036854775807L;
    static final long LMIN = -9223372036854775808L;

    // output
    static void pr(int i) {pw.print(i);}
    static void prln(int i) {pw.println(i);}
    static void pr(long l) {pw.print(l);}
    static void prln(long l) {pw.println(l);}
    static void pr(double d) {pw.print(d);}
    static void prln(double d) {pw.println(d);}
    static void pr(char c) {pw.print(c);}
    static void prln(char c) {pw.println(c);}
    static void pr(char[] s) {pw.print(new String(s));}
    static void prln(char[] s) {pw.println(new String(s));}
    static void pr(String s) {pw.print(s);}
    static void prln(String s) {pw.println(s);}
    static void pr(Object o) {pw.print(o);}
    static void prln(Object o) {pw.println(o);}
    static void prln() {pw.println();}
    static void pryes() {pw.println("yes");}
    static void pry() {pw.println("Yes");}
    static void prY() {pw.println("YES");}
    static void prno() {pw.println("no");}
    static void prn() {pw.println("No");}
    static void prN() {pw.println("NO");}
    static void pryesno(boolean b) {pw.println(b ? "yes" : "no");};
    static void pryn(boolean b) {pw.println(b ? "Yes" : "No");}
    static void prYN(boolean b) {pw.println(b ? "YES" : "NO");}
    static void prln(int... a) {for(int i = 0, len = a.length - 1; i < len; pw.print(a[i]), pw.print(' '), ++i); pw.println(a[a.length - 1]);}
    static void prln(long... a) {for(int i = 0, len = a.length - 1; i < len; pw.print(a[i]), pw.print(' '), ++i); pw.println(a[a.length - 1]);}
    static <T> void prln(Collection<T> c) {int n = c.size() - 1; Iterator<T> iter = c.iterator(); for(int i = 0; i < n; pw.print(iter.next()), pw.print(' '), ++i); if(n >= 0) pw.println(iter.next()); else pw.println();}
    static void h() {pw.println("hlfd");}
    static void flush() {pw.flush();}
    static void close() {pw.close();}
}
