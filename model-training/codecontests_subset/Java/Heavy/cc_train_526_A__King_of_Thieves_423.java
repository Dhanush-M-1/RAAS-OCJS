import java.awt.Point;
import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.ArrayDeque;

import static java.lang.Math.*;

public class Main {

    final boolean ONLINE_JUDGE = !new File("input.txt").exists();
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Main().run();
        // Sworn to fight and die
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class LOL implements Comparable<LOL> {
        long count;
        long type;

        public LOL(long time, long num) {
            this.count = time;
            this.type = num;
        }

        @Override
        public int compareTo(LOL o) {

            if (o.count != count)
                return (int) (o.count - count); // ---->
            return (int) (o.type - type); // <----
        }

    }

    public long gcd(long a, long b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    public int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    boolean prime(int n) {
        for (int i = 2; i <= sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }



    public void solve() throws IOException {
       int n = readInt();
        char[] s = readString().toCharArray();
        for (int i = 0; i < n - 4; i++)
            for(int j = 1; j <= (n - i - 1)/4; j++)
                if(s[i] == '*' && s[i+j] == '*' && s[i+2*j] == '*'&& s[i+3*j] == '*'&& s[i+4*j] == '*') {
                    out.print("yes");
                    return;
                }
        out.print("no");
    }

}