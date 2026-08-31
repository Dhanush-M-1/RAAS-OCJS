import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main implements Runnable
{
    boolean multiple = true;
    long MOD;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        long toPrint = r - l + 1;
        long curr = 1;
        for (long group = 1; group <= n; group++)
        {
            //how many in this group
            long num = 2 * (n - group);
            if (group == n && toPrint != 0) { p(1); break; }
            if (l >= curr + num) { curr += num; continue; }
//            System.out.println(group + " " + toPrint);
            //else we are going to start printing
            long start = max(curr, l);
//            System.out.println(group + " " + start + " " + num + " gay");
            for (long idx = start; idx < curr + num; idx++)
            {
                if (toPrint == 0) break;
                long i = idx - curr + 1;
                if (i % 2 == 1) p(group);
                else p(1 + (i / 2) + (group - 1));
                p(' ');
                toPrint--;
            }
            curr += num;
            if (toPrint == 0) break;
        }
        pl();
    }

    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Main.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Main(), "", (1 << 26));thread.start();thread.join();if (Main.uncaught != null) {throw Main.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}