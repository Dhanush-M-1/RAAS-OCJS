import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main{
    final boolean isFileIO =  false;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    String delim = " ";

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.initIO();
        m.solve();
        m.in.close();
        m.out.close();
    }

    public void initIO() throws IOException {
        if(!isFileIO) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String nt() throws IOException {
        if(!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken(delim);
    }

    String rl() throws IOException {
        return in.readLine();
    }

    int ni() throws IOException {
        return Integer.parseInt(nt());
    }

    long nl() throws IOException {
        return Long.parseLong(nt());
    }

    double nd() throws IOException {
        return Double.parseDouble(nt());
    }

    class Pair {
        public long x;
        public long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("{%d, %d}", x, y);
        }
    }

    public void solve() throws IOException {
        int n = ni();
        HashMap<Integer, Integer> errors = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            int num = ni();
            if(errors.containsKey(num)) {
                errors.put(num, errors.get(num) + 1);
            } else {
                errors.put(num, 1);
            }
        }
        for(int i = 0; i < 2; i++) {
            HashMap<Integer, Integer> next = new HashMap<Integer, Integer>();
            for(int j = 0; j < n - i - 1; j++) {
                int num = ni();
                if(next.containsKey(num)) {
                    next.put(num, next.get(num) + 1);
                } else {
                    next.put(num, 1);
                }
            }
            for(int key : errors.keySet()) {
                if(!errors.get(key).equals(next.get(key))) {
                    out.println(key);
                    break;
                }
            }
            errors = next;
        }
    }
}

class Utils {

    public static long binpow(long a, long exp, long mod) {
        if(exp == 0) {
            return 1;
        }
        if(exp % 2 == 0) {
            long temp = binpow(a, exp / 2, mod);
            return (temp * temp) % mod;
        } else {
            return (binpow(a, exp - 1, mod) * a) % mod;
        }
    }

    public static long inv(long a, long mod) {
        return binpow(a, mod - 2, mod);
    }

    public static long addmod(long a, long b, long mod) {
        return ((a + b) % mod + mod) % mod;
    }

    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    //mul must be < 10^18
    public static long mulmod(long a, long b, long mod) {
        return (a * b + (((a * b) / mod) + 1) * mod) % mod;
    }
}