import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class b {
    
    final String bad = "ILLEGAL_ERASE_ARGUMENT";
    int t, n;
    int[] p, a;
    int curNum = 1;

    private void solve() throws Exception {
        t = nextInt(); n = nextInt();
        p = new int[n];
        for (int it = 0; it < t; ++it){
            /*for (int i = 0; i < n; ++i)
                out.print(p[i]);
            out.println();*/
            String cmd = nextToken();
            if (cmd.startsWith("al")){
                int size = nextInt();
                boolean added = false;
                for (int i = 0; i <= n - size; ++i){
                    boolean good = true;
                    for (int j = 0; j < size; ++j)
                        if (p[i + j] != 0)
                            good = false;
                    if (good){
                        out.println(curNum);
                        for (int j = 0; j < size; ++j)
                            p[i + j] = curNum;
                        ++curNum;
                        added = true;
                        break;
                    }
                }
                if (!added)
                    out.println("NULL");
            }
            else if (cmd.startsWith("er")){
                int num = nextInt();
                boolean contains = false;
                for (int i : p)
                    if (i == num)
                        contains = true;
                if (num <= 0 || !contains){
                    out.println(bad);
                    continue;
                }
                for (int i = 0; i < n; ++i)
                    if (p[i] == num)
                        p[i] = 0;
            }
            else{
                a = new int[n];
                int curA = 0;
                for (int i = 0; i < n; ++i)
                    if (p[i] != 0)
                        a[curA++] = p[i];
                p = a;
            }
        }
    }

    public void run() {
        try {
            solve();
        } catch (Exception e) {
            NOO(e);
        } finally {
            out.close();
        }
    }

    PrintWriter out;
    BufferedReader in;
    StringTokenizer St;

    void NOO(Exception e) {
        e.printStackTrace();
        System.exit(1);
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String nextToken() {
        while (!St.hasMoreTokens()) {
            try {
                String line = in.readLine();
                St = new StringTokenizer(line);
            } catch (Exception e) {
                NOO(e);
            }
        }
        return St.nextToken();
    }

    private b(String name) {
        try {
            in = new BufferedReader(new FileReader(name + ".in"));
            St = new StringTokenizer("");
            out = new PrintWriter(new FileWriter(name + ".out"));
        } catch (Exception e) {
            NOO(e);
        }
    }

    private b() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            St = new StringTokenizer("");
            out = new PrintWriter(System.out);
        } catch (Exception e) {
            NOO(e);
        }
    }

    public static void main(String[] args) {
        new b().run();
    }

}
