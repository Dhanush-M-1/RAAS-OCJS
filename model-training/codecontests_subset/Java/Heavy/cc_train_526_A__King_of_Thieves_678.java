import java.awt.*;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

//<editor-fold defaultstate="collapsed" desc="Main">
public class Main {
    // https://netbeans.org/kb/73/java/editor-codereference_ru.html#display

    private void run() {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception e) {
        }
        boolean oj = true;
        try {
            oj = System.getProperty("MYLOCAL") == null;
        } catch (Exception e) {
        }

        if (oj) {
            sc = new FastScanner(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
//            try {
//                sc = new FastScanner(new FileReader ("stacks.in" ));
//                out = new PrintWriter(new FileWriter("stacks.out"));
//            } catch (IOException e) {
//                MLE();
//            }
        } else {
            try {
                sc = new FastScanner(new FileReader("input.txt"));
                out = new PrintWriter(new FileWriter("output.txt"));
            } catch (IOException e) {
                MLE();
            }
        }
        Solver s = new Solver();
        s.sc = sc;
        s.out = out;
        s.solve();
        if (!oj) {
            err.println("Time: " + (System.currentTimeMillis() - timeBegin) / 1e3);
            err.printf("Mem: %d\n", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 20);
        }
        out.flush();
    }

    private void show(int[] arr) {
        for (int v : arr) {
            err.print(" " + v);
        }
        err.println();
    }

    public static void exit() {
        err.println("Time: " + (System.currentTimeMillis() - timeBegin) / 1e3);
        err.printf("Mem: %d\n", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 20);
        out.flush();
        out.close();
        System.exit(0);
    }

    public static void MLE() {
        int[][] arr = new int[1024 * 1024][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[1024 * 1024];
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    static long timeBegin = System.currentTimeMillis();
    static FastScanner sc;
    static PrintWriter out;
    static PrintStream err = System.err;
}
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FastScanner">
class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStreamReader reader) {
        br = new BufferedReader(reader);
        st = new StringTokenizer("");
    }

    String next() {
        while (!st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception ex) {
                return null;
            }
        }
        return st.nextToken();
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

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            return null;
        }
    }
}
//</editor-fold>

class Solver {

    void aser(boolean OK) {
        if (!OK) {
            Main.MLE();
            //for(;;);
        }
    }

    FastScanner sc;
    PrintWriter out;
    static PrintStream err = System.err;


    void solve(){
        int n;
        String s;

        n = sc.nextInt();
        s = sc.next();

        int a = 0;

        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == '*')
            {
                for(int j = 1; j < s.length(); ++j)
                {
                    boolean ok = true;
                    for (int k = 1; k <= 4; ++k)
                    {
                        if (i + j * k < s.length()&& s.charAt(i + j * k) == '*')
                        {
                            ;
                        }
                        else
                        {
                            ok = false;
                            break;
                        }
                    }
                    if (ok == true)
                    {
                        out.println("yes");
                        return ;
                    }
                }
            }
        }
        out.println("no");
    }
}